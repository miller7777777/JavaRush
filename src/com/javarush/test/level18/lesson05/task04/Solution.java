package com.javarush.test.level18.lesson05.task04;

/* Реверс файла
Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1Name = reader.readLine();
        String file2Name = reader.readLine();

        FileInputStream fis = new FileInputStream(file1Name);
        int dataVolume = fis.available();
        byte[] buffer = new byte[dataVolume];
        int count = fis.read(buffer);

        byte[] buffer2 = new byte[buffer.length];

        for (int i = 0; i < buffer.length; i++)
        {
            buffer2[i] = buffer[buffer.length - i - 1];
        }

        FileOutputStream fos = new FileOutputStream(file2Name);
        fos.write(buffer2, 0, count);

        reader.close();
        fis.close();
        fos.close();

    }
}
