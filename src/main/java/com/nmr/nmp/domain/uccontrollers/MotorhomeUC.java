package com.nmr.nmp.domain.uccontrollers;

import com.nmr.nmp.domain.IDataFacade;
import com.nmr.nmp.domain.Motorhome;

public class MotorhomeUC {

    private IDataFacade<Motorhome> dataFacade;

    public MotorhomeUC(IDataFacade<Motorhome> dataFacade) { this.dataFacade = dataFacade; }

    public void create(Motorhome motorhome) {
        dataFacade.create(motorhome);
    }
}
