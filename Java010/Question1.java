/*----------------------------------------------------------------------------------------------------------------------
    Homework 10 Question 1

    100 tane kapı var. Bu kapılar 1'den 100'e kadar numaralandırılmış. Başlangıçta kapıların hepsi kilitli. Elimizde
    1'den 20'ye kadar numaralandırılmış 20 tane anahtar var. Bir kapının numarası bir anahtarın numarasına tam
    bölünüyorsa o anahtar o kapıyı açabiliyor (ya da kilitleyebiliyor!). 1 numaralı anahtardan başlayarak her anahtar
    için kapıları dolaşıyoruz. Anahtar ile kapıyı açıyor ya da kilitliyoruz. (Yani kapı açıksa kilitliyor kapı kilitli
    ise kapıyı açıyoruz.) 20. turdan sonra (yani son anahtarı kullanmamızdan sonra) hangi kapılar açık hangi kapılar
    kilitlidir? Açık olan kapıların numaralarını ekrana yazdıran programı yazınız.

    Programınızın ekran çıktısı aşağıd aki gibi olmalı:
    1 4 9 16 21 22 23 24 26 27 28 29 30 31 32 33 34 35 37 38 39 40 41 43 45 47 51 53 55 57 59 61 64 65 66 67 71
    72 73 77 78 79 81 83 85 88 89 90 91 92 95 97
----------------------------------------------------------------------------------------------------------------------*/
package Homework.Java010;

public class Question1 {
    public static void main(String [] args)
    {
        LookDoorTestApp.run();
    }
}

class LookDoorTestApp {
    public static void run () {
        boolean [] door = new boolean[101];

        door = Util.door(door);

        for (int i = 1; i < door.length; i++)
            if (door[i])
                System.out.printf ("%d test", i);
    }
}

class Util {
    public static boolean [] door (boolean [] door) {

        for (int i = 1; i < door.length; i++)
            for (int j = 1; j < 21; j++)
                if (i % j == 0)
                    door[i] = !door[i];

        return  door;
    }
}