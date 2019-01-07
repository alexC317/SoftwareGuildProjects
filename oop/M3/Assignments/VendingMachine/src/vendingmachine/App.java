/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine;

import vendingmachine.controller.VendingMachineController;
import vendingmachine.dao.VendingMachineAuditDao;
import vendingmachine.dao.VendingMachineAuditDaoFileImpl;
import vendingmachine.dao.VendingMachineDao;
import vendingmachine.dao.VendingMachineDaoFileImpl;
import vendingmachine.dao.VendingMachinePersistenceException;
import vendingmachine.service.InsufficientFundsException;
import vendingmachine.service.ItemOutOfStockException;
import vendingmachine.service.VendingMachineService;
import vendingmachine.service.VendingMachineServiceImpl;
import vendingmachine.view.UserIO;
import vendingmachine.view.UserIOConsoleImpl;
import vendingmachine.view.VendingMachineView;

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
     */
    public static void main(String[] args) throws VendingMachinePersistenceException, InsufficientFundsException, ItemOutOfStockException {
        UserIO myIo = new UserIOConsoleImpl();
        VendingMachineView myView = new VendingMachineView(myIo);
        VendingMachineDao myDao = new VendingMachineDaoFileImpl();
        VendingMachineAuditDao myAuditDao = new VendingMachineAuditDaoFileImpl();
        VendingMachineService myService = new VendingMachineServiceImpl(myDao, myAuditDao);
        VendingMachineController controller = new VendingMachineController(myView, myService);
        controller.run();
    }

}
