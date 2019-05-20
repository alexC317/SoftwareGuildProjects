/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.supersighting.dto;

import java.util.List;
import java.util.Objects;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 *
 * @author Alex
 */
public class Power {

    private int powerID;

    @NotBlank(message = "Power name must not be empty.")
    @Size(max = 50, message = "Cannot be more than 50 characters")
    private String powerName;

    @NotBlank(message = "Power description must not be empty.")
    @Size(max = 50, message = "Cannot be more than 50 characters")
    private String powerDescription;

    public int getPowerID() {
        return powerID;
    }

    public void setPowerID(int powerID) {
        this.powerID = powerID;
    }

    public String getPowerName() {
        return powerName;
    }

    public void setPowerName(String powerName) {
        this.powerName = powerName;
    }

    public String getPowerDescription() {
        return powerDescription;
    }

    public void setPowerDescription(String powerDescription) {
        this.powerDescription = powerDescription;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.powerID;
        hash = 97 * hash + Objects.hashCode(this.powerName);
        hash = 97 * hash + Objects.hashCode(this.powerDescription);
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
        final Power other = (Power) obj;
        if (this.powerID != other.powerID) {
            return false;
        }
        if (!Objects.equals(this.powerName, other.powerName)) {
            return false;
        }
        if (!Objects.equals(this.powerDescription, other.powerDescription)) {
            return false;
        }
        return true;
    }

}
