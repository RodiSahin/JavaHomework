/*----------------------------------------------------------------------------------------------------------------------
    Klavyeden girilen bir yazıyı ilk karakteri 1.satıra, ilk 2 karakteri 2.satıra, ilk 3 karakteri 3. satıra...
    olacak şekilde ekrana yazdıran programı yazınız.
    Programın örnek çalışması:
    Bir yazı giriniz: java
    j
    ja
    jav
    java
----------------------------------------------------------------------------------------------------------------------*/
package Homework.Java008;

public class Question2 {
    public static void main(String [] args)
    {
        StringAppTestApp.run();
    }
}

class StringAppTestApp {
    public static void run()
    {
        java.util.Scanner kb = new java.util.Scanner(System.in);

        System.out.print("Bir yazı giriniz : ");
        String s = kb.nextLine();
        for (int index = 1; index <= s.length(); index++)
        {
            System.out.println(StringApp.stepString(s,index));
        }
    }
}
class StringApp {
    public static String stepString (String s,int index)
    {
        return s.substring(0,index);
    }
}