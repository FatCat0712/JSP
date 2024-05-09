package util;

import java.security.MessageDigest;

import org.apache.tomcat.util.codec.binary.Base64;

public class MaHoa {
	public static String encryptPass(String pass) {
		String salt = "sanphamcuatoi";
		String result = null;
		
		String plaintext = pass + salt;
		try {
			byte[] dataBytes = plaintext.getBytes("UTF-8");
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			result = Base64.encodeBase64String(md.digest(dataBytes));		
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
