package com.nmr.nmp.data;

import com.nmr.nmp.domain.IDataFacade;
import com.nmr.nmp.domain.Motorhome;

import java.util.Map;

public class DataFacadeMotorhomeImplementation implements IDataFacade<Motorhome> {

    MotorhomeMapper motorhomeMapper = new MotorhomeMapper();

    @Override
    public void create(Motorhome motorhome) {
        motorhomeMapper.create(motorhome);
    }

    @Override
    public Map<Integer, Motorhome> read() {
        return null;
    }

    @Override
    public Motorhome read(Motorhome type) {
        return null;
    }

    @Override
    public void update(Motorhome type) {

    }

    @Override
    public void delete(Motorhome type) {

    }
}
