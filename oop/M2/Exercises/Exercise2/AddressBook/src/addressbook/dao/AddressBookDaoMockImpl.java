/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addressbook.dao;

import addressbook.dto.Address;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddressBookDaoMockImpl implements AddressBookDao {

    Map<String, Address> addresses = new HashMap<>();

    @Override
    public void create(Address address) throws AddressBookDaoException {
        addresses.put(address.getLastName(), address);
    }

    @Override
    public List<Address> readAll() throws AddressBookDaoException {
        return new ArrayList<Address>(addresses.values());
    }

    @Override
    public Address readByLastName(String lastName) throws AddressBookDaoException {
        return addresses.get(lastName);
    }

    @Override
    public void delete(String lastName) throws AddressBookDaoException {
        addresses.remove(lastName);
    }

    @Override
    public int addressCount() throws AddressBookDaoException {
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

}
