package stepDefinitions;

import org.apache.commons.lang3.RandomStringUtils;

public class Randomstring {

	public static void main(String[] args) {

		String RandomNames=randomString()+"@gmail.com";
		System.out.println(RandomNames);
		
	}

	public static String randomString() {
		String randommail = RandomStringUtils.randomAlphabetic(6);
		return randommail;
	}

}
