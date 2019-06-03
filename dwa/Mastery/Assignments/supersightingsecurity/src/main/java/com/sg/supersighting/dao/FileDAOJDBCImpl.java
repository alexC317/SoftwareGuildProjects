/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.supersighting.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Repository
public class FileDAOJDBCImpl implements FileDAO {

    @Autowired
    private JdbcTemplate jdbc;

    private final String INSERT_NEW_FILE = "INSERT INTO files(fileName, superID) VALUES (?, ?)";
    private final String SELECT_BY_SUPER_ID = "SELECT fileName, superID FROM files WHERE superID = ?";

    @Override
    @Transactional
    public MultipartFile create(MultipartFile file, int superID) {
        jdbc.update(INSERT_NEW_FILE, file.getOriginalFilename(), superID);
        return file;
    }

    @Override
    public List<MultipartFile> readAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public MultipartFile readByID(int fileID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public MultipartFile readBySuperID(int superID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(int fileID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int fileID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
