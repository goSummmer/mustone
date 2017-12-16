package cn.edu.common.encode;

import java.security.MessageDigest;

import org.apache.commons.codec.binary.Hex;

public class Md5PwdImpl implements Md5Pwd {

	/**
	 *  加密
	 * @param password
	 */
	public String encode(String password) {
		String algorithm = "MD5";
		//扩展加盐     在密码中加入一些特点字符串。
		//password="smkafnksbbcjakbsja";
		MessageDigest instance = null ;
		try{
			instance = MessageDigest.getInstance(algorithm);
		}catch (Exception e) {
			e.printStackTrace();
		}
		//MD5加密
		byte[] digest = instance.digest(password.getBytes());
		//16进制加密
		char[] encodeHex = Hex.encodeHex(digest);
		return new String(encodeHex);
	}
}
