package com.javarush.test.level18.lesson03.task03;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

/* Самые частые байты
Ввести с консоли имя файла
Найти байт или байты с максимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        FileInputStream fis = new FileInputStream(fileName);

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        while (fis.available() > 0){
            int data = fis.read();
            if(!map.containsKey(data)){
                map.put(data, 1);
            }else{
                int t = map.get(data);
                map.put(data, t+1);
            }
        }

        List list = new ArrayList(map.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> a, Map.Entry<Integer, Integer> b) {
                return b.getValue() - a.getValue();
            }
        });



        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < list.size(); i++)
        {
            String t = list.get(i).toString();
            String t1[] = t.split("=");
            t = t1[0];
            result.add(Integer.parseInt(t));
        }

//        for (int i = 0; i < result.size(); i++)
//        {
//            System.out.print(result.get(i) + " ");
//        }

        System.out.print(result.get(0));


        fis.close();
        reader.close();
    }
}
