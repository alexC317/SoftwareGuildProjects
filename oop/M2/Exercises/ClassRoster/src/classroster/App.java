/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classroster;

import classroster.controller.ClassRosterController;
import classroster.dao.ClassRosterDao;
import classroster.dao.ClassRosterDaoFileImpl;
import classroster.ui.ClassRosterView;
import classroster.ui.UserIO;
import classroster.ui.UserIOConsoleImpl;

/**
 *
 * @author Alex
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        UserIO myIo = new UserIOConsoleImpl();
        ClassRosterView myView = new ClassRosterView(myIo);
        ClassRosterDao myDao = new ClassRosterDaoFileImpl();
        ClassRosterController controller = new ClassRosterController(myDao, myView);
        controller.run();
    }

}
