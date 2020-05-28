package com.nmr.nmp.domain;

import com.nmr.nmp.domain.models.DomainEntity;

import java.util.ArrayList;
import java.util.Map;

public interface IDataFacade {
    void create(DomainEntity domainEntity);
    ArrayList<DomainEntity> readAll();
    ArrayList<DomainEntity> readAvailable();
    DomainEntity read(int id);
    int readLastInsertID();
//    DomainEntity readLast();
    void update(DomainEntity domainEntity);
    void delete(int id);
}