/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.supersighting.dao;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Repository
public class FileDAOJDBCImpl implements FileDAO {

    @Autowired
    private JdbcTemplate jdbc;

    private final String INSERT_NEW_FILE = "INSERT INTO files(fileName, superID) VALUES (?, ?)";
    private final String SELECT_BY_SUPER_ID = "SELECT fileName FROM files WHERE superID = ?";

    @Override
    @Transactional
    public void create(String file, int superID) {
        jdbc.update(INSERT_NEW_FILE, file, superID);
    }

    @Override
    public List<MultipartFile> readAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public MultipartFile readByID(int fileID) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public MultipartFile readBySuperID(int superID) {
        try {
            String filename = jdbc.queryForObject(SELECT_BY_SUPER_ID, new FileMapper(), superID);
            MultipartFile file = (MultipartFile) new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(filename)));
            return file;
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public void update(int fileID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int fileID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static final class FileMapper implements RowMapper<String> {

        @Override
        public String mapRow(ResultSet rs, int i) throws SQLException {
            return rs.getString("fileName");
        }

    }
}
