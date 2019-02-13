/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.flooring.dao;

import com.swcguild.flooring.dto.Order;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author acetip
 */
public class OrderDAOFileImpl implements OrderDAO {

    private Map<Integer, Order> orders = new HashMap<>();
    private LocalDate currentDate;

    public static final String ORDER_FILE = "Orders_";
    public static final String DELIMITER = ",";

    public OrderDAOFileImpl() {
    }

    @Override
    public void create(LocalDate date, Order order) {
        currentDate = date;

        orders.put(order.getOrderNumber(), order);
    }

    @Override
    public List<Order> readAll(LocalDate date) {
        return new ArrayList<>(orders.values());
    }

    @Override
    public Order readById(LocalDate date, int id) {
        if (orders.containsKey(id)) {
            return orders.get(id);
        }
        return null;
    }

    @Override
    public void update(LocalDate date, int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(LocalDate date, int id) {
        if (orders.containsKey(id)) {
            orders.remove(id);
        }

    }

    private void fileWriter(LocalDate date) throws FlooringPersistenceException {
        String fullFileName = ORDER_FILE + date;
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(fullFileName));
        } catch (IOException e) {
            throw new FlooringPersistenceException("Could not save order data.", e);
        }

        // Write out the Student objects to the roster file.
        // NOTE TO THE APPRENTICES: We could just grab the student map,
        // get the Collection of Students and iterate over them, but we've
        // already created a method that gets a List of Students so
        // we'll reuse it.
        List<Order> orderList = this.readAll(date);
        for (Order currentOrder : orderList) {
            // write the Student object to the file
            out.println(currentOrder.getOrderNumber()+ DELIMITER
                    + currentOrder.getCustomerName()+ DELIMITER
                    + currentOrder.getStateName()+ DELIMITER
                    + currentOrder.getTaxRate() + DELIMITER
                    + currentOrder.getProductType()+ DELIMITER
                    + currentOrder.getArea() + DELIMITER
                    + currentOrder.getCostPerSquareFoot()+ DELIMITER
                    + currentOrder.getLaborCostPerSquareFoot()+ DELIMITER
                    + currentOrder.getMaterialCost()+ DELIMITER
                    + currentOrder.getLaborCost()+ DELIMITER
                    + currentOrder.getTax()+ DELIMITER
                    + currentOrder.getTotal());
            // force PrintWriter to write line to the file
            out.flush();
        }
        //Clean up
        out.close();
    }

    private void fileReader(LocalDate date) {

    }

}
