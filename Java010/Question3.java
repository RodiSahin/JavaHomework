/*----------------------------------------------------------------------------------------------------------------------
    Homework 10 Question 3

    Parametresi ile aldığı iki sayıdan, birin cisinin rakamları ile ikinci sayının elde edilip edilemiyeceğini test eden
    isPossible isimli metodu yazınız.

    Örnek :A = 2735; B = 5273 - Yazılabilir.
    A = 2753; B = 25333 - Yazılabilir.
    A = 28; B = 823 – Yazılamaz!
    A = 223; B = 32 – Yazılabilir.
----------------------------------------------------------------------------------------------------------------------*/
package Homework.Java010;

import java.util.Scanner;

public class Question3 {
    public static void main(String [] args)
    {
        TestApp.run();
    }
}

class TestApp {
    public static void run () {
        Scanner kb = new Scanner(System.in);

        for (;;) {
            System.out.print("A = ");
            int a = Integer.parseInt(kb.nextLine());

            if (a == -1)
                break;

            System.out.print("B = ");
            int b = Integer.parseInt(kb.nextLine());
            if (NumberUtil.isPossible(a,b))
                System.out.println("Yazılabilir");
            else
                System.out.println("Yazılamaz");
        }
    }
}

class NumberUtil {
    public static boolean  isPossible (int a, int b) {

        int [] numberA = digitArray(a);
        int [] numberB = digitArray(b);

        for (int i = 0; i < numberB.length; i++) {
            int j;
            for (j = 0; j < numberA.length; j++)
                if (numberB[i] == numberA[j])
                    break;
            int x = j == numberA.length ? j - 1 : j;
            if (numberB[i] != numberA[x])
                return false;
        }
        return true;
    }

    public static int [] digitArray (int a) {
        int[] array = new int[getDigitsCount(a)];
        int len = array.length;
        for (int i = 0; i < len; i++) {
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