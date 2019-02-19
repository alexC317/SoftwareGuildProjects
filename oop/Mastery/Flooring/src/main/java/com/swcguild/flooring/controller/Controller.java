/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.flooring.controller;

import com.swcguild.flooring.dao.FlooringPersistenceException;
import com.swcguild.flooring.dto.Order;
import com.swcguild.flooring.service.NoOrdersFoundException;
import com.swcguild.flooring.service.OrderValidationException;
import com.swcguild.flooring.service.Service;
import com.swcguild.flooring.view.View;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Alex
 */
public class Controller {

    private View view;
    private Service service;

    /**
     * Constructor for the class. Takes in View and Service objects.
     *
     * @param view
     * @param service
     */
    public Controller(View view, Service service) {
        this.view = view;
        this.service = service;
    }

    /**
     * Runs the program. Uses a loop to keep running until the user specifies
     * not to.
     */
    public void run() {
        boolean quit = false;
        int menuSelection;

        while (!quit) {
            try {
                displayMenu();
                menuSelection = getMenuChoice();

                switch (menuSelection) {
                    case 1:
                        displayOrders();
                        break;
                    case 2:
                        addOrder();
                        break;
                    case 3:
                        editOrder();
                        break;
                    case 4:
                        removeOrder();
                        break;
                    case 5:
                        saveCurrentWork();
                        break;
                    case 6:
                        quit = true;
                        break;
                    default:
                        unknownCommand();
                }
            } catch (FlooringPersistenceException
                    | OrderValidationException
                    | NoOrdersFoundException e) {
                view.displayErrorMessage(e.getMessage());
            }
        }
    }

    /**
     * Displays the menu to the user.
     */
    private void displayMenu() {
        view.displayMenu();
    }

    /**
     * Prompts the user for their menu choice and passes it back to the run()
     * loop.
     *
     * @return The value the user selected for the menu.
     */
    private int getMenuChoice() {
        return view.getMenuChoice();
    }

    /**
     * Displays all orders for a particular date.
     *
     * @throws FlooringPersistenceException - If there are no orders for that
     * date, then an Exception is thrown.
     */
    private void displayOrders() throws FlooringPersistenceException {
        view.displayDisplayOrdersBanner();
        LocalDate orderDate = view.getOrderDate();
        List<Order> orderList = service.displayOrders(orderDate);
        view.displayOrders(orderList, orderDate);
    }

    /**
     * Prompts the user to provide information to create a new Order which is
     * then passed to the Service layer for validation and submission, pending
     * user approval.
     *
     * @throws FlooringPersistenceException - If the file cannot be written/read
     * from, then we have an Exception thrown.
     * @throws OrderValidationException - If the provided information is
     * invalid, this Exception is thrown.
     */
    private void addOrder() throws FlooringPersistenceException, OrderValidationException {
        view.displayAddOrderBanner();
        Order newOrder = view.getOrderInformation();
        if (newOrder != null) {
            service.addOrder(newOrder);
        }
    }

    /**
     * Prompts the user to provide an order date and order number. If an Order
     * matches those parameters, the user is then prompted to provide updated
     * information. That information is then sent to the Service layer for
     * validation and submission.
     *
     * @throws FlooringPersistenceException - If the file cannot be written/read
     * from, then we have an Exception thrown.
     * @throws OrderValidationException - If the provided information is
     * invalid, this Exception is thrown.
     * @throws NoOrdersFoundException - If there is no order number for that
     * date found, then this Exception is thrown.
     */
    private void editOrder() throws FlooringPersistenceException, OrderValidationException, NoOrdersFoundException {
        view.displayEditOrderBanner();
        LocalDate orderDate = view.getOrderDate();
        int orderNumber = view.getOrderNumber();
        Order originalOrder = service.getOrder(orderDate, orderNumber);
        Order updatedOrder = view.getUpdatedInformation(originalOrder);
        service.editOrder(orderDate, orderNumber, updatedOrder);
    }

    /**
     * Prompts the user to provide an order date and order number. If an Order
     * matches those parameters, the user is then provided with an order
     * summary. They are then prompted to if they are sure they want to delete
     * the order. If they do, the order is deleted.
     *
     * @throws - FlooringPersistenceException - If the file cannot be
     * written/read from, then we have an Exception thrown.
     * @throws - NoOrdersFoundException - If there is no order number for that
     * date found, then this Exception is thrown.
     */
    private void removeOrder() throws FlooringPersistenceException, NoOrdersFoundException {
        view.displayRemoveOrderBanner();
        LocalDate orderDate = view.getOrderDate();
        int orderNumber = view.getOrderNumber();
        Order orderToRemove = service.getOrder(orderDate, orderNumber);
        boolean removeOrder = view.removeOrder(orderToRemove);
        if (removeOrder) {
            service.removeOrder(orderDate, orderNumber);
        }
    }

    /**
     * Writes whatever additions, changes and deletions have happened to the
     * Order files.
     *
     * @throws - FlooringPersistenceException - If the file cannot be
     * written/read from, then we have an Exception thrown.
     */
    private void saveCurrentWork() throws FlooringPersistenceException {
        view.displaySaveWorkBanner();
        view.saveWork();
        service.saveCurrentWork();
    }

    /**
     * Displays a message when an unknown command happens.
     */
    private void unknownCommand() {
        view.displayUnknownCommand();
    }

}
