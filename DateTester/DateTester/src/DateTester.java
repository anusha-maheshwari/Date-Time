public class DateTester {

	/** You need two constructors.  One that has three int parameters.  One that has two ints and a String*/
	Date d1 = new Date(2020, 4, 14);
	Date d2 = new Date(31, "Dec", 2019);
	Date test1 = new Date(2019, 1, 1);
	Date test2 = new Date(2021, 1, 1);

	public static void main(String[] args) {
		new DateTester().start();
	}

	private void start() {
		// this will call the toString method and add d1's and d2's String to literal Strings
		// In order for this to look right, you must override the toString method appropriately
		System.out.println("Testing "+d1+" and "+d2);
		testLeapYear();
		testDaysInMonth();
		testAdvanceDates();
		testComparableQuality();
		testDaysUntil();
	}

	/** This method tests all the modifier methods.  Modifier method modify (or change) the Object.  
	 * Other examples of modifiers are "setters".  The move method in the Robot class is another modifier.
	 */
	private void testAdvanceDates() {
		System.out.println("d2 "+d2+" at the start");
		d2.next();// adds one day
		System.out.println("d2 "+d2+" after calling next");

		System.out.println("d1 "+d1+ " at the start");
		d1.addDay(1);// adds one day
		System.out.println("d1 "+d1+ " after adding one day");
		d1.addDay(100);// adds one day
		System.out.println("d1 "+d1+ " after adding 100 days");

		System.out.println("d2 "+d2+" at the start");
		d2.addMonth(1);// adds one month
		System.out.println("d2 "+d2+" after adding 1 month.");

		System.out.println("d1 "+d1+ " at the start");
		d1.addYear(2); // adds two years
		System.out.println("d1 "+d1+ " after adding 2 years");
	}

	/** This method tests the static method isLeapYear.  isLeapYear takes in a parameter that is 
	 * of type Date, but it also might make sense to override this so that it can also accept an int
	 * that represent the year.
	 */
	private void testLeapYear() {
		System.out.println(d2+" is a leap year "+Date.isLeapYear(d2));
		System.out.println(d1+" is a leap year "+Date.isLeapYear(d1));
		Date d3 = new Date(1999, 12, 31);
		System.out.println(d3+" is a leap year "+Date.isLeapYear(d3));
		Date d4 = d3;
		d4.addYear(1);
		System.out.println(d4+" is a leap year "+Date.isLeapYear(d4));
		d3.addYear(100);
		System.out.println(d4+" is a leap year "+Date.isLeapYear(d4));
		// might make sense to add functionality to allow the lines below to run
		// System.out.println(1998+" is a leap year "+Date.isLeapYear(1998));
		// System.out.println(2008+" is a leap year "+Date.isLeapYear(2008));
	}

	/** This method tests the static method daysInMonth.  This method takes in two int parameters that represent
	 * year and month, respectively.  It might make sense to override this method so that it takes in a parameter of 
	 * type date.  I would highly recommend daysInMonth call isLeapYear where appropriate.
	 */
	private void testDaysInMonth() {
		System.out.println("Days in April 2022 "+Date.daysInMonth(2022, 4));
		System.out.println("Days in February 2020 "+Date.daysInMonth(2020, 2));
		System.out.println("Days in February 2021 "+Date.daysInMonth(2021, 2));
		// if you override the method, you can use the lines below to test
		//System.out.println("Days in "+d2 " month are: "+Date.daysInMonth(d2));
		//System.out.println("Days in "+d1 " month are: "+Date.daysInMonth(d1));
	}

	/** The Date class must implement Comparable correctly.  This is NOT a modifier, so the Dates should
	 * not be changed by the compareTo method.  
	 */
	private void testComparableQuality() {
		System.out.println("Comparing "+d1+" and "+d2);
		int comp = d1.compareTo(d2);
		if(comp < 0)
			System.out.println(d1 + " is smaller than "+d2);
		else if(comp > 0)
			System.out.println(d2 + " is smaller than "+d1);
		else 
			System.out.println(d1 + " is the same as "+d2);

		Date d3 = new Date(2000, 1, 30);// Jan 30, 2000
		Date d4 = new Date(2000, 5, 5);// Cinco de Mayo of same year
		System.out.println("Finding out how many days until "+d3+" is "+d4);
		int days = 0;
		while(d3.compareTo(d4) < 0) {
			d3.next();
			days++;
		}
		System.out.println(d3+" was "+days+" earlier than "+d4);
		System.out.println("Why are they the same, now?????");

	}
	/**
	 * This method tests the daysUntil method.  This method is NOT a modifier, 
	 * meaning each Date should remain unchanged by the static method.
	 * You could also override this method and make it non-static, as well.
	 */
	private void testDaysUntil() {
		System.out.println("Calculating days until "+d1+" reaches "+d2);
		System.out.println(Date.daysUntil(d1,d2));
		System.out.println("Calculating days until "+d2+" reaches "+d1);
		System.out.println(Date.daysUntil(d2,d1));
		System.out.println("Calculating days until "+test1+" reaches "+test2);
		System.out.println(Date.daysUntil(test1,test2));
		// if you try to override it and make a second, non-static method uncomment the lines below
		// System.out.println(d1+" is "+d1.daysUntil(d2)+" before " +d2);
		// System.out.println(d2+" is "+d2.daysUntil(d1)+" before " +d1);


	}
}
