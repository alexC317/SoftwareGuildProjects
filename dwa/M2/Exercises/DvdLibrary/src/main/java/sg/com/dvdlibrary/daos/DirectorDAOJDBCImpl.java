/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.com.dvdlibrary.daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Transactional;
import sg.com.dvdlibrary.dtos.Director;

public class DirectorDAOJDBCImpl implements DirectorDAO {

    @Autowired
    private JdbcTemplate jdbc;

    public DirectorDAOJDBCImpl(DataSource dataSource) {
        this.jdbc = new JdbcTemplate(dataSource);
    }

    @Override
    @Transactional
    public Director Create(Director entity) {
        final String INSERT_DIRECTOR = "INSERT INTO director(name) VALUES(?)";
        jdbc.update(INSERT_DIRECTOR, entity.getName());
        int newID = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        entity.setId(newID);
        return entity;
    }

    @Override
    @Transactional
    public void Delete(int id) {
        final String DELETE_DVDS_BY_DIRECTOR = "DELETE FROM dvd WHERE directorID = ?";
        jdbc.update(DELETE_DVDS_BY_DIRECTOR, id);
        final String DELETE_DIRECTOR = "DELETE FROM director WHERE id = ?";
        jdbc.update(DELETE_DIRECTOR, id);
    }

    @Override
    public List<Director> ReadAll() {
        final String SELECT_ALL_DIRECTORS = "SELECT id, name FROM director";
        return jdbc.query(SELECT_ALL_DIRECTORS, new DirectorMapper());
    }

    @Override
    public Director ReadById(int id) {
        final String SELECT_DIRECTOR_BY_ID = "SELECT id, name FROM director WHERE id = ?";
        return jdbc.queryForObject(SELECT_DIRECTOR_BY_ID, new DirectorMapper(), id);
    }

    @Override
    public void Update(int id, Director entity) {
        final String UPDATE_DIRECTOR_BY_ID = "UPDATE director SET name = ? WHERE id = ?";
        jdbc.update(UPDATE_DIRECTOR_BY_ID, entity.getName(), entity.getId());
    }

    public static final class DirectorMapper implements RowMapper<Director> {

        @Override
        public Director mapRow(ResultSet rs, int i) throws SQLException {
            Director director = new Director();
            director.setId(rs.getInt("ID"));
            director.setName(rs.getString("name"));
            return director;
        }

    }

}
