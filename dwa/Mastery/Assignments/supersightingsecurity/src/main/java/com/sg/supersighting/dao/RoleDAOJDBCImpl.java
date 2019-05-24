/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.supersighting.dao;

import com.sg.supersighting.dto.Role;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDAOJDBCImpl implements RoleDAO {

    @Autowired
    private JdbcTemplate jdbc;

    private final String INSERT_NEW_ROLE = "INSERT INTO roles(userRole) VALUES (?)";
    private final String SELECT_ALL_ROLES = "SELECT roleID, userRole FROM roles";
    private final String SELECT_ROLE_BY_ID = "SELECT roleID, userRole FROM roles WHERE roleID = ?";
    private final String SELECT_ROLE_BY_ROLE = "SELECT roleID, userRole FROM roles WHERE userRole = ?";
    private final String UPDATE_ROLE = "UPDATE roles SET userRole = ? WHERE roleID = ?";
    private final String DELETE_ROLE = "DELETE FROM roles WHERE roleID = ?";

    private final String DELETE_FROM_USERS_ROLES = "DELETE FROM users_roles WHERE roleID = ?";

    @Override
    public Role create(Role role) {
        jdbc.update(INSERT_NEW_ROLE, role.getRole());
        int newID = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        role.setRoleID(newID);
        return role;
    }

    @Override
    public List<Role> readAll() {
        return jdbc.query(SELECT_ALL_ROLES, new RoleMapper());
    }

    @Override
    public Role readByID(int roleID) {
        try {
            return jdbc.queryForObject(SELECT_ROLE_BY_ID, new RoleMapper(), roleID);
        } catch (DataAccessException ex) {
            return null;
        }
    }

    @Override
    public Role readByRole(String role) {
        try {
            return jdbc.queryForObject(SELECT_ROLE_BY_ROLE, new RoleMapper(), role);
        } catch (DataAccessException ex) {
            return null;
        }
    }

    @Override
    public boolean update(Role role) {
        return jdbc.update(UPDATE_ROLE, role.getRole(), role.getRoleID()) > 0;
    }

    @Override
    public boolean delete(int roleID) {
        jdbc.update(DELETE_FROM_USERS_ROLES, roleID);
        return jdbc.update(DELETE_ROLE, roleID) > 0;
    }

    public final static class RoleMapper implements RowMapper<Role> {

        @Override
        public Role mapRow(ResultSet rs, int i) throws SQLException {
            Role role = new Role();
            role.setRoleID(rs.getInt("roleID"));
            role.setRole(rs.getString("userRole"));
            return role;
        }

    }

}
