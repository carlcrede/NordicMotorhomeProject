package com.nmr.nmp.data.implementations;

import com.nmr.nmp.data.mappers.ExtraMapper;
import com.nmr.nmp.domain.IDataFacade;
import com.nmr.nmp.domain.models.Extra;

import java.util.ArrayList;

public class ExtraFacadeImpl implements IDataFacade<Extra> {

    ExtraMapper extraMapper = new ExtraMapper();

    @Override
    public void create(Extra extra) {
        extraMapper.create(extra);
    }

    @Override
    public ArrayList<Extra> read() {
        return extraMapper.read();
    }

    @Override
    public Extra read(int id) {
        return extraMapper.read(id);
    }

    @Override
    public void update(Extra extra) {
        extraMapper.update(extra);
    }

    @Override
    public void delete(int id) {
        extraMapper.delete(id);
    }

}
