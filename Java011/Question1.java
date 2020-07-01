/*----------------------------------------------------------------------------------------------------------------------
    Bir anakütle içerisinden çekilen rastgele örneklere ilişkin ortalamaların dağılımı normal olma eğilimindedir. Buna
    istatistikte merkezi limit teoremi (central limit theorem) denir. Örnekler ne kadar büyük olursa ve örneklem sayısı
    ne kadar fazlaysa örnek ortalamaları normal dağılıma o kadar yaklaşır. Ana kütle dağılımı ne olursa olsun durum
    böyledir.Merkezi limit teoremini sınayan aşağıdaki programı yazınız:

    - 0 ile 10000 arasındaki sayılar ana kütleyi temsil etsin.

    - Örnek kütle (sample) sayısını 5 olarak belirleyiniz

    -Her defasında 0 ile 10000 arasında 5 rastgele sayı üreterek (yani ana kütleden 5’lik rastgele örnek çekerek)
    ortalamalarını hesaplayınız. Bu işlem belirli sayıda yapılacaktır. (Örneğin 5000 kez)

    - 10 elemanlı bir dizi açarak sıfırlayınız. Dizinin her elemanı [0-1000],(1000-2000],(2000-3000], ...(9000,10000]
    biçiminde aralık belirtiyor olsun. Alınan örnek ortalaması hangi aralıktaysa dizinin o elemanını bir artırınız.

    - Bu işlemler sonucunda sıklık sayılarına ilişkin bir dizi elde edeceksiniz. Bunun histogramını çizerek normal
    dağılımı izleyiniz. Histogram her satıra dizideki eleman sayısıyla orantılı olacak X karakterleriyle çizilecektir.
    Örneğin:

    XX
    XXXXX
    XXXXXXXX
    XXXXXXXXXXX
    XXXXXXXXXXXXXXX
    XXXXXXX
    XX
    XXX
    XXX
    XX
    X
    Örneğin sıklık sayılarının 0 ile 1000 arasında değiştiğini varsayalım. Bu durumda her X 50 tane sıklık sayısı
    belirtiyor olabilir. Toplam olarak kaç örnek alacağınıza ve bir X karakterinin kaç sıklık sayısına karşı geleceğini
    siz belirleyiniz.
----------------------------------------------------------------------------------------------------------------------*/
package Java011;

import java.util.Random;
import java.util.Scanner;

public class Question1 {
    public static void main(String [] args)
    {
        CentralLimitTeoremTestApp.run();
    }
}

class CentralLimitTeoremTestApp {

    public static void run ()
    {
        Scanner kb = new Scanner(System.in);

        System.out.print("Lütfen örnek sayısını giriniz : ");
        int a = Integer.parseInt(kb.nextLine());

        System.out.print("Lütfen gösterim sıklığını giriniz : ");
        int x = Integer.parseInt(kb.nextLine());

        CentralLimitTeorem c = new CentralLimitTeorem();
        for (int i = 0; i < 5000; i++)
        {
            int d [] = c.sample(a);
            c.histogram(d);
        }

        c.toString(c.histogram,x);

    }
}
class CentralLimitTeorem {
    public int [] histogram = new int [10];

    public int [] sample (int a)
    {
        Random r = new Random();

        int [] d =  getRandomArray(r,a,0,10000);

        return d;
    }
    public  int [] histogram (int [] d)
    {
        ++histogram[density(d) / 1000];
        return histogram;
    }

    public static int density (int [] d)
    {
        int sum = 0;
        for (int i = 0; i < d.length; i++)
        {
            sum += d[i];
        }
        return sum/d.length;
    }

    public static int[] getRandomArray(Random r,int a, int min, int max)
    {
        int [] d = new int [a];
        for (int i = 0; i < d.length; ++i)
            d[i] = r.nextInt(max - min) + min;

        return d;
    }

    public void toString (int [] histogram,int x)
    {
        for ( int i : histogram) {
            for (int j = 0; j < i / x; j++)
                System.out.print("X");
            System.out.println();
        }
    }

}

