package com.epam.calculator;

import com.epam.entities.Cone;
import com.epam.entities.Point;

public class Calculator {

	public static double coneSurfaceAreaCalculation(double radius, double height) {
		return Math.PI * radius * (Math.sqrt(radius*radius + height*height) + radius);
	}
	
	public static double coneVolumeCalculation(Cone cone) {
		return (1/3) * Math.PI * (cone.getConeRadius() * cone.getConeRadius()) * cone.getСoneHeight();
	}
	
	public static double coneVolumeRatioCalculation(double cuttingPlaneHeight, Cone defaultCone) {
		/*The cut plane is assumed to be parallel to the base of the cone*/
		
		/*
		 * To find the volumes of the resulting figures, it is necessary to find the
		 * radius of the truncated cone, which is possible if we consider the resulting
		 * truncated trapezoid, as well as the rectangular triangle forming it
		 */
		
		/*Find the cotangent of angle between the base of the cone and the side*/
		double сtgAlpha = defaultCone.getConeRadius()/defaultCone.getСoneHeight();
		
		/*Now we can find the upper base of our's rectangular trapezoid*/
		double frustumConeUpperRadius = defaultCone.getConeRadius() - cuttingPlaneHeight * сtgAlpha;
		
		/*Now we can calculate volume of the frustum cone*/
		double frustumConeHeight = cuttingPlaneHeight;
		double frustumConeBaseRadius = defaultCone.getConeRadius();
		double frustumConeVolume = (1/3) * Math.PI * frustumConeHeight * 
			((frustumConeBaseRadius * frustumConeBaseRadius) + 
			frustumConeBaseRadius * frustumConeUpperRadius + 
			(frustumConeUpperRadius * frustumConeUpperRadius));
		
		/*Finally, volume ratio calculation*/
		double smallConeVolume = coneVolumeCalculation(defaultCone) - frustumConeVolume;
		if (frustumConeVolume >= smallConeVolume) {
			return frustumConeVolume/smallConeVolume;
		} else {
			return smallConeVolume/frustumConeVolume;
		}
	}
	/*Add some other checks*/
	public static void isConeBaseOnCoordinatePlane(Cone cone) {
		Point coneCenter = cone.getCenter();
		if (coneCenter.getX() == 0) {
			System.out.println("The base of the figure is on the XY coordinate plane");
		} 
	}
	
}
