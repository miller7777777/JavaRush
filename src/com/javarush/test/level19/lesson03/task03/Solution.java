package com.javarush.test.level19.lesson03.task03;

/* Адаптация нескольких интерфейсов
Адаптировать IncomeData к Customer и Contact.
Классом-адаптером является IncomeDataAdapter.
Инициализируйте countries перед началом выполнения программы. Соответствие кода страны и названия:
UA Ukraine
RU Russia
CA Canada
Дополнить телефонный номер нулями до 10 цифр при необходимости (смотри примеры)
Обратите внимание на формат вывода фамилии и имени человека
*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();

    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }


    public static class IncomeDataAdapter implements Customer, Contact{



        private IncomeData data;

        public IncomeDataAdapter(IncomeData data)
        {
            this.data = data;


        }

        @Override
        public String getName()
        {
            String s = this.data.getContactLastName() + ", " + this.data.getContactFirstName();
            return s;
        }

        @Override
        public String getPhoneNumber()
        {
            String number = String.valueOf(this.data.getPhoneNumber());
            int numberOfNull = 10 - number.length();



            StringBuilder sb = new StringBuilder();
            StringBuilder sb1 = new StringBuilder();


            for (int i = 0; i < numberOfNull; i++)
            {
                sb1.append("0");
            }

            sb1.append(number);

            number = new String(sb1);

            sb.append("+").append(this.data.getCountryPhoneCode()).append("(").append(number.substring(0, 3)).append(")").append(number.substring(3, 6)).append("-").append(number.substring(6, 8)).append("-").append(number.substring(8));


            String phone = new String(sb);
            return phone;
        }

        @Override
        public String getCompanyName()
        {
            return this.data.getCompany();
        }

        @Override
        public String getCountryName()
        {
//            if (this.data.getCountryCode().equals("UA")){
//                return "Ukraine";
//            }else if(this.data.getCountryCode().equals("RU")){
//                return "Russia";
//            }else {
//                return "Canada";
//            }

            return countries.get(this.data.getCountryCode());
        }
    }

    public static interface IncomeData {
        String getCountryCode();        //example UA

        String getCompany();            //example JavaRush Ltd.

        String getContactFirstName();   //example Ivan

        String getContactLastName();    //example Ivanov

        int getCountryPhoneCode();      //example 38

        int getPhoneNumber();           //example 501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.

        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan

        String getPhoneNumber();        //example +38(050)123-45-67
    }
}