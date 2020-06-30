/*----------------------------------------------------------------------------------------------------------------------
    Homework7 Question 1

    Bir tombala torbasında 1'den 99'a kadar numaralanmış (99 dahil) pullar bulunmaktadır. Bu tombala torbasıyla aşağıdaki
    oyunlar oynanmaktadır:
    Çekilen bir pul torbaya geri atılmamak üzere
    i) Torbadan 3 pul çekiliyor. Çekilen pulların toplamı 150' den küçük ise oyuncu kazanıyor.
    ii) Torbadan 3 pul çekiliyor. Çekilen pulların toplamı asal sayı ise oyuncu kazanıyor.
    iii) Torbadan 3 pul çekiliyor. En büyük değerli pul ile en küçük değerli pul arasındaki fark ortanca değerli puldan
    büyükse oyuncu kazanıyor.
    Oynanacak her bir oyun için oyuncunun kazanma olasılığını en az 30000 oyunu simule ederek hesaplayınız!
----------------------------------------------------------------------------------------------------------------------*/

package Homework.Java007;

public class Question1 {
    public static void main(String [] args)
    {
        RandomFlakeTestApp.run();
    }
}

class RandomFlakeTestApp {
    public static void run()
    {
        java.util.Scanner kb = new java.util.Scanner(System.in);
        java.util.Random r = new java.util.Random();

        int winCount1 = 0;
        int winCount2 = 0;
        int winCount3 = 0;
        int playCount = 300_000;
        for(int i = 0; i < playCount; i++)
        {
            int flake1 = r.nextInt(99) + 1;
            int flake2 = r.nextInt(99) + 1;
            int flake3 = r.nextInt(99) + 1;

            if (!Util.difNumber(flake1, flake2))
                for (;;) {
                    flake2 = r.nextInt(99) + 1;
                    if (Util.difNumber(flake1, flake2))
                        break;
                }
            if(!Util.difNumber(flake1, flake3) || !Util.difNumber(flake2, flake3))
                for (;;) {
                    flake3 =r.nextInt(99) + 1;
                    if(Util.difNumber(flake1, flake3) && Util.difNumber(flake2, flake3))
                        break;
                }

            //System.out.printf("%d%n%d%n%d%n", flake1, flake2, flake3);

            if (RandomFlake.sumFlakes(flake1, flake2,flake3))
                winCount1++;

            if (RandomFlake.primeSumFlakes(flake1, flake2, flake3))
                winCount2++;

            if (RandomFlake.MaxMinDifFlakes(flake1, flake2, flake3))
                winCount3++;
        }
        System.out.println("Oyunların Kazanma Oranları");
        System.out.printf("1. Oyunun kazanma oranı %.4f%n", Util.winRate(playCount, winCount1));
        System.out.printf("2. Oyunun kazanma oranı %.4f%n", Util.winRate(playCount, winCount2));
        System.out.printf("3. Oyunun kazanma oranı %.4f%n", Util.winRate(playCount, winCount3));

    }
}

class RandomFlake {
    public static boolean sumFlakes (int flake1, int flake2, int flake3)
    {
        return flake1 + flake2 + flake3 < 150;
    }
    public static boolean primeSumFlakes (int flake1, int flake2, int flake3)
    {
        return Util.primeNumber(flake1 + flake2 + flake3);
    }
    public static boolean MaxMinDifFlakes (int flake1, int flake2, int flake3)
    {
        int maxFlake = Util.maxFlake(flake1, flake2, flake3);
        int minFlake = Util.minFlake(flake1, flake2, flake3);
        int middleFlake = Util.middleFlake(flake1, flake2, flake3);

        //System.out.printf("MiddleFlake : %d%n", middleFlake);

        return maxFlake - minFlake > middleFlake;
    }
}

class Util {

    public static  int maxFlake (int flake1, int flake2, int flake3)
    {
        return flake1 > flake2 ? flake1 > flake3 ? flake1 : flake3 : flake2 > flake3 ? flake2 : flake3;
    }

    public static  int minFlake (int flake1, int flake2, int flake3)
    {
        return flake1 < flake2 ? flake1 < flake3 ? flake1 : flake3 : flake2 < flake3 ? flake2 : flake3;
    }

    public static int middleFlake (int flake1, int flake2, int flake3)
    {
        int middleFlake = flake1 > flake2 ? flake2 > flake3 ? flake2 : (flake1 < flake3 ? flake1 : flake3) :
                (flake1 > flake3 ? flake1 : flake2 > flake3 ? flake3 : flake2);

        return middleFlake;
    }

    public static boolean difNumber (int a, int b)
    {
        return a != b;
    }

    public static double winRate (int playCount, int winCount)
    {
        return (double)winCount / playCount * 100;
    }

    public static boolean primeNumber (int val)
    {
        if (val < 2)
            return false;
        if (val == 2)
            return true;
        if (val == 3)
            return true;
        if (val == 5)
            return true;
        if (val == 7)
            return true;
        if (val == 9)
            return true;
        for (int i = 11; i*i < val; i++)
            if (val % i == 0)
                return false;
        return true;
    }
}


