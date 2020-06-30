/*----------------------------------------------------------------------------------------------------------------------
	x ve y pozitif tamsayılar olmak üzere eğer x sayısının kendisi hariç bölenleri toplamı y sayısına ve aynı
zamanda y sayısının kendisi hariç bölenleri toplamı x sayısına eşit ise bu sayılar arkadaştır denir. Örneğin 220
ve 284 sayıları arkadaş sayılardır. Parametre olarak aldığı iki tamsayının arkadaş olup olmadıklarını test eden
areFriends metodunu yazınız. Metodunuzu dört basamaklı bir arkadaş sayı çifti bulan bir kodla test edebilirsiniz.
-----------------------------------------------------------------------------------------------------------------------*/

package Homework.Java005;

public class Question3 {
    public static void main (String [] args)
    {
        FriendsNumberTestApp.run();
    }
}


class FriendsNumberTestApp {

    public static void run ()
    {
        java.util.Scanner kb = new java.util.Scanner(System.in);

		/*System.out.print ("X : ");
		int x = Integer.parseInt(kb.nextLine());
		System.out.print("Y : ");
		int y = Integer.parseInt(kb.nextLine());
		System.out.printf("SumFactorsX : %d  SumFactorsY : %d%n", NumberUtil.sumFactors(x),NumberUtil.sumFactors(y));
		if (NumberUtil.areFriends(x, y))
			System.out.printf("%d ve %d arkadaş sayılardır", x, y);
		*/
        for (int x = 1000; x <= 9999; ++x)
            for (int y = x; y <= 9999; ++y)
                if (FriendsNumber.areFriends(x, y) && x != y)
                    System.out.printf("%d ve %d arkadaş sayılardır %n", x, y);
    }

}
class FriendsNumber {
    public static boolean areFriends (int x, int y)
    {
        return sumFactors(x) == y && sumFactors(y) == x;
    }
    public static int sumFactors (int val)
    {
        int sum = 1;
        for(int i = 2; i < val; ++i)
            if (val % i == 0)
                sum += i;
        return sum;
    }


}