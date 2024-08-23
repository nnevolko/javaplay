package test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import main.java.TimeConverter;

public class TimeConverterTest {

	TimeConverter tc = new TimeConverter();

	@Test
	public void testConvertStandardToMilitary() {


			String sampleTime1 = "12:05:30PM";
			String result1 = tc.convertStandardToMilitary(sampleTime1);
			assertTrue(result1.equals("12:05:30"));
			
			String sampleTime2 = "07:05:45PM";
			String result2= tc.convertStandardToMilitary(sampleTime2);
			assertTrue(result2.equals("19:05:45"));
			
			String sampleTime3 = "07:05:45AM";
			String result3 =tc.convertStandardToMilitary(sampleTime3);
			assertTrue(result3.equals("07:05:45"));
			
			String sampleTime4 = "12:05:30AM";
			String result4 = tc.convertStandardToMilitary(sampleTime4);
			assertTrue(result4.equals("00:05:30"));


	}
}
