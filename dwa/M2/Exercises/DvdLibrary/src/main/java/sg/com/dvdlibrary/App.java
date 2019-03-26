/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.com.dvdlibrary;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import sg.com.dvdlibrary.controllers.DVDController;
import sg.com.dvdlibrary.daos.DirectorDAOFileImpl;
import sg.com.dvdlibrary.daos.DVDDAOFileImpl;
import sg.com.dvdlibrary.services.DVDServiceImpl;
import sg.com.dvdlibrary.views.DVDLibraryView;
import sg.com.dvdlibrary.views.UserConsoleIOImpl;

/**
 *
 * @author Randall
 */
public class App {

    public static void main(String[] args) {
        //DvdDao dvdDao = new DVDDAOFileImpl();
        //DirectorDao directorDao = new DirectorDAOFileImpl();
        //DvdService service = new DVDServiceImpl(dvdDao, directorDao);
        //UserIO io = new UserConsoleIOImpl();
        //DvdLibraryView view = new DVDLibraryView(io);
        //DvdController controller = new DVDController(view, service);

        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        DVDController controller = ctx.getBean("DVDController", DVDController.class);

        controller.Run();
    }
}
