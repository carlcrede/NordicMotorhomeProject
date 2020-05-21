package com.nmr.nmp.domain.uccontrollers;

import com.nmr.nmp.domain.IDataFacade;
import com.nmr.nmp.domain.models.Motorhome;

import java.util.ArrayList;

public class MotorhomeUC {

    private IDataFacade<Motorhome> dataFacade;

    public MotorhomeUC(IDataFacade<Motorhome> dataFacade) { this.dataFacade = dataFacade; }

    public void create(Motorhome motorhome) {
        dataFacade.create(motorhome);
    }

    public Motorhome read(int id) {
        return dataFacade.read(id);
    }

    public ArrayList<Motorhome> read() {
        return dataFacade.read();
    }

    public void update(Motorhome motorhome) {
        dataFacade.update(motorhome);
    }

    public void delete(int id) {
        dataFacade.delete(id);
    }
}
