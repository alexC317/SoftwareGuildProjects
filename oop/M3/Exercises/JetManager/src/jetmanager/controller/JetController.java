/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jetmanager.controller;

import java.util.List;
import jetmanager.dao.JetDao;
import jetmanager.dao.JetDaoException;
import jetmanager.dto.Jet;
import jetmanager.view.JetView;

/**
 *
 * @author Alex
 */
public class JetController {

    //Member fields
    private JetDao dao;
    private JetView view;

    //Constructor
    public JetController(JetDao dao, JetView view) {
        this.dao = dao;
        this.view = view;
    }

    /**
     * Runs the program. This will continously display the menu, take in a user
     * choice, and then act on that choice.
     *
     * @throws JetDaoException
     */
    public void run() {
        //Variable declaration
        boolean quit = false; //Used to keep the program running
        int choice = 0; //Stores what the menu choice is

        try {
            intro(); //Calls the controller's intro function
            //Loops the program until the user quits using option 7
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
                        searchByPilot();
                        break;
                    case 7:
                        getAllJetsFromXYears();
                        break;
                    case 8:
                        getAllJetsByModel();
                        break;
                    case 9:
                        getJetAverageAge();
                        break;
                    case 10:
                        quit = true;
                        break;
                    default:
                        unknownCommand();
                }
            }
            exitMessage();
        } catch (JetDaoException e) {
            view.displayErrorMessage(e.getMessage());
        }//finally and use run() again
    }

    /**
     * Calls the View Layer's introduction method.
     */
    private void intro() throws JetDaoException {
        dao.initialLoad();
        view.displayIntroduction();
    }

    /**
     * Calls the View Layer's menu display and returns their choice.
     *
     * @return the menu option selected by the user
     */
    private int getMenuSelection() throws JetDaoException {
        return view.displayMenuAndGetChoice();
    }

    /**
     * Creates a new instance of the Jet class.
     */
    private void createJet() throws JetDaoException {
        view.displayCreateJetBanner();
        Jet newJet = view.getNewJetInfo();
        dao.create(newJet);
        view.displayCreateSuccessBanner();
    }

    /**
     * Displays all the Jets currently in the system.
     */
    private void listJets() {
        view.displayListJetBanner();
        List<Jet> currentJets = dao.readAll();
        view.displayCurrentJetList(currentJets);
    }

    /**
     * Displays information for a single Jet.
     */
    private void viewJet() {
        view.displayDisplayJetBanner();
        int id = view.getJetIdChoice();
        Jet newJet = dao.readById(id);
        view.displayJet(newJet);
    }

    /**
     * Updates the information for a single Jet.
     *
     * @throws JetDaoException
     */
    private void updateJet() throws JetDaoException {
        view.displayUpdateJetBanner();
        int id = view.getJetIdChoice();
        Jet currentJet = dao.readById(id);
        Jet updateJet = view.getUpdateJetInfo(currentJet);
        dao.update(id, updateJet);
        view.displayUpdateSuccessBanner();
    }

    /**
     * Deletes a Jet from the system.
     *
     * @throws JetDaoException
     */
    private void deleteJet() throws JetDaoException {
        view.displayDeleteJetBanner();
        int id = view.getJetIdChoice();
        dao.delete(id);
        view.displayDeleteSuccessBanner();
    }

    /**
     * Allows the user to search for a pilot and displays all the Jets they fly.
     */
    private void searchByPilot() {
        view.displaySearchPilotBanner();
        String name = view.getPilotName();
        List<Jet> jets = dao.findPilot(name);
        view.displayPilotList(jets);
    }

    /**
     * Allows the user to get a List of all Jets issues within X amount of
     * years.
     */
    private void getAllJetsFromXYears() {
        view.displayGetJetsByYearRangeBanner();
        int years = view.getNumOfYears();
        List<Jet> jets = dao.getAllJetsFromLastXYears(years);
        view.displayCurrentJetList(jets);
    }

    /**
     * Allows the user to get a List of all Jets by a particular model.
     */
    private void getAllJetsByModel() {
        view.displayGetJetsByModelBanner();
        String model = view.getModel();
        List<Jet> jets = dao.getJetsByModel(model);
        view.displayCurrentJetList(jets);
    }

    /**
     * Allows the user to get the average age of all the Jets in the hangar.
     */
    private void getJetAverageAge() {
        view.displayGetAverageAgeBanner();
        float avgAge = (float) dao.getAverageJetAge();
        view.displayAverageAge(avgAge);
    }

    /**
     * Calls the View Layer's unknown command method.
     */
    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    /**
     * Calls the View Layer's exit message method.
     */
    private void exitMessage() throws JetDaoException {
        dao.exitProgram();
        view.displayExitMessageBanner();
    }

}
