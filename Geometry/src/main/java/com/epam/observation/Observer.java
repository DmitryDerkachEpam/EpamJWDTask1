package com.epam.observation;

public interface Observer<T> {

    void update(T event);
}
