package com.lde.helper;

/**
 * Created by byzilio on 29.11.17.
 */

public class Pair<E,T> {
    E first;
    T second;

    public Pair(E first, T second){
        this.first = first;
        this.second = second;
    }

    public T getSecond() {
        return second;
    }

    public void setSecond(T second) {
        this.second = second;
    }

    public E getFirst() {
        return first;
    }

    public void setFirst(E first) {
        this.first = first;
    }
}
