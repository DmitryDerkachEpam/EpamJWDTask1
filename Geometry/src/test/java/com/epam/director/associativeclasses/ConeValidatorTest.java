package com.epam.director.associativeclasses;

import org.junit.Assert;
import org.junit.Test;
import com.epam.entities.Cone;
import com.epam.entities.Point;

public class ConeValidatorTest {
	
	private static final String VALID_DATA = "2 2 2 2 2";
	private static final String INVALID_DATA = "2 2 2 -1 -1";
	ConeValidator coneValidator = new ConeValidator();
	/*Do we need test for private methods?*/
  @Test
  public void testIsAValidShouldReturnTrueWhenConeIsValid() {
      //given
	 
      //when
      boolean isValid = coneValidator.isValid(VALID_DATA);
      //then
      Assert.assertTrue(isValid);
  }
  
  @Test
  public void testIsAValidShouldReturnFalseWhenConeIsNotValid() {
      //given
 
      //when
      boolean isValid = coneValidator.isValid(INVALID_DATA);
      //then
      Assert.assertFalse(isValid);
  }
	
}
