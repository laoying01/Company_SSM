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
    /*date转String忽略时分秒*/
    public static String toString1(Date date) {
        if(date==null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String time = sdf.format(date);
        return time;

    }
    /**
     * String ==>  Date
     * @param time
     * @return
     */
    public static Date toDate(String time) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = sdf.parse(time);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return date;
    }
    public static Date toDate1(String time) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = sdf.parse(time);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return date;
    }
    /*去年月日*/
    public static Date dateTime(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String s = sdf.format(date);
        Date date1 =null;
        try {
            date1=sdf.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date1;
    }
    /*去时分秒*/
    public static Date dateToDate(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String s = sdf.format(date);
        Date date1 =null;
        try {
             date1=sdf.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date1;
    }
    /*日期加3天*/
    public static Date addDate(Date date){
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.DATE,3);
        return calendar.getTime();
    }

    /*日期加30天*/
    public static Date addDate1(Date date){
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.DATE,30);
        return calendar.getTime();
    }
}
