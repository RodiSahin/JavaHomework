/*----------------------------------------------------------------------------------------------------------------------
    Parametresi ile aldığı int türden bir dizi içerisindeki en çok tekrarlanan sayıyı bulan mod isimli metodu yazınız.

    Not: Metot, dizi içinde en çok tekrarlanan sayı birden fazla ise ilk görülen elamanın değeriyle ile geri dönecektir
----------------------------------------------------------------------------------------------------------------------*/
package Homework.Java010;


import java.util.Random;

public class Question2 {
    public static void main(String [] args)
    {
        ModTestApp.run();
    }
}
class ModTestApp {
    public static void run () {
        Random r = new Random();

        int x = r.nextInt(100);
        int [] a = new int [x];
        a = ArrayUtil.getRandomArray(r,a,0,10);

        for (int value : a)
            System.out.printf("%d ", value);
        System.out.println();
        System.out.printf ("Value : %d%n",ArrayUtil.mod(a));
    }
}

class ArrayUtil {
    public static int  mod (int [] a) {

        int [] count = new int[a.length];
        int countId = 0;
        int result = 0;
        for (int i = 0; i < a.length; i++) {
            for (int value : a) {
                if (a[i] == value)
                    ++count[i];
            }
            if (count[i] > countId) {
                countId = count[i];
                result = a[i];
            }
        }
        System.out.printf("Count : %d%n",countId);
        return result ;
    }
    public static int[] getRandomArray(Random r, int [] a, int min, int max)
    {
        for (int i = 0; i < a.length; ++i)
            a[i] = r.nextInt(max - min) + min;

        return a;
    }
}