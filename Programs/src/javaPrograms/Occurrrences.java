package javaPrograms;

import java.util.HashMap;
import java.util.Map;

public class Occurrrences {

	public static void main(String[] args) {
		String str = "i am bharath";

		int count = 0;
		for (char ch : str.toCharArray()) {
			if (ch == 'a') {
				count++;
			}
		}
		System.out.println(count+" count of a");
		getcharcount(str, 'r');
   getcount("infinite");
	}
	
	//occurence using method
	public static void getcharcount(String str , char val ) {
		int count=0;
		for(char ch:str.toCharArray()) {
			if(ch==val) {
				count++;
			}
			
		}
		System.out.println(val +":"+count);
	
	}
// simple way 
	public static void getcount(String name) {
		
		Map<Character, Integer>map=new HashMap<Character, Integer>();
		
		char[] cha=name.toCharArray(); //it will convert string into charArray
		
		for(char c:cha) {
			if(map.containsKey(c)) {
			map.put(c, map.get(c)+1);
		  }
			else {
				map.put(c, 1);
			}
		}
		System.out.println(map);
	}
	
	
	
	
	
	
}
