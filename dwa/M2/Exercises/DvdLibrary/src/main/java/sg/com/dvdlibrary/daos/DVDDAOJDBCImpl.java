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
import sg.com.dvdlibrary.dtos.DVD;

public class DVDDAOJDBCImpl implements DVDDAO {

    @Autowired
    private JdbcTemplate jdbc;

    public DVDDAOJDBCImpl(DataSource dataSource) {
        this.jdbc = new JdbcTemplate(dataSource);
    }

    @Override
    public DVD Create(DVD entity) {
        final String INSERT_DVD = "INSERT INTO dvd(directorID, name, releaseDate, rating "
                + "VALUES(?,?,?,?)";
        jdbc.update(INSERT_DVD, entity.getDirectorId(), entity.getName(), entity.getReleaseDate(), entity.getRating());
        int newID = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        entity.setId(newID);
        return entity;
    }

    @Override
    public void Delete(int id) {
        final String DELETE_DVD = "DELETE FROM dvd WHERE id = ?";
        jdbc.update(DELETE_DVD, id);
    }

    @Override
    public List<DVD> ReadAll() {
        final String SELECT_ALL_DVDS = "SELECT id, directorID, name, releaseDate, rating FROM dvd";
        return jdbc.query(SELECT_ALL_DVDS, new DVDMapper());
    }

    @Override
    public List<DVD> ReadByDirectorId(int directorId) {
        final String SELECT_DVDS_BY_DIRECTOR_ID = "SELECT id, directorID, name, releaseDate, rating FROM dvd WHERE directorID = ?";
        return jdbc.query(SELECT_DVDS_BY_DIRECTOR_ID, new DVDMapper(), directorId);
    }

    @Override
    public DVD ReadById(int id) {
        final String SELECT_DVD_BY_ID = "SELECT id, directorID, name, releaseDate, rating FROM dvd WHERE directorID = ?";
        return jdbc.queryForObject(SELECT_DVD_BY_ID, new DVDMapper(), id);
    }

    @Override
    public void Update(int id, DVD entity) {
        final String UPDATE_DVD = "UPDATE dvd SET directorID = ?, name = ?, releaseDate = ?, rating = ? FROM  WHERE id = ?";
        jdbc.update(UPDATE_DVD, entity.getDirectorId(), entity.getName(), entity.getReleaseDate(), entity.getReleaseDate(), id);
    }

    public static final class DVDMapper implements RowMapper<DVD> {

        @Override
        public DVD mapRow(ResultSet rs, int i) throws SQLException {
            DVD dvd = new DVD();
            dvd.setId(rs.getInt("id"));
            dvd.setDirectorId(rs.getInt("directorID"));
            dvd.setName(rs.getString("name"));
            dvd.setReleaseDate(rs.getDate("releaseDate").toLocalDate());
            dvd.setRating(rs.getString("rating"));
            return dvd;
        }

    }
}
