package ir.cliqmind.am.mapper;

import java.sql.Timestamp;

public class DateMapper {

    public static java.sql.Date convertDate(java.util.Date date){
        if(date == null){
            return null;
        }
        return new java.sql.Date(date.getTime());
    }

    public static Timestamp now() {
        return new Timestamp(System.currentTimeMillis());
    }
}
