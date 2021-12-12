package com.epam.repository;

import java.util.Comparator;
import java.util.List;

import com.epam.entities.ConeObservable;

public interface ConeRepository {

    void add(ConeObservable coneObservable);

    void delete(ConeObservable coneObservable);

    void update(ConeObservable coneObservable);

    List<ConeObservable> query(ConeSpecification coneSpecification);

    List<ConeObservable> sort(Comparator<ConeObservable> comparator);
}
