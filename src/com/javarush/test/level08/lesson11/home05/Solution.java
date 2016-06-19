package com.javarush.test.level08.lesson11.home05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Мама Мыла Раму. Теперь с большой буквы
Написать программу, которая вводит с клавиатуры строку текста.
Программа заменяет в тексте первые буквы всех слов на заглавные.
Вывести результат на экран.

Пример ввода:
  мама     мыла раму.

Пример вывода:
  Мама     Мыла Раму.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();


        //напишите тут ваш код
//        String[]sArr = s.split(" ");
//        String output = "";
//
//        for(String word:sArr){
//            String first = word.substring(0,1).toUpperCase();
//            String all = word.substring(1);
//            output+=first+all + " ";
//        }
//
//        output = output.substring(0, output.length()-1);
//
//        System.out.println(output);


        char[] arr = s.toCharArray();
        s = "";
        for (int i = 0; i < arr.length; i++) {
            if (Character.isAlphabetic(arr[i]) &&
                    (i < 1 || Character.isSpaceChar(arr[i - 1])))
                s += Character.toUpperCase(arr[i]);
            else
                s += arr[i];
        }
        System.out.println(s);


    }


}
