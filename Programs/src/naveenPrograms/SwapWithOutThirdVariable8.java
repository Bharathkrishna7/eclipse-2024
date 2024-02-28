package naveenPrograms;

public class SwapWithOutThirdVariable8 {

	public static void main(String[] args) {

		int i = 4;
		int j = 3;

		// With using third variable

//		int t;
//		t=i;//4 	
//		i=j;//3
//		j=t;//4
//		
// System.out.println("After swapping i is "+i+" And j value is "+j);

		// 1.With out Using Third variable:By using + operator
		i = i + j;// 7
		j = i - j;// 4
		i = i - j;// 3

		// 2.with out using Third variable:By using * operator
		i = i * j;// 12
		j = i / j;// 4
		i = i / j;// 3

		System.out.println(i);
		System.out.println(j);

	}

}
