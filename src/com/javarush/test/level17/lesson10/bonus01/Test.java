package com.javarush.test.level17.lesson10.bonus01;

import java.util.Date;
import java.util.Scanner;

public class Test

{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        String man = scanner.nextLine();

        System.out.println(man);

        String[] forDate = man.split("/");
        int day = Integer.parseInt(forDate[0]);
        int month = Integer.parseInt(forDate[1]);
        int year = Integer.parseInt(forDate[2]);

        Date date = new Date(year-1900, month - 1, day);

        System.out.println(day);
        System.out.println(month);
        System.out.println(year);
        System.out.println(date);
    }
}
