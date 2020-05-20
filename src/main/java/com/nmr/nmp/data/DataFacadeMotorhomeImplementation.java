package com.nmr.nmp.data;

import com.nmr.nmp.domain.IDataFacade;
import com.nmr.nmp.domain.Motorhome;

import java.util.ArrayList;
import java.util.Map;

public class DataFacadeMotorhomeImplementation implements IDataFacade<Motorhome> {

    MotorhomeMapper motorhomeMapper = new MotorhomeMapper();

    @Override
    public void create(Motorhome motorhome) {
        motorhomeMapper.create(motorhome);
    }

    @Override
    public ArrayList<Motorhome> read() {
        return motorhomeMapper.read();
    }

    @Override
    public Motorhome read(int id) {
        return motorhomeMapper.read(id);
    }

    @Override
    public void update(Motorhome motorhome) {
        motorhomeMapper.update(motorhome);
    }

    @Override
    public void delete(int id) {
        motorhomeMapper.delete(id);
    }
}
