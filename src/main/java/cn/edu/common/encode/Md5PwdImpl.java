package cn.edu.common.encode;

import java.security.MessageDigest;

import org.apache.commons.codec.binary.Hex;

public class Md5PwdImpl implements Md5Pwd {

	/**
	 *  ����
	 * @param password
	 */
	public String encode(String password) {
		String algorithm = "MD5";
		//��չ����     �������м���һЩ�ص��ַ�����
		//password="smkafnksbbcjakbsja";
		MessageDigest instance = null ;
		try{
			instance = MessageDigest.getInstance(algorithm);
		}catch (Exception e) {
			e.printStackTrace();
		}
		//MD5����
		byte[] digest = instance.digest(password.getBytes());
		//16���Ƽ���
		char[] encodeHex = Hex.encodeHex(digest);
		return new String(encodeHex);
	}
}
