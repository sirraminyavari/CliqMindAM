package ir.cliqmind.am.utils;

import java.util.Date;

public class JalaliCalendar{
	
    private final static int gregorianDaysInMonth[] = {31, 28, 31, 30, 31,
            30, 31, 31, 30, 31, 30, 31};
    private final static int jalaliDaysInMonth[] = {31, 31, 31, 31, 31, 31,
            30, 30, 30, 30, 30, 29};
    
	public static YearMonthDate gregorianToJalali(final long t) {
		return gregorianToJalali(new Date(t));
	}
	
	@SuppressWarnings("deprecation")
	public static YearMonthDate gregorianToJalali(final Date d) {
		return gregorianToJalali(new YearMonthDate(d.getYear()+1900, d.getMonth(), d.getDate()));
	}
	
	public static YearMonthDate gregorianToJalali(final YearMonthDate gregorian) {

		if (gregorian.getMonth() > 11 || gregorian.getMonth() < -11) {
			throw new IllegalArgumentException();
		}
		int jalaliYear;
		int jalaliMonth;
		int jalaliDay;

		int gregorianDayNo, jalaliDayNo;
		int jalaliNP;
		int i;

		gregorian.setYear(gregorian.getYear() - 1600);
		gregorian.setDate(gregorian.getDate() - 1);

		gregorianDayNo = 365 * gregorian.getYear() + (int) Math.floor((gregorian.getYear() + 3) / 4)
				- (int) Math.floor((gregorian.getYear() + 99) / 100)
				+ (int) Math.floor((gregorian.getYear() + 399) / 400);
		for (i = 0; i < gregorian.getMonth(); ++i) {
			gregorianDayNo += gregorianDaysInMonth[i];
		}

		if (gregorian.getMonth() > 1 && ((gregorian.getYear() % 4 == 0 && gregorian.getYear() % 100 != 0)
				|| (gregorian.getYear() % 400 == 0))) {
			++gregorianDayNo;
		}

		gregorianDayNo += gregorian.getDate();

		jalaliDayNo = gregorianDayNo - 79;

		jalaliNP = (int) Math.floor(jalaliDayNo / 12053);
		jalaliDayNo = jalaliDayNo % 12053;

		jalaliYear = 979 + 33 * jalaliNP + 4 * (int) (jalaliDayNo / 1461);
		jalaliDayNo = jalaliDayNo % 1461;

		if (jalaliDayNo >= 366) {
			jalaliYear += (int) Math.floor((jalaliDayNo - 1) / 365);
			jalaliDayNo = (jalaliDayNo - 1) % 365;
		}

		for (i = 0; i < 11 && jalaliDayNo >= jalaliDaysInMonth[i]; ++i) {
			jalaliDayNo -= jalaliDaysInMonth[i];
		}
		jalaliMonth = i;
		jalaliDay = jalaliDayNo + 1;

		return new YearMonthDate(jalaliYear, jalaliMonth+1, jalaliDay);
	}

	public static YearMonthDate jalaliToGregorian(YearMonthDate jalali) {
		if (jalali.getMonth() > 11 || jalali.getMonth() < -11) {
			throw new IllegalArgumentException();
		}

		int gregorianYear;
		int gregorianMonth;
		int gregorianDay;

		int gregorianDayNo, jalaliDayNo;
		int leap;

		int i;
		jalali.setYear(jalali.getYear() - 979);
		jalali.setDate(jalali.getDate() - 1);

		jalaliDayNo = 365 * jalali.getYear() + (int) (jalali.getYear() / 33) * 8
				+ (int) Math.floor(((jalali.getYear() % 33) + 3) / 4);
		for (i = 0; i < jalali.getMonth(); ++i) {
			jalaliDayNo += jalaliDaysInMonth[i];
		}

		jalaliDayNo += jalali.getDate();

		gregorianDayNo = jalaliDayNo + 79;

		gregorianYear = 1600 + 400 * (int) Math.floor(gregorianDayNo
				/ 146097); /* 146097 = 365*400 + 400/4 - 400/100 + 400/400 */
		gregorianDayNo = gregorianDayNo % 146097;

		leap = 1;
		if (gregorianDayNo >= 36525) /* 36525 = 365*100 + 100/4 */ {
			gregorianDayNo--;
			gregorianYear += 100 * (int) Math.floor(gregorianDayNo
					/ 36524); /* 36524 = 365*100 + 100/4 - 100/100 */
			gregorianDayNo = gregorianDayNo % 36524;

			if (gregorianDayNo >= 365) {
				gregorianDayNo++;
			} else {
				leap = 0;
			}
		}

		gregorianYear += 4 * (int) Math
				.floor(gregorianDayNo / 1461); /* 1461 = 365*4 + 4/4 */
		gregorianDayNo = gregorianDayNo % 1461;

		if (gregorianDayNo >= 366) {
			leap = 0;

			gregorianDayNo--;
			gregorianYear += (int) Math.floor(gregorianDayNo / 365);
			gregorianDayNo = gregorianDayNo % 365;
		}

		for (i = 0; gregorianDayNo >= gregorianDaysInMonth[i] + ((i == 1 && leap == 1) ? i : 0); i++) {
			gregorianDayNo -= gregorianDaysInMonth[i] + ((i == 1 && leap == 1) ? i : 0);
		}
		gregorianMonth = i;
		gregorianDay = gregorianDayNo + 1;

		return new YearMonthDate(gregorianYear, gregorianMonth, gregorianDay);

	}
	
	
	public static void main(String[]args)
	{
		final long t = System.currentTimeMillis();
		Date d = new Date(t);
		YearMonthDate d1 = JalaliCalendar.gregorianToJalali(d);
		String s = d1.toString("-");
		//String s = gregorianToJalali(new YearMonthDate(2017, 11, 24)).toString("-");
		System.out.println(d1.getDate());
		System.out.println(s);
	}
}
