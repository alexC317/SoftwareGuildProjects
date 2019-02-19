/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.flooring.dao;

import com.swcguild.flooring.dto.Product;
import java.util.List;

/**
 *
 * @author Alex
 */
public interface ProductDAO {

    /**
     * Gets all the Products in the product file.
     *
     * @return All the Products in the product file.
     */
    public List<Product> readAll();

    /**
     * Gets a Product from the product file.
     *
     * @param productName The product name to look for.
     * @return The Product associated with the product Name.
     */
    public Product readById(String productName);

}
