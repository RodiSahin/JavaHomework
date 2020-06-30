/*----------------------------------------------------------------------------------------------------------------------

    Parametresi ile aldığı yazının içindeki küçük harfleri büyük harfe, büyük harfleri ise küçük harfe çevirip yeni bir
    String ile geri dönen changeCase isimli metodu yazınız.
----------------------------------------------------------------------------------------------------------------------*/

package Homework.Java008;

import java.util.Scanner;

public class Question5 {
    public static void main(String [] args)
    {
        ChangeCaseTestApp.run();
    }
}

class ChangeCaseTestApp {

    public static void run () {
        Scanner kb = new Scanner(System.in);

        System.out.print ("Bir yazıyı giriniz : ");
        String s = kb.nextLine();

        System.out.print ("Yeni yazı : ");
        System.out.println (ChangeCaseApp.changeCase(s));
    }
}

class ChangeCaseApp {

    public static String changeCase (String s)
    {
        for (int i = 0; i < s.length(); i++)
        {
            if (Character.isUpperCase(s.charAt(i)))
                s = s.replace(s.charAt(i),Character.toLowerCase(s.charAt(i)));
            else if (Character.isLowerCase(s.charAt(i)))
                s = s.replace((s.charAt(i)), Character.toUpperCase(s.charAt(i)));
        }
        return s;
    }
}