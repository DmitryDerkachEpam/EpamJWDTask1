package com.epam.storage;

public class ConeParametersForStoraging {
	
    private final double volume;
    private final double surfaceArea;

    public ConeParametersForStoraging (double volume, double surfaceArea) {
        this.volume = volume;
        this.surfaceArea = surfaceArea;
    }

    public double getVolume() {
        return volume;
    }

    public double getSurfaceArea() {
        return surfaceArea;
    }

}
