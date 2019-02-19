/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.flooring.dao;

import com.swcguild.flooring.dto.Order;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author acetip
 */
public class OrderDAOProdFileImpl implements OrderDAO {

    private Map<LocalDate, Map> masterList = new HashMap<>();
    private Map<Integer, Order> currentOrders = new HashMap<>();
    private LocalDate currentDate;

    public static final String ORDER_FILE = "Orders_";
    public static final String DELIMITER = ",";

    public OrderDAOProdFileImpl() {
    }

    @Override
    public void create(LocalDate orderDate, Order newOrder) throws FlooringPersistenceException {
        currentDate = orderDate;
        currentOrders.put(newOrder.getOrderNumber(), newOrder);

        masterList.put(currentDate, currentOrders);
    }

    @Override
    public List<Order> readAll(LocalDate orderDate) throws FlooringPersistenceException {
        Map<Integer, Order> localOrders;
        if (masterList.containsKey(orderDate)) {
            localOrders = masterList.get(orderDate);
            return new ArrayList<>(localOrders.values());
        } else {
            localOrders = loadOrders(orderDate);
            masterList.put(orderDate, localOrders);
            return new ArrayList<>(localOrders.values());
        }
    }

    @Override
    public Order readById(LocalDate orderDate, int orderNumber) throws FlooringPersistenceException {
        Map<Integer, Order> localOrders;

        if (masterList.containsKey(orderDate)) {
            localOrders = masterList.get(orderDate);
            if (localOrders.containsKey(orderNumber)) {
                return localOrders.get(orderNumber);
            }
        } else {
            localOrders = loadOrders(orderDate);
            masterList.put(orderDate, localOrders);
            if (localOrders.containsKey(orderNumber)) {
                return localOrders.get(orderNumber);
            }
        }
        return null;
    }

    @Override
    public void update(LocalDate orderDate, int orderNumber, Order updatedOrder) throws FlooringPersistenceException {
        Map<Integer, Order> localOrders;

        if (masterList.containsKey(orderDate)) {
            localOrders = masterList.get(orderDate);
            if (localOrders.containsKey(orderNumber)) {
                localOrders.put(orderNumber, updatedOrder);
            }
        } else {
            localOrders = loadOrders(orderDate);
            if (localOrders.containsKey(orderNumber)) {
                localOrders.put(orderNumber, updatedOrder);
            }
        }
        masterList.put(orderDate, localOrders);
        //writeOrders(orderDate, localOrders);
    }

    @Override
    public void delete(LocalDate orderDate, int orderNumber) throws FlooringPersistenceException {
        Map<Integer, Order> localOrders;

        if (masterList.containsKey(orderDate)) {
            localOrders = masterList.get(orderDate);
            if (localOrders.containsKey(orderNumber)) {
                localOrders.remove(orderNumber);
            }
        } else {
            localOrders = loadOrders(orderDate);
            if (localOrders.containsKey(orderNumber)) {
                localOrders.remove(orderNumber);
            }
        }
        masterList.put(orderDate, localOrders);
        //writeOrders(orderDate, localOrders);
    }

    @Override
    public void save() throws FlooringPersistenceException {
        for (LocalDate activeDate : masterList.keySet()) {
            writeOrders(activeDate, masterList.get(activeDate));
        }
    }

    @Override
    public List<Order> getAllExistingOrders(LocalDate orderDate) throws FlooringPersistenceException {
        Map<Integer, Order> localOrders;
        try {
            if (masterList.containsKey(orderDate)) {
                localOrders = masterList.get(orderDate);
                return new ArrayList<>(localOrders.values());
            } else {
                localOrders = loadOrders(orderDate);
                masterList.put(orderDate, localOrders);
                return new ArrayList<>(localOrders.values());
            }
        } catch (FlooringPersistenceException e) {
            return null;
        }
    }

