/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.supersighting.service;

import com.sg.supersighting.dao.FileDAO;
import com.sun.media.jfxmedia.logging.Logger;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileServiceImpl implements FileService {

    private static final String UPLOAD_FOLDER = "D:/SuperHeroImgs/";

    @Autowired
    FileDAO fileDAO;

    @Override
    public void create(String path, MultipartFile file, int superID) {
        if (!file.isEmpty()) {
            try {
                String fileName = file.getOriginalFilename();
                file.transferTo(new File(path + "superHero-" + superID + ".jpg"));
                fileDAO.create(fileName, superID);
            } catch (Exception e) {
                Logger.logMsg(Logger.DEBUG, e.getMessage());
            }
        }
    }

    @Override
    public List<MultipartFile> readAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public MultipartFile readByFileName(String fileName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public MultipartFile readBySuperID(String path, int superID) {
        MultipartFile file = (MultipartFile) new File("C:\\Users\\xito9\\AppData\\Local\\Temp\\tomcat-docbase.1062251540545491323.8080" + "superHero-" + superID + ".jpg");
        return file;
        //return fileDAO.readBySuperID(superID);
    }

    @Override
    public void update(String fileName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String fileName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
