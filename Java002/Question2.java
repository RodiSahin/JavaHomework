/*----------------------------------------------------------------------------------------------------------------------
	Parametresi ile aldığı long türden saniye cinsinden süreyi saat, dakika ve saniye olarak ayrıştırarak ekrana yazdıran
	displayDuration isimli metodu yazınız. Eğer saat, dakika ya da saniye değeri 0(sıfır) ise ekrana yazdırılmayacaktır
----------------------------------------------------------------------------------------------------------------------*/

package Homework.Java002;

public class Question2 {

    public static void main (String [] args)
    {
        DisplayDurationTestApp.run();
    }
}

class DisplayDurationTestApp {

    public static void run ()
    {
        java.util.Scanner kb = new java.util.Scanner(System.in);
        System.out.print("Saniyeyi giriniz : ");

        long n = Long.parseLong(kb.nextLine());
        Duration.displayDuration(n);

    }
}
class Duration {
    public static void displayDuration (long n)
    {
        long h, m, s;

        h = hour (n);
        if (h == 0)
        {
            m = minute (n);
            if (m == 0)
            {
                s = second (n);
                if (s != 0)
                    System.out.printf("%d = %d saniye %n", n, s);
            }
            else
            {
                s = second(n % 60);
                if (s != 0)
                    System.out.printf("%d = %d dakika %d saniye %n", n, m, s);
                else
                    System.out.printf("%d = %d dakika %n", n, m);
            }
        }

        else
        {
            m = minute(n % 3600);
            if (m == 0) {
                s = second (n % 60);
                if (s != 0)
                    System.out.printf("%d = %d saat %d  saniye %n", n, h, s);
                else
                    System.out.printf("%d = %d saat %n", n, h);
            }
            else
            {
                s = second(n % 60);
                if (s != 0)
                    System.out.printf("%d = %d saat %d dakika %d saniye %n", n, h, m, s);
                else
                    System.out.printf("%d = %d saat %d dakika %n", n, h, m);
            }
        }


    }

    public static long hour (long n)
    {
        if (n / 3600 != 0)
            return n / 3600;
        return  0;
    }

    public static long minute (long n)
    {
        if (n / 60 != 0)
            return n / 60;
        return 0;
    }

    public static long  second (long n)
    {
        if (n != 0)
            return n;
        return 0;
    }
}

