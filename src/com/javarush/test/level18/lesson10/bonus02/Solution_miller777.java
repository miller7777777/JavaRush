package com.javarush.test.level18.lesson10.bonus02;

/* Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-c  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id, найденный в файле

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;
import java.util.ArrayList;

public class Solution_miller777
{

    static int id;
    static String sId;
    public static void main(String[] args) throws Exception {

//        int id;
//        String sId;
        String mode = args[0];
        String productName = args[1];
        String price = args[2];
        String quantity = args[3];
        String fileName = "c:\\Temp\\77\\Base.txt";

        FileInputStream fis = new FileInputStream(fileName);
        ArrayList<String> lines = new ArrayList<String>();

        StringBuilder sb = new StringBuilder();

        if(fis.available() == 0){
            id = 0;
        }

        if (fis.available() > 0){
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            String s = new String(buffer);
            String[] lin = s.split("\n");
            id = Integer.parseInt(lin[lin.length - 1].substring(0, 8));

            id ++;
            sId = id + "";



        }




        sb.append(getSubString(sId, 8)).append(getSubString(productName, 30)).append(getSubString(price, 8)).append(getSubString(quantity, 4)).append("\n");

        String s = new String(sb);
        PrintWriter pw = new PrintWriter(fileName);

        pw.write(s);
        pw.flush();






    }

    public static String  getSubString(String name, int capasity)
    {
        StringBuilder sb = new StringBuilder();

        sb.append(name);

        int a = capasity - name.length();

        for (int i = 0; i < a; i++)
        {
            sb.append(" ");
        }

        return new String(sb);
    }


}
