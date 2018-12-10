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
                    viewJet();
                    break;
                case 4:
                    updateJet();
                    break;
                case 5:
                    deleteJet();
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

    private void viewJet() {
        view.displayDisplayJetBanner();
        int id = view.getJetIdChoice();
        Jet newJet = dao.readById(id);
        view.displayJet(newJet);
    }

    private void updateJet() {
        view.displayUpdateJetBanner();
        int id = view.getJetIdChoice();
        double fuelCap = dao.readById(id).getFuelCapacity();
        Jet newJet = view.getUpdateJetInfo(fuelCap);
        dao.update(id, newJet);
        view.displayUpdateSuccessBanner();
    }

    private void deleteJet() {
        view.displayDeleteJetBanner();
        int id = view.getJetIdChoice();
        dao.delete(id);
        view.displayDeleteSuccessBanner();
    }
        //private List searchByPilot
    }
