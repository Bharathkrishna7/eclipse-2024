package javaPrograms;

import java.util.HashMap;
import java.util.Map;

public class Occurrence {

	public static void main(String[] args) {
	
   getchar("bharath");
	}
	
	public static void getchar(String name) {
	Map<Character, Integer> cha=new HashMap<Character, Integer>();
		char[] ch=name.toCharArray();
		for(char c:ch) {
			if(cha.containsKey(c)) {
				cha.put(c, cha.get(c)+1);
			}
			else {
				cha.put(c, 1);
			}
		}
	System.out.println(name+":"+cha);
	}
	

}
