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
public class Organization {

    private int organizationID;
    private String organizationName;
    private String organizationDescription;
    private Location organizationAddress;
    private String organizationContact;
    private List<Super> supers;

    public int getOrganizationID() {
        return organizationID;
    }

    public void setOrganizationID(int organizationID) {
        this.organizationID = organizationID;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getOrganizationDescription() {
        return organizationDescription;
    }

    public void setOrganizationDescription(String organizationDescription) {
        this.organizationDescription = organizationDescription;
    }

    public Location getOrganizationAddress() {
        return organizationAddress;
    }

    public void setOrganizationAddress(Location organizationAddress) {
        this.organizationAddress = organizationAddress;
    }

    public String getOrganizationContact() {
        return organizationContact;
    }

    public void setOrganizationContact(String organizationContact) {
        this.organizationContact = organizationContact;
    }

    public List<Super> getSupers() {
        return supers;
    }

    public void setSupers(List<Super> supers) {
        this.supers = supers;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.organizationID;
        hash = 17 * hash + Objects.hashCode(this.organizationName);
        hash = 17 * hash + Objects.hashCode(this.organizationDescription);
        hash = 17 * hash + Objects.hashCode(this.organizationAddress);
        hash = 17 * hash + Objects.hashCode(this.organizationContact);
        hash = 17 * hash + Objects.hashCode(this.supers);
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
        final Organization other = (Organization) obj;
        if (this.organizationID != other.organizationID) {
            return false;
        }
        if (!Objects.equals(this.organizationName, other.organizationName)) {
            return false;
        }
        if (!Objects.equals(this.organizationDescription, other.organizationDescription)) {
            return false;
        }
        if (!Objects.equals(this.organizationContact, other.organizationContact)) {
            return false;
        }
        if (!Objects.equals(this.organizationAddress, other.organizationAddress)) {
            return false;
        }
        if (!Objects.equals(this.supers, other.supers)) {
            return false;
        }
        return true;
    }

}
