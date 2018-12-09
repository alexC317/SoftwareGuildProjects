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
    
    public void displayIntroduction(){
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
        int jetMissleCount = io.readInt("Please how many missles the jet is carrying.");
        double jetFuel = io.readDouble("Please enter the fuel capacity of the plane.");
        String jetPilot = io.readString("Please enter the name of the pilot.");

        Jet currentJet = new Jet(jetId);
        currentJet.setModel(jetModel);
        currentJet.setMissleCount(jetMissleCount);
        currentJet.setFuelCapacity(jetFuel);
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
