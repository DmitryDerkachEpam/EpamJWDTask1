package com.epam.director.associativeclasses;

import org.junit.Assert;
import org.junit.Test;

import com.epam.entities.Cone;
import com.epam.entities.Point;

public class ConeCreatorTest {

	private static final String VALID_DATA = "4 4 1 2 3";
	private static final String INVALID_DATA = "-1 -1 1 2 3";
	private final ConeCreator creator = new ConeCreator();
	
	@Test
	public void testCreateShouldCreateAConeWhenDataIsValid() {
		//given
		Cone expectedCone = new Cone (new Point(1, 2, 3), 4, 4);
		//when 
		Cone createdCone = creator.create(VALID_DATA);
		//then
		Assert.assertEquals(expectedCone, createdCone);
	}
	
	/*We don't need this test because creation is the step after and only after validation*/ 
	
	/*
	 * @Test 
	 * public void testCreateShouldNotCreateAConeWhenDataIsInvalid() { //given
	 * Cone expectedCone = new Cone (new Point(1, 2, 3), -1, -1); //when Cone
	 * createdCone = creator.create(INVALID_DATA); //then
	 * Assert.assertEquals(expectedCone, createdCone); }
	 */
	
}
