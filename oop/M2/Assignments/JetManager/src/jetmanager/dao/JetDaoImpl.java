/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jetmanager.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import jetmanager.dto.Jet;

public class JetDaoImpl implements JetDao {

    private Map<Integer, Jet> hangar = new HashMap<>();

    @Override
    public Jet create(Jet jet) {
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
    public void update(int id, Jet updateJet) {
        Jet currentJet = hangar.get(id);

        if (updateJet.getMissleCount() != currentJet.getMissleCount() && updateJet.getMissleCount() != -1) {
            hangar.get(id).setMissleCount(updateJet.getMissleCount());
        }

        if (updateJet.getCurrentFuel() != currentJet.getCurrentFuel() && updateJet.getCurrentFuel() != -1) {
            hangar.get(id).setCurrentFuel(updateJet.getCurrentFuel());
        }

        if (updateJet.getPilot() != currentJet.getPilot()) {
            if (updateJet.getPilot() != null) {
                hangar.get(id).setPilot(updateJet.getPilot());
            }
        }
    }

    @Override
    public void delete(int id) {
        hangar.remove(id);
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

}
