/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jetmanager.view;

import java.util.List;
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

    public void displayIntroduction() {
        io.print("Hello and welcome Commander.");
        io.print("This is the Jet Manager program, developed by Macmillan Heavy Industries.");
        io.print("This program will help manage the various planes in your hangar. Please select from the following options below.");
    }

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

    public void displayCreateJetBanner() {
        io.print("=== Create new Jet ===");
    }

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

        return currentJet;
    }

    public void displayCreateSuccessBanner() {
        io.print("Jet successfully created.");
    }

    public void displayListJetBanner() {
        io.print("=== List All Jets ===");
    }

    public void displayCurrentJetList(List<Jet> currentJets) {
        for (Jet currentJet : currentJets) {
            io.print(currentJet.getId() + ": " + currentJet.getModel());
        }
        io.print("");
    }

    public void displayDisplayJetBanner() {
        io.print("=== Display Jet ===");
    }

    public int getJetIdChoice() {
        return io.readInt("Please enter the id of the jet.");
    }

    public void displayJet(Jet jet) {
        io.print("-----------");
        if (jet != null) {
            io.print("Id: " + jet.getId());
            io.print("Model: " + jet.getModel());
            io.print("Pilot: " + jet.getPilot());
            io.print("Current Missles: " + jet.getMissleCount());
            io.print("Fuel: " + jet.getCurrentFuel() + "/" + jet.getFuelCapacity());
        } else {
            io.print("No such plane in the hangar.");
        }
        io.print("-----------");
        io.print("");
    }

    public void displayUpdateJetBanner() {
        io.print("=== Update Jet ===");
    }

    public Jet getUpdateJetInfo(double fuelCap) {
        boolean quit = false;
        int choice;
        int jetMissleCount = 0;
        double currentFuel = 0;
        String jetPilot = "";
        Jet updateJet = new Jet(0);

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
                    currentFuel = io.readDouble("Please enter the current fuel the plane has.", 0, fuelCap);
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

    public void displayUpdateSuccessBanner() {
        io.print("Jet successfully updated.");
    }

    public void displayDeleteJetBanner() {
        io.print("=== Delete Jet ===");
    }

    public void displayDeleteSuccessBanner() {
        io.print("Jet successfully deleted.");
    }

}
