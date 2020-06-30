/*----------------------------------------------------------------------------------------------------------------------
    26.02.2020
    3 .Ödev 1. Soru:

    abc üç basamaklı bir tamsayıdır ve aşağıdaki koşulları sağlamaktadır:
    koşul 1		cba > abc olacak
    koşul 2		abc asal sayı olacak
    koşul 3		cba asal sayı olacak
    koşul 4  	ab asal sayı olacak
    koşul 5		bc asal sayı olacak
    koşul 6 	cb asal sayı olacak
    koşul 7		ba asal sayı olacak

    113 sayısı bu koşulları sağlamaktadır!

    koşul 1 	cba > abc olacak		311 > 113
    koşul 2 	abc asal sayı olacak	113 asal
    koşul 3		cba asal sayı olacak	311 asal
    koşul 4		ab asal sayı olacak		11 asal
    koşul 5		bc asal sayı olacak		13 asal
    koşul 6		cb asal sayı olacak		31 asal
    koşul 7		ba asal sayı olacak		11 asal

    Yukarıdaki koşulların hepsini sağlayan tüm abc sayılarını bulan programı yazınız.
----------------------------------------------------------------------------------------------------------------------*/

package Homework.Java003;

public class Question1 {
    public static void main(String[] args) {
        NumberUtilTestApp.run();
    }
}

class NumberUtilTestApp {

    public static void run ()
    {
        java.util.Scanner kb = new java.util.Scanner(System.in);

        System.out.print("3 Basamaklı bir sayı giriniz: ");
        int val = Integer.parseInt(kb.nextLine());

        while (val != 0)
        {

            if (val > 100 && val < 1000)
            {
                if (NumberUtil.conditions(val))
                {
                        System.out.printf("%d Tüm koşulları sağlıyor %n", val);
                }
                else
                {
                    System.out.println("Tüm koşulları sağlamıyor");
                }
            }
            else {
                System.out.println("Lütfen 3 basamaklı pozitif bir sayı giriniz!!!");
            }
            System.out.print("3 Basamaklı bir sayı giriniz: ");
            val = Integer.parseInt(kb.nextLine());

        }

    }

}
class NumberUtil {

    public static boolean conditions (int val)
    {
        if (getReverse (val) > val)
            if (isPrime(val))
                if (isPrime(getReverse(val)))
                    if (isPrime(getFirstTwoDigit(val)))
                        if (isPrime(getLastTwoDigit(val)))
                            if(isPrime(getReverse(getFirstTwoDigit(val))))
                                if(isPrime(getReverse(getLastTwoDigit(val))))
                                {
                                    System.out.printf("%d > %d%n", getReverse (val), val);
                                    System.out.printf("%d asal%n", val);
                                    System.out.printf("%d asal%n", getReverse(val));
                                    System.out.printf("%d asal%n", getFirstTwoDigit(val));
                                    System.out.printf("%d asal%n", getLastTwoDigit(val));
                                    System.out.printf("%d asal%n", getReverse(getFirstTwoDigit(val)));
                                    System.out.printf("%d asal%n", getReverse(getLastTwoDigit(val)));
                                    return true;
                                }



        return false;
    }

    public static int getLastTwoDigit (int val)
    {
        return val % 100;
    }

    public static int getFirstTwoDigit (int val)
    {
        return val / pow(10,getDigitsCount(val) - 2);

    }

    public static int pow (int a, int b)
    {
        b = Math.abs(b);
        int pow = 1;
        while (b-- > 0)
        {
            pow *= a;
        }
        return pow;
    }

    public static int getDigitsCount(int val)
    {
        if (val == 0)
            return 1;

        int count = 0;

        while (val != 0)
        {
            ++count;
            val /= 10;
        }

        return count;
    }

    public static int getReverse (int val)
    {
        int reverseNumber = 0;

        while (val !=0)
        {
            reverseNumber = reverseNumber * 10 + (val % 10);
            val /= 10;
        }
        return reverseNumber;
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

