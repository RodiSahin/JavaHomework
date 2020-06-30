/*----------------------------------------------------------------------------------------------------------------------
	Aşağıda açıklanan isPrimeX isimli metodu yazınız: isPrimeX metodu içerisinde, gönderilen argumanın asal olup olmadığı
test edilecek, eğer sayı asal ise bu kez sayının basamak değerleri toplanarak elde edilen sayının asal olup olmadığı
test edilecektir. Bu işlem sonuçta tek basamaklı bir sayı kalana kadar devam edilecektir. Eğer en son elde edilen
tek basamaklı sayı dahil tüm sayılar asal ise isPrimeX metodu true değerine geri dönecektir.
Eğer herhangi bir kademede asal olmayan bir sayı elde edilirse metot false değerine geri dönecektir.
(Not : birden fazla metot yazabilirsiniz.)
----------------------------------------------------------------------------------------------------------------------*/

package Homework.Java003;

public class Question2 {

    public static void main (String [] args)
    {
        UtilTestApp.run();
    }
}

class UtilTestApp {

    public static void run ()
    {
		/*
	 	java.util.Scanner kb = new java.util.Scanner(System.in);

		System.out.print("Bir sayı giriniz: ");
		int val = Integer.parseInt(kb.nextLine());

		while (val != 0)
		{
			if (val > 100 && val < 1000)
			{
				if (NumberUtil.isPrimeX(val))
				{
					System.out.printf("%d isPrimeX bir sayıdır. %n", val);
				}
			}
			else
			{
				System.out.println("Sayı isPrimeX bir sayı değildir!!!");
			}
			val = Integer.parseInt(kb.nextLine());
		}
		*/
        for (int i = 2; i < 1000; ++i)
        {
            if (Util.isPrimeX(i))
            {
                System.out.printf("%d isPrimeX bir sayıdır. %n", i);
            }
        }


    }

}
class Util {

    public static boolean isPrimeX (int val)
    {
        while (val >= 10)
        {
            if (isPrime(val))
                val = getDigitsSum(val);

            else
                return false;
        }
        if (val < 10 && isPrime(val))
            return true;

        return false;

    }

    public static int getDigitsSum(int val)
    {
        int sum = 0;

        while (val != 0) {
            sum += val % 10;
            val /= 10;
        }

        return Math.abs(sum);
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
