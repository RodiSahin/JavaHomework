/*----------------------------------------------------------------------------------------------------------------------
        Çağrıldığında ekrana 01.01.1900 ve 31.12.2100 arasında rastgele bir tarihi yazan printRandomDate isimli metodu
    yazınız. Metodun ekrana yazdırdığı tarih geçerli bir tarih olmalıdır. Rasgele tarihin  Şubat ayına denk gelmesi
    durumunda, seçilen yılın artık yıl olup olmamasına göre, Şubat ayı 29 çekebilecektir. Tarih ekrana aşağıdaki
    formatta yazdırılacaktır:

    11th Jul 1983
----------------------------------------------------------------------------------------------------------------------*/
package Homework.Java007;

import java.util.Random;

public class Question2 {
    public static void main(String [] args)
    {
        RandomDateTestApp.run();
    }
}




class RandomDateTestApp {
    public static void run ()
    {
        Random r = new Random();
        int year = RandomDate.randomYear(r);
        int month = RandomDate.randomMonth(r);
        int day = RandomDate.randomDay(r);

        for(;;) {
            if (!Date.isValidDate(day, month, year)) {
                year = RandomDate.randomYear(r);
                month = RandomDate.randomMonth(r);
                day = RandomDate.randomDay(r);
            }
            break;
        }
        RandomDate.displayRandomDateEN(day, month, year);

    }
}

class RandomDate {

    public static String [] monthsEN = {"", "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

    public static void displayRandomDateEN (int day, int month, int year)
    {
        String postfix = "th";

        switch (day) {
            case 1:
            case 21:
            case 31:
                postfix = "st";
                break;

            case 2:
            case 22:
                postfix = "nd";
                break;
            case 3:
            case 23:
                postfix = "rd";
                break;
        }
        System.out.printf("%d%s %s %d%n",day,postfix, monthsEN[month], year);
    }

    public static int randomYear (Random r)
    {
        return r.nextInt(201) + 1900;
    }

    public static int randomMonth (Random r)
    {
        return r.nextInt(12) + 1;
    }

    public static int randomDay (Random r)
    {
        return r.nextInt(31) + 1;
    }
}

class Date {
    public static int[] ms_daysOfMonths = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static boolean isValidDate(int day, int mon, int year) {
        if (day < 1 || day > 31 || mon < 1 || mon > 12)
            return false;

        int days = mon == 2 && isLeapYear(year) ? 29 : ms_daysOfMonths[mon];

        return day <= days;
    }

    public static boolean isLeapYear(int year) {
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }
}