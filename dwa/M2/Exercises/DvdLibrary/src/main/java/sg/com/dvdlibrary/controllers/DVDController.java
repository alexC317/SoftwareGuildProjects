/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.com.dvdlibrary.controllers;

import java.util.List;
import sg.com.dvdlibrary.dtos.Director;
import sg.com.dvdlibrary.dtos.DVD;
import sg.com.dvdlibrary.services.DirectorNotFoundException;
import sg.com.dvdlibrary.views.DVDLibraryView;
import sg.com.dvdlibrary.services.DVDService;

/**
 *
 * @author Randall
 */
public class DVDController {

    DVDLibraryView view;
    DVDService service;

    public DVDController(DVDLibraryView view, DVDService service) {
        this.view = view;
        this.service = service;
    }

    public void Run() {
        boolean keepRunning = true;
        while (keepRunning) {
            int userChoice = view.GetMenuChoice();
            switch (userChoice) {
                case 1:
                    CreateDirector();
                    break;
                case 2:
                    ReadAllDirectors();
                    break;
                case 3:
                    ReadDirectorById();
                    break;
                case 4:
                    UpdateDirector();
                    break;
                case 5:
                    DeleteDirector();
                    break;
                case 6:
                    CreateDvd();
                    break;
                case 7:
                    ReadAllDvds();
                    break;
                case 8:
                    ReadDvdById();
                    break;
                case 9:
                    ReadDvdsByDirectorId();
                    break;
                case 10:
                    UpdateDvd();
                    break;
                case 11:
                    DeleteDvd();
                    break;
                case 12:
                    keepRunning = false;
                    break;
                default:
                    break;
            }
        }
    }

    private void CreateDirector() {
        String directorName = view.getNewDirectorName();
        service.CreateDirector(directorName);

    }

    private void ReadAllDirectors() {
        List<Director> directors = service.ReadAllDirectors();
        view.DisplayDirectors(directors);

    }

    private void ReadDirectorById() {
        int directorID = view.getDirectorId();
        Director director = service.ReadDirectorById(directorID);
        view.displayDirector(director);

    }

    private void UpdateDirector() {
        int directorID = view.getDirectorId();
        Director director = service.ReadDirectorById(directorID);
        director = view.editDirector(director);
        service.UpdateDirector(directorID, director);
    }

    private void DeleteDirector() {
        int directorID = view.getDirectorId();
        Director director = service.ReadDirectorById(directorID);
        if(view.DeleteDirector(director) == true){
            service.DeleteDirector(directorID);
        }
    }

    private void CreateDvd() {
        
        DVD dvd = view.getNewDvdInfo();
        try {
            dvd = service.CreateDvd(dvd);
            view.displayDvd(dvd);
        } catch (DirectorNotFoundException ex) {
            view.DisplayError(ex);
        }
        
    }

    private void ReadAllDvds() {
        view.DisplayDvds(service.ReadAllDvds());
    }

    private void ReadDvdById() {
        int dvdId = view.getDvdId();
        view.displayDvd(service.ReadDvdById(dvdId));
    }

    private void ReadDvdsByDirectorId() {
        int directorId = view.getDirectorId();
        view.DisplayDvds(service.ReadDvdsByDirectorId(directorId));
    }

    private void UpdateDvd() {
        int dvdId = view.getDvdId();
        DVD dvd = service.ReadDvdById(dvdId);
        dvd = view.editDvd(dvd);
        try {
            service.UpdateDvd(dvdId, dvd);
        } catch (DirectorNotFoundException ex) {
            view.DisplayError(ex);
        }
    }

    private void DeleteDvd() {
        int dvdId = view.getDvdId();
        DVD dvd = service.ReadDvdById(dvdId);
        if(view.deleteDvd(dvd) == true){
            service.DeleteDvd(dvdId);
        }
    }
}
