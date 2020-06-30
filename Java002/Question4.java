/*----------------------------------------------------------------------------------------------------------------------
    Klavyeden bir height ve width değişkenleri için sayılar okuyunuz ve aşağıda ki deseni oluşturunuz:
|*       |
| *      |
|  *     |
|   *    |
|    *   |
|      * |
|       *|
|      * |
|     *  |
|    *   |
|   *    |
| *      |
|*       |
| *      |
|  *     |
----------------------------------------------------------------------------------------------------------------------*/

package Homework.Java002;

public class Question4 {
    public static void main (String [] args)
    {
        GetFigureZTestApp.run();
    }
}

class GetFigureZTestApp {

    public static void run ()
    {
        java.util.Scanner kb = new java.util.Scanner(System.in);

        System.out.print("Height = ");
        int h = Integer.parseInt(kb.nextLine());

        System.out.print ("Width = ");

        int w = Integer.parseInt(kb.nextLine());

        FigureZ.zigZag(h, w);

    }
}
class FigureZ {
    public static void zigZag (int h, int w)
    {
        for (int i = 0; i < h; ++i) {
            for (int k = 0; k < w ; ++k)
            {
                System.out.print ("|");

                for (int j = 0; j < k; ++j)
                    System.out.print(" ");
                System.out.print("*");
                for (int l = k + 1 ; l < w ; ++l)
                    System.out.print(" ");
                System.out.println("|");
                ++i;
            }

            for (int k = 2; k < w ; ++k)
            {
                System.out.print("|");
                for (int j = w - k; j > 0; --j)
                    System.out.print(" ");
                System.out.print("*");
                for (int l = w +1- k; l < w; ++l)
                    System.out.print(" ");
                System.out.println("|");
                ++i;
            }
        }
    }
}

