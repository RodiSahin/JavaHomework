/*----------------------------------------------------------------------------------------------------------------------
    “Mastermind” isimli oyun iki kişi ile oynanan bir sayı bulmaca oyunudur. Oyunculardan biri, [1000-9999] kümesinden
    basamak değerleri birbirinden farklı bir sayı belirler. Diğer oyuncunun amacı bu sayıyı en fazla 10 tahminde
    bulmaktır. Sayıyı belirleyen oyuncu, diğer oyuncunun her tahmininden sonra oyunun kuralları doğrultusunda bilgiler
    vermektedir.
    - Tahmin edilen sayı içerisinde belirlenen sayının içerisindeki rakamlardan biri varsa fakat basamak değeri
    tutmuyorsa - işareti ile, basamak değeri de tutuyorsa + işareti ile bilgi verilir.Örnekler:

    Belirlenen sayı: 1234
    Tahmin edilen sayı: 4567
    Verilecek bilgi:-

    Belirlenen sayı: 1234
    Tahmin edilen sayı: 5674
    Verilecek bilgi: +

    Belirlenen sayı: 1234
    Tahmin edilen sayı: 4237
    Verilecek bilgi: +2-

    Not: Verilecek olan bilgide + ve -'lerin sırasının bir önemi yoktur.

    Bir sayı belirleyerek mastermind oyununu oynatan programı yazınız
----------------------------------------------------------------------------------------------------------------------*/
package Homework.Java009;

import java.util.Random;
import java.util.Scanner;

public class Question1 {
    public static void main(String [] args)
    {
        MasterMindTestApp.run();
    }
}

class MasterMindTestApp {

    public static void run () {
        Random r = new Random ();
        int a = r.nextInt(9000) + 1000;
        if (ArrayUtil.masterMind(a))
            System.out.println("Tebrikler");
        else
            System.out.println("Bşarısız oldunuz...");
    }
}

class ArrayUtil {

    public static boolean masterMind (int a)
    {
        int [] numberArray = digitArray(a);

        Scanner kb = new Scanner(System.in);

        for (int j = 0; j < 10; j++){
            System.out.printf("Belirlenen sayı : %d%n",a);

            System.out.print("Tahmin edilen sayı : ");
            int guess = Integer.parseInt(kb.nextLine());

            int [] guessArray = digitArray(guess);

            System.out.print("Verilecek bilgi: ");
            for (int i = 0; i < numberArray.length; i++){
                for(int k = 0; k < guessArray.length; k++) {
                    if (guessArray [i] == numberArray [k]) {
                        if (i == k){
                            System.out.print("+");
                            break;
                        }
                        else {
                            System.out.print("-");
                            break;
                        }
                    }
                }
            }
            if(a == guess) {
                System.out.println();
                return true;
            }
            System.out.println();
        }
        return false;
    }

    public static int [] digitArray (int a) {
        int [] array = new int [getDigitsCount(a)];
        int len = array.length;
        for(int i = 0; i < len ; i++) {
            array[len - 1 - i] = a % 10;
            a /= 10;
        }
        return array;
    }
    public static int getDigitsCount(long val)
    {
        return val == 0 ? 1 : (int)Math.log10(Math.abs(val)) + 1;
    }
}