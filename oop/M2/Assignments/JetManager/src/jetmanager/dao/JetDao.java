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

    /**
     * Stores a Jet in the system.
     *
     * @param jet The jet we are storing in the hangar.
     * @return The newly inserted Jet object.
     */
    public Jet create(Jet jet);

    /**
     * Returns all the Jets in the system.
     *
     * @return A List of all the Jets currently in the hangar.
     */
    public List<Jet> readAll();

    /**
     * Returns the Jet object from the system.
     *
     * @param id the id of the Jet we are wanting to view.
     * @return The Jet associated with that ID number.
     */
    public Jet readById(int id);

    /**
     * Updates a Jet in the system.
     *
     * @param id The id of the Jet we are wanting to update.
     * @param jet A temporary Jet that holds the changes we want to make.
     */
    public void update(int id, Jet jet) throws JetDaoException;

    /**
     * Removes a Jet from the system.
     *
     * @param id The id associated with the Jet we want to remove.
     */
    public void delete(int id);

    /**
     * Finds a specific pilot in the system.
     *
     * @param name The name of the pilot we want to find.
     * @return A list of all the Jets that pilot is associated with.
     */
    public List<Jet> findPilot(String name);

    /**
     * Loads the text file that represents the hangar.
     *
     * @throws JetDaoException
     */
    public void initialLoad() throws JetDaoException;

    /**
     * Writes the hangar in memory to the text file.
     *
     * @throws JetDaoException
     */
    public void exitProgram() throws JetDaoException;
}
