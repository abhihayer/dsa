package com.example.dsa_java.dsa.ds.common;

public interface Collection<E> extends IterableInterface<E>{

    void add(E item);
    boolean remove(E item);
    void clear();
}
