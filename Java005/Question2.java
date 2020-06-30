/*----------------------------------------------------------------------------------------------------------------------
	Parametresi ile aldığı pozitif bir tam sayının kendisi hariç tüm çarpanlarının toplamı ile geri dönen sumFactors
metodunu yazınız. Metot parametresi ile aldığı sayı hariç tüm çarpanlarının toplamına geri dönecektir: (1 her sayının
doğal çarpanıdır ve toplama dahil edilecektir.
-----------------------------------------------------------------------------------------------------------------------*/
package Homework.Java005;

public class Question2 {
    public static void main (String [] args)
    {
        UtilTestApp.run();
    }
}

class UtilTestApp {

    public static void run ()
    {
        java.util.Scanner kb = new java.util.Scanner(System.in);
        System.out.print ("Bir sayı giriniz : ");

        long val = Long.parseLong(kb.nextLine());
        System.out.printf("Sum Factors = %d%n ", Util.sumFactors(val));

    }

}
class Util {

    public static long sumFactors (long val)
    {
        long sum = 1;
        for(long i = 2; i < val; ++i)
            if (val % i == 0)
                sum += i;

        return sum;
    }

}
