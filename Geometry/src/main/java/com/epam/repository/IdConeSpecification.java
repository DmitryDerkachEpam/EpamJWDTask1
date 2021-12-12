package com.epam.repository;

import com.epam.entities.ConeObservable;

public class IdConeSpecification implements ConeSpecification{

	private final Integer id;
	
	public IdConeSpecification(Integer id) {
		this.id = id;
	}
	
	@Override
	public boolean specified(ConeObservable coneObservable) {
		int currentConeId = coneObservable.getId();
		if (currentConeId == id.intValue()) {
			return true;
		} else {
			return false;
		}
	}

}
