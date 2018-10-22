package com.laoying.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class MyUtil {

    /**
     * Date ==> String
     * @param date
     * @return
     */
    public static String toString(Date date) {
        if(date==null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ");
        String time = sdf.format(date);
        return time;

    }
    /**
     * String ==>  Date
     * @param time
     * @return
     */
    public static Date toDate(String time) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ");
        Date date = null;
        try {
            date = sdf.parse(time);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return date;
    }

    /*日期加3天*/
    public static Date addDate(Date date){
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.DATE,3);
        return calendar.getTime();
    }
}
