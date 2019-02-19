/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.flooring.dto;

import java.math.BigDecimal;

/**
 *
 * @author Alex
 */
public class Tax {

    private String stateName;
    private BigDecimal taxRate;

    /**
     * Constructor for the Tax class. Takes in a State name that will be its ID.
     *
     * @param stateName A String that will work as an ID.
     */
    public Tax(String stateName) {
        this.stateName = stateName;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }

}
