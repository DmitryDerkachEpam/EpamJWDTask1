package com.epam.dataprocessing;

import org.junit.Assert;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;

public class DataReaderTest {

	private final DataReader reader = new DataReader();

	@Test
	public void testReadShouldReadStringsWhenFileHasOneString() throws DataException {
		// given
		List<String> expectedLines = Arrays.asList("3 7 2 3 4");
		// when
		List<String> actualLines = reader.read("src/test/resources/inputDataOneLine.txt");
		// then
		Assert.assertEquals(expectedLines, actualLines);
	}

    @Test
    public void testReadShouldReadStringsWhenFileHasMultipleStrings() throws DataException {
        //given
        List<String> expectedLines = Arrays.asList("1 2 3 4 5", "abracadabra", "-1-1-1", "12121212");
        //when
        List<String> actualLines = reader.read("src/test/resources/inputDataMultiLines.txt");
        //then
        Assert.assertEquals(expectedLines, actualLines);
    }
	  
    @Test(expected = DataException.class)
    public void testReadShouldThrowDataExceptionWhenFileNotFound() throws DataException {
        //given
        //when
        List<String> result = reader.read("wrongFileExample");
    }
	 
}
