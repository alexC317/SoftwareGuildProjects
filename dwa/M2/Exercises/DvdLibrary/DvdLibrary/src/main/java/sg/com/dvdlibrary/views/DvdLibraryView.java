/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.com.dvdlibrary.views;

import java.util.List;
import sg.com.dvdlibrary.dtos.Director;
import sg.com.dvdlibrary.dtos.Dvd;
import sg.com.dvdlibrary.services.DirectorNotFoundException;

/**
 *
 * @author Randall
 */
public class DvdLibraryView {

    UserIO io;

    public DvdLibraryView(UserIO io) {
        this.io = io;
    }

    public int GetMenuChoice() {
        io.display("1.) Create Director");
        io.display("2.) Read All Directors");
        io.display("3.) Read Director By Id");
        io.display("4.) Update Director");
        io.display("5.) Delete Director");
        io.display("6.) Create Dvd");
        io.display("7.) Read All Dvds");
        io.display("8.) Read Dvd ById");
        io.display("9.) Read Dvds By Director Id");
        io.display("10.) Update Dvd");
        io.display("11.) Delete Dvd");
        io.display("12.) Exit");
        return io.promptInt("Enter Choice:");
    }

    public String getNewDirectorName() {
        return io.promptString("Enter new Director Name");
    }

    public void DisplayDirectors(List<Director> directors) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getDirectorId() {
        return io.promptInt("Enter director id");
    }

    public void displayDirector(Director director) {
        io.display("ID: " + director.getId() + " Name" + director.getName());
    }

    public Director editDirector(Director director) {
        io.display("ID: " + director.getId() + " Name" + director.getName());
        String name = io.promptString("What is your new Director Name? ");
        if(!"".equals(name)){
            director.setName(name);
        }
        
        return director;
    }

    public boolean DeleteDirector(Director director) {
        String prompt = io.promptString("Are you sure you want to delete this Director? (" + director.getName() + ") Y/N");
        return prompt.equalsIgnoreCase("y");
    }

    public Dvd getNewDvdInfo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void DisplayError(DirectorNotFoundException ex) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void displayDvd(Dvd dvd) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void DisplayDvds(List<Dvd> ReadAllDvds) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getDvdId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Dvd editDvd(Dvd dvd) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean deleteDvd(Dvd dvd) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
