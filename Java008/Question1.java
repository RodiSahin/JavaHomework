/*----------------------------------------------------------------------------------------------------------------------
    Klavyeden bir yazı giriniz. Yazı içerisinde iç içe küme parantezleri bulunuyor olsun. En içteki küme parantezinin
    içerisindeki yazıyı yazdırınız.
    Örneğin:
        Yazı: Bu örnek {aslında {hiç zor}}değil
        Sonuç: hiç zor
        Yazı: Bu örnekten {daha {zor {örnekler de yapacağız}değil}}mi?
        Sonuç: örnekler de yapacağız
        Yazı:Yanlış{ bir giriş için hata mesajı yazdırılacak
        Sonuç: yanlış bir giriş
----------------------------------------------------------------------------------------------------------------------*/
package Homework.Java008;

public class Question1 {
    public static void main(String [] args)
    {
        Util.searchStringTest();
    }
}

class Util {
    public static void searchStringTest ()
    {
        java.util.Scanner kb = new java.util.Scanner(System.in);

        System.out.print("Bir yazı giriniz : ");
        String s = kb.nextLine();

        System.out.println(searchString(s));
    }

    public static String searchString (String s)
    {
        int startIndex = s.lastIndexOf('{');
        int endIndex = s.indexOf('}');

        if (startIndex == -1 || endIndex == -1)
            return "yanlış bir giriş";
        if (endIndex <= startIndex)
            return "yanlış bir giriş";
        return s.substring(startIndex + 1,endIndex );
    }
}