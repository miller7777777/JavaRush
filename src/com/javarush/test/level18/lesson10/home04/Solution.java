package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String file1Name = reader.readLine();
        String file2Name = reader.readLine();

        FileInputStream fis1 = new FileInputStream(file1Name);
        int dataVolume1 = fis1.available();
        byte[] buffer1 = new byte[dataVolume1];
        int count1 = fis1.read(buffer1);

        FileInputStream fis2 = new FileInputStream(file2Name);
        int dataVolume2 = fis2.available();
        byte[] buffer2 = new byte[dataVolume2];
        int count2 = fis2.read(buffer2);

        FileOutputStream fos1 = new FileOutputStream(file1Name);
        FileOutputStream fos2 = new FileOutputStream(file1Name, true);
        fos1.write(buffer2);
        fos2.write(buffer1);

        reader.close();
        fos1.close();
        fos2.close();
        fis1.close();
        fis2.close();
    }
}
