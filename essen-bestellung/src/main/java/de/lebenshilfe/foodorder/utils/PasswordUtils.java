package de.lebenshilfe.foodorder.utils;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class PasswordUtils {
	
	public static String encodePassword(String password) {
		String saltPwd = BCrypt.gensalt(12);
		String hashPwd = BCrypt.hashpw(password, saltPwd);
		
		return hashPwd;
	}
	
	public static boolean validatePassword(String inputPwd, String hashPwd) {
		return BCrypt.checkpw(inputPwd, hashPwd);
	}
	
}