package com.epam.repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.epam.entities.ConeObservable;

public class ConeRepositoryImpl implements ConeRepository{
	
	Map<Integer, ConeObservable> cones = new HashMap();

	@Override
	public void add(ConeObservable coneObservable) {
		cones.put(coneObservable.getId(), coneObservable);
	}

	@Override
	public void delete(ConeObservable coneObservable) {
		cones.remove(coneObservable.getId(), coneObservable);
	}

	/*final? What is the difference between this and put method?*/
	@Override
	public void update(final ConeObservable coneObservable) {
		cones.put(coneObservable.getId(), coneObservable);
	}

	@Override
	public List<ConeObservable> query(ConeSpecification coneSpecification) {
        List<ConeObservable> result = new ArrayList<>();
        for (ConeObservable cone : cones.values()) {
            if (coneSpecification.specified(cone)) {
                result.add(cone);
            }
        }
        return result;
	}
	/*final?*/
	@Override
	public List<ConeObservable> sort(final Comparator<ConeObservable> comparator) {
        List<ConeObservable> result = new ArrayList<>(cones.values());
        result.sort(comparator);
        return result;
	}

}
