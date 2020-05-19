package com.nmr.nmp.domain.uccontrollers;

import com.nmr.nmp.domain.IDataFacade;
import com.nmr.nmp.domain.Motorhome;

import java.util.ArrayList;

public class MotorhomeUC {

    private IDataFacade<Motorhome> dataFacade;

    public MotorhomeUC(IDataFacade<Motorhome> dataFacade) { this.dataFacade = dataFacade; }

    public void create(Motorhome motorhome) {
        dataFacade.create(motorhome);
    }

    public ArrayList<Motorhome> read() {
        return dataFacade.read();
    }
}
