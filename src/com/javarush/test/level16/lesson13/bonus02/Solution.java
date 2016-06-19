package com.javarush.test.level16.lesson13.bonus02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* Клубок
1. Создай 5 различных своих нитей c отличным от Thread типом:
1.1. нить 1 должна бесконечно выполняться;
1.2. нить 2 должна выводить "InterruptedException" при возникновении исключения InterruptedException;
1.3. нить 3 должна каждые полсекунды выводить "Ура";
1.4. нить 4 должна реализовать интерфейс Message, при вызове метода showWarning нить должна останавливаться;
1.5. нить 5 должна читать с консоли цифры пока не введено слово "N", а потом вывести в консоль сумму введенных цифр.
2. В статическом блоке добавь свои нити в List<Thread> threads в перечисленном порядке.
3. Нити не должны стартовать автоматически.
Подсказка: Нить 4 можно проверить методом isAlive()
*/

public class Solution
{
    public static List<Thread> threads = new ArrayList<Thread>(5);

    static
    {
        T0 t0 = new T0();
        T1 t1 = new T1();
        T2 t2 = new T2();
        T3 t3 = new T3();
        T4 t4 = new T4();


        threads.add(t0);
        threads.add(t1);
        threads.add(t2);
        threads.add(t3);
        threads.add(t4);
    }


    public static class T0 extends Thread
    {
        @Override
        public void run()
        {
            super.run();
            while (!isInterrupted())
            {
//                System.out.println("I`am working...");
            }
        }
    }

    public static class T1 extends Thread
    {
        @Override
        public void run()
        {
            super.run();
            while (true)
            {
                try
                {
                    sleep(5);
                }
                catch (InterruptedException e)
                {
                    System.out.println("InterruptedException");

                }
            }

        }
    }

    public static class T2 extends Thread
    {
        @Override
        public void run()
        {
            super.run();
            while (true)
            {
                try
                {
                    sleep(500);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                System.out.println("Ура");
            }

        }
    }

    public static class T3 extends Thread implements Message
    {
        @Override
        public void run()
        {
           while (!isInterrupted()){

           }

        }


        @Override
        public void showWarning() throws InterruptedException
        {
            interrupt();
            join();
        }
    }

    public static class T4 extends Thread
    {
        @Override
        public void run()
        {
            super.run();
            Scanner scanner = new Scanner(System.in);
            int sum = 0;
            String s = "";
            while (!(s = scanner.nextLine()).equals("N"))
            {

                sum = sum + Integer.parseInt(s);
            }
            scanner.close();

            System.out.println(sum);
        }
    }

}

