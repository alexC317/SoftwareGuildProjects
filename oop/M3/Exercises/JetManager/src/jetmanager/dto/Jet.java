/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jetmanager.dto;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

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
    private LocalDate dateIssued = null;

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

    public LocalDate getDateIssued() {
        return dateIssued;
    }

    public void setDateIssued(LocalDate dateIssued) {
        this.dateIssued = dateIssued;
    }
    
    public long getYearsInService() {
        Period p = dateIssued.until((LocalDate.now()));
        return p.getYears();
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + this.id;
        hash = 47 * hash + Objects.hashCode(this.model);
        hash = 47 * hash + this.missleCount;
        hash = 47 * hash + (int) (Double.doubleToLongBits(this.fuelCapacity) ^ (Double.doubleToLongBits(this.fuelCapacity) >>> 32));
        hash = 47 * hash + (int) (Double.doubleToLongBits(this.currentFuel) ^ (Double.doubleToLongBits(this.currentFuel) >>> 32));
        hash = 47 * hash + Objects.hashCode(this.pilot);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Jet other = (Jet) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.missleCount != other.missleCount) {
            return false;
        }
        if (Double.doubleToLongBits(this.fuelCapacity) != Double.doubleToLongBits(other.fuelCapacity)) {
            return false;
        }
        if (Double.doubleToLongBits(this.currentFuel) != Double.doubleToLongBits(other.currentFuel)) {
            return false;
        }
        if (!Objects.equals(this.model, other.model)) {
            return false;
        }
        if (!Objects.equals(this.pilot, other.pilot)) {
            return false;
        }
        return true;
    }

}
