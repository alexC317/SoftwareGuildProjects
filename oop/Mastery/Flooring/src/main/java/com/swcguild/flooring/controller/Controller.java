/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.flooring.controller;

import com.swcguild.flooring.dao.FlooringPersistenceException;
import com.swcguild.flooring.dto.Order;
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

    public Controller(View view, Service service) {
        this.view = view;
        this.service = service;
    }

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
            } catch (Exception e) {
                view.displayErrorMessage(e.getMessage());
            }
        }
    }

    private void displayMenu() {
        view.displayMenu();
    }

    private int getMenuChoice() {
        return view.getMenuChoice();
    }

    private void displayOrders() throws FlooringPersistenceException {
        view.displayDisplayOrdersBanner();
        LocalDate orderDate = view.getOrderDate();
        List<Order> orderList = service.displayOrders(orderDate);
        view.displayOrders(orderList, orderDate);
    }

    private void addOrder() throws FlooringPersistenceException, OrderValidationException {
        view.displayAddOrderBanner();
        Order newOrder = view.getOrderInformation();
        if (newOrder != null) {
            service.addOrder(newOrder);
        }
    }

    private void editOrder() throws FlooringPersistenceException, OrderValidationException {
        view.displayEditOrderBanner();
        LocalDate orderDate = view.getOrderDate();
        int orderNumber = view.getOrderNumber();
        Order originalOrder = service.getOrder(orderDate, orderNumber);
        Order updatedOrder = view.getUpdatedInformation(originalOrder);
        service.editOrder(orderDate, orderNumber, updatedOrder);
    }

    private void removeOrder() throws FlooringPersistenceException {
        view.displayRemoveOrderBanner();
        LocalDate orderDate = view.getOrderDate();
        int orderNumber = view.getOrderNumber();
        Order orderToRemove = service.getOrder(orderDate, orderNumber);
        boolean removeOrder = view.removeOrder(orderToRemove);
        if (removeOrder) {
            service.removeOrder(orderDate, orderNumber);
        }
    }

    private void saveCurrentWork() throws FlooringPersistenceException {
        view.displaySaveWorkBanner();
        view.saveWork();
        service.saveCurrentWork();
    }

    private void unknownCommand() {
        view.displayUnknownCommand();
    }

}
