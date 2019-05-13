/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.supersighting.dtos;

import java.util.List;
import java.util.Objects;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 *
 * @author Alex
 */
public class Super {

    private int superID;

    @NotBlank(message = "Super name must not be empty.")
    @Size(max = 50, message = "Cannot not be more than 50 characters")
    private String superName;

    @NotBlank(message = "Super description must not be empty.")
    @Size(max = 50, message = "Cannot not be more than 50 characters")
    private String superDescription;

    private List<Power> superPowers;

    public int getSuperID() {
        return superID;
    }

    public void setSuperID(int superID) {
        this.superID = superID;
    }

    public String getSuperName() {
        return superName;
    }

    public void setSuperName(String superName) {
        this.superName = superName;
    }

    public String getSuperDescription() {
        return superDescription;
    }

    public void setSuperDescription(String superDescription) {
        this.superDescription = superDescription;
    }

    public List<Power> getSuperPowers() {
        return superPowers;
    }

    public void setSuperPowers(List<Power> superPowers) {
        this.superPowers = superPowers;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + this.superID;
        hash = 47 * hash + Objects.hashCode(this.superName);
        hash = 47 * hash + Objects.hashCode(this.superDescription);
        hash = 47 * hash + Objects.hashCode(this.superPowers);
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
        final Super other = (Super) obj;
        if (this.superID != other.superID) {
            return false;
        }
        if (!Objects.equals(this.superName, other.superName)) {
            return false;
        }
        if (!Objects.equals(this.superDescription, other.superDescription)) {
            return false;
        }
        if (!Objects.equals(this.superPowers, other.superPowers)) {
            return false;
        }
        return true;
    }

}
