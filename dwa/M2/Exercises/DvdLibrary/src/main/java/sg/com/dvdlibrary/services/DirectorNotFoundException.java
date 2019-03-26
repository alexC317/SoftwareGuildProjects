/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.com.dvdlibrary.services;

import sg.com.dvdlibrary.dtos.DVD;

/**
 *
 * @author Randall
 */
public class DirectorNotFoundException extends Exception {

    private DVD dvd;

    public DirectorNotFoundException(String message, DVD dvd) {
        super(message);
        this.dvd = dvd;
    }

    public DVD getDvd() {
        return dvd;
    }

    public void setDvd(DVD dvd) {
        this.dvd = dvd;
    }

}
