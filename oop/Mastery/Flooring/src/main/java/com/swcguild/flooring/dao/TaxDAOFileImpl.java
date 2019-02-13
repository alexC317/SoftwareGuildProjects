/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.flooring.dao;

import com.swcguild.flooring.dto.Tax;
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
public class TaxDAOFileImpl implements TaxDAO {

    private Map<String, Tax> taxes = new HashMap<>();

    public static final String TAX_FILE = "Taxes.txt";
    public static final String DELIMITER = ",";

    public TaxDAOFileImpl() throws FlooringPersistenceException {
        loadTaxes();
    }

    @Override
    public List<Tax> readAll() {
        return new ArrayList<>(taxes.values());
    }

    @Override
    public Tax readById(String stateName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void loadTaxes() throws FlooringPersistenceException {
        Scanner scanner;

        try {
            //Create scanner for reading the file
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(TAX_FILE)));
        } catch (FileNotFoundException e) {
            throw new FlooringPersistenceException(
                    "-_- Could not load tax information into memory.", e);
        }

        String currentLine;
        String[] currentTokens;

        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentTokens = currentLine.split(DELIMITER);

            Tax currentItem = new Tax((currentTokens[0]));
            currentItem.setTaxRate(new BigDecimal(currentTokens[1]));

            taxes.put(currentItem.getStateName(), currentItem);
        }
        scanner.close();
    }

}
