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
public class Product {

    private String productType;
    private BigDecimal costPerSquareFoot;
    private BigDecimal laborCostPerSqaureFoot;

    public Product(String productType) {
        this.productType = productType;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public BigDecimal getCostPerSquareFoot() {
        return costPerSquareFoot;
    }

    public void setCostPerSquareFoot(BigDecimal costPerSquareFoot) {
        this.costPerSquareFoot = costPerSquareFoot;
    }

    public BigDecimal getLaborCostPerSqaureFoot() {
        return laborCostPerSqaureFoot;
    }

    public void setLaborCostPerSqaureFoot(BigDecimal laborCostPerSqaureFoot) {
        this.laborCostPerSqaureFoot = laborCostPerSqaureFoot;
    }

}
