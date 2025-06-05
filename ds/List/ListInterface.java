package com.example.dsa_java.dsa.ds.List;

import com.example.dsa_java.dsa.ds.common.Collection;

public interface ListInterface<E> extends Collection<E>{

    E get(int index);

    void add(int index, E item);
    void set(int index, E item);

    boolean remove(int index);
}