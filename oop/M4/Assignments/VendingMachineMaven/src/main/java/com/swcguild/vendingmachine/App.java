/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.vendingmachine;

import com.swcguild.vendingmachine.controller.VendingMachineController;
import com.swcguild.vendingmachine.dao.VendingMachineAuditDao;
import com.swcguild.vendingmachine.dao.VendingMachineAuditDaoFileImpl;
import com.swcguild.vendingmachine.dao.VendingMachineDao;
import com.swcguild.vendingmachine.dao.VendingMachineDaoFileImpl;
import com.swcguild.vendingmachine.dao.VendingMachinePersistenceException;
import com.swcguild.vendingmachine.service.InsufficientFundsException;
import com.swcguild.vendingmachine.service.ItemOutOfStockException;
import com.swcguild.vendingmachine.service.VendingMachineItemOverCapacityException;
import com.swcguild.vendingmachine.service.VendingMachineServiceLayer;
import com.swcguild.vendingmachine.service.VendingMachineServiceLayerImpl;
import com.swcguild.vendingmachine.view.UserIO;
import com.swcguild.vendingmachine.view.UserIOConsoleImpl;
import com.swcguild.vendingmachine.view.VendingMachineView;

/**
 *
 * @author Alex
 */
public class App {

    /**
     * @param args the command line arguments
     * @throws vendingmachine.dao.VendingMachinePersistenceException
     * @throws vendingmachine.service.InsufficientFundsException
     * @throws vendingmachine.service.ItemOutOfStockException
     * @throws vendingmachine.service.VendingMachineItemOverCapacityException
     */
    public static void main(String[] args) throws
            VendingMachinePersistenceException,
            InsufficientFundsException,
            ItemOutOfStockException,
            VendingMachineItemOverCapacityException {
        UserIO myIo = new UserIOConsoleImpl();
        VendingMachineView myView = new VendingMachineView(myIo);
        VendingMachineDao myDao = new VendingMachineDaoFileImpl();
        VendingMachineAuditDao myAuditDao = new VendingMachineAuditDaoFileImpl();
        VendingMachineServiceLayer myService = new VendingMachineServiceLayerImpl(myDao, myAuditDao);
        VendingMachineController controller = new VendingMachineController(myView, myService);
        controller.run();
    }

}
