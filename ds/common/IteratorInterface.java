package com.example.dsa_java.dsa.ds.common;


public interface IteratorInterface<E> {

    boolean hasNext();
    E next();
    
    default boolean hasPrevious() {
        throw new UnsupportedOperationException("hasPrevious");
    }
    default E previous() {
        throw new UnsupportedOperationException("previous");
    }
}
