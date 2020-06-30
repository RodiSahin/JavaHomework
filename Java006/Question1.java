/*----------------------------------------------------------------------------------------------------------------------
    Craps hemen hemen dünyanın her yerinde bilinen, iki zarla oynanan bir oyundur.
    Oyunun kuralları şöyledir :
    Zarları atacak oyuncu oyunu kasaya karşı oynar. Atılan iki zarın toplam değeri

    i) 7 ya da 11 ise oyuncu kazanır.
    ii)2,3,12 ise oyuncu kaybeder. (Buna craps denir!)
    iii) İki zarın toplam değeri yukarıdakilerin dışında bir değer ise (yani 4,5,6,8,9,10) oyun şu şekilde devam eder:

    Oyuncu aynı sonucu buluncaya kadar zarları tekrar atar. Eğer aynı sonucu bulamadan önce oyuncu 7 atarsa (yani atılan
    iki zarın toplam değeri 7 olursa) oyuncu kaybeder. Eğer 7 gelmeden önce oyuncu aynı sonucu tekrar atmayı başarırsa ,
    kazanır.

    Birkaç örnek :
    Oyuncu zarları attı, zarların toplam değeri :

    11 oyuncu kazandı.Yeni oyun oynanacak.

    3 oyuncu kaybetti.Yeni oyun oynanacak.

    12 oyuncu kaybetti. Yeni oyun oynanacak.

    7 oyuncu kazandı. Yeni oyun oynanacak.

    9 sonuç belli değil, oyuncu tekrar zar atacak.

        8 sonuç belli değil, oyuncu tekrar zar atacak.

            11 sonuç belli değil oyuncu tekrar zar atacak.
                5 sonuç belli değil oyuncu tekrar zar atacak.
                    9oyuncu kazandı. (7 atmadan aynı zarı tekrar attı). Yeni oyun oynanacak.

    6   sonuç belli değil, oyuncu tekrar zar atacak.
        3 sonuç belli değil, oyuncu tekrar zar atacak.
            10 sonuç belli değil, oyuncu tekrar zar atacak.
                7 oyuncu kaybetti. (Aynı zarı tekrar atamadan 7 geldi)

Bu oyunu simüle ederek bilgisayara örneğin 100.000 kez oynatan, ve oyuncunun kazanma olasılığını hesaplayan programı
yazınız.
----------------------------------------------------------------------------------------------------------------------*/
package Homework.Java006;

public class Question1 {
    public static void main(String [] args)
    {
        CrapsTestApp.run();
    }
}

class CrapsTestApp {
    public static void run ()
    {
        /*
        System.out.println("Lütfen zaarları atın");
        System.out.print("Zarları atmak için 1' e basınız :");
        java.util.Scanner kb = new java.util.Scanner(System.in);
        int dices = Integer.parseInt(kb.nextLine());
        if (dices == 1){
            int dice1 = RandomDice.dice();
            int dice2 = RandomDice.dice();
            if (Craps.craps(dice1,dice2))
                System.out.println("Tebrikler \n *****Winnner*****");
            else
                System.out.println("Üzgünüz Tekrar Deneyiniz \n Bad Luck");

         */
        int winCount = 0;
        int playCount = 100_000;
        for (int i = 0;i < playCount; i++) {
            int dice1 = RandomDice.dice();
            int dice2 = RandomDice.dice();
            if (Craps.craps(dice1,dice2))
                winCount++;
        }
        System.out.printf("Kazanma Olasılığı %%%.4f%n",WinRate.rate(winCount,playCount));
    }
}
class Craps {
    public static boolean craps (int dice1, int dice2)
    {
        int sum = dice1 + dice2;

        if (sum == 7 || sum == 11)
            return true;

        if ((sum == 2 || sum == 3 || sum == 12))
            return false;

        for (;;) {
            dice1 = RandomDice.dice();
            dice2 = RandomDice.dice();

            if (sum == dice1 + dice2)
                return true;
            else if (dice1 + dice2 == 7)
                return false;
        }
    }
}
class RandomDice {
    public static int dice ()
    {
        java.util.Random r = new java.util.Random();
        int dice = r.nextInt(6) + 1;

        return dice;
    }
}
class WinRate {
    public static double rate (int winCount, int playCount)
    {
        return (double)winCount / playCount * 100;
    }
}
