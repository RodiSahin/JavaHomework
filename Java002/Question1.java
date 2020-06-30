/*----------------------------------------------------------------------------------------------------------------------
	1.Klavyeden bir n sayısı okuyunuz ve aşağıdaki deseni oluşturan programı yazınız (örneğimizde n = 6’dır):

     *
    ***
   *****
  *******
 *********
***********
 *********
  *******
   *****
    ***
     *

----------------------------------------------------------------------------------------------------------------------*/

package Homework.Java002;

public class Question1 {
    public static void main (String [] args)
    {
        GetFigureTestApp.run();
    }
}


class GetFigureTestApp {

    public static void run ()
    {
        java.util.Scanner kb = new java.util.Scanner(System.in);
        System.out.print("Sayıyı giriniz : ");

        int n = Integer.parseInt(kb.nextLine());
        Figure.deltoid(n);

    }
}
class Figure {
    public static void deltoid (int n)
    {


        for (int i = 0; i < n; ++i ) {

            for (int k = 1; k < n - i; ++k)
                System.out.print (" ");
            for (int j = n - i; j <= n + i; ++j)
                System.out.print ("*");
            for (int l = n + i; l < 2 * n - 1; ++l)
                System.out.print (" ");
            System.out.println();

        }

        for (int i = 1; i < n; ++i) {
            for (int k = 0; k < i; ++k)
                System.out.print (" ");
            for (int j = i + 1 ; j < 2 * n - i; ++j)
                System.out.print ("*");
            for (int l = 2 * n - i; l <= 2 * n - 1; ++l)
                System.out.print (" ");
            System.out.println();
        }

    }
}


