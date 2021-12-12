package com.epam.entities;

import java.util.ArrayList;
import java.util.List;

import com.epam.observation.Observable;
import com.epam.observation.Observer;

public class ConeObservable extends Cone implements Observable<ConeObservable>{

	private final Integer id;
	private final List<Observer<ConeObservable>> observerList = new ArrayList<>();
	
	public ConeObservable(Integer id, Point center, double coneRadius, double сoneHeight) {
		super(center, coneRadius, сoneHeight);
		this.id = id;
	}
	
	public Integer getId() {
		return id;
	}
	
	@Override
	public void setCenter(Point center) {
		super.setCenter(center);
		notifyObservers();
	}

	@Override
	public void setConeRadius(double coneRadius) {
		super.setConeRadius(coneRadius);
		notifyObservers();
	}
	
	@Override
	public void setСoneHeight(double сoneHeight) {
		super.setСoneHeight(сoneHeight);
		notifyObservers();
	}
	
	@Override
    public void attach(Observer<ConeObservable> observer) {
        observerList.add(observer);
    }

	@Override
    public void detach(Observer<ConeObservable> observer) {
        observerList.remove(observer);
    }

	@Override
    public void notifyObservers() {
        for (Observer<ConeObservable> observer : observerList) {
            observer.update(this);
        }
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((observerList == null) ? 0 : observerList.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		ConeObservable other = (ConeObservable) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (observerList == null) {
			if (other.observerList != null) {
				return false;
			}
		} else if (!observerList.equals(other.observerList)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "ConeObservable [id=" + id + ", observerList=" + observerList + "]";
	}
	
}
