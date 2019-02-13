/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.flooring.dao;

import com.swcguild.flooring.dto.Product;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Alex
 */
public class ProductDAOFileImpl implements ProductDAO {

    private Map<String, Product> products = new HashMap<>();

    public static final String PRODUCT_FILE = "Products.txt";
    public static final String DELIMITER = ",";

    public ProductDAOFileImpl() throws FlooringPersistenceException {
        loadProducts();
    }

    @Override
    public List<Product> readAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public Product readById(String productName) {
        if (products.containsKey(productName)) {
            return products.get(productName);
        }

        return null;
    }

    private void loadProducts() throws FlooringPersistenceException {
        Scanner scanner;

        try {
            //Create scanner for reading the file
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(PRODUCT_FILE)));
        } catch (FileNotFoundException e) {
            throw new FlooringPersistenceException(
                    "-_- Could not load product information into memory.", e);
        }

        String currentLine;
        String[] currentTokens;

        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentTokens = currentLine.split(DELIMITER);

            Product currentItem = new Product((currentTokens[0]));
            currentItem.setCostPerSquareFoot(new BigDecimal(currentTokens[1]));
            currentItem.setLaborCostPerSqaureFoot(new BigDecimal(currentTokens[2]));

            products.put(currentItem.getProductType(), currentItem);
        }
        scanner.close();
    }
}
