package com.javarush.test.level18.lesson10.home08;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки. Не использовать try-with-resources
*/

public class Solution_miller777
{
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException
    {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String filename;

        while (!("exit".equals(filename = reader.readLine())))
        {

            Thread tr = new ReadThread(filename);
            tr.start();
//            filename = reader.readLine();

        }
        reader.close();


    }

    public static class ReadThread extends Thread
    {
        private String fileName;

        public ReadThread(String fileName)
        {
            //implement constructor body
            this.fileName = fileName;
        }

        @Override
        public void run()
        {
            super.run();
//            System.out.println("Новая нить запущена.");
            try
            {
                readFile(fileName);
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }

        }

        // implement file reading here - реализуйте чтение из файла тут
        private void readFile(String fileName) throws IOException
        {
            FileInputStream fis = new FileInputStream(fileName);
            ArrayList<Integer> bytes = new ArrayList<Integer>();


            while (fis.available() > 0)
            {
                int data = fis.read();
                bytes.add(data);
            }


            fis.close();

            Map<Integer, Integer> map = new HashMap<Integer, Integer>();

            for (int i = 0; i < bytes.size(); i++)
            {
                if (!map.keySet().contains(bytes.get(i)))
                {
                    map.put(bytes.get(i), 1);
                } else
                {
                    map.put(bytes.get(i), map.get(bytes.get(i)) + 1);
                }
            }


            int max = 0;
            int t = 0;
            for (Integer aByte : map.keySet())
            {
                if (map.get(aByte) > max)
                {
                    max = map.get(aByte);
                    t = aByte;
                }
            }

            synchronized (Solution_miller777.class)
            {
                resultMap.put(fileName, t);
            }
        }
    }
}
