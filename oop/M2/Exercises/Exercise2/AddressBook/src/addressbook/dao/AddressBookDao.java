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

    public void create(Address address);

    public List<Address> readAll();

    public Address readByLastName(String lastName);

    public void delete(String lastName);
    
    public int addressCount();
    
    public void editAddress(String lastName, Address newAddress);
}
