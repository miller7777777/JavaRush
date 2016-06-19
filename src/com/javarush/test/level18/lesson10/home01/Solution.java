package com.javarush.test.level18.lesson10.home01;

/* Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв)
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException
    {

        String fileName = args[0];
//        String fileName = "c:\\Temp\\777.txt";
        int countASCII = 0;
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

        FileInputStream fis = new FileInputStream(fileName);
        int dataVolume = fis.available();
        byte[] buffer = new byte[dataVolume];
        int count = fis.read(buffer);

        for (int i = 0; i < buffer.length; i++)
        {
//            if(buffer[i] >= 65 || buffer[i] <= 90){
            String s = Character.toString(((char) buffer[i]));
            if(alphabet.contains(s)){
                countASCII++;
            }
        }
        System.out.println(countASCII );
        fis.close();
    }
}
