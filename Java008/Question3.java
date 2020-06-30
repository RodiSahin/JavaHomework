/*----------------------------------------------------------------------------------------------------------------------
    Klavyeden girilen bir yazının başındaki ve sonundaki boşlukları atarak yazıyı parantez içine alan programı yazınız.
    Programı bir tane String referansı kullanarak yazınız.
----------------------------------------------------------------------------------------------------------------------*/
package Homework.Java008;

public class Question3 {
    public static void main(String [] args)
    {
        StringUtilTestApp.run();
    }

}

class StringUtilTestApp {
    public static void run ()
    {
        java.util.Scanner kb = new java.util.Scanner(System.in);

        System.out.print ("Bir yazı giriniz : ");
        String s = kb.nextLine();

        int startIndex = StringUtil.startIndex(s);
        int endIndex = StringUtil.endIndex(s);

        System.out.printf ("{%s}%n", StringUtil.trim(s, startIndex, endIndex));
    }
}

class StringUtil {
    public static String trim (String s, int startIndex, int endIndex)
    {
        return s.substring(startIndex, endIndex);
    }

    public static int startIndex (String s) {
        int index;
        for (index = 0; index < s.length(); index++)
            if (!Character.isWhitespace(s.charAt(index)))
                break;
        return index;
    }

    public static int endIndex (String s)
    {
        int index;
        int len = s.length();
        for (index = len -1 ; index >= 0; index--)
            if (Character.isLetter(s.charAt(index)))
                break;
        return index;

    }
}

