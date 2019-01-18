/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jetmanagermaven.dao;

import java.util.List;
import jetmanagermaven.dto.Jet;

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
     * @throws jetmanager.dao.JetDaoException
     */
    public Jet create(Jet jet) throws JetDaoException;

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
     * @throws JetDaoException
     */
    public void update(int id, Jet jet) throws JetDaoException;

    /**
     * Removes a Jet from the system.
     *
     * @param id The id associated with the Jet we want to remove.
     * @throws JetDaoException
     */
    public void delete(int id) throws JetDaoException;

    /**
     * Finds a specific pilot in the system.
     *
     * @param name The name of the pilot we want to find.
     * @return A list of all the Jets that pilot is associated with.
     */
    public List<Jet> findPilot(String name);

    /**
     * Gets all Jets from the past user-indicated years
     *
     * @param years
     * @return A list of Jets that were issued from now to the specified year.
     */
    public List<Jet> getAllJetsFromLastXYears(int years);

    /**
     * Gets all Jets of a particular model.
     *
     * @param model
     * @return A list of Jets matching the specified model.
     */
    public List<Jet> getJetsByModel(String model);

    /**
     * Gets the average of the Jets in the hangar.
     */
    public double getAverageJetAge();

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
