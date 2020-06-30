/*----------------------------------------------------------------------------------------------------------------------
    Homework 9 Question 2
    Parametresi ile aldığı int türden bir dizinin en büyük ikinci elemanını bulan secondMax isimli metodu yazınız.
    Denemeyi bir diziye ilk değer vererek yapabilirsiniz.
----------------------------------------------------------------------------------------------------------------------*/

package Homework.Java009;

import java.util.Random;

public class Question2 {
    public static void main(String [] args)
    {
        UtilTestApp.run();
    }
}

class UtilTestApp {

    public static void run () {
        Random r = new Random ();
        int x = r.nextInt(20);
        int [] a = new int [x];
        a = Util.getRandomArray(r,a,0,100);


        for (int i = 0; i < a.length; i++)
            System.out.printf ("%d ", a[i]);

        System.out.println();
        System.out.println (Util.getSecondMax(a));

    }
}

class Util {

    public static int getSecondMax (int[] a)
    {
        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < a.length -1; j++)
                if (a[j] < a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
        for (int i = 0; i < a.length; i++)
            System.out.printf ("%d ", a[i]);

        System.out.println();

        return a[1];
    }
    public static int[] getRandomArray(Random r, int [] a, int min, int max)
    {
        for (int i = 0; i < a.length; ++i)
            a[i] = r.nextInt(max - min) + min;

        return a;
    }

}