package com.javarush.test.level18.lesson10.home02;

/* Пробелы
В метод main первым параметром приходит имя файла.
Вывести на экран соотношение количества пробелов к количеству всех символов. Например, 10.45
1. Посчитать количество всех символов.
2. Посчитать количество пробелов.
3. Вывести на экран п2/п1*100, округлив до 2 знаков после запятой
4. Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Solution {
    public static void main(String[] args) throws IOException
    {

        String fileName = args[0];
//        String fileName = "c:\\Temp\\777.txt";
        FileInputStream fis = new FileInputStream(fileName);
        int dataVolume = fis.available();
        byte[] buffer = new byte[dataVolume];
        int count = fis.read(buffer);

        int spaces = 0;

        for (int i = 0; i < buffer.length; i++)
        {
//            System.out.println(buffer[i] );
            if(buffer[i] == 32){
                spaces++;

            }
        }
        double x = (spaces + 0.0) / (dataVolume + 0.0) * 100;
        double newDouble = new BigDecimal(x).setScale(2, RoundingMode.HALF_UP).doubleValue();


        System.out.println(newDouble);
        fis.close();


    }
}
