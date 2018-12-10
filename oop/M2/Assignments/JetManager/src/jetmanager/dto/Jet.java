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

    //Private class fields
    private int id;
    private String model;
    private int missleCount = -1;
    private double fuelCapacity = -1;
    private double currentFuel = -1;
    private String pilot = null;

    //Constructor
    public Jet(int id) {
        this.id = id;
    }

    //Get and Set Methods
    public int getId() {
        return id;
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

    public double getCurrentFuel() {
        return currentFuel;
    }

    public void setCurrentFuel(double currentFuel) {
        this.currentFuel = currentFuel;
    }

    public String getPilot() {
        return pilot;
    }

    public void setPilot(String pilot) {
        this.pilot = pilot;
    }

}
