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
        newOrder.setArea(io.readBigDecimal("Please type in the area you wish to floor: "));

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
        return null;
    }

}
