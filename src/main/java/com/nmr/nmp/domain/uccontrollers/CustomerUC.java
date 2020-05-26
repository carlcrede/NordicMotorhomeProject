package com.nmr.nmp.domain.uccontrollers;

import com.nmr.nmp.domain.IDataFacade;
import com.nmr.nmp.domain.models.Customer;
import com.nmr.nmp.domain.models.DomainEntity;

import java.util.ArrayList;

public class CustomerUC {

    private IDataFacade dataFacade;

    public CustomerUC(IDataFacade dataFacade) { this.dataFacade = dataFacade; }

    public void create(DomainEntity domainEntity) {
        dataFacade.create(domainEntity);
    }

    public DomainEntity read(int id) {
        return dataFacade.read(id);
    }

    public ArrayList<DomainEntity> readAll() {
        return dataFacade.readAll();
    }

    public void update(DomainEntity domainEntity) {
        dataFacade.update(domainEntity);
    }

    public void delete(int id) {
        dataFacade.delete(id);
    }

}
