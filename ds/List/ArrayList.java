package com.example.dsa_java.dsa.ds.List;

import com.example.dsa_java.dsa.ds.common.IteratorInterface;

public class ArrayList<E> implements ListInterface<E>{
    private int capacity;
    private int size;
    private E[] arrayList = null;

    public ArrayList() {
        setInitial();
    }
    
    @SuppressWarnings("unchecked")
    public void setInitial(){
        capacity = 2;
        size = 0;

        arrayList = (E[]) new Object[capacity];
    }
    
    @SuppressWarnings("unchecked")
    private void addCapacity(){
        capacity = capacity*capacity;

        E[] tempList = (E[]) new Object[capacity];

        for(int i=0; i<size; i++){
            tempList[i] = arrayList[i];
        }
        arrayList = tempList;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

    public int getCapacity(){
        return capacity;
    }

    @Override
    public String toString() {
        return  arrayList.toString();
    }

    @Override
    public E get(int index) {
        if(index>=size){
            throw new ArrayIndexOutOfBoundsException(index);
        }

        return arrayList[index];
    }

    @Override
    public void set(int index, E item) {
        if(index>=size){
            throw new ArrayIndexOutOfBoundsException(index);
        }

        arrayList[index] = item;
    }

    @Override
    public void add(int index, E item) {
        if(size + 1 > capacity){
            addCapacity();
        }

        for(int i=size-1; i>=index; i++){
            arrayList[i+1] = arrayList[i];
        }

        arrayList[index] = item;
        size++;
    }

    @Override
    public void add(E item) {
        if(size+1 > capacity) {
            addCapacity();
        }

        arrayList[size] = item;
        size++;
    }

    @Override
    public void clear() {
        setInitial();
    }

    @Override
    public boolean remove(E item) {
        int index = -1;
        for(int i=0; i<size; i++) {
            if(arrayList[i]==item){
                index = i;
                break;
            }
        }

        if(index==-1) {
            return false;
        }

        return remove(index);
    }

    @Override
    public boolean remove(int index) {
        if(index>=size){
            throw new ArrayIndexOutOfBoundsException(index);
        }
        
        for(int i=index; i<size; i++){
            arrayList[i] = arrayList[i+1];
        }
        size--;
        return true;
    }

    @Override
    public IteratorInterface<E> getIterator() {
        ListIterator<E> li = new ListIterator<E>(arrayList);
        return li;
    }

}
