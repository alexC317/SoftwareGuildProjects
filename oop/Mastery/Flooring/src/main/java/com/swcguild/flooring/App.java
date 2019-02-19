/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.flooring;

import com.swcguild.flooring.controller.Controller;
import com.swcguild.flooring.dao.FlooringPersistenceException;
import com.swcguild.flooring.dao.OrderDAO;
import com.swcguild.flooring.dao.OrderDAOProdFileImpl;
import com.swcguild.flooring.dao.ProductDAO;
import com.swcguild.flooring.dao.ProductDAOFileImpl;
import com.swcguild.flooring.dao.TaxDAO;
import com.swcguild.flooring.dao.TaxDAOFileImpl;
import com.swcguild.flooring.service.Service;
import com.swcguild.flooring.service.ServiceImpl;
import com.swcguild.flooring.view.UserIO;
import com.swcguild.flooring.view.UserIOConsoleImpl;
import com.swcguild.flooring.view.View;

/**
 *
 * @author Alex
 */
public class App {

    public static void main(String[] args) throws FlooringPersistenceException {
        UserIO IO = new UserIOConsoleImpl();
        View view = new View(IO);
        OrderDAO orderDAO = new OrderDAOProdFileImpl();
        ProductDAO productDAO = new ProductDAOFileImpl();
        TaxDAO taxDAO = new TaxDAOFileImpl();
        Service service = new ServiceImpl(taxDAO, productDAO, orderDAO);
        Controller controller = new Controller(view, service);

        controller.run();
    }
}
