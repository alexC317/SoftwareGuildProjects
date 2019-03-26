/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.com.dvdlibrary.services;

import java.util.List;
import sg.com.dvdlibrary.dtos.Director;
import sg.com.dvdlibrary.dtos.DVD;
import sg.com.dvdlibrary.daos.DVDDAO;
import sg.com.dvdlibrary.daos.DirectorDAO;

public class DVDServiceImpl implements DVDService {

    DVDDAO dvdDao;
    DirectorDAO directorDao;

    public DVDServiceImpl(DVDDAO dvdDao, DirectorDAO directorDao) {
        this.dvdDao = dvdDao;
        this.directorDao = directorDao;
    }

    @Override
    public Director CreateDirector(String name) {
        Director director = new Director();
        director.setName(name);
        directorDao.Create(director);
        return director;
    }

    @Override
    public List<Director> ReadAllDirectors() {
        return directorDao.ReadAll();
    }

    @Override
    public Director ReadDirectorById(int directorId) {
        Director director = directorDao.ReadById(directorId);
        if (director != null) {
            director.setDvds(dvdDao.ReadByDirectorId(directorId));
        }
        return director;
    }

    @Override
    public void UpdateDirector(int directorId, Director director) {
        directorDao.Update(directorId, director);
    }

    @Override
    public void DeleteDirector(int directorId) {
        directorDao.Delete(directorId);
    }

    @Override
    public DVD CreateDvd(DVD dvd) throws DirectorNotFoundException {
        Director director = directorDao.ReadById(dvd.getDirectorId());
        if (director != null) {
            return dvdDao.Create(dvd);
        }
        throw new DirectorNotFoundException("Director not found", dvd);
    }

    @Override
    public List<DVD> ReadAllDvds() {
        return this.dvdDao.ReadAll();
    }

    @Override
    public DVD ReadDvdById(int dvdId) {
        return this.dvdDao.ReadById(dvdId);
    }

    @Override
    public List<DVD> ReadDvdsByDirectorId(int directorId) {
        return this.dvdDao.ReadByDirectorId(directorId);
    }

    @Override
    public void UpdateDvd(int dvdId, DVD dvd) throws DirectorNotFoundException {
        Director director = directorDao.ReadById(dvd.getDirectorId());
        if (director == null) {
            throw new DirectorNotFoundException("Director not found", dvd);
        }
        this.dvdDao.Update(dvdId, dvd);
    }

    @Override
    public void DeleteDvd(int dvdId) {
        this.dvdDao.Delete(dvdId);
    }

}
