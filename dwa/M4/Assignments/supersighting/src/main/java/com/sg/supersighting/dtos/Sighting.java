/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.supersighting.dtos;

import java.time.LocalDate;
import java.util.Objects;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Alex
 */
public class Sighting {

    private int sightingID;

    @PastOrPresent(message = "Date must be valid")
    @NotNull(message = "Date must be valid")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate sightingDate;

    private Super sightingSuper;

    private Location sightingLocation;

    public int getSightingID() {
        return sightingID;
    }

    public void setSightingID(int sightingID) {
        this.sightingID = sightingID;
    }

    public LocalDate getSightingDate() {
        return sightingDate;
    }

    public void setSightingDate(LocalDate sightingDate) {
        this.sightingDate = sightingDate;
    }

    public Super getSightingSuper() {
        return sightingSuper;
    }

    public void setSightingSuper(Super sightingSuper) {
        this.sightingSuper = sightingSuper;
    }

    public Location getSightingLocation() {
        return sightingLocation;
    }

    public void setSightingLocation(Location sightingLocation) {
        this.sightingLocation = sightingLocation;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 73 * hash + this.sightingID;
        hash = 73 * hash + Objects.hashCode(this.sightingDate);
        hash = 73 * hash + Objects.hashCode(this.sightingSuper);
        hash = 73 * hash + Objects.hashCode(this.sightingLocation);
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
        final Sighting other = (Sighting) obj;
        if (this.sightingID != other.sightingID) {
            return false;
        }
        if (!Objects.equals(this.sightingDate, other.sightingDate)) {
            return false;
        }
        if (!Objects.equals(this.sightingSuper, other.sightingSuper)) {
            return false;
        }
        if (!Objects.equals(this.sightingLocation, other.sightingLocation)) {
            return false;
        }
        return true;
    }

}
