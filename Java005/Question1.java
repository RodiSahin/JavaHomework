/*----------------------------------------------------------------------------------------------------------------------
   Bir Java programı yazarak e sayısını yukarıdaki seri toplamıyla hesaplayarak ekrana yazdırınız
-----------------------------------------------------------------------------------------------------------------------*/

package Homework.Java005;

public class Question1 {
    public static void main (String [] args)
    {
        MathUtilTestApp.run();
    }
}

class MathUtilTestApp {

    public static void run ()
    {
        java.util.Scanner kb = new java.util.Scanner(System.in);
        System.out.println ("Sayı giriniz...");
        while (true)
        {
            int e = Integer.parseInt(kb.nextLine());
            System.out.println("e = " + MathUtil.e(e));
        }
    }

}
class MathUtil {

    public static double e (double e)
    {
        double result = 0;
        for (int i = 0; i < e; i++)
            result += 1 / (double)factorial(i);
        return result;
    }

    public static long factorial (int fac)
    {
        long result = 1;
        for(int i = 2; i <= fac; ++i)
            result *= i;

        return result;
    }
}
