/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jetmanager.dao;

import java.util.List;
import jetmanager.dto.Jet;

/**
 *
 * @author Alex
 */
public interface JetDao {

    //Create
    public Jet create(Jet jet);

    //ReadAll
    public List<Jet> readAll();

    //ReadById
    public Jet readById(int id);

    //Update
    public void update(int id, Jet jet);

    //Delete
    public void delete(int id);
    
    public List<Jet> findPilot(String name);
}
