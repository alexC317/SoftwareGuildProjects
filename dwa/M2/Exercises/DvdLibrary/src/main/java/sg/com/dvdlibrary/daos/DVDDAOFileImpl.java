/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.com.dvdlibrary.daos;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import sg.com.dvdlibrary.dtos.DVD;

public class DVDDAOFileImpl implements DVDDAO {

    private Map<Integer, DVD> dvds;

    public DVDDAOFileImpl() {
        this.dvds = new HashMap<>();
    }

    @Override
    public DVD Create(DVD entity) {
        int id = 0;
        if (dvds.size() > 0) {
            id = this.dvds.keySet().stream().max(Comparator.reverseOrder()).get();
        }
        id++;
        entity.setId(id);
        dvds.put(id, entity);
        return entity;
    }

    @Override
    public List<DVD> ReadAll() {
        return new ArrayList(dvds.values());
    }

    @Override
    public DVD ReadById(int id) {
        if (dvds.containsKey(id)) {
            return dvds.get(id);
        }
        return null;
    }

    @Override
    public void Update(int id, DVD entity) {
        if (dvds.containsKey(id)) {
            dvds.put(id, entity);
        }
    }

    @Override
    public void Delete(int id) {
        if (dvds.containsKey(id)) {
            dvds.remove(id);
        }
    }

    @Override
    public List<DVD> ReadByDirectorId(int directorId) {
        List<DVD> results = new ArrayList<>();
        
        for(DVD dvd : dvds.values()){
            if(directorId == dvd.getDirectorId()){
                results.add(dvd);
            }
        }
        return results;
    }

}
