package com.epam.observation;

import com.epam.observation.Observer;

public interface Observable<T> {

    void attach(Observer<T> observer);

    void detach(Observer<T> observer);

    void notifyObservers();
}
