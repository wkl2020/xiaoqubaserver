package com.socket.server.util;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;

public class Test0001 {

	public static void main(String[] args) {
		
//		
		KeystoreUtil.generateSecureCommandStr("aaaa");
//		System.out.println("aaaaaa: " + KeystoreUtil.generateSecureCommandStr("aaaa"));
//		
//		
//		
//		
//		InputStream licenseStrIS = new ByteArrayInputStream(new Base64().decode(fileContent));
//		try {	
//		
//			
//           //读取keystore文件到KeyStore对象
//           FileInputStream in = new FileInputStream(patha);
//           KeyStore ks = KeyStore.getInstance("JKS");// JKS: Java KeyStoreJKS，可以有多种类型
//           ks.load(in,"whitedove".toCharArray());
//           in.close();
//
//           //从keystore中读取证书和私钥
//           String alias= "secure.keystore";  // 记录的别名
//           String pswd= "whitedove";   // 记录的访问密码
//
//           java.security.cert.Certificate cert = ks.getCertificate(alias);
//           PublicKey publicKey = cert.getPublicKey();
//           PrivateKey privateKey = (PrivateKey) ks.getKey(alias, pswd.toCharArray());
//           
//           System.out.println("Init public and private key success");
//
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//            e.printStackTrace();
//        }
		
//		
//		String path = "D:/littleworks/jun0606ws/License.xml";
//		
//		try {
//		
//		
//			FileInputStream liscenseFileIS = new FileInputStream(path);
//	        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//	        byte[] lisenceBufBytes = new byte[1024];
//	        int length = 0;
//	        while((length = liscenseFileIS.read(lisenceBufBytes)) != -1) {
//	            outputStream.write(lisenceBufBytes, 0, length);
//	        }
//	        byte[] licenseBufData = outputStream.toByteArray();
//	        String licenseFileContent = new String(licenseBufData);
//	        liscenseFileIS.close();
//	        outputStream.close();
//	        
//	        System.out.println(licenseFileContent);
//        
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		
//		String keystoreContent = "";
//		String crerContent = "";
		
		
		
		
	}

}
