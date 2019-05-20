/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.supersighting.dto;

import java.util.Objects;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 *
 * @author Alex
 */
public class Location {

    private int locationID;

    @NotBlank(message = "Location name must not be empty.")
    @Size(max = 50, message = "Cannot not be more than 50 characters")
    private String locationName;

    @NotBlank(message = "Location description must not be empty.")
    @Size(max = 50, message = "Cannot not be more than 50 characters")
    private String locationDescription;

    @NotBlank(message = "Location address must not be empty.")
    @Size(max = 50, message = "Cannot not be more than 50 characters")
    private String locationAddress;

    @NotBlank(message = "Location longitude must not be empty.")
    @Size(max = 50, message = "Cannot not be more than 50 characters")
    private String locationLongitude;

    @NotBlank(message = "Location latitude must not be empty.")
    @Size(max = 50, message = "Cannot not be more than 50 characters")
    private String locationLatitude;

    public int getLocationID() {
        return locationID;
    }

    public void setLocationID(int locationID) {
        this.locationID = locationID;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getLocationDescription() {
        return locationDescription;
    }

    public void setLocationDescription(String locationDescription) {
        this.locationDescription = locationDescription;
    }

    public String getLocationAddress() {
        return locationAddress;
    }

    public void setLocationAddress(String locationAddress) {
        this.locationAddress = locationAddress;
    }

    public String getLocationLongitude() {
        return locationLongitude;
    }

    public void setLocationLongitude(String locationLongitude) {
        this.locationLongitude = locationLongitude;
    }

    public String getLocationLatitude() {
        return locationLatitude;
    }

    public void setLocationLatitude(String locationLatitude) {
        this.locationLatitude = locationLatitude;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.locationID;
        hash = 29 * hash + Objects.hashCode(this.locationName);
        hash = 29 * hash + Objects.hashCode(this.locationDescription);
        hash = 29 * hash + Objects.hashCode(this.locationAddress);
        hash = 29 * hash + Objects.hashCode(this.locationLongitude);
        hash = 29 * hash + Objects.hashCode(this.locationLatitude);
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
        final Location other = (Location) obj;
        if (this.locationID != other.locationID) {
            return false;
        }
        if (!Objects.equals(this.locationName, other.locationName)) {
            return false;
        }
        if (!Objects.equals(this.locationDescription, other.locationDescription)) {
            return false;
        }
        if (!Objects.equals(this.locationAddress, other.locationAddress)) {
            return false;
        }
        if (!Objects.equals(this.locationLongitude, other.locationLongitude)) {
            return false;
        }
        if (!Objects.equals(this.locationLatitude, other.locationLatitude)) {
            return false;
        }
        return true;
    }

}
