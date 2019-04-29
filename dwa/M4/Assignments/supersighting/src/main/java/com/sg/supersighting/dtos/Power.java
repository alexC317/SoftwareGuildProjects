/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.supersighting.dtos;

import java.util.List;
import java.util.Objects;

/**
 *
 * @author Alex
 */
public class Power {

    private int powerID;
    private String powerName;
    private String powerDescription;
    private List<Super> poweredSupers;

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

    public List<Super> getPoweredSupers() {
        return poweredSupers;
    }

    public void setPoweredSupers(List<Super> poweredSupers) {
        this.poweredSupers = poweredSupers;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.powerID;
        hash = 97 * hash + Objects.hashCode(this.powerName);
        hash = 97 * hash + Objects.hashCode(this.powerDescription);
        hash = 97 * hash + Objects.hashCode(this.poweredSupers);
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
        if (!Objects.equals(this.poweredSupers, other.poweredSupers)) {
            return false;
        }
        return true;
    }

}
