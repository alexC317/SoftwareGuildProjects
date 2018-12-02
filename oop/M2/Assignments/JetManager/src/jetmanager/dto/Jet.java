/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jetmanager.dto;

/**
 *
 * @author Alex
 */
public class Jet {
    
    private int id;
    private String model;
    private int missleCount;
    private double fuelCapacity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getMissleCount() {
        return missleCount;
    }

    public void setMissleCount(int missleCount) {
        this.missleCount = missleCount;
    }

    public double getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(double fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }
    
}
