/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jetmanager.view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import jetmanager.dao.JetDaoException;
import jetmanager.dto.Jet;

/**
 *
 * @author Alex
 */
public class JetView {

    private UserIO io;

    public JetView(UserIO io) {
        this.io = io;
    }

    /**
     * Displays an introduction to the user.
     */
    public void displayIntroduction() {
        io.print("Hello and welcome Commander.");
        io.print("This is the Jet Manager program, developed by Macmillan Heavy Industries.");
        io.print("This program will help manage the various planes in your hangar. Please select from the following options below.");
    }

    /**
     * Displays the menu to the user. It also will pass along the user choice to
     * the controller.
     *
     * @return The menu choice the user selected.
     */
    public int displayMenuAndGetChoice() {
        io.print("Main Menu");
        io.print("1. Create new Jet");
        io.print("2. View all Jets in the hangar");
        io.print("3. View an individual Jet");
        io.print("4. Update an individual Jet");
        io.print("5. Delete an individual Jet");
        io.print("6. Search for a pilot");
        io.print("7. Exit");

        return io.readInt("Please select one from the above choices.", 1, 7);
    }

    /**
     * Displays a banner once the user has selected to create a new Jet.
     */
    public void displayCreateJetBanner() {
        io.print("=== Create new Jet ===");
    }

    /**
     * Takes in the information from the user to make a new Jet and does so.
     *
     * @return A new Jet back to the controller.
     */
    public Jet getNewJetInfo() {
        int jetId = io.readInt("Please enter the ID.");
        String jetModel = io.readString("Please enter the model.");
        int jetMissleCount = io.readInt("Please enter how many missles the jet is carrying.");
        double jetFuel = io.readDouble("Please enter the fuel capacity of the plane.");
        double currentFuel = io.readDouble("Please enter the current fuel the plane has.", 0, jetFuel);
        String jetPilot = io.readString("Please enter the name of the pilot.");

        Jet currentJet = new Jet(jetId);
        currentJet.setModel(jetModel);
        currentJet.setMissleCount(jetMissleCount);
        currentJet.setFuelCapacity(jetFuel);
        currentJet.setCurrentFuel(currentFuel);
        currentJet.setPilot(jetPilot);
        currentJet.setDateIssued(LocalDate.now());

        return currentJet;
    }

    /**
     * Displays a banner once the Jet has been successfully created.
     */
    public void displayCreateSuccessBanner() {
        io.readString("Jet successfully created. Press enter to continue.");
    }

    /**
     * Displays a banner once the user has selected to view all Jets.
     */
    public void displayListJetBanner() {
        io.print("=== List All Jets ===");
    }

    /**
     * Displays all Jets and their associated IDs in the system.
     *
     * @param currentJets A list of current Jets in the system.
     */
    public void displayCurrentJetList(List<Jet> currentJets) {
        for (Jet currentJet : currentJets) {
            io.print(currentJet.getId() + ": " + currentJet.getModel());
        }
        io.print("");
    }

    /**
     * Displays a banner once the user has selected to view a particular Jet.
     */
    public void displayDisplayJetBanner() {
        io.print("=== Display Jet ===");
    }

    /**
     * Prompts the user to enter the ID of the Jet they want to view.
     *
     * @return The ID of the Jet the user wants to view.
     */
    public int getJetIdChoice() {
        return io.readInt("Please enter the id of the jet.");
    }

    /**
     * Displays the information of the Jet the user wants to view.
     *
     * @param jet The Jet associated with the ID they indicated earlier.
     */
    public void displayJet(Jet jet) {
        io.print("-----------");
        if (jet != null) {
            io.print("Id: " + jet.getId());
            io.print("Model: " + jet.getModel());
            io.print("Pilot: " + jet.getPilot());
            io.print("Current Missles: " + jet.getMissleCount());
            io.print("Fuel: " + jet.getCurrentFuel() + "/" + jet.getFuelCapacity());
            io.print("Date Issued: " + jet.getDateIssued().format(DateTimeFormatter.ofPattern("MM/dd/yyyy")));
        } else {
            io.print("No such plane in the hangar.");
        }
        io.print("-----------");
        io.print("");
    }

