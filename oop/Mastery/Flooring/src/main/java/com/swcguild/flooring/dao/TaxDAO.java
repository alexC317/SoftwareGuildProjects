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

    public List<Tax> readAll();

    public Tax readById(String stateName);

}
