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

    public List<Product> readAll();

    public Product readById(String productName);

}
