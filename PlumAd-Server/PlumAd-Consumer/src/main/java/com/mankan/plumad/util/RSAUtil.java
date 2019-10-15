package com.mankan.plumad.util;


import com.mankan.plumad.dto.EncryptionResult;
import com.mipay.base.util.CommonUtil;

import java.util.Base64;


public class RSAUtil {
	/**
	 * 	解密
	 */
	public static String getdecode(String encrtptKey, String encryptData, String signData, String privatekey) {
		byte[] decodeBase64KeyBytes;
		try {
			encrtptKey=encrtptKey.replaceAll(" ", "+");
			encryptData=encryptData.replaceAll(" ", "+");
			decodeBase64KeyBytes = Base64.getDecoder().decode(encrtptKey.getBytes("UTF-8"));
			/*对加密的AES进行解密*/
			byte[] merchantAESKeyBytes = KeyUtil.jdkRSA_(decodeBase64KeyBytes,privatekey);
			/*用解密后的AES密钥解密银行响应报文*/
			String resEncryptData = encryptData;

			byte[] decodeBase64DataBytes = Base64.getDecoder().decode(resEncryptData.getBytes("UTF-8"));
			byte[] merchantXmlDataBytes = KeyUtil.jdkAES_(decodeBase64DataBytes, merchantAESKeyBytes);
			/*验签*/

			/*转换为String类型*/
			String resjson = new String(merchantXmlDataBytes,"utf-8");
			return resjson;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * 加密
	 * @param publicKey 公钥
	 * @param date 内容
	 * @param privates 私钥
	 * @return
	 */
	public static EncryptionResult getencryption(String publicKey, String date, String privates) {

		byte[] plainBytes;
		EncryptionResult encryption = new EncryptionResult();
		try {
			plainBytes = date.getBytes("utf-8");
			//生成AES秘钥
			byte[] keyBytes = CommonUtil.generateLenString(16).getBytes("utf-8");
			System.out.println(keyBytes.length);
			/*AES密钥加密请求报文*/
			String encryptData = Base64.getEncoder().encodeToString(KeyUtil.jdkAES(plainBytes, keyBytes));
			/*RSA公钥加密AES密钥*/
			String encrtptKey = Base64.getEncoder().encodeToString(KeyUtil.jdkRSA(keyBytes,publicKey));
			/*RSA密钥签名请求报文*/
			String signData = Base64.getEncoder().encodeToString(KeyUtil.rsaSign(plainBytes, privates));
			encryption.setDescData(RSAReturnCode.SUCCESS);
			encryption.setEncryptData(encryptData);
			encryption.setEncrtptKey(encrtptKey);
			encryption.setSignData(signData);
			return encryption;
		}
		catch (Exception e) {
			e.printStackTrace();
			encryption.setDescData(RSAReturnCode.ENCRYPTIONFAILURE);
			return encryption;
		}
	}
}
