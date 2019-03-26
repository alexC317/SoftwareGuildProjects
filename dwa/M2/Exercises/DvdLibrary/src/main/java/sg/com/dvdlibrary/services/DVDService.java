/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.com.dvdlibrary.services;

import java.util.List;
import sg.com.dvdlibrary.dtos.Director;
import sg.com.dvdlibrary.dtos.DVD;

/**
 *
 * @author Randall
 */
public interface DVDService {
    Director CreateDirector(String name);
    List<Director> ReadAllDirectors();
    Director ReadDirectorById(int directorId);
    void UpdateDirector(int directorId, Director director);
    void DeleteDirector(int directorId);
    
    DVD CreateDvd(DVD dvd) throws DirectorNotFoundException;
    List<DVD> ReadAllDvds();
    DVD ReadDvdById(int dvdId);
    List<DVD> ReadDvdsByDirectorId(int directorId);
    void UpdateDvd(int directorId, DVD dvd) throws DirectorNotFoundException;
    void DeleteDvd(int dvdId);
}
