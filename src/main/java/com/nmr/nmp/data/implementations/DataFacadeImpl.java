/* Author: Carl Christian Hasselbalch */

package com.nmr.nmp.data.implementations;

import com.nmr.nmp.data.mappers.DataMapper;
import com.nmr.nmp.domain.IDataFacade;
import com.nmr.nmp.domain.models.DomainEntity;

import java.util.ArrayList;

public class DataFacadeImpl implements IDataFacade {

    DataMapper dataMapper;

    public DataFacadeImpl(DataMapper dataMapper){
        this.dataMapper = dataMapper;
    }

    @Override
    public void create(DomainEntity domainEntity) {
        dataMapper.create(domainEntity);
    }

    @Override
    public DomainEntity read(int id) {
        return dataMapper.read(id);
    }

    @Override
    public int readLastInsertID() {
        return dataMapper.readLastInsertID();
    }

    @Override
    public ArrayList<DomainEntity> readAll() {
        return dataMapper.readAll();
    }

    @Override
    public ArrayList<DomainEntity> readAvailable() {
        return dataMapper.readAvailable();
    }

    @Override
    public void update(DomainEntity domainEntity) {
        dataMapper.update(domainEntity);
    }

    @Override
    public void delete(int id) {
        dataMapper.delete(id);
    }
}
