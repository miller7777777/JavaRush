package com.javarush.test.level08.lesson11.home09;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/* Работа с датой
1. Реализовать метод isDateOdd(String date) так, чтобы он возвращал true, если количество дней с начала года - нечетное число, иначе false
2. String date передается в формате MAY 1 2013
Пример:
JANUARY 1 2000 = true
JANUARY 2 2020 = false
*/

public class Solution
{
    public static void main(String[] args)
    {
        //
        isDateOdd("JANUARY 2 2020");
        //
    }

    public static boolean isDateOdd(String date)
    {
//        Date date0 = new Date();    // дата начала года, 1 января
//        date0.setMonth(0);
//        date0.setDate(1);



        Boolean result;
        String[] data1 = date.split(" ");
        String[] months = {"JANUARY", "FEBRUARY", "MARCH", "APRIL", "MAY", "JUNE", "JULY", "AUGUST", "SEPTEMBER", "OCTOBER", "NOVEMBER", "DECEMBER"};
        int month1 = -1;

        for (int i = 0; i < months.length; i++)
        {
            if(data1[0].equals(months[i])) month1 = i;
        }

//        String month1 = "Calendar." + data1[0];
        int day1 = Integer.parseInt(data1[1]);
        int year = Integer.parseInt(data1[2]) - 1900;

        Date date0 = new Date();
        date0.setDate(1);
        date0.setMonth(0);
        date0.setYear(year);
        date0.setHours(0);
        date0.setMinutes(0);
        date0.setSeconds(0);

//        System.out.println("date0 = " + date0);
        Date date1 = new Date();

        date1.setDate(day1);
        date1.setMonth(month1);
        date1.setYear(year);
        date1.setHours(0);
        date1.setMinutes(0);
        date1.setSeconds(0);

//        System.out.println("date1 = " + date1);


        long delay = date1.getTime() - date0.getTime(); //ms

        long delay_d = (delay / (1000 * 60 * 60 * 24)) + 1;



        if(delay_d%2==0) result =  false;
        else result = true;


        //
//        Date currentDate = new Date();
//        System.out.println(year);
//        System.out.println(month1);
//        System.out.println(day1);
//        System.out.println(date);
//        System.out.println(date0);
//        System.out.println(date1);
//        System.out.println(currentDate);
//        System.out.println(delay_d);
//        System.out.println(result);
        //


//        GregorianCalendar calendar0 = new GregorianCalendar(year, Calendar.JANUARY, 1);
//        GregorianCalendar calendar1;
//        calendar1 = new GregorianCalendar(year, month1, date1);
//
//        long delay = calendar1.getTime() - calendar0.getTime();
     return result;
    }
}
