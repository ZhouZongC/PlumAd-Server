package com.mankan.plumad.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author: youtiao
 * @create: 2019-10-14 10:26
 * @description:
 **/
public class WeekUtil {

    public static String dayForWeek(Date date) throws Throwable {

//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//
//        Date tmpDate = format.parse(pTime);

        Calendar cal = Calendar.getInstance();

        String[] weekDays = { "7", "1", "2", "3", "4", "5", "6" };

        try {

            cal.setTime(date);

        } catch (Exception e) {

            e.printStackTrace();

        }

        int w = cal.get(Calendar.DAY_OF_WEEK) - 1; // 指示一个星期中的某天。

        if (w < 0)

            w = 0;

        return weekDays[w];

    }

    public static int hourForday(Date date) throws Throwable {

        Calendar cal=Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));

        int hour = cal.get(Calendar.HOUR);

        return hour;

    }

    public static void main(String[] args) throws Throwable {

        int a = hourForday(new Date());

        System.out.println(a);

    }

}
