/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addressbook.dao;

import addressbook.dto.Address;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class AddressBookDaoImpl implements AddressBookDao {

    public static final String ADDRESS_FILE = "addressBook.txt";
    public static final String DELIMITER = "::";

    Map<String, Address> addresses = new HashMap<>();

    @Override
    public void create(Address address) throws AddressBookDaoException {
        addresses.put(address.getLastName(), address);
        writeAddresses();
    }

    @Override
    public List<Address> readAll() throws AddressBookDaoException {
        loadAddresses();
        return new ArrayList<Address>(addresses.values());
    }

    @Override
    public Address readByLastName(String lastName) throws AddressBookDaoException {
        loadAddresses();
        return addresses.get(lastName);
    }

    @Override
    public void delete(String lastName) throws AddressBookDaoException {
        addresses.remove(lastName);
        writeAddresses();
    }

    @Override
    public int addressCount() {
        return addresses.size();
    }

    @Override
    public void editAddress(String lastName, Address newAddress) throws AddressBookDaoException {
        Address currentAddress = addresses.get(lastName);
        String oldFirstName = currentAddress.getFirstName();

        newAddress.setFirstName(oldFirstName);
        newAddress.setLastName(lastName);
        addresses.put(lastName, newAddress);
    }

    private void loadAddresses() throws AddressBookDaoException {
        Scanner scanner;

        try {
            // Create Scanner for reading the file
            scanner = new Scanner(new BufferedReader(new FileReader(ADDRESS_FILE)));
        } catch (FileNotFoundException e) {
            throw new AddressBookDaoException("-_- Could not load address data into memory.", e);
        }
        // currentLine holds the most recent line read from the file
        String currentLine;
        String[] currentTokens;
        while (scanner.hasNextLine()) {
            // get the next line in the file
            currentLine = scanner.nextLine();
            // break up the line into tokens
            currentTokens = currentLine.split(DELIMITER);
            Address currentAddress = new Address(currentTokens[0], currentTokens[1], currentTokens[2],
                    currentTokens[3], currentTokens[4], Integer.parseInt(currentTokens[5]));
            addresses.put(currentAddress.getLastName(), currentAddress);
        }
        // close scanner
        scanner.close();
    }

    /**
     * Writes all the students in the roster out to a ROSTER_FILE. See
     * loadRoster for file format.
     *
     * @throws ClassRosterPersistenceException if an error occurs writing to the
     * file
     */
    private void writeAddresses() throws AddressBookDaoException {
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(ADDRESS_FILE));
        } catch (IOException e) {
            throw new AddressBookDaoException("Could not save address data.", e);
        }
        List<Address> addressList = this.readAll();
        for (Address currentAddress : addressList) {
            out.println(currentAddress.getFirstName() + DELIMITER
                    + currentAddress.getLastName() + DELIMITER
                    + currentAddress.getStreetAddress() + DELIMITER
                    + currentAddress.getCity() + DELIMITER
                    + currentAddress.getState() + DELIMITER
                    + currentAddress.getZipCode());
            out.flush();
        }
        //Clean up
        out.close();
    }

}
