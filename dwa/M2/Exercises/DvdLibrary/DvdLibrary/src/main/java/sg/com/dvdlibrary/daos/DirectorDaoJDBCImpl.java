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
import sg.com.dvdlibrary.dtos.Director;

public class DirectorDaoJDBCImpl implements DirectorDao {

    @Autowired
    private JdbcTemplate jdbc;

    @Override
    public Director Create(Director entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Director> ReadAll() {
        final String SELECT_ALL_DIRECTORS = "SELECT * FROM DVD";
        //try {
        return jdbc.query(SELECT_ALL_DIRECTORS, new DirectorMapper());
//        } catch (Exception ex) {
//            System.out.println(ex.getMessage());
//        }

        //return null;
    }

    @Override
    public Director ReadById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Update(int id, Director entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static final class DirectorMapper implements RowMapper<Director> {

        @Override
        public Director mapRow(ResultSet rs, int index) throws SQLException {
            Director d = new Director();
            d.setId(rs.getInt("ID"));
            d.setName(rs.getString("name"));
            return d;
        }

    }
}
