/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jetmanager.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import jetmanager.dto.Jet;

public class JetDaoFileImpl implements JetDao {

    //Member fields
    private Map<Integer, Jet> hangar = new HashMap<>(); //Data structure representing all the Jets in the hangar
    public static final String HANGAR_FILE = "hangar.txt"; //Text file to be read from and written to
    public static final String DELIMITER = "::"; //Delimiter for parsing through the text file

    @Override
    public Jet create(Jet jet) throws JetDaoException {
        if (hangar.containsKey(jet.getId())) {
            throw new JetDaoException("Id already in use");
        }
        Jet newJet = hangar.put(jet.getId(), jet);
        return newJet;
    }

    @Override
    public List<Jet> readAll() {
        return new ArrayList<Jet>(hangar.values());
    }

    @Override
    public Jet readById(int id) {
        return hangar.get(id);
    }

    @Override
    public void update(int id, Jet updateJet) throws JetDaoException {
        Jet currentJet = hangar.get(id);

        try {
            //If the new value is different from the old value and not set to the default value,
            //then the changes will take place
            if (updateJet.getMissleCount() != currentJet.getMissleCount() && updateJet.getMissleCount() != -1) {
                hangar.get(id).setMissleCount(updateJet.getMissleCount());
            }

            if (updateJet.getCurrentFuel() != currentJet.getCurrentFuel() && updateJet.getCurrentFuel() != -1) {
                hangar.get(id).setCurrentFuel(updateJet.getCurrentFuel());
            }

            if (!updateJet.getPilot().equals(currentJet.getPilot())) {
                if (updateJet.getPilot() != null) {
                    hangar.get(id).setPilot(updateJet.getPilot());
                }
            }
        } catch (NullPointerException e) {
            throw new JetDaoException("No such jet in the hangar.", e);
        }

    }

    @Override
    public void delete(int id) throws JetDaoException {
        //If the hangar contains a Jet with the specified id, then remove it
        if (hangar.containsKey(id)) {
            hangar.remove(id);
        } else {
            throw new JetDaoException("Id not found");
        }
    }

    @Override
    public List<Jet> findPilot(String name) {
        Set<Integer> jets = hangar.keySet();
        ArrayList<Jet> pilotJets = new ArrayList<>();
        Jet currentJet;
        for (Integer i : jets) {
            currentJet = hangar.get(i);
            if (currentJet.getPilot().equals(name)) {
                pilotJets.add(currentJet);
            }
        }
        return pilotJets;
    }

    @Override
    public void initialLoad() throws JetDaoException {
        loadHangar();
    }

    @Override
    public void exitProgram() throws JetDaoException {
        writeHangar();
    }

    /**
     * Loads the hangar from the text file and stores it into memory. Adapted
     * from The Software Guild's code-along.
     *
     * @throws JetDaoException
     */
    private void loadHangar() throws JetDaoException {
        Scanner scanner;

        try {
            //Create scanner for reading the file
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(HANGAR_FILE)));
        } catch (FileNotFoundException e) {
            throw new JetDaoException(
                    "-_- Could not load roster into memory", e);
        }

        String currentLine;
        String[] currentTokens;

        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentTokens = currentLine.split(DELIMITER);

            Jet currentJet = new Jet(Integer.parseInt(currentTokens[0]));
            currentJet.setModel(currentTokens[1]);
            currentJet.setMissleCount(Integer.parseInt(currentTokens[2]));
            currentJet.setFuelCapacity(Double.parseDouble(currentTokens[3]));
            currentJet.setCurrentFuel(Double.parseDouble(currentTokens[4]));
            currentJet.setPilot(currentTokens[5]);

            hangar.put(currentJet.getId(), currentJet);
        }
        scanner.close();
    }

    /**
     * Writes the hangar in memory to the text file. Adapted from The Software
     * Guild's code-along.
     *
     * @throws JetDaoException
     */
    private void writeHangar() throws JetDaoException {
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(HANGAR_FILE));
        } catch (IOException e) {
            throw new JetDaoException(
                    "Could not save hangar data.", e);
        }

        List<Jet> jetList = this.readAll();
        for (Jet currentJet : jetList) {
            out.println(currentJet.getId() + DELIMITER
                    + currentJet.getModel() + DELIMITER
                    + currentJet.getMissleCount() + DELIMITER
                    + currentJet.getFuelCapacity() + DELIMITER
                    + currentJet.getCurrentFuel() + DELIMITER
                    + currentJet.getPilot());
            out.flush();
        }
        out.close();
    }

}
