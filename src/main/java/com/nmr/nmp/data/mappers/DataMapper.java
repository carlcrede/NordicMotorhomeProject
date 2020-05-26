package com.nmr.nmp.data.mappers;

import com.nmr.nmp.data.DBManager;
import com.nmr.nmp.domain.models.DomainEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public abstract class DataMapper {
    Connection connection = DBManager.getConnection();
    PreparedStatement ps = null;
    ResultSet rs = null;

    public abstract String insertStatement();
    public abstract String readSingleStatement();
    public abstract String readAllStatement();
    public abstract String readAvailableStatement();
    public abstract String updateStatement();
    public abstract String deleteStatement();

    public abstract void doInsert(DomainEntity domainEntity, PreparedStatement ps);
    public abstract DomainEntity load(ResultSet resultSet);
    protected abstract void doUpdate(DomainEntity domainEntity, PreparedStatement ps);

    public void create(DomainEntity domainEntity){
        try {
            ps = connection.prepareStatement(insertStatement());
            doInsert(domainEntity, ps);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeStatementOrSet();
        }
    }

    public DomainEntity read(int id){
        try {
            ps = connection.prepareStatement(readSingleStatement());
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if(rs.next()) {
                return load(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeStatementOrSet();
        }
        return null;
    }

    public ArrayList<DomainEntity> readAll(){
        ArrayList<DomainEntity> all = new ArrayList<>();
        try {
            ps = connection.prepareStatement(readAllStatement());
            rs = ps.executeQuery();
            while (rs.next()) {
                all.add(load(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeStatementOrSet();
        }
        return all;
    }

    public ArrayList<DomainEntity> readAvailable(){
        ArrayList<DomainEntity> available = new ArrayList<>();
        try {
            ps = connection.prepareStatement(readAvailableStatement());
            rs = ps.executeQuery();
            while (rs.next()) {
                available.add(load(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeStatementOrSet();
        }
        return available;
    }

    public void update(DomainEntity domainEntity){
        try {
            ps = connection.prepareStatement(updateStatement());
            doUpdate(domainEntity, ps);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeStatementOrSet();
        }
    }

    public void delete(int id){
        try {
            ps = connection.prepareStatement(deleteStatement());
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeStatementOrSet();
        }
    }

    private void closeStatementOrSet(){
        try {
            if (ps != null) {
                ps.close();
            }
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}