    private void writeOrders(LocalDate orderDate, Map orders) throws FlooringPersistenceException {
        String dateAsString = orderDate.format(DateTimeFormatter.ofPattern("MMddyyyy"));
        String fullFileName = ORDER_FILE + dateAsString;
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
        List<Order> orderList = new ArrayList<>(orders.values());
        for (Order currentOrder : orderList) {
            // write the Student object to the file
            out.println(currentOrder.getOrderNumber() + DELIMITER
                    + currentOrder.getCustomerName() + DELIMITER
                    + currentOrder.getStateName() + DELIMITER
                    + currentOrder.getTaxRate() + DELIMITER
                    + currentOrder.getProductType() + DELIMITER
                    + currentOrder.getArea() + DELIMITER
                    + currentOrder.getCostPerSquareFoot() + DELIMITER
                    + currentOrder.getLaborCostPerSquareFoot() + DELIMITER
                    + currentOrder.getMaterialCost() + DELIMITER
                    + currentOrder.getLaborCost() + DELIMITER
                    + currentOrder.getTax() + DELIMITER
                    + currentOrder.getTotal());
            // force PrintWriter to write line to the file
            out.flush();
        }
        //Clean up
        out.close();
    }

    private Map loadOrders(LocalDate orderDate) throws FlooringPersistenceException {
        Map<Integer, Order> localOrders = new HashMap<>();

        String dateAsString = orderDate.format(DateTimeFormatter.ofPattern("MMddyyyy"));
        String fullFileName = ORDER_FILE + dateAsString;
        Scanner scanner;

        try {
            // Create Scanner for reading the file
            scanner = new Scanner(new BufferedReader(new FileReader(fullFileName)));
        } catch (FileNotFoundException e) {
            throw new FlooringPersistenceException("No orders for this date found.", e);
        }
        // currentLine holds the most recent line read from the file
        String currentLine;
        // currentTokens holds each of the parts of the currentLine after it has been split on our DELIMITER.
        // NOTE FOR APPRENTICES: In our case we use :: as our delimiter. If
        // cuurentLine looks like this:
        // 1234::Joe::Smith::Java-September2013
        // then currentTokens wlll be a String array that looks like this:
        // 
        // ___________________________________
        // |    |   |     |                  |
        // |1234|Joe|Smith|Java-September2013|
        // |    |   |     |                  |
        // -----------------------------------
        //  [0]  [1]  [2]           [3]
        String[] currentTokens;
        // Go through ROSTER_FILE line by line, decoding each line into a Student object
        // Process while we have more lines in the file
        while (scanner.hasNextLine()) {
            // get the next line in the file
            currentLine = scanner.nextLine();
            // break up the line into tokens
            currentTokens = currentLine.split(DELIMITER);
            // Create a new Studen object and put it into the map of students 
            // NOTE FOR APPRENTICES: We are going to use the student id
            // Which is currentTokens[0] as the map key for out student object.
            // We also have to pass the student id into the Student constructor
            Order currentOrder = new Order(Integer.parseInt(currentTokens[0]));
            //Set the remaining values on currentStudent manually
            currentOrder.setCustomerName(currentTokens[1]);
            currentOrder.setStateName(currentTokens[2]);
            currentOrder.setTaxRate(new BigDecimal(currentTokens[3]));
            currentOrder.setProductType(currentTokens[4]);
            currentOrder.setArea(new BigDecimal(currentTokens[5]));
            currentOrder.setCostPerSquareFoot(new BigDecimal(currentTokens[6]));
            currentOrder.setLaborCostPerSquareFoot(new BigDecimal(currentTokens[7]));
            currentOrder.setMaterialCost(new BigDecimal(currentTokens[8]));
            currentOrder.setLaborCost(new BigDecimal(currentTokens[9]));
            currentOrder.setTax(new BigDecimal(currentTokens[10]));
            currentOrder.setTotal(new BigDecimal(currentTokens[11]));
            //Put currentStudent into the map using studentId as the key
            localOrders.put(currentOrder.getOrderNumber(), currentOrder);
        }
        // close scanner
        scanner.close();

        return localOrders;
    }

}
