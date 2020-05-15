package com.nmr.nmp.domain;

import java.util.Map;

public interface IDataFacade<T> {
    void create(T type);
    Map<Integer, T> read();
    T read(int id);
    void update(T type);
    void delete(int id);
}
