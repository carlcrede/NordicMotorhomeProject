package com.nmr.nmp.domain;

import com.nmr.nmp.domain.models.DomainEntity;

import java.util.ArrayList;

public interface IDataFacade {
    void create(DomainEntity domainEntity);
    ArrayList<DomainEntity> readAll();
    ArrayList<DomainEntity> readAvailable();
    DomainEntity read(int id);
    int readLastInsertID();
    void update(DomainEntity domainEntity);
    void delete(int id);
}