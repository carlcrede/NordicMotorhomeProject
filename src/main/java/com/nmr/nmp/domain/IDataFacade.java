package com.nmr.nmp.domain;

import java.util.ArrayList;
import java.util.Map;

public interface IDataFacade<T> {
    void create(T type);
    ArrayList<T> read();
    T read(T type);
    void update(T type);
    void delete(T type);
}
