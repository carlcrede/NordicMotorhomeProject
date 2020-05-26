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

    public abstract void doCreateInsert(DomainEntity domainEntity, PreparedStatement ps);
    public abstract DomainEntity loadEntity(ResultSet resultSet);
    public abstract void doUpdateInsert(DomainEntity domainEntity, PreparedStatement ps);

    public void create(DomainEntity domainEntity){
        try {
            ps = connection.prepareStatement(insertStatement());
            doCreateInsert(domainEntity, ps);
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
                return loadEntity(rs);
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
                DomainEntity entity = loadEntity(rs);
                all.add(entity);
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
                available.add(loadEntity(rs));
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
            doUpdateInsert(domainEntity, ps);
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