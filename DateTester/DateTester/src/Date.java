/**
 * 
 * @author AMaheshwari
 * TODO List:
 * 1.  instance variables and constructors
 * 2.  toString
 * 3.  isLeapYear
 * 4.  daysInMonth
 * 5.  next() -- lots of logic here.  Use 3 and 4 to help you
 * 6.  addDay, addMonth, addYear
 * 7.  compareTo  MAKE SURE YOU MADE THIS CLASS Comparable
 * 8.  daysUntil 
 */

public class Date implements Comparable<Date>{
	private int year;
	private int month;
	private int day;
	private String monthName;

	public Date(int yr, int mon, int dy){
		year = yr;
		month = mon;
		day= dy;
		monthName = "";
	}
	public Date(int dy, String mon, int yr){
		year = yr;
		monthName = mon;
		day = dy;
		month = 0;
	}

	@Override
	public String toString(){
		String suffix = "";
		if(this.month == 1 || this.monthName.equals("Jan")){
			monthName = "January";
			month = 1;
		}else if(this.month == 2 || this.monthName.equals("Feb")){
			monthName = "February";
			month = 2;
		}else if(this.month == 3 || this.monthName.equals("Mar")){
			monthName = "March";
			month = 3;
		}else if(this.month == 4 || this.monthName.equals("Apr")){
			monthName = "April";
			month = 4;
		}else if(this.month == 5 || this.monthName.equals("May")){
			monthName = "May";
			month = 5;
		}else if(this.month == 6 || this.monthName.equals("Jun")){
			monthName = "June";
			month = 6;
		}else if(this.month == 7 || this.monthName.equals("Jul")){
			monthName = "July";
			month = 7;
		}else if(this.month == 8 || this.monthName.equals("August")){
			monthName = "August";
			month = 8;
		}else if(this.month == 9 || this.monthName.equals("Sept")){
			monthName = "September";
			month = 9;
		}else if(this.month == 10 || this.monthName.equals("Oct")){
			monthName = "October";
			month = 10;
		}else if(this.month == 11 || this.monthName.equals("Nov")){
			monthName = "November";
			month = 11;
		}else if(this.month == 12  || this.monthName.equals("Dec")){
			monthName = "December";
			month = 12;
		}
		if(this.day == 1){
			suffix = "st";
		}else if(this.day == 2){
			suffix = "nd";
		}else if(this.day == 3){
			suffix = "rd";
		}else{
			suffix = "th";
		}
		return monthName + " " + day + suffix +", " + year;
	}

	public static boolean isLeapYear(Date d){
		if(d.year % 4 == 0){
			if(d.year % 100 == 0){
				if(d.year % 400 == 0){
					return true;
				}else{
					return false;
				}
			}else{
				return true;
			}
		}else{
			return false;
		}
	}

	public static int daysInMonth(int yr, int mon){
		if(mon >= 8){
			if(mon%2 == 0){
				return 31;
			}else{
				return 30;
			}
		}else if(mon != 2){
			if(mon %2 == 0){
				return 30;
			}else{
				return 31;
			}
		}else{
			if(isLeapYear(new Date(yr, mon, 1))){
				return 29;
			}else{
				return 28;
			}
		}
	}

	public void next(){
		if(this.day<daysInMonth(this.year, this.month)){
			day++;
		}else if(this.day == daysInMonth(this.year, this.month)){
			this.day = 1;
			if(this.month < 12){
				this.month++;
			}else if(month == 12){
				month = 1;
				year++;
			}
		}
	}

	public void addDay(int daysAdded){
		for(int count = 0;count<daysAdded; count++){
			this.next();
		}
	}

	public void addMonth(int monthsAdded){
		int count = 0;

		while(count < monthsAdded){
			if(this.month < 12){
				this.month++;
			}else if(month == 12){
				this.month = 1;
				this.year++;
			}
			count++;
		}

		int subtract = 0;
		if(daysInMonth(this.year, this.month)< this.day){
			subtract = this.day - daysInMonth(this.year, this.month);
			this.day = daysInMonth(this.year, this.month);
			for(int  i = 0; i<subtract; i++){
				this.next();
			}
		}
	}

	public void addYear(int yearsAdded){
		this.year = year + yearsAdded;
		if(this.month == 2){
			int subtract = 0;
			if(daysInMonth(this.year, this.month)< this.day){
				subtract = this.day - daysInMonth(this.year, this.month);
				this.day = daysInMonth(this.year, this.month);
				for(int  i = 0; i<subtract; i++){
					this.next();
				}
			}
		}
	}

	public static int daysUntil(Date d1, Date d2){
		int days = 0;
		if(d1.compareTo(d2) == 1) {
			return -1;
		}
		if(d1.compareTo(d2) == 0) {
			return 0;
		}
		Date prev = d1;
		while(d1.compareTo(d2) < 0) {
			d1.next();
			days++;
		}
		d1 = prev;
		return days;
	}

	public int compareTo(Date d){
		if(this.year > d.year){
			return 1;
		}else if(this.year < d.year){
			return -1;
		}else{
			if(this.month > d.month){
				return 1;
			}else if(this.month < d.month){
				return -1;
			}else{
				if(this.day > d.day){
					return 1;
				}else if(this.day < d.day){
					return -1;
				}else{
					return 0;
				}
			}
		}
	}
}