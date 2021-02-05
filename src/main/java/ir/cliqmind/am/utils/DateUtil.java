package ir.cliqmind.am.utils;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtil {

    public static int diffDay(LocalDate d1, LocalDate d2){
        return Period.between(d1,d2).getDays();
    }

    public static boolean dateIsInRange(LocalDate date, LocalDate start, LocalDate end) {
        if(start == null && end == null){
            return true;
        }
        if(start==null){
            return date.compareTo(end) <= 0;
        }
        if(end == null){
            return date.compareTo(start) >=0;
        }
        return date.compareTo(start) >=0 && date.compareTo(end) <= 0;
    }

    public static LocalDate addMonth(LocalDate d, int month){
        ZoneId zoneId = ZoneId.systemDefault();
        Date date = Date.from(d.atStartOfDay(zoneId).toInstant());
        YearMonthDate d1 = JalaliCalendar.gregorianToJalali(date);
        int dy = month / 12;
        d1.setMonth(d1.getMonth() + (month % 12));
        d1.setYear(d1.getYear() + dy);
        if(d1.getMonth() > 12){
            d1.setMonth(d1.getMonth() % 12);
            d1.setYear(d1.getYear() + 1);
        }
        d1.setMonth(d1.getMonth()-1);
        YearMonthDate d2 = JalaliCalendar.jalaliToGregorian(d1);
        d2.setMonth(d2.getMonth()+1);
        date = new GregorianCalendar(d2.getYear(), d2.getMonth() - 1, d2.getDate()).getTime();
        return date.toInstant().atZone(zoneId).toLocalDate();
    }

}
