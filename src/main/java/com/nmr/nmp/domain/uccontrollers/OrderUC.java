package com.nmr.nmp.domain.uccontrollers;

import com.nmr.nmp.domain.IDataFacade;
import com.nmr.nmp.domain.models.DomainEntity;
import com.nmr.nmp.domain.models.Order;

import java.util.ArrayList;

public class OrderUC {

    private IDataFacade dataFacade;

    public OrderUC(IDataFacade dataFacade) { this.dataFacade = dataFacade; }

    public void create(DomainEntity domainEntity) {
        dataFacade.create(domainEntity);
    }

    public DomainEntity read(int id) {
        return dataFacade.read(id);
    }

    public int readLastInsertID(){
        return dataFacade.readLastInsertID();
    }

    public ArrayList<DomainEntity> readAll() {
        return dataFacade.readAll();
    }

    public ArrayList<DomainEntity> readAvailable() {
        return dataFacade.readAvailable();
    }

    public void update(DomainEntity domainEntity) {
        dataFacade.update(domainEntity);
    }

    public void delete(int id) {
        dataFacade.delete(id);
    }

}