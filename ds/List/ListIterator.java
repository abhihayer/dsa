package com.example.dsa_java.dsa.ds.List;

import com.example.dsa_java.dsa.ds.common.IteratorInterface;

public class ListIterator<E> implements IteratorInterface<E>{
    private int currIndex = 0;
    private E[] iteratorList = null;

    public ListIterator(E[] list){
        iteratorList = list;
    }

    @Override
    public boolean hasNext() {
        return currIndex < iteratorList.length;
    }

    @Override
    public E next() {
        return iteratorList[currIndex++];
    }

}
