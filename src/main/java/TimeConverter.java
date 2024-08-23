package main.java;

public class TimeConverter {

	
	public String convertStandardToMilitary(String time) {

		String hourStr = time.substring(0, 2);
		String minStr = time.substring(3, 5);
		String secStr = time.substring(6, 8);
		String partOfDay = time.substring(8, 10);

		int hour = Integer.parseInt(hourStr);
		int minute = Integer.parseInt(minStr);
		int second = Integer.parseInt(secStr);

		if (hour == 12) {
			if ((partOfDay.toLowerCase()).equals("am")) {
				hour = 0;
			}
		}

		if ((partOfDay.toLowerCase()).equals("pm")) {
			if (hour != 12) {
				hour += 12;
			}
		}

		String result = String.format("%02d:%02d:%02d", hour, minute, second);
		return result;
	}
}
