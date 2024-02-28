package naveenPrograms;

public class StringSwapping9 {

	public static void main(String[] args) {

		String a="Bharath";
		String b="Krishna";
	System.out.println("before swapping: ");
	System.out.println("the value of a is "+a);
	System.out.println("the value of b is "+b);
	
 //1.append a and b:
	 a=a+b; //BharathKrishna

 //2. store initial String a in String b:	
	b=a.substring(0, a.length()-b.length());//Bharath

//3. Store initial string b in String a:
	a=a.substring(b.length());//Krishna
	
	System.out.println("After swapping: ");
	System.out.println("the value of a is "+a);
	System.out.println("the value of b is "+b);
	}

}
