/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.supersighting.dao;

import com.sg.supersighting.dao.RoleDAOJDBCImpl.RoleMapper;
import com.sg.supersighting.dto.Role;
import com.sg.supersighting.dto.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserDAOJDBCImpl implements UserDAO {

    @Autowired
    private JdbcTemplate jdbc;

    private final String INSERT_NEW_USER = "INSERT INTO users(username, userPassword, enabled) VALUES (?, ?, ?)";
    private final String SELECT_ALL_USERS = "SELECT userID, username, userPassword, enabled FROM users";
    private final String SELECT_USER_BY_ID = "SELECT userID, username, userPassword, enabled FROM users "
            + "WHERE userID = ?";
    private final String SELECT_USER_BY_USERNAME = "SELECT userID, username, userPassword, enabled FROM users "
            + "WHERE username = ?";
    private final String UPDATE_USER = "UPDATE users SET username = ?, userPassword = ?, enabled = ? "
            + "WHERE userID = ?";
    private final String DELETE_USER = "DELETE from users WHERE userID = ?";

    private final String INSERT_USER_ROLE = "INSERT INTO users_roles(userID, roleID) VALUES(?, ?)";
    private final String SELECT_ROLES_FOR_USER = "SELECT r.roleID, r.userRole FROM roles r INNER JOIN users_roles ur ON "
            + "ur.roleID = r.roleID WHERE ur.userID = ?";
    private final String DELETE_USER_ROLES = "DELETE FROM users_roles WHERE userID = ?";

    @Override
    @Transactional
    public User create(User user) {
        jdbc.update(INSERT_NEW_USER, user.getUsername(), user.getPassword(), user.isEnabled());
        int newID = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        user.setUserID(newID);
        addUserRoles(user);
        return user;
    }

    @Override
    @Transactional
    public List<User> readAll() {
        List<User> users = jdbc.query(SELECT_ALL_USERS, new UserMapper());
        for (User user : users) {
            user.setRoles(getUserRoles(user.getUserID()));
        }
        return users;
    }

    @Override
    @Transactional
    public User readByID(int userID) {
        try {
            User user = jdbc.queryForObject(SELECT_USER_BY_ID, new UserMapper(), userID);
            user.setRoles(getUserRoles(user.getUserID()));
            return user;
        } catch (DataAccessException ex) {
            return null;
        }
    }

    @Override
    @Transactional
    public User readByUsername(String username) {
        try {
            User user = jdbc.queryForObject(SELECT_USER_BY_USERNAME, new UserMapper(), username);
            user.setRoles((getUserRoles(user.getUserID())));
            return user;
        } catch (DataAccessException ex) {
            return null;
        }
    }

    @Override
    @Transactional
    public boolean update(User user) {
        updateUserRoles(user);
        return jdbc.update(UPDATE_USER, user.getUsername(), user.getPassword(), user.isEnabled(), user.getUserID()) > 0;
    }

    @Override
    @Transactional
    public boolean delete(int userID) {
        jdbc.update(DELETE_USER_ROLES, userID);
        return jdbc.update(DELETE_USER, userID) > 0;
    }

    private void addUserRoles(User user) {
        for (Role role : user.getRoles()) {
            jdbc.update(INSERT_USER_ROLE, user.getUserID(), role.getRoleID());
        }
    }

    private Set<Role> getUserRoles(int userID) {
        Set<Role> roles = new HashSet(jdbc.query(SELECT_ROLES_FOR_USER, new RoleMapper(), userID));
        return roles;
    }

    private void updateUserRoles(User user) {
        jdbc.update(DELETE_USER_ROLES, user.getUserID());
        addUserRoles(user);
    }

    public static final class UserMapper implements RowMapper<User> {

        @Override
        public User mapRow(ResultSet rs, int i) throws SQLException {
            User user = new User();
            user.setUserID(rs.getInt("userID"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("userPassword"));
            user.setEnabled(rs.getBoolean("enabled"));
            return user;
        }

    }

}
