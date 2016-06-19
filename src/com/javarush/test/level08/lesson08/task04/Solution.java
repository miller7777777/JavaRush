package com.javarush.test.level08.lesson08.task04;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* Удалить всех людей, родившихся летом
Создать словарь (Map<String, Date>) и занести в него десять записей по принципу: «фамилия» - «дата рождения».
Удалить из словаря всех людей, родившихся летом.
*/

public class Solution
{
    public static HashMap<String, Date> createMap()
    {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Stallone", new Date("JUNE 1 1980"));
        map.put("Putin", new Date("JUNE 1 1960"));
        map.put("Petrov", new Date("JANUARY 1 1980"));
        map.put("Ivanov", new Date("JUNE 1 1980"));
        map.put("Sidorov", new Date("JUNE 1 1980"));
        map.put("Vasiliev", new Date("JUNE 1 1980"));
        map.put("Kotov", new Date("JUNE 1 1980"));
        map.put("Reryu", new Date("JUNE 1 1980"));
        map.put("Huter", new Date("JUNE 1 1980"));
        map.put("Sanin", new Date("JUNE 1 1980"));

        //напишите тут ваш код

        return map;
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map)
    {
        //напишите тут ваш код

//        for(String fam : map.keySet()){
//
//            int month = map.get(fam).getMonth();
//            if(month == 6 || month == 7 || month == 8){
//                map.remove(fam);
//
//            }
//
//
//        }
        Iterator<Map.Entry<String, Date>> iterator = map.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<String, Date> pair = iterator.next();
            Date date = pair.getValue();
            if ( (int) date.getMonth() > 4 && (int) date.getMonth() < 8){
                iterator.remove();
            }

        }

    }

    }

