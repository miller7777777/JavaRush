package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать через пробел во второй файл
Закрыть потоки. Не использовать try-with-resources
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
-3.49 - -3
-3.50 - -3
-3.51 - -4
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_1
{
    public static void main(String[] args) throws IOException
    {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

//        String file1Name = reader.readLine();
//        String file2Name = reader.readLine();
        String file1Name = "c:\\Temp\\5.txt";
        String file2Name = "c:\\Temp\\5_5.txt";

        FileInputStream fis1 = new FileInputStream(file1Name);
        int dataVolume1 = fis1.available();
        byte[] buffer1 = new byte[dataVolume1];
        int count1 = fis1.read(buffer1);

        String str = new String(buffer1, "UTF-8");

        String[] numbers = str.split(" ");

        double[] t = new double[numbers.length];
        int[] result = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++)
        {
            System.out.println(numbers[i]);


            t[i] = Double.parseDouble(numbers[i]);
//            System.out.println(t[i]);
//            result[i] = (int) t[i];
//            System.out.println(result[i]);
        }
    }
}
