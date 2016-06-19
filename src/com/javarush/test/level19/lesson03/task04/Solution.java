package com.javarush.test.level19.lesson03.task04;

import java.io.IOException;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/* И еще один адаптер
Адаптировать Scanner к PersonScanner.
Классом-адаптером является PersonScannerAdapter.
Данные в файле хранятся в следующем виде:
Иванов Иван Иванович 31 12 1950

В файле хранится большое количество людей, данные одного человека находятся в одной строке. Метод read() должен читать данные одного человека.
*/

public class Solution {
    public static class PersonScannerAdapter implements PersonScanner{

        Scanner scanner;

        public PersonScannerAdapter(Scanner scanner)
        {
            this.scanner = scanner;
        }

        @Override
        public Person read() throws IOException
        {
            String data = this.scanner.nextLine();
            String[] dataOfPerson = data.split(" ");
            String firstName = dataOfPerson[0];
            String middleName = dataOfPerson[1];
            String lastName = dataOfPerson[2];
            int day = Integer.parseInt(dataOfPerson[3]);
            int month = Integer.parseInt(dataOfPerson[4]);
            int year = Integer.parseInt(dataOfPerson[5]) - 1;
            GregorianCalendar calendar = new GregorianCalendar(year, month, day);
            Date birthday = calendar.getTime();

            return new Person(firstName, middleName, lastName, birthday);
        }

        @Override
        public void close() throws IOException
        {

            this.scanner.close();
        }
    }
}
