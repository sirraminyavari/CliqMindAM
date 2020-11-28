package ir.cliqmind.am.utils;

import java.sql.Timestamp;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtil {

    public static Date today(){
        Date d = new Date(1000 * (System.currentTimeMillis() / 1000));
        d.setHours(0);
        d.setMinutes(0);
        d.setSeconds(0);
        return d;
    }

    public static java.util.Date now(){
        return new Date(System.currentTimeMillis());
    }

    public static java.sql.Date todaySql(){
        return new java.sql.Date(today().getTime());
    }

    public static java.sql.Date nowSql(){
        return new java.sql.Date(System.currentTimeMillis());
    }

    public static java.sql.Date addMonthSql(java.sql.Date date, int month){
        return convertDate(addMonth(date, month));
    }


    public static int diffDay(Date d1, Date d2){
        return Math.abs((int) ((d1.getTime() - d2.getTime()) / MILLIS_IN_DAY));
    }

    public static boolean dateIsInRange(Date date, Date start, Date end) {
        if(start == null && end == null){
            return true;
        }
        if(start==null){
            return date.equals(end) || date.before(end);
        }
        if(end == null){
            return date.equals(start) || date.after(start);
        }
        return date.equals(start) || date.equals(end) || (date.after(start) && date.before(end));
    }

    public static java.sql.Date convertDate(Date date){
        if(date == null){
            return null;
        }
        return new java.sql.Date(date.getTime());
    }

    public static Timestamp nowTimestamp() {
        return new Timestamp(System.currentTimeMillis());
    }

    public static Date addMonth(Date date, int month){
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
        return new GregorianCalendar(d2.getYear(), d2.getMonth() - 1, d2.getDate()).getTime();
    }

    private final static long MILLIS_IN_DAY = 24 * 60 * 60 * 1000;


}
