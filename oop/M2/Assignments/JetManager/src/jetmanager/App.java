/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jetmanager;

import jetmanager.controller.JetController;
import jetmanager.dao.JetDao;
import jetmanager.dao.JetDaoException;
import jetmanager.dao.JetDaoFileImpl;
import jetmanager.view.JetView;
import jetmanager.view.UserIO;
import jetmanager.view.UserIOConsoleImpl;

/**
 *
 * @author Alex
 */
public class App {
    
    /**
     * 
     * @param args
     * @throws JetDaoException 
     */
    public static void main(String[] args) throws JetDaoException {
        //Object declaration for Dependency Injection
        UserIO io = new UserIOConsoleImpl();
        JetDao dao = new JetDaoFileImpl();
        JetView view = new JetView(io);
        JetController controller = new JetController(dao, view);

        //Run the program
        controller.run();
    }

}
