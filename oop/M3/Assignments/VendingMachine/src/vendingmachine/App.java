/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine;

import vendingmachine.controller.VendingMachineController;
import vendingmachine.dao.VendingMachineDao;
import vendingmachine.dao.VendingMachineDaoFileImpl;
import vendingmachine.dao.VendingMachinePersistenceException;
import vendingmachine.service.InsufficientFundsException;
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
     */
    public static void main(String[] args) throws VendingMachinePersistenceException, InsufficientFundsException {
        UserIO myIo = new UserIOConsoleImpl();
        VendingMachineView myView = new VendingMachineView(myIo);
        VendingMachineDao myDao = new VendingMachineDaoFileImpl();
        VendingMachineService myService = new VendingMachineServiceImpl(myDao);
        VendingMachineController controller = new VendingMachineController(myView, myService);
        controller.run();
    }

}
