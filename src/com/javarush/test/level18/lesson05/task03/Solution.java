package com.javarush.test.level18.lesson05.task03;

/* Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать бОльшую часть.
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

//        String file1Name = "c:\\Users\\mille_000\\Google Диск\\Books\\_Художественные\\Х\\Харитонов Михаил\\Харитонов_Факап.txt";
//        String file2Name = "c:\\Temp\\1_1.txt";
//        String file3Name = "c:\\Temp\\1_2.txt";

        int dataVolume2;
        int dataVolume3;

        FileInputStream fis = new FileInputStream(file1Name);
        FileOutputStream fos2 = new FileOutputStream(file2Name);
        FileOutputStream fos3 = new FileOutputStream(file3Name);

        int dataVolume = fis.available();
        if(dataVolume % 2 == 0){
            dataVolume2 = dataVolume / 2;
            dataVolume3 = dataVolume / 2;
        }else{
            dataVolume3 = (Integer)(dataVolume / 2);
            dataVolume2 = dataVolume3 + 1;
        }
        byte[] buffer2 = new byte[dataVolume2];
        byte[] buffer3 = new byte[dataVolume3];
        int count2 = fis.read(buffer2);
        int count3 = fis.read(buffer3);

        fos2.write(buffer2, 0, count2);
        fos3.write(buffer3, 0, count3);

        reader.close();
        fis.close();
        fos2.close();
        fos3.close();


    }
}
