package com.epam.caclulator;

import org.junit.Assert;
import org.junit.Test;
import com.epam.calculator.Calculator;
import com.epam.entities.Cone;
import com.epam.entities.Point;

public class CalculatorTest {
	/*static fields in Calc or not?*/
    //private final Calculator calculator = new Calculator();
    private static final double DELTA=0.001;

    @Test
    public void testCalculateSurfaceAreaShouldCalculateWhenConeIsValid() {
        //given
        Cone cone = new Cone(new Point(0, 0, 0), 3, 3);
        //when
        double surfaceArea = Calculator.coneSurfaceAreaCalculation(cone);
        //then
        Assert.assertEquals(68, surfaceArea, DELTA);
    }

    @Test
    public void testCalculateVolumeShouldCalculateWhenBallIsValid() {
        //given
        Cone cone = new Cone(new Point(0, 0, 0), 5, 5);
        //when
        double volume = Calculator.coneVolumeCalculation(cone);
        //then
        Assert.assertEquals(131, volume, DELTA);
    }
}
