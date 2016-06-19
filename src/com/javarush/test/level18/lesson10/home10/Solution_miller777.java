package com.javarush.test.level18.lesson10.home10;

/* Собираем файл
level18.lesson10.home10
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Solution_miller777
{
    public static void main(String[] args) throws IOException
    {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        ArrayList<String> names = new ArrayList<String>();

        String fileName;
        String prefix;
        String[] t = new String[1];

        while (!("end".equals(fileName = reader.readLine())))
        {
            String[] temp = fileName.split("part");
            int number = Integer.parseInt(temp[temp.length - 1]);
            prefix = fileName.replace(temp[temp.length - 1], "");
            t[0] = prefix;

            numbers.add(number);

        }
        prefix = t[0];
        reader.close();
        Collections.sort(numbers);

        for (int i = 0; i < numbers.size(); i++)
        {
            names.add(prefix + String.valueOf(numbers.get(i)));
        }


        String outputFileName = prefix.substring(0, prefix.length() - 5);


        FileOutputStream fos = new FileOutputStream(outputFileName);

        for (int i = 0; i < names.size(); i++)
        {
            FileInputStream fis = new FileInputStream(names.get(i));

            if (fis.available() > 0)
            {
                byte[] buffer = new byte[fis.available()];
                fis.read(buffer);

                fos.write(buffer);
                fos.flush();
            }
            fis.close();
        }

        fos.close();
    }
}
