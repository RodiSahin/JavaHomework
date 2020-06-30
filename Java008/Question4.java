/*----------------------------------------------------------------------------------------------------------------------
    Parametresi ile aldığı iki yazının birincisi içerisinden ikincisindeki karakterlerin silinmiş olduğu yeni bir
    String döndüren squeeze isimli metodu yazınız ve test ediniz
----------------------------------------------------------------------------------------------------------------------*/
package Homework.Java008;

import java.util.Scanner;

public class Question4 {
    public static void main(String [] args)
    {
        SqueezeTestApp.run();
    }
}

class SqueezeTestApp {

    public static void run () {
        Scanner kb = new Scanner(System.in);

        System.out.print ("İlk yazıyı giriniz : ");
        String s1 = kb.nextLine();

        System.out.print ("İkinci yazıyı giriniz : ");
        String s2 = kb.nextLine();

        System.out.println ("Sadeleştirilmiş yazı : ");
        System.out.println (SqueezeApp.squeeze(s1,s2));
    }
}

class SqueezeApp {

    public static String squeeze (String s1, String s2)
    {
        String result = "";
        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();
        int len1 = s1.length();
        int len2 = s2.length();
        for (int i = 0; i < len2; i++)
            if (s1.contains(Character.toString(s2.charAt(i))))
                for (int j = 0; j < len1; j++)
                {
                    s1 = s1.replace(String.valueOf(s2.charAt(i)),"");
                }
        return s1;
    }
}