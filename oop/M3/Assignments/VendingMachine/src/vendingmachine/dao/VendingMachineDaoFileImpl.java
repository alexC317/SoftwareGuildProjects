/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import vendingmachine.dto.VendingMachineItem;

public class VendingMachineDaoFileImpl implements VendingMachineDao {

    private Map<Integer, VendingMachineItem> items = new HashMap<>();

    public static final String INVENTORY_FILE = "inventory.txt";
    public static final String DELIMITER = "::";

    // LOAD THE FILE INTO MEMORY IN THE CONSTRUCTOR
    public VendingMachineDaoFileImpl() throws VendingMachinePersistenceException {
        loadInventory();
    }

    @Override
    public List<VendingMachineItem> readAll() {
        return new ArrayList<>(items.values());
    }

    @Override
    public VendingMachineItem readByID(int itemId) {
        if (items.containsKey(itemId)) {
            return items.get(itemId);
        } else {
            return null;
        }
    }

    @Override
    public void update(int itemId, VendingMachineItem item) {
        if (items.containsKey(itemId)) {
            if (items.get(itemId).getItemName().equals(item.getItemName())) {
            } else {
                items.get(itemId).setItemName(item.getItemName());
            }

            if (items.get(itemId).getItemCount() == item.getItemCount()) {
            } else {
                items.get(itemId).setItemCount(item.getItemCount());
            }

            if (items.get(itemId).getItemPrice().equals(item.getItemPrice())) {
            } else {
                items.get(itemId).setItemPrice(item.getItemPrice());
            }
        }
    }

    private void loadInventory() throws VendingMachinePersistenceException {
        Scanner scanner;

        try {
            //Create scanner for reading the file
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(INVENTORY_FILE)));
        } catch (FileNotFoundException e) {
            throw new VendingMachinePersistenceException(
                    "-_- Could not load roster into memory.", e);
        }

        String currentLine;
        String[] currentTokens;

        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentTokens = currentLine.split(DELIMITER);

            VendingMachineItem currentItem = new VendingMachineItem(Integer.parseInt(currentTokens[0]));
            currentItem.setItemName(currentTokens[1]);
            currentItem.setItemPrice(new BigDecimal(currentTokens[2]));
            currentItem.setItemCount(Integer.parseInt(currentTokens[3]));

            items.put(currentItem.getItemId(), currentItem);
        }
        scanner.close();
    }

    private void writeInventory() throws VendingMachinePersistenceException {
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(INVENTORY_FILE));
        } catch (IOException e) {
            throw new VendingMachinePersistenceException("Could not save inventory data.", e);
        }

        List<VendingMachineItem> itemList = this.readAll();
        for (VendingMachineItem currentItem : itemList) {
            out.println(currentItem.getItemId() + DELIMITER
                    + currentItem.getItemName() + DELIMITER
                    + currentItem.getItemPrice() + DELIMITER
                    + currentItem.getItemCount());
            out.flush();
        }
        out.close();
    }
}
