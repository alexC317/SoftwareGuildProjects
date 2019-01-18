/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jetmanagermaven;

import jetmanagermaven.controller.JetController;
import jetmanagermaven.dao.JetDao;
import jetmanagermaven.dao.JetDaoException;
import jetmanagermaven.dao.JetDaoFileImpl;
import jetmanagermaven.view.JetView;
import jetmanagermaven.view.UserIO;
import jetmanagermaven.view.UserIOConsoleImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Alex
 */
public class App {

    public static void main(String[] args) throws JetDaoException {
//        //Object declaration for Dependency Injection
//        UserIO io = new UserIOConsoleImpl();
//        JetDao dao = new JetDaoFileImpl();
//        JetView view = new JetView(io);
//        JetController controller = new JetController(dao, view);

        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        JetController controller = ctx.getBean("controller", JetController.class);

        //Run the program
        controller.run();

    }
}
