/*----------------------------------------------------------------------------------------------------------------------
	2'den büyük tüm çift sayılar  iki asal sayının toplamı biçiminde yazılabilir (Goldbach teoremi).
	Klavyeden çift sayı alan ve bunu iki asal sayının toplamı Biçiminde yazdıran programı yazınız. Örneğin:

	Sayı : 16

	11 + 5
----------------------------------------------------------------------------------------------------------------------*/

package Homework.Java002;

public class Question5 {

    public static void main (String [] args)
    {
        UtilTestApp.run();
    }
}

class UtilTestApp {

    public static void run ()
    {
        java.util.Scanner kb = new java.util.Scanner(System.in);

        System.out.print(" 2' den büyük bir çift sayı giriniz = ");
        int val = Integer.parseInt(kb.nextLine());


        Util.goldBach(val);

    }

}
class Util {

    public static boolean goldBach (int val)
    {
        if (val % 2 != 0 && val <= 2)
        {
            System.out.println("Geçersiz Sayı girdiniz....");
            return false;
        }

        for(int i = val; i >= 2; --i)
        {
            if (isPrime(i))
                for(int j = val - i; j >=2 ; --j) {
                    if	(isPrime(j))
                        if(val == i + j)
                        {
                            System.out.printf("%d + %d = %d%n", i, j, val);
                            return true;
                        }
                }
        }
        return false;
    }

    public static boolean isPrime (int val)
    {
        if(val < 2)
            return false;

        if (val % 2 == 0)
            return val == 2;

        if (val % 3 == 0)
            return val == 3;

        if (val % 5 == 0)
            return val == 5;

        if (val % 7 == 0)
            return val == 7;

        for (int i = 11; i < val; i += 2) {
            if (val % i == 0)
                return false;
        }
        return true;
    }

}
