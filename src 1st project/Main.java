import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
	public static void main(String[] args) {
		/**
		 * Create prompt for user to select Day, Month and Year as ints Repeat the
		 * prompt twice, to get two dates Dates needs to be in this format: "dd MM yyyy"
		 * example: "23 01 2023" Use provided method int getDaysBetweenTwoDates(String
		 * dateString1, String dateString2) to calculate difference in days Print out
		 * the answer. Repeat while selection != 0
		 */
		int days1, days2, month1, month2, year1, year2, number = 0;
		Scanner myInput = new Scanner(System.in);

		do {
			System.out.print("Enter Date 1 Day: ");
			days1 = myInput.nextInt();
			System.out.print("Enter Date 1 Month: ");
			month1 = myInput.nextInt();
			System.out.println("Enter Date 1 Year: ");
			year1 = myInput.nextInt();

			System.out.print("Enter Date 2 Day: ");
			days2 = myInput.nextInt();
			System.out.print("Enter Date 2 Month: ");
			month2 = myInput.nextInt();
			System.out.print("Enter Date 2 Year: ");
			year2 = myInput.nextInt();

			String d1 = Integer.toString(days1);
			String m1 = Integer.toString(month1);
			String y1 = Integer.toString(year1);
			String d2 = Integer.toString(days2);
			String m2 = Integer.toString(month2);
			String y2 = Integer.toString(year2);

			String date1 = d1 + " " + m1 + " " + y1;
			String date2 = d2 + " " + m2 + " " + y2;

			int daysBetween = getDaysBetweenTwoDates(date1, date2);
			System.out.println("Days: " + daysBetween);

			System.out.println("For new calculation enter 1, otherwise enter 0 to quit");
			number = myInput.nextInt();
		} while (number == 1);
		System.out.println("Program Finished");

// example for the calculation
//int daysBetween = getDaysBetweenTwoDates("23 01 2023", "23 01 2022");
//System.out.println ("Days: " + daysBetween);
	}

	/**
	 * Calculates days difference between two string dates in "dd MM yyyy" format
	 * 
	 * @param dateString1 string date1
	 * @param dateString2 string date2
	 * @return int representation of days in between the input dates
	 */
	private static int getDaysBetweenTwoDates(String dateString1, String dateString2) {
		int days = 0;
		SimpleDateFormat myFormat = new SimpleDateFormat("dd MM yyyy");
		try {
			Date date1 = myFormat.parse(dateString1);
			Date date2 = myFormat.parse(dateString2);
			long diff = date2.getTime() - date1.getTime();

			days = (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return Math.abs(days);
	}
}