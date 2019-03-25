/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.com.dvdlibrary.daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import sg.com.dvdlibrary.dtos.Dvd;


public class DvdDaoJDBCImpl implements DvdDao {
    
    @Autowired
    private JdbcTemplate jdbc;

    @Override
    public Dvd Create(Dvd entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Dvd> ReadAll() {
        final String SELECT_ALL_DVDS = "SELECT * FROM DVD";
        return jdbc.query(SELECT_ALL_DVDS, new DVDMapper());
    }

    @Override
    public List<Dvd> ReadByDirectorId(int directorId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Dvd ReadById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Update(int id, Dvd entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public static final class DVDMapper implements RowMapper<Dvd>{

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
