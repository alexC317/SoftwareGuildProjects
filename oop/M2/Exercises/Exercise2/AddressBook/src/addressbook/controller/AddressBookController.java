/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addressbook.controller;

import addressbook.dao.AddressBookDao;
import addressbook.dao.AddressBookDaoException;
import addressbook.dto.Address;
import addressbook.view.AddressBookView;
import java.util.List;

/**
 *
 * @author Alex
 */
public class AddressBookController {
    
    private AddressBookView view;
    private AddressBookDao dao;
    
    public AddressBookController(AddressBookView view, AddressBookDao dao) {
        this.view = view;
        this.dao = dao;
    }
    
    public void run() {
        boolean quit = false;
        int menuChoice = 0;
        
        try {
            while (!quit) {
                menuChoice = menuSelection();
                
                switch (menuChoice) {
                    case 1:
                        createAddress();
                        break;
                    case 2:
                        deleteAddress();
                        break;
                    case 3:
                        readAnAddress();
                        break;
                    case 4:
                        countAddresses();
                        break;
                    case 5:
                        readAllAddresses();
                        break;
                    case 6:
                        editAnAddress();
                        break;
                    case 7:
                        quit = true;
                        quitProgram();
                        break;
                    default:
                        view.displayUnknownCommandBanner();
                }
            }
        } catch (AddressBookDaoException ex) {
            view.displayErrorMessage(ex.getMessage());
        }
    }
    
    private int menuSelection() {
        return view.menuDisplay();
    }
    
    private void createAddress() throws AddressBookDaoException {
        view.displayCreateAddressBanner();
        Address address = view.getNewAddressInfo();
        dao.create(address);
        view.displayCreateSuccessBanner();
    }
    
    private void readAllAddresses() throws AddressBookDaoException {
        view.displayDisplayAllBanner();
        List<Address> addressList = dao.readAll();
        view.displayCurrentAddressList(addressList);
        
    }
    
    private void readAnAddress() throws AddressBookDaoException {
        view.displayDisplayAddressBanner();
        String lastName = view.getLastNameChoice();
        Address address = dao.readByLastName(lastName);
        view.displayAddress(address);
    }
    
    private void deleteAddress() throws AddressBookDaoException {
        view.displayRemoveAddressBanner();
        String lastName = view.getLastNameChoice();
        dao.delete(lastName);
        view.displayRemoveSuccessBanner();
    }
    
    private void countAddresses() throws AddressBookDaoException {
        view.displayAddressCountBanner();
        int addressCount = dao.addressCount();
        view.displayAddressCount(addressCount);
    }
    
    private void editAnAddress() throws AddressBookDaoException {
        view.displayEditAddressBanner();
        String lastName = view.getLastNameChoice();
        Address newAddress = view.getNewAddressInfo();
        dao.editAddress(lastName, newAddress);
    }
    
    private void quitProgram() {
        view.displayExitBanner();
    }
    
}
