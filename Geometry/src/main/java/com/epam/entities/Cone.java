package com.epam.entities;

public class Cone {
	private Point center;
	private double coneRadius;
	private double сoneHeight;
	
	public Cone(Point center, double coneRadius, double сoneHeight) {
		this.center = center;
		this.coneRadius = coneRadius;
		this.сoneHeight = сoneHeight;
	}
	
	public Cone() {
		
	}

	public Point getCenter() {
		return center;
	}

	public double getConeRadius() {
		return coneRadius;
	}

	public double getСoneHeight() {
		return сoneHeight;
	}

	public void setCenter(Point center) {
		this.center = center;
	}

	public void setConeRadius(double coneRadius) {
		this.coneRadius = coneRadius;
	}

	public void setСoneHeight(double сoneHeight) {
		this.сoneHeight = сoneHeight;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((center == null) ? 0 : center.hashCode());
		long temp;
		temp = Double.doubleToLongBits(coneRadius);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(сoneHeight);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cone other = (Cone) obj;
		if (center == null) {
			if (other.center != null)
				return false;
		} else if (!center.equals(other.center))
			return false;
		if (Double.doubleToLongBits(coneRadius) != Double.doubleToLongBits(other.coneRadius))
			return false;
		if (Double.doubleToLongBits(сoneHeight) != Double.doubleToLongBits(other.сoneHeight))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cone [center=" + center + ", coneRadius=" + coneRadius + ", сoneHeight=" + сoneHeight + "]";
	}
	
	
	
	
}	
