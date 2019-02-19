/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.flooring.view;

import com.swcguild.flooring.dto.Order;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 *
 * @author Alex
 */
public class View {

    private UserIO io;

    public View(UserIO io) {
        this.io = io;
    }

    public void displayMenu() {
        io.print("************************************** \n");
        io.print("* Welcome to SWG's Flooring Program! * \n");
        io.print("* Here are our options:              * \n");
        io.print("*  1. Display Orders                 * \n");
        io.print("*  2. Add Order                      * \n");
        io.print("*  3. Edit an Order                  * \n");
        io.print("*  4. Remove an Orer                 * \n");
        io.print("*  5. Save current work              * \n");
        io.print("*  6: Quit the program               * \n");
        io.print("************************************** \n");
    }

    public int getMenuChoice() {
        return io.readInt("Please enter your menu selection: ");
    }

    public void displayDisplayOrdersBanner() {
        io.print("=== DISPLAY ORDERS === \n");
    }

    public LocalDate getOrderDate() {
        return io.readLocalDate("Please enter a date, in the format MMDDYYYY: ");
    }

    public void displayOrders(List<Order> orderList, LocalDate orderDate) {
        io.print("Displaying all orders for " + orderDate.format(DateTimeFormatter.ofPattern("MM/dd/yyyy")));

        for (Order currentOrder : orderList) {
            io.print("*Order number " + currentOrder.getOrderNumber() + "\n");
            io.print("** Customer name: " + currentOrder.getCustomerName() + "\n");
            io.print("** State: " + currentOrder.getStateName() + "\n");
            io.print("** Product: " + currentOrder.getProductType() + "\n");
            io.print("** Area: " + currentOrder.getArea() + "\n");
            io.print("*** Material Cost: " + currentOrder.getMaterialCost() + "\n");
            io.print("*** Labor Cost: " + currentOrder.getLaborCost() + "\n");
            io.print("** Total: " + currentOrder.getTotal() + "\n");
            io.print("-------------------------");
        }
    }

    public void displayAddOrderBanner() {
        io.print("=== ADD ORDER === \n");
    }

    public Order getOrderInformation() {
        Order newOrder = new Order(0);

        newOrder.setCustomerName(io.readString("Please enter your name: "));
        io.print("We provide services to only the following states: \n");
        io.print("**OH, 6.25% tax rate \n");
        io.print("**PA, 6.75% tax rate \n");
        io.print("**MI, 5.75% tax rate\n");
        io.print("**IN, 6.00% tax rate\n");
        newOrder.setStateName(io.readString("Please type your state abbreviation: "));
        io.print("We provide the following flooring materials: \n");
        io.print("**Carpet   | $2.25 per square foot, $2.10 labor cost per square foot \n");
        io.print("**Laminate | $1.75 per square foot, $2.10 labor cost per square foot \n");
        io.print("**Tile     | $3.50 per square foot, $4.15 labor cost per square foot \n");
        io.print("**Wood     | $5.15 per square foot, $4.70 labor cost per square foot \n");
        newOrder.setProductType(io.readString("Please type in the product you wish to order: "));
        newOrder.setArea(io.readBigDecimal("Please type in the square feet of the area you wish to floor: "));

        io.print("Please verify the following information: \n");
        io.print("Your name: " + newOrder.getCustomerName());
        io.print("Your state: " + newOrder.getStateName());
        io.print("Your product: " + newOrder.getProductType());
        io.print("Your area: " + newOrder.getArea());

        String choice;

        do {
            choice = io.readString("If this is correct, press Y to confirm the order. If not, press N to discard the order: ");
            if (choice.equalsIgnoreCase("y")) {
                io.print("Please make sure to save your work by hitting option 5 on the menu! \n");
                return newOrder;
            }
        } while (!choice.equalsIgnoreCase("y") || !choice.equalsIgnoreCase("n"));
        io.print("Order data discarded. \n");

        return null;
    }

    public void displayEditOrderBanner() {
        io.print("=== EDIT ORDER === \n");
    }

    public int getOrderNumber() {
        return io.readInt("Please enter the order number you wish to edit: ");
    }

    public Order getUpdatedInformation(Order originalOrder) {
        Order updatedOrder = new Order(0);

        updatedOrder.setCustomerName(io.readString("Please enter your name: (" + originalOrder.getCustomerName() + "): "));
        updatedOrder.setStateName(io.readString("Please type your state abbreviation: (" + originalOrder.getStateName() + "): "));
        updatedOrder.setProductType(io.readString("Please type in the product you wish to order: (" + originalOrder.getProductType() + "): "));
        updatedOrder.setArea(io.readBigDecimal("Please type in the square feet of the area you wish to floor: (" + originalOrder.getArea() + "): "));

        return updatedOrder;
    }

    public void displayRemoveOrderBanner() {
        io.print("=== REMOVE ORDER === \n");
    }

    public boolean removeOrder(Order orderToRemove) {
        io.print("Here is the order information of the order you wish to remove: \n");
        io.print("Customer name: " + orderToRemove.getCustomerName());
        io.print("State name: " + orderToRemove.getStateName());
        io.print("Tax rate: " + orderToRemove.getTaxRate());
        io.print("Product type: " + orderToRemove.getProductType());
        io.print("Area: " + orderToRemove.getArea());
        io.print("Cost per square foot: " + orderToRemove.getCostPerSquareFoot());
        io.print("Labor cost per square foot: " + orderToRemove.getLaborCostPerSquareFoot());
        io.print("Material cost: " + orderToRemove.getMaterialCost());
        io.print("Labor cost: " + orderToRemove.getLaborCost());
        io.print("Total tax: " + orderToRemove.getTax());
        io.print("Total cost: " + orderToRemove.getTotal());

        String choice;
        do {
            choice = io.readString("Are you sure you want to remove this order? Y/N \n");
            if (choice.equalsIgnoreCase("y")) {
                io.print("Order deleted. \n");
                return true;
            }
        } while (!choice.equalsIgnoreCase("y") || !choice.equalsIgnoreCase("n"));
        io.print("Order not deleted. \n");

        return false;
    }

    public void displaySaveWorkBanner() {
        io.print("=== SAVE WORK === \n");
    }

    public void saveWork() {
        io.print("Work saved.");
    }

    public void displayErrorMessage(String message) {
        io.print("=== ERROR ===");
        io.print(message);
    }

    public void displayUnknownCommand() {
        io.print("Unknown Command.");
    }

}
