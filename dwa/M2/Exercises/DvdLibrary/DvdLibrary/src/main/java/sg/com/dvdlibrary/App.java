/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.com.dvdlibrary;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import sg.com.dvdlibrary.controllers.DvdController;
import sg.com.dvdlibrary.daos.DirectorDaoFileImpl;
import sg.com.dvdlibrary.daos.DvdDaoFileImpl;
import sg.com.dvdlibrary.services.DvdServiceImpl;
import sg.com.dvdlibrary.views.DvdLibraryView;
import sg.com.dvdlibrary.views.UserConsoleIOImpl;

/**
 *
 * @author Randall
 */
public class App {

    public static void main(String[] args) {
        //DvdDao dvdDao = new DvdDaoFileImpl();
        //DirectorDao directorDao = new DirectorDaoFileImpl();
        //DvdService service = new DvdServiceImpl(dvdDao, directorDao);
        //UserIO io = new UserConsoleIOImpl();
        //DvdLibraryView view = new DvdLibraryView(io);
        //DvdController controller = new DvdController(view, service);

        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        DvdController controller = ctx.getBean("dvdController", DvdController.class);

        controller.Run();
    }
}
