/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jetmanager.view;

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

    public int getMenuChoice() {
        io.print("1. List JETS");
        io.print("2. Create JETS");
        io.print("3. View JETS");
        io.print("4. Remove JETS");
        return io.promptUserInt("5. Exit");
    }

    public void displayCreateJetBanner() {
        io.print("===Create Jet===");
    }

    public void displayCreateSuccessBanner() {
        io.readString("Jet successfully created. Please hit enter to continue.");
    }

    public Jet getNewJetInfo() {
        int jetID = io.promptUserInt("Please enter Student ID:");
        String jetModel = io.readString("Please enter the model: ");
        int jetMissle = io.promptUserInt("Please enter how many missles this is armed with: ");
        double jetFuel = io.promptUserDouble("Please enter the fuel capacity for this jet: "); //Can't melt steel beams

        Jet currentJet = new Jet();

        currentJet.setId(jetID);
        currentJet.setModel(jetModel);
        currentJet.setMissleCount(jetMissle);
        currentJet.setFuelCapacity(jetFuel);
        return currentJet;
    }
}
