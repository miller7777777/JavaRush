package com.javarush.test.level18.lesson10.home07;

/* Поиск данных внутри файла
Считать с консоли имя файла
Найти в файле информацию, которая относится к заданному id, и вывести ее на экран в виде, в котором она записана в файле.
Программа запускается с одним параметром: id (int)
Закрыть потоки. Не использовать try-with-resources

В файле данные разделены пробелом и хранятся в следующей последовательности:
id productName price quantity

где id - int
productName - название товара, может содержать пробелы, String
price - цена, double
quantity - количество, int

Информация по каждому товару хранится в отдельной строке
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException
    {

        String  sId = args[0];
        int id = Integer.parseInt(args[0]);
//        int id = 777777;


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String fileName = reader.readLine();
        BufferedReader fr = new BufferedReader(new FileReader(fileName));
//        ArrayList<String > list = new ArrayList<String>();
        String s;

        while ((s = fr.readLine()) != null){

//            list.add(s);
            if(s.startsWith((String.valueOf(id) + " " ))){
                System.out.println(s );
            }
    }
        reader.close();
        fr.close();
    }
}
