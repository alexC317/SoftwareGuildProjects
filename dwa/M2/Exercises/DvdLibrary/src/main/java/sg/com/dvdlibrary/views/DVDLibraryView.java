/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.com.dvdlibrary.views;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import sg.com.dvdlibrary.dtos.Director;
import sg.com.dvdlibrary.dtos.DVD;
import sg.com.dvdlibrary.services.DirectorNotFoundException;

/**
 *
 * @author Randall
 */
public class DVDLibraryView {

    UserIO io;

    public DVDLibraryView(UserIO io) {
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
        for (Director director : directors) {
            io.display("ID: " + director.getId() + " Name: " + director.getName());
        }

        io.promptString("Press Enter to Continue");
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
        if (!"".equals(name)) {
            director.setName(name);
        }

        return director;
    }

    public boolean DeleteDirector(Director director) {
        String prompt = io.promptString("Are you sure you want to delete this Director? (" + director.getName() + ") Y/N");
        return prompt.equalsIgnoreCase("y");
    }

    public DVD getNewDvdInfo() {

        DVD newDvd = new DVD();

        String title = io.promptString("Enter new Dvd Title");
        int directorId = io.promptInt("Enter Director Id"); //TODO: change to look up by name
        String rating = io.promptString("Enter Rating");
        LocalDate releaseDate = io.promptDate("Enter Release Date");

        newDvd.setDirectorId(directorId);
        newDvd.setName(title);
        newDvd.setRating(rating);
        newDvd.setReleaseDate(releaseDate);
        return newDvd;
    }

    public void DisplayError(DirectorNotFoundException ex) {
        io.display(ex.getMessage());
    }

    public void displayDvd(DVD dvd) {

        io.display("Title: " + dvd.getName());
        //io.display("Director: " + dvd.getDirector().getName());
        io.display("Rating: " + dvd.getRating());
        io.display("Release Date:" + dvd.getReleaseDate().format(DateTimeFormatter.ISO_LOCAL_DATE));

    }

    public void DisplayDvds(List<DVD> ReadAllDvds) {
        for (DVD dvd : ReadAllDvds) {
            displayDvd(dvd);
        }
    }

    public int getDvdId() {
        return io.promptInt("Enter Dvd Id");
    }

    public DVD editDvd(DVD dvd) {
        DVD newDvd = new DVD();

        String title = io.promptString("Enter new Dvd Title");
        int directorId = io.promptInt("Enter Director Id"); //TODO: change to look up by name
        String rating = io.promptString("Enter Rating");
        LocalDate releaseDate = io.promptDate("Enter Release Date");

        newDvd.setDirectorId(directorId);
        newDvd.setName(title);
        newDvd.setRating(rating);
        newDvd.setReleaseDate(releaseDate);
        return newDvd;
    }

    public boolean deleteDvd(DVD dvd) {
        String userInput = io.promptString("Are you sure you want to delete " + dvd.getName());
        return "y".equalsIgnoreCase(userInput);
    }

}
