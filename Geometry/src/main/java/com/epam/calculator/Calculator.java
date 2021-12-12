package com.epam.calculator;

import com.epam.entities.Cone;
import com.epam.entities.Point;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
import static java.lang.Math.PI;;

public class Calculator {
	
	public static double coneSurfaceAreaCalculation(Cone cone) {
		final double coneRadius = cone.getConeRadius();
		final double coneHeight = cone.getСoneHeight();
		double surfaceArea = PI * coneRadius * (sqrt(pow(coneRadius, 2) + pow(coneHeight, 2)) + coneRadius);
		return resultOfCalculationFormating(surfaceArea);
	}

	public static double coneVolumeCalculation(Cone cone) {
		final double coneRadius = cone.getConeRadius();
		final double coneHeight = cone.getСoneHeight();
		double volume = (1/3.0) * PI * (pow(coneRadius, 2)) * coneHeight;
		return resultOfCalculationFormating(volume);
	}

	public static double coneVolumeRatioCalculation(double cuttingPlaneHeight, Cone defaultCone) {
		/* The cut plane is assumed to be parallel to the base of the cone */

		/*
		 * To find the volumes of the resulting figures, it is necessary to find the
		 * radius of the truncated cone, which is possible if we consider the resulting
		 * truncated trapezoid, as well as the rectangular triangle forming it
		 */

		/* Find the cotangent of angle between the base of the cone and the side */
		double сtgAlpha = defaultCone.getConeRadius() / defaultCone.getСoneHeight();

		/* Now we can find the upper base of our's rectangular trapezoid */
		double frustumConeUpperRadius = defaultCone.getConeRadius() - cuttingPlaneHeight * сtgAlpha;

		/* Now we can calculate volume of the frustum cone */
		double frustumConeHeight = cuttingPlaneHeight;
		double frustumConeBaseRadius = defaultCone.getConeRadius();
		double frustumConeVolume = (1 / 3) * Math.PI * frustumConeHeight
				* ((frustumConeBaseRadius * frustumConeBaseRadius) + frustumConeBaseRadius * frustumConeUpperRadius
						+ (frustumConeUpperRadius * frustumConeUpperRadius));

		/* Finally, volume ratio calculation */
		double smallConeVolume = coneVolumeCalculation(defaultCone) - frustumConeVolume;
		if (frustumConeVolume >= smallConeVolume) {
			return frustumConeVolume / smallConeVolume;
		} else {
			return smallConeVolume / frustumConeVolume;
		}
	}
	/* Add some other checks */
	public static void isConeBaseOnCoordinatePlane(Cone cone) {
		Point coneCenter = cone.getCenter();
		if (coneCenter.getX() == 0) {
			System.out.println("The base of the figure is on the XY coordinate plane");
		}
	}
	
	private static double resultOfCalculationFormating (double input) {
		String surfaceAreaRounding = String.format("%.0f", input); 
		return Double.parseDouble(surfaceAreaRounding);
	}
	

}
