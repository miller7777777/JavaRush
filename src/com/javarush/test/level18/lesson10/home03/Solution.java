package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать в первый файл содержимое третьего файла
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String file1Name = reader.readLine();
        String file2Name = reader.readLine();
        String file3Name = reader.readLine();


//        String file1Name = "c:\\Temp\\777.txt";
//        String file2Name = "c:\\Temp\\888.txt";
//        String file3Name = "c:\\Temp\\999.txt";




        FileInputStream fis2 = new FileInputStream(file2Name);
        int dataVolume2 = fis2.available();
        byte[] buffer2 = new byte[dataVolume2];
        int count2 = fis2.read(buffer2);

        FileInputStream fis3 = new FileInputStream(file3Name);
        int dataVolume3 = fis3.available();
        byte[] buffer3 = new byte[dataVolume3];
        int count3 = fis3.read(buffer3);

        FileOutputStream fos1 = new FileOutputStream(file1Name, true);
        fos1.write(buffer2);
        fos1.write(buffer3);

        reader.close();
        fos1.close();
        fis2.close();
        fis3.close();

    }
}
