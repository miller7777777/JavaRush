package mnz.miller777.level18;

import com.javarush.test.level19.lesson03.task04.Person;

import java.util.Calendar;
import java.util.Calendar.Builder;
import java.util.Date;
import java.util.GregorianCalendar;

public class DataTest
{

    public static void main(String[] args)
    {
        String data = "Иванов Иван Иванович 31 12 1950";
        String[] dataOfPerson = data.split(" ");
        String firstName = dataOfPerson[0];
        String middleName = dataOfPerson[1];
        String lastName = dataOfPerson[2];
        int day = Integer.parseInt(dataOfPerson[3]);
        int month = Integer.parseInt(dataOfPerson[4]);
        int year = Integer.parseInt(dataOfPerson[5]) - 1;
//        GregorianCalendar calendar = new GregorianCalendar(year, month, day);
//        Date birthday = calendar.getTime();


        System.out.println(firstName + " " + middleName + " " + lastName + " " + birthday);
    }
}
