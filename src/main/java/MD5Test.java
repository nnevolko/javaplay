package main.java;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class MD5Test {

	
	public void testMD5(){
		
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
