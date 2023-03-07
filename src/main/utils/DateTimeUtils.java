package main.utils;

import java.util.Date;

public class DateTimeUtils
{
    public static Date getDateTime(Long date) {
        if(date == null || date < 0) {
            return null;
        }
        return new Date(date);
    }
}
