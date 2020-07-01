/*----------------------------------------------------------------------------------------------------------------------
Parametresi ile aldığı bir dizinin standart sapmasını bulan standardDeviation isimli metodu yazınız ve
elemanları rasgele üretilmiş diziler ile test ediniz.
----------------------------------------------------------------------------------------------------------------------*/

package Java012;

import java.util.Random;

public class Question1 {
    public static void main(String [] args)
    {
        StandardDeviationTestApp.run();
    }
}

class StandardDeviationTestApp {
    public static void run () {

        Random r = new Random();

        int a [] = Util.getRandomArray(r,10,0,100);
        double d = StandardDeviation.standardDeviation(a);

        Util.display(2,a);

        System.out.printf("%.4f%n",d);
    }
}
class StandardDeviation {
    public static double standardDeviation (int [] a) {
        double u = Util.average(a);
        int n = a.length;
        int sum = 0;

        for(int i = 0; i < n; sum += Math.pow((a[i] - u), 2), i++)
            ;
        double alpha =  Math.sqrt(sum/n);

        return alpha;
    }

}
class Util {

    public static int[] getRandomArray(Random r, int a, int min, int max)
        {
        int [] d = new int [a];
        for (int i = 0; i < d.length; ++i)
        d[i] = r.nextInt(max - min) + min;

        return d;
        }

    public static double average(int [] a)
    {
        return (double)sum(a) / a.length;
    }

    public static int sum(int [] a)
    {
        int total = 0;

        for (int val : a)
            total += val;

        return total;
    }

    public static void display(int n, int [] a)
    {
        display(n, a.length, a);
    }

    public static void display(int n, int count, int [] a)
    {
        String fmt = String.format("%%0%dd ", n);

        for (int i = 0; i < count; ++i)
            System.out.printf(fmt, a[i]);

        System.out.println();
    }
}

