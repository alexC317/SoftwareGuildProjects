/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.supersighting.service;

import com.sg.supersighting.dao.FileDAO;
import com.sg.supersighting.dao.SuperDAO;
import com.sg.supersighting.dto.Super;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class SuperServiceImpl implements SuperService {

    @Autowired
    SuperDAO superDAO;

    @Autowired
    FileDAO fileDAO;

    private static final String UPLOAD_FOLDER = "src/main/resources/uploads/";

    @Override
    public Super create(Super s) {
//        MultipartFile file = s.getFile();
//
//        if (!file.isEmpty()) {
//            try {
//                byte[] bytes = file.getBytes();
//                Path path = Paths.get(UPLOAD_FOLDER + file.getOriginalFilename());
//                Files.write(path, bytes);
//                fileDAO.create(file, s.getSuperID());
//            } catch (IOException e) {
//            }
//        }

        return superDAO.create(s);
    }

    @Override
    public List<Super> readAll() {
        List<Super> supers = superDAO.readAll();
//        for (Super s : supers) {
//            MultipartFile file = fileDAO.readBySuperID(s.getSuperID());
//            s.setFile(file);
//        }
        return supers;
    }

    @Override
    public Super readByID(int superID) {
        Super s = superDAO.readByID(superID);
//        MultipartFile file = fileDAO.readBySuperID(superID);
//        s.setFile(file);
        return s;
    }

    @Override
    public List<Super> readSupersByOrganization(int organizationID) {
        return superDAO.readByOrganizationID(organizationID);
    }

    @Override
    public List<Super> readSupersByLocation(int locationID) {
        return superDAO.readByLocationID(locationID);
    }

    @Override
    public void update(Super s) {
        superDAO.update(s);
    }

    @Override
    public void delete(int superID) {
        superDAO.delete(superID);
    }

}
