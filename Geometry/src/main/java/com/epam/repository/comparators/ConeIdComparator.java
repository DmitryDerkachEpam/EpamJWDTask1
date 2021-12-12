package com.epam.repository.comparators;

import java.util.Comparator;

import com.epam.entities.ConeObservable;

public class ConeIdComparator implements Comparator<ConeObservable>{
	
	@Override
	public int compare(ConeObservable firstCone, ConeObservable secondCone) {
		Integer firstConeId = firstCone.getId();
		Integer secondConeId = secondCone.getId();
		return firstConeId.compareTo(secondConeId);
	}

}
