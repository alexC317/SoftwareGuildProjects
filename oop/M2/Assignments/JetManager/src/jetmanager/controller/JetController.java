/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jetmanager.controller;

import java.util.List;
import jetmanager.dao.JetDao;
import jetmanager.dto.Jet;
import jetmanager.view.JetView;
import jetmanager.view.UserIO;
import jetmanager.view.UserIOConsoleImpl;

/**
 *
 * @author Alex
 */
public class JetController {

    private JetDao dao;
    private JetView view;

    public JetController(JetDao dao, JetView view) {
        this.dao = dao;
        this.view = view;
    }

    public void run() {
        boolean quit = false;
        int choice;

        UserIO io = new UserIOConsoleImpl();
        view = new JetView(io);

        intro();

        while (!quit) {
            choice = getMenuSelection();

            switch (choice) {
                case 1:
                    createJet();
                    break;
                case 2:
                    listJets();
                    break;
                case 3:
                    //ReadById
                    break;
                case 4:
                    //Update
                    break;
                case 5:
                    //Delete
                    break;
                case 6:
                    //Search by pilot
                    break;
                case 7:
                    quit = true;
                    break;
                default:
                    io.print("Unknown command");
            }
        }
        io.print("Goodbye");
    }

    private void intro() {
        view.displayIntroduction();
    }

    private int getMenuSelection() {
        return view.displayMenuAndGetChoice();
    }

    private void createJet() {
        view.displayCreateJetBanner();
        Jet newJet = view.getNewJetInfo();
        dao.create(newJet);
        view.displayCreateSuccessBanner();
    }

    private void listJets() {
        view.displayListJetBanner();
        List<Jet> currentJets = dao.readAll();
        view.displayCurrentJetList(currentJets);
    }
    //private Jet readById
    //private void updateJet
    //private Jet deleteJet
    //private List searchByPilot
}
