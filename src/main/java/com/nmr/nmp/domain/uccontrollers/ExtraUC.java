package com.nmr.nmp.domain.uccontrollers;

import com.nmr.nmp.domain.IDataFacade;
import com.nmr.nmp.domain.models.Extra;

import java.util.ArrayList;

public class ExtraUC {

    private IDataFacade<Extra> dataFacade;

    public ExtraUC(IDataFacade<Extra> dataFacade) { this.dataFacade = dataFacade; }

    public void create(Extra extra) {
        dataFacade.create(extra);
    }

    public Extra read(int id) {
        return dataFacade.read(id);
    }

    public ArrayList<Extra> read() {
        return dataFacade.read();
    }

    public void update(Extra motorhome) {
        dataFacade.update(motorhome);
    }

    public void delete(int id) {
        dataFacade.delete(id);
    }

}
