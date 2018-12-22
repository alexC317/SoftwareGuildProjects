/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addressbook.dao;

import addressbook.dto.Address;
import java.util.List;

/**
 *
 * @author Alex
 */
public interface AddressBookDao {

    public void create(Address address) throws AddressBookDaoException;

    public List<Address> readAll() throws AddressBookDaoException;

    public Address readByLastName(String lastName) throws AddressBookDaoException;

    public void delete(String lastName) throws AddressBookDaoException;
    
    public int addressCount() throws AddressBookDaoException;
    
    public void editAddress(String lastName, Address newAddress) throws AddressBookDaoException;
}
