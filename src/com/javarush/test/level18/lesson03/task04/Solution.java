package com.javarush.test.level18.lesson03.task04;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.lang.Math.*;

/* Самые редкие байты
Ввести с консоли имя файла
Найти байт или байты с минимальным количеством повторов
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

        int min1 = 2147483647;

        for (Integer key : map.keySet())
        {
            if(map.get(key) < min1){
                min1 = map.get(key);
            }
        }
//        System.out.println(min1);

        ArrayList<Integer> list = new ArrayList<Integer>();
        for (Integer key : map.keySet())
        {
            if(map.get(key) == min1){
                list.add(key);
            }
        }

        for (Integer n : list)
        {
            System.out.print(n + " ");
        }
    }
}
