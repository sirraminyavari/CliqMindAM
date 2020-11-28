package ir.cliqmind.am.utils;

public class YearMonthDate {
	
	private int year;
	private int month;
	private int date;
	
	public YearMonthDate() {
		
	}
	
	public YearMonthDate(int year, int month, int date) {
		this.year = year;
		this.month = month;
		this.date = date;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = date;
	}

	public String toString() {
		return toString("/");
	}
	
	public String toString(String split) {
		return year + split + ((month<10?"0":"")+month)+ split + ((date<10?"0":"")+date);
	}
}
