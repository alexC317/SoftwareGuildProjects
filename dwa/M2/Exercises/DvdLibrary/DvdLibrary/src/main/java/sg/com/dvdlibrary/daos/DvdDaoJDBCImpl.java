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
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import sg.com.dvdlibrary.dtos.Dvd;

@Repository
public class DvdDaoJDBCImpl implements DvdDao {

    @Autowired
    private JdbcTemplate jdbc;

    public DvdDaoJDBCImpl(DataSource dataSource) {
        this.jdbc = new JdbcTemplate(dataSource);
    }

    @Override
    @Transactional
    public Dvd Create(Dvd entity) {
        final String INSERT_DVD = "INSERT INTO dvd(directorID, name, releaseDate, rating) "
                + "VALUES(?,?,?,?)";
        jdbc.update(INSERT_DVD,
                entity.getDirectorId(),
                entity.getName(),
                entity.getReleaseDate(),
                entity.getRating());
        int newID = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        entity.setId(newID);

        return entity;

    }

    @Override
    public void Delete(int id) {
        final String DELETE_DVD = "DELETE FROM dvd WHERE ID = ?";
        jdbc.update(DELETE_DVD, id);
    }

    @Override
    public List<Dvd> ReadAll() {
        final String SELECT_ALL_DVDS = "SELECT * FROM DVD";
        return jdbc.query(SELECT_ALL_DVDS, new DVDMapper());
    }

    @Override
    public List<Dvd> ReadByDirectorId(int directorId) {
        final String SELECT_BY_DIRECTOR_ID = "SELECT * FROM dvd WHERE directorID = ?";
        return jdbc.query(SELECT_BY_DIRECTOR_ID, new DVDMapper(), directorId);
    }

    @Override
    public Dvd ReadById(int id) {
        final String SELECT_BY_DVD_ID = "SELECT * FROM dvd WHERE id = ?";
        return jdbc.queryForObject(SELECT_BY_DVD_ID, new DVDMapper(), id);
    }

    @Override
    public void Update(int id, Dvd entity) {
        final String UPDATE_DVD = "UPDATE dvd SET "
                + "directorID = ?, "
                + "name = ?, "
                + "releaseDate = ?, "
                + "rating = ? "
                + "WHERE id = ?";
        jdbc.update(UPDATE_DVD,
                entity.getDirectorId(),
                entity.getName(),
                entity.getReleaseDate(),
                entity.getRating(),
                entity.getId());
    }

    public static final class DVDMapper implements RowMapper<Dvd> {

        @Override
        public Dvd mapRow(ResultSet rs, int index) throws SQLException {
            Dvd dvd = new Dvd();
            dvd.setId(rs.getInt("ID"));
            dvd.setDirectorId(rs.getInt("directorID"));
            dvd.setName(rs.getString("name"));
            dvd.setRating(rs.getString("rating"));
            dvd.setReleaseDate(rs.getDate("releaseDate").toLocalDate());
            return dvd;
        }

    }
}
