///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package sg.com.dvdlibrary.daos;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//import javax.sql.DataSource;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
//import sg.com.dvdlibrary.dtos.Director;
//import sg.com.dvdlibrary.dtos.Dvd;
//
//public class DirectorDaoJDBCImpl implements DirectorDao {
//
//    private JdbcTemplate jdbc;
//
//    private String updateDirectors = "UPDATE director set name=? where ID = ?";
//    private String insertDirector = "INSERT INTO Director(`name`) VALUES(?)";
//    private String deleteDirector = "DELETE FROM Director WHERE ID = ?";
//    private String selectDirectors = "SELECT Id, Name FROM director";
//    private String selectDirectorsById = "SELECT Id, Name FROM director Where ID = ?";
//    private String deleteDvdsByDirectorID = "DELETE FROM DVD WHERE directorId = ?";
//
//    public DirectorDaoJDBCImpl(DataSource dataSource) {
//        this.jdbc = new JdbcTemplate(dataSource);
//    }
//
//    @Transactional
//    @Override
//    public Director Create(Director entity) {
//        this.jdbc.update(insertDirector, entity.getName());
//        int newId = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
//        entity.setId(newId);
//        return entity;
//    }
//
//    @Transactional
//    @Override
//    public void Delete(int id) {
//        this.jdbc.update(deleteDvdsByDirectorID, id);
//        this.jdbc.update(deleteDirector, id);
//    }
//
//    @Override
//    public List<Director> ReadAll() {
//        return this.jdbc.query(selectDirectors, new DirectorJDBCMapper());
//    }
//
//    @Override
//    public Director ReadById(int id) {
//        return this.jdbc.queryForObject(selectDirectorsById, new DirectorJDBCMapper(), id);
//    }
//
//    @Override
//    public void Update(int id, Director entity) {
//        this.jdbc.update(this.updateDirectors, entity.getName(), id);
//    }
//
//    private class DirectorJDBCMapper implements org.springframework.jdbc.core.RowMapper<Director> {
//
//        @Override
//        public Director mapRow(ResultSet rs, int rowNum) throws SQLException {
//            Director d = new Director();
//
//            d.setId(rs.getInt("Id"));
//            d.setName(rs.getString("Name"));
//            return d;
//        }
//
//    }
//}
