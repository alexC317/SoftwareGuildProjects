/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addressbook.view;

import addressbook.dto.Address;
import java.util.List;

/**
 *
 * @author Alex
 */
public class AddressBookView {

    private UserIO io;

    public AddressBookView(UserIO io) {
        this.io = io;
    }

    public int menuDisplay() {
        io.print("========");
        io.print("Initial Menu");
        io.print("      Please select the operation you wish to perform.");
        io.print("          1. Add address.");
        io.print("          2. Delete address.");
        io.print("          3. Find Address.");
        io.print("          4. List Address Count.");
        io.print("          5. List All Addresses.");
        io.print("          6. Edit an Address.");
        io.print("          7. Exit");

        return io.readInt("Please enter your selection: ", 1, 7);
    }

    public Address getNewAddressInfo() {
        String firstName = io.readString("Please enter first name: ");
        String lastName = io.readString("Please enter last name: ");
        String streetAddress = io.readString("Please enter the street address: ");
        String city = io.readString("Please enter the city: ");
        String state = io.readString("Please enter the state: ");
        int zipCode = io.readInt("Please enter the zip code: ");

        Address currentAddress = new Address(firstName, lastName, streetAddress, city, state, zipCode);

        return currentAddress;
    }

    public void displayCreateAddressBanner() {
        io.print("=== Create Address ===");
    }

    public void displayCreateSuccessBanner() {
        io.readString("Address successfully created. Please hit enter to continue.");
    }

    public void displayDisplayAllBanner() {
        io.print("=== Display All Addresses ===");
    }

    public void displayCurrentAddressList(List<Address> addressList) {
        io.print("===========");
        for (Address currentAddress : addressList) {
            io.print(currentAddress.getFirstName() + " " + currentAddress.getLastName() + " : ");
            io.print(currentAddress.getStreetAddress());
            io.print(currentAddress.getCity() + ", " + currentAddress.getState() + ", " + currentAddress.getZipCode());
            io.print("");
        }
        io.print("===========");
        io.readString("Please hit enter to continue.");
    }

    public void displayDisplayAddressBanner() {
        io.print("=== Display Address ===");
    }

    public String getLastNameChoice() {
        return io.readString("Please enter the last name.");
    }

    public void displayAddress(Address currentAddress) {
        if (currentAddress != null) {
            io.print(currentAddress.getFirstName() + " " + currentAddress.getLastName() + " : ");
            io.print(currentAddress.getStreetAddress());
            io.print(currentAddress.getCity() + ", " + currentAddress.getState() + ", " + currentAddress.getZipCode());
            io.print("");
        } else {
            io.print("No such address.");
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayRemoveAddressBanner() {
        io.print("=== Remove Address ===");
    }

    public void displayRemoveSuccessBanner() {
        io.print("Address succesfully removed. Please hit enter to continue.");
    }

    public void displayAddressCountBanner() {
        io.print("=== Show Address Count ===");
    }

    public void displayAddressCount(int addressCount) {
        io.print("There are " + addressCount + " address in the address book");
    }

    public void displayEditAddressBanner() {
        io.print("=== Edit Address ===");
    }

    public void displayExitBanner() {
        io.print("Good bye!");
    }

    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!");
    }

    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }

}
