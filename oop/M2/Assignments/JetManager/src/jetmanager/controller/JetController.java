/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jetmanager.controller;

import jetmanager.view.JetView;

/**
 *
 * @author Alex
 */
public class JetController {
    
    JetView view;
    //JetDao dao = new JetDaoImpl();
    
    public void run(){
        //UserIO io = new UserIOConsoleImpl();
        view = new JetView(io);
        boolean quit = false;
        while(!quit){
            int menuSelection = view.getMenuChoice();
            switch(menuSelection){
                case 1:
                    io.print("LIST JETS");
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    quit = true;
                    break;
                default:
                    io.print("UKNOWN COMMAND");
            }
        }
    }
    io.print("GOOD BYE");
}
