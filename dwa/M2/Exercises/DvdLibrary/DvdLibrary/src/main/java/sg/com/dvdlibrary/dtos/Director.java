/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.com.dvdlibrary.dtos;

import java.util.List;

/**
 *
 * @author Randall
 */
public class Director {
    private int id;
    private String name;
    private List<Dvd> dvds;

    public List<Dvd> getDvds() {
        return dvds;
    }

    public void setDvds(List<Dvd> dvds) {
        this.dvds = dvds;
    }
    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
