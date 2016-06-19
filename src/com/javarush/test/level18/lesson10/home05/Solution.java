package com.javarush.test.level18.lesson10.home05;/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать во второй файл
Закрыть потоки
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
*/

import java.io.*;
import java.util.Locale;
import java.util.Scanner;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String path1 = reader.readLine();
        String path2 = reader.readLine();
//        String path1 = "c:\\Temp\\5.txt";
//        String path2 = "c:\\Temp\\5_5.txt";
        Scanner scanner = new Scanner(new FileReader(path1)).useLocale(Locale.ENGLISH);
        FileWriter writer1 = new FileWriter(path2);
        StringBuilder builder = new StringBuilder();
        while (scanner.hasNext())
        {
            double data = scanner.nextDouble();
            int num = (int) Math.round(data);
            builder.append(num + " ");
        }
        writer1.write(builder.toString());
        writer1.flush();
        reader.close();
        scanner.close();
        writer1.close();
    }
}