/*----------------------------------------------------------------------------------------------------------------------
      Aşağıda açıklanan isPrimeX isimli metodu yazınız isPrimeX metodu içerisinde, gönderilen argumanın asal olup olmadığı
      test edilecek, eğer sayı asal ise bu kez sayının basamak değerleri toplanarak elde edilen sayının asal olup olmadığı
      test edilecektir. Bu işlem sonuçta tek basamaklı bir sayı kalana kadar devam edilecektir. Eğer en son elde edilen
      tek basamaklı sayı dahil tüm sayılar asal ise isPrimeX metodu true değerine geri dönecektir.
      Eğer herhangi bir kademede asal olmayan bir sayı elde edilirse metot false değerine geri dönecektir.
       (Not  birden fazla metot yazabilirsiniz.
---------------------------------------------------------------------------------------------------------------------*/
package Homework.Java004;

public class Question1 {
    public static void main (String [] args)
    {
        NumberUtilTestApp.run();
    }
}

class NumberUtilTestApp {

    public static void run ()
    {
        java.util.Scanner kb = new java.util.Scanner(System.in);
        System.out.println ("Sayıları girmeye başlayınız...");

        int max = 0, min = 100;
        long sum = 0L, count = 0L;

        while (true)
        {
            System.out.print("Yeni bir değer girmek istiyor musunuz [Evet için 1] [Hayır için 0] giriniz : ");
            int enter = Integer.parseInt(kb.nextLine());

            if (NumberUtil.enterValue(enter))
            {
                System.out.print("Sayıyı giriniz:");
                int val = Integer.parseInt(kb.nextLine());

                if (val >= 0 && val <= 100)
                {
                    sum += val;
                    ++count;

                    if (max < val)
                    max = val;

                    if (min > val)
                    min = val;
                }
                else
                    System.out.println("Geçersiz değer");
            }
            else if(enter == 0)
            {
                System.out.println("Program sonlandı.");
                break;
            }
            else
            {
                System.out.println("Geçersiz değer");
            }
        }
        NumberUtil.statistics(count, max, min, sum);
    }

}
class NumberUtil {

    public static boolean enterValue(int enter)
    {
        return enter == 1;
    }


    public static void statistics (long count, int max, int min, long sum)
    {
        System.out.printf("Toplam %d değer girildi.%n", count);
        System.out.printf("Max = %d%n", max);
        System.out.printf("Min = %d%n", min);
        System.out.printf("Ortalama = %f%n", avg(count, sum));
    }

    public static double avg (long count, long sum)
    {
        return sum / count;
    }
}