    /**
     * Displays a banner once the user has selected to update a particular Jet.
     */
    public void displayUpdateJetBanner() {
        io.print("=== Update Jet ===");
    }

    /**
     * Prompts the user for new information in order to update a particular Jet.
     * The user selects what information they want to provide. Not all fields
     * are subject to change (such as the ID, the Model and the Fuel Capacity).
     *
     * @param jet The Jet that will be changed is passed along only to get the
     * Fuel Capacity.
     * @return A Jet object containing the changes the user indicated.
     */
    public Jet getUpdateJetInfo(Jet jet) {
        boolean quit = false;
        int choice;
        int jetMissleCount = -1;
        double currentFuel = -1;
        String jetPilot = null;
        Jet updateJet = new Jet(0);

        if (jet != null) {
            io.print("Change Menu");
            while (!quit) {
                io.print("1. Missle Count");
                io.print("2. Current Fuel");
                io.print("3. Pilot");
                io.print("4. Exit");
                choice = io.readInt("Please select which attribute you wish to update:", 1, 4);
                switch (choice) {
                    case 1:
                        jetMissleCount = io.readInt("Please enter how many missles the jet is now carrying.");
                        updateJet.setMissleCount(jetMissleCount);
                        break;
                    case 2:
                        currentFuel = io.readDouble("Please enter the current fuel the plane has.", 0, jet.getFuelCapacity());
                        updateJet.setCurrentFuel(currentFuel);
                        break;
                    case 3:
                        jetPilot = io.readString("Please enter the name of the pilot.");
                        updateJet.setPilot(jetPilot);
                        break;
                    case 4:
                        quit = true;
                        break;
                }
            }
            return updateJet;
        }
        return jet;
    }

    /**
     * Displays a banner once the Jet has been successfully updated.
     */
    public void displayUpdateSuccessBanner() {
        io.print("Jet successfully updated. Press enter to continue.");
    }

    /**
     * Displays a banner once the user has selected to update a particular Jet.
     */
    public void displayDeleteJetBanner() {
        io.print("=== Delete Jet ===");
    }

    /**
     * Displays a banner once the Jet has been successfully deleted.
     */
    public void displayDeleteSuccessBanner() {
        io.readString("Jet successfully deleted. Press enter to continue.");
    }

    /**
     * Displays a banner once the user has selected to search for a particular
     * Jet.
     */
    public void displaySearchPilotBanner() {
        io.print("=== Search for Pilot ===");
    }

    /**
     * Prompts the user to enter the name of the pilot they want to find.
     *
     * @return The String containing the pilot's name.
     */
    public String getPilotName() {
        return io.readString("Please enter the pilot's name.");
    }

    /**
     * Displays the pilot the user was searching for, as well as what Jets they
     * fly.
     *
     * @param jets The list of Jets associated with that pilot.
     */
    public void displayPilotList(List<Jet> jets) {
        io.print("-----------");
        if (!jets.isEmpty()) {
            io.print("Pilot: " + jets.get(0).getPilot() + " flies the following: ");
            for (Jet j : jets) {
                io.print(j.getId() + ": " + j.getModel());
            }

        } else {
            io.print("No such pilot found.");
        }
        io.print("-----------");
    }

    /**
     * Displays a banner if there is an unknown command.
     */
    public void displayUnknownCommandBanner() {
        io.print("Unknown command.");
    }

    /**
     * Displays once the user has selected to exit the program.
     */
    public void displayExitMessageBanner() {
        io.print("Goodbye, Commander.");
    }

    /**
     * Displays a banner and error message if an exception has been reached.
     *
     * @param errorMsg
     */
    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }

}
