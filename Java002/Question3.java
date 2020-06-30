/*----------------------------------------------------------------------------------------------------------------------
	3.Bir sayının asal çarpanlarını yazdıran programı yazınız. Örneğin :
		Sayı: 12
		2 2 3
----------------------------------------------------------------------------------------------------------------------*/

package Homework.Java002;

public class Question3 {
    public static void main (String [] args)
    {
        PrimeFactorNumberTestApp.run();
    }
}

class PrimeFactorNumberTestApp {

    public static void run ()
    {
        java.util.Scanner kb = new java.util.Scanner(System.in);
        System.out.print("Sayıyı giriniz  : ");

        int n = Integer.parseInt(kb.nextLine());
        NumberUtil.primeFactorNumber(n);

    }
}
class NumberUtil {
    public static void primeFactorNumber (int n)
    {
        while (n != 0)
            for (int i = 2; i <= n; ++i) {
                if (n % i == 0) {
                    System.out.printf("%d ",i);
                    n /= i;
                    break;
                }
            }
    }
}