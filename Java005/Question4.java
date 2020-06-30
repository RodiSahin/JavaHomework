/*----------------------------------------------------------------------------------------------------------------------
	Kendisi haricindeki tüm pozitif bölenlerinin toplamına eşit olan tamsayılara "mükemmel sayı" (perfect number) denir.
Örneğin 6 ve 28 sayıları mükemmel sayılardır:
6 = 1 + 2 + 3
28 = 1 + 2 + 4 + 7 + 14

a) Parametresi ile aldığı int türden bir değerin mükemmel sayı olup olmadığını test eden isPerfect metodunu yazınız.
	Metot sayı mükemmel ise true mükemmel değil ise false değerine geri dönecektir.
b) 4 basamaklı tek bir mükemmel sayı vardır. Yazmış olduğunuz isPerfect metodunu kullanarak 4 basamaklı mükemmel sayıyı
bulan programı yazınız.
-----------------------------------------------------------------------------------------------------------------------*/

package Homework.Java005;

public class Question4 {
    public static void main (String [] args)
{
    NumberUtilTestApp.run();
}
}

class NumberUtilTestApp {

    public static void run ()
    {
        java.util.Scanner kb = new java.util.Scanner(System.in);
		/*
		System.out.print ("Bir sayı giriniz : ");
		int val = Integer.parseInt(kb.nextLine());

		if (NumberUtil.isPerfect(val))
			System.out.printf("%d sayısı mükemmel bir sayıdır.%n", val);
		*/
        for (int i = 1000; i <= 9999; ++ i)
            if(NumberUtil.isPerfect(i))
                System.out.printf("%d sayısı mükemmel  bir sayısıdır.%n", i);

    }

}
class NumberUtil {

    public static boolean isPerfect (int  val)
    {
        return val == sumFactors(val);
    }

    public static int sumFactors (int val)
    {
        int sum = 1;
        for(int i = 2; i < val; ++i)
            if (val % i == 0)
                sum += i;

        return sum;
    }
}
