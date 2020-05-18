package com.nmr.nmp.domain;

import java.util.Map;

public interface IDataFacade<T> {
    void create(T type);
    Map<Integer, T> read();
    T read(T type);
    void update(T type);
    void delete(T type);
}
