package javaPrograms;

import java.util.HashMap;
import java.util.Map;

public class Occurrences1 {

	public static void main(String[] args) {
		getnamecount("krishna");
		String nam="i am bharath";
		
		int count=0;
		for(char cha:nam.toCharArray()) {
			if(cha=='b') {
				count++;
			}
		}
	System.out.println("count of b is "+count);
	}

	public static void getnamecount(String name) {
		
	Map<Character,Integer> map=new HashMap<Character,Integer >();
	
	char[] ch=name.toCharArray();
	for(char c:ch) {
		if(map.containsKey(c)) {
			map.put(c, map.get(c)+1);
		}
		else {
			map.put(c,1);
		}
	}
	System.out.println(name+":"+map);
	}
}
