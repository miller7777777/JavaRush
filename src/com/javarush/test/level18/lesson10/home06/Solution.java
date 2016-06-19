package com.javarush.test.level18.lesson10.home06;

/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки. Не использовать try-with-resources

Пример вывода:
, 19
- 7
f 361
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {

        String fileName = args[0];
//        String fileName = "c:\\eula.1033.txt";

        FileInputStream fis = new FileInputStream(fileName);
        int dataVolume = fis.available();
        byte[] buffer = new byte[dataVolume];
        int count = fis.read(buffer);


        HashMap<Byte, Integer> map = new HashMap<Byte, Integer>();
        ArrayList<Byte> list = new ArrayList<Byte>();

        for (int i = 0; i < buffer.length; i++)
        {
            byte t = buffer[i];
            if (!map.containsKey(t))
            {
                map.put(t, 1);
                list.add(t);
            } else
            {
                int t1 = map.get(t);
                map.put(t, t1 + 1);
            }
        }

        Collections.sort(list);

        byte[] x = new byte[1];


        for (int i = 0; i < list.size(); i++)
        {

            x[0] = list.get(i);
            String s = new String(x);

            System.out.println(s + " " + map.get(list.get(i)));
        }

        fis.close();


    }
}
