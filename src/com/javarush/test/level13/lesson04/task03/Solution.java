package com.javarush.test.level13.lesson04.task03;

import java.awt.*;

/* Интерфейс Animal
1. Унаследовать Fox от интерфейса Animal.
2. Поменяй код так, чтобы в классе Fox был только один метод - getName.
3. Методы удалять нельзя!
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
    }

    public interface Animal
    {
        Color getColor();
    }

    public static class AnimalFox implements Animal
    {

        @Override
        public Color getColor()
        {
            return null;
        }
    }

    public static class Fox extends AnimalFox implements Animal
    {
        public String getName()
        {
            return "Fox";
        }


    }
}
