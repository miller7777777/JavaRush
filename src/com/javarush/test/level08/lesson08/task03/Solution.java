package com.javarush.test.level08.lesson08.task03;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* Одинаковые имя и фамилия
Создать словарь (Map<String, String>) занести в него десять записей по принципу «Фамилия» - «Имя».
Проверить сколько людей имеют совпадающие с заданным имя или фамилию.
*/

public class Solution


{
    public static HashMap<String, String> createMap()
    {
        //напишите тут ваш код

        HashMap<String, String> map = new HashMap<String, String>();
        map.put("Иванов", "Алексей");
        map.put("Петров", "Сергей");
        map.put("Васечкин", "Иван");
        map.put("Ваганов", "Рустам");
        map.put("Пушкин", "Александр");
        map.put("Лермонтов", "Михаил");
        map.put("Руставели", "Шота");
        map.put("Гоголь", "Николай");
        map.put("Шевченко", "Тарас");
        map.put("Куприн", "Александр");

        return map;
    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name)
    {
        //напишите тут ваш код




        int count = 0;

        for(String fam : map.keySet()){
            if(map.get(fam).equals(name)){
                count++;
            }
        }
        return count;

    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String familiya)
    {
        //напишите тут ваш код
        if (map.containsKey(familiya)){
            return 1;
        }else return 0;

    }
}
