package com.javarush.test.level08.lesson11.bonus01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* Номер месяца
Программа вводит с клавиатуры имя месяца и выводит его номер на экран в виде: «May is 5 month».
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        System.out.println("input month:");
        String month = reader.readLine();
        String monthUp = month.toUpperCase();
        month = monthUp;



//        Scanner scanner = new Scanner(System.in);
//        String month = scanner.nextLine();
        String[] months = {"JANUARY", "FEBRUARY", "MARCH", "APRIL", "MAY", "JUNE", "JULY", "AUGUST", "SEPTEMBER", "OCTOBER", "NOVEMBER", "DECEMBER"};
        int month1 = -1;

        for (int i = 0; i < months.length; i++)
        {
            if(month.equals(months[i])) month1 = i + 1;
        }

        month = monthUp.toLowerCase();
        char[] arr = month.toCharArray();
        String s = "";
        for (int i = 0; i < arr.length; i++) {
            if (Character.isAlphabetic(arr[i]) &&
                    (i < 1 || Character.isSpaceChar(arr[i - 1])))
                s += Character.toUpperCase(arr[i]);
            else
                s += arr[i];
        }
        month = s;

        System.out.println(month + " is " + month1 + " month");
    }

}
