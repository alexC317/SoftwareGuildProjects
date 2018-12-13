/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addressbook;

import addressbook.controller.AddressBookController;
import addressbook.dao.AddressBookDao;
import addressbook.dao.AddressBookDaoImpl;
import addressbook.view.AddressBookView;
import addressbook.view.UserIO;
import addressbook.view.UserIOImpl;

/**
 *
 * @author Alex
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        UserIO io = new UserIOImpl();
        AddressBookView view = new AddressBookView(io);
        AddressBookDao dao = new AddressBookDaoImpl();
        AddressBookController controller = new AddressBookController(view, dao);
        controller.run();
        
    }
    
}
