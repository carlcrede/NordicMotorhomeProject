/* Author: Philip Bretlau, Jannick Lücking Espersen */

package com.nmr.nmp.domain.handlers;

import com.nmr.nmp.domain.IDataFacade;
import com.nmr.nmp.domain.models.DomainEntity;

import java.util.ArrayList;

public class CustomerHandler {

    private IDataFacade dataFacade;

    public CustomerHandler(IDataFacade dataFacade) { this.dataFacade = dataFacade; }

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

    public void update(DomainEntity domainEntity) {
        dataFacade.update(domainEntity);
    }

    public void delete(int id) {
        dataFacade.delete(id);
    }

}
