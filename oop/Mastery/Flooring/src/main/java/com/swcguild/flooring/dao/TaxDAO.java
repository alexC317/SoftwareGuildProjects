/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.flooring.dao;

import com.swcguild.flooring.dto.Tax;
import java.util.List;

/**
 *
 * @author Alex
 */
public interface TaxDAO {

    /**
     * Gets all the Taxes in the taxes file.
     *
     * @return All the Taxes in the taxes file.
     */
    public List<Tax> readAll();

    /**
     * Gets a Tax from the product file.
     *
     * @param stateName The state name to look for.
     * @return The Tax associated with the product Name.
     */
    public Tax readById(String stateName);

}
