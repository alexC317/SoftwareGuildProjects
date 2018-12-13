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
    public void create(Address address) {
        addresses.put(address.getLastName(), address);
    }

    @Override
    public List<Address> readAll() {
        return new ArrayList<Address>(addresses.values());
    }

    @Override
    public Address readByLastName(String lastName) {
        return addresses.get(lastName);
    }

    @Override
    public void delete(String lastName) {
        addresses.remove(lastName);
    }

    @Override
    public int addressCount() {
        return addresses.size();
    }

    @Override
    public void editAddress(String lastName, Address newAddress) {
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
            Address currentAddress = new Address(currentTokens[0], currentTokens[1], currentTokens[2],
                    currentTokens[3], currentTokens[4], Integer.parseInt(currentTokens[5]));
            //Put currentStudent into the map using studentId as the key
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
        // NOTE FOR APPRENTICES: We are not handling the IOException - but
        // we are translating it to an application specific exception and 
        // then simple throwing it (i.e. 'reporting' it) to the code that 
        // called us. It is the responsibility of the calling code to
        // handle any errors that occur.
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(ADDRESS_FILE));
        } catch (IOException e) {
            throw new AddressBookDaoException("Could not save address data.", e);
        }

        // Write out the Student objects to the roster file.
        // NOTE TO THE APPRENTICES: We could just grab the student map,
        // get the Collection of Students and iterate over them, but we've
        // already created a method that gets a List of Students so
        // we'll reuse it.
        List<Address> addressList = this.readAll();
        for (Address currentAddress : addressList) {
            // write the Student object to the file
            out.println(currentAddress.getFirstName() + DELIMITER
                    + currentAddress.getLastName() + DELIMITER
                    + currentAddress.getStreetAddress() + DELIMITER
                    + currentAddress.getCity() + DELIMITER
                    + currentAddress.getState() + DELIMITER
                    + currentAddress.getZipCode());
            // force PrintWriter to write line to the file
            out.flush();
        }
        //Clean up
        out.close();
    }

}
