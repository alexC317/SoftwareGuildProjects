/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.supersighting.daos;

import com.sg.supersighting.daos.LocationDAOJDBCImpl.LocationMapper;
import com.sg.supersighting.daos.PowerDAOJDBCImpl.PowerMapper;
import com.sg.supersighting.daos.SuperDAOJDBCImpl.SuperMapper;
import com.sg.supersighting.dtos.Location;
import com.sg.supersighting.dtos.Organization;
import com.sg.supersighting.dtos.Power;
import com.sg.supersighting.dtos.Super;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class OrganizationDAOJDBCImpl implements OrganizationDAO {

    @Autowired
    private JdbcTemplate jdbc;

    private final String INSERT_NEW_ORGANIZATION = "INSERT INTO organizations (organizationName, organizationDescription, "
            + "organizationContact, locationID) VALUES (?, ?, ?, ?)";
    private final String SELECT_ALL_ORGANIZATIONS = "SELECT organizationID, organizationName, organizationDescription, "
            + "organizationContact, locationID FROM organizations";
    private final String SELECT_ORGANIZATION_BY_ID = "SELECT organizationID, organizationName, organizationDescription, "
            + "organizationContact, locationID FROM organizations WHERE organizationID = ?";
    private final String SELECT_ORGANIZATION_BY_SUPER = "SELECT o.organizationID, o.organizationName, o.organizationDescription, "
            + "o.organizationContact, o.locationID FROM organizations o INNER JOIN supers_organizations so "
            + "ON o.organizationID = so.organizationID WHERE so.superID = ?";
    private final String UPDATE_ORGANIZATION = "UPDATE organizations SET "
            + "organizationName = ?, organizationDescription = ?, organizationContact = ?, locationID = ? "
            + "WHERE organizationID = ?";
    private final String DELETE_ORGANIZATION = "DELETE FROM organizations WHERE organizationID = ?";

    private final String SELECT_LOCATION_FOR_ORGANIZATION = "SELECT locations.locationID, locationName, locationDescription, "
            + "locationAddress, locationLongitude, locationLatitude FROM locations INNER JOIN organizations "
            + "ON locations.locationID = organizations.locationID WHERE organizationID = ?";

    private final String INSERT_INTO_SUPERS_ORGANIZATIONS = "INSERT INTO supers_organizations (superID, organizationID) VALUES (?, ?)";
    private final String SELECT_SUPERS_FOR_ORGANIZATION = "SELECT supers.superID, superName, superDescription FROM supers INNER JOIN supers_organizations "
            + "ON supers.superID = supers_organizations.superID WHERE supers_organizations.organizationID = ?";
    private final String DELETE_FROM_SUPERS_ORGANIZATION = "DELETE FROM supers_organizations WHERE organizationID = ?";

    @Override
    @Transactional
    public Organization addNewOrganization(Organization organization) {
        jdbc.update(INSERT_NEW_ORGANIZATION, organization.getOrganizationName(), organization.getOrganizationDescription(),
                organization.getOrganizationContact(), organization.getOrganizationAddress().getLocationID());
        int newID = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        organization.setOrganizationID(newID);
        addSupersForOrganization(organization);
        return organization;
    }

    @Override
    @Transactional
    public List<Organization> getAllOrganizations() {
        List<Organization> organizations = jdbc.query(SELECT_ALL_ORGANIZATIONS, new OrganizationMapper());
        for (Organization organization : organizations) {
            getLocationForOrganization(organization);
            getSupersForOrganization(organization);
        }
        return organizations;
    }

    @Override
    @Transactional
    public Organization getOrganizationByID(int organizationID) {
        Organization organization = jdbc.queryForObject(SELECT_ORGANIZATION_BY_ID, new OrganizationMapper(), organizationID);
        getLocationForOrganization(organization);
        getSupersForOrganization(organization);
        return organization;
    }

    @Override
    @Transactional
    public Boolean updateOrganization(Organization organization) {
        return jdbc.update(UPDATE_ORGANIZATION, organization.getOrganizationName(), organization.getOrganizationDescription(),
                organization.getOrganizationContact(), organization.getOrganizationAddress().getLocationID(),
                organization.getOrganizationID()) > 0;
    }

    @Override
    @Transactional
    public Boolean deleteOrganization(int organizationID) {
        jdbc.update(DELETE_FROM_SUPERS_ORGANIZATION, organizationID);
        return jdbc.update(DELETE_ORGANIZATION, organizationID) > 0;
    }

    @Override
    @Transactional
    public List<Organization> getOrganizationsBySuper(int superID) {
        List<Organization> organizations = jdbc.query(SELECT_ORGANIZATION_BY_SUPER, new OrganizationMapper(), superID);
        for (Organization organization : organizations) {
            getLocationForOrganization(organization);
            getSupersForOrganization(organization);
        }
        return organizations;
    }

    private void addSupersForOrganization(Organization organization) {
        if (organization.getSupers() == null || organization.getSupers().isEmpty()) {
        } else {
            for (Super s : organization.getSupers()) {
                jdbc.update(INSERT_INTO_SUPERS_ORGANIZATIONS, s.getSuperID(), organization.getOrganizationID());
            }
        }
    }

    private void getLocationForOrganization(Organization organization) {
        Location location = jdbc.queryForObject(
                SELECT_LOCATION_FOR_ORGANIZATION, new LocationMapper(), organization.getOrganizationID());
        organization.setOrganizationAddress(location);
    }

    private void getSupersForOrganization(Organization organization) {
        List<Super> supers = jdbc.query(SELECT_SUPERS_FOR_ORGANIZATION, new SuperMapper(), organization.getOrganizationID());
        if (supers.isEmpty()) {
            supers = null;
        } else {
            for (Super s : supers) {
                List<Power> powers = jdbc.query("SELECT p.* FROM powers p JOIN superpowers s ON s.powerID = p.powerID where s.superID = ?",
                        new PowerMapper(), s.getSuperID());
                if (powers.isEmpty()) {
                    s.setSuperPowers(null);
                } else {
                    s.setSuperPowers(powers);
                }
            }
        }
        organization.setSupers(supers);
    }

    public static final class OrganizationMapper implements RowMapper<Organization> {

        @Override
        public Organization mapRow(ResultSet rs, int i) throws SQLException {
            Organization org = new Organization();
            org.setOrganizationID(rs.getInt("organizationID"));
            org.setOrganizationName(rs.getString("organizationName"));
            org.setOrganizationDescription(rs.getString("organizationDescription"));
            org.setOrganizationContact(rs.getString("organizationContact"));
            return org;
        }

    }

}
