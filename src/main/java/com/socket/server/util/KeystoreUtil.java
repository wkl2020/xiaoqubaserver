package com.socket.server.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.PrivateKey;
import java.security.PublicKey;

import javax.xml.crypto.MarshalException;
import javax.xml.crypto.dsig.DigestMethod;
import javax.xml.crypto.dsig.XMLSignature;
import javax.xml.crypto.dsig.XMLSignatureException;
import javax.xml.crypto.dsig.XMLSignatureFactory;
import javax.xml.crypto.dsig.dom.DOMValidateContext;
import javax.xml.crypto.dsig.spec.TransformParameterSpec;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.commons.codec.binary.Base64;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.security.InvalidAlgorithmParameterException;
import java.security.KeyException;
import java.security.KeyStore;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;

import javax.xml.crypto.dsig.CanonicalizationMethod;
import javax.xml.crypto.dsig.Reference;
import javax.xml.crypto.dsig.SignatureMethod;
import javax.xml.crypto.dsig.SignedInfo;
import javax.xml.crypto.dsig.Transform;
import javax.xml.crypto.dsig.dom.DOMSignContext;
import javax.xml.crypto.dsig.keyinfo.KeyInfo;
import javax.xml.crypto.dsig.keyinfo.KeyInfoFactory;
import javax.xml.crypto.dsig.keyinfo.KeyValue;
import javax.xml.crypto.dsig.spec.C14NMethodParameterSpec;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class KeystoreUtil {
	
	public static String publicKeyString = "LS0tLS1CRUdJTiBDRVJUSUZJQ0FURS0tLS0tDQpNSUlEYVRDQ0FsR2dBd0lCQWdJRUJTbkVRREFO\r\n" +
			"QmdrcWhraUc5dzBCQVFzRkFEQmtNUXN3Q1FZRFZRUUdFd0pqYmpFUk1BOEdBMVVFDQpDQk1JYzJo\r\n" +
			"aGJtZG9ZV2t4RGpBTUJnTlZCQWNUQlhoMWFIVnBNUTR3REFZRFZRUUtFd1Z6WVdsamJ6RU5NQXNH\r\n" +
			"QTFVRUN4TUVjMk5wDQpjekVUTUJFR0ExVUVBeE1LYTJGcGJHOXVaeTUzZFRBZ0Z3MHhOREF6TVRF\r\n" +
			"d09ERTRORE5hR0E4eU1EWTRNVEl4TWpBNE1UZzBNMW93DQpaREVMTUFrR0ExVUVCaE1DWTI0eEVU\r\n" +
			"QVBCZ05WQkFnVENITm9ZVzVuYUdGcE1RNHdEQVlEVlFRSEV3VjRkV2gxYVRFT01Bd0dBMVVFDQpD\r\n" +
			"aE1GYzJGcFkyOHhEVEFMQmdOVkJBc1RCSE5qYVhNeEV6QVJCZ05WQkFNVENtdGhhV3h2Ym1jdWQz\r\n" +
			"VXdnZ0VpTUEwR0NTcUdTSWIzDQpEUUVCQVFVQUE0SUJEd0F3Z2dFS0FvSUJBUUMzNlJpVkdKazlF\r\n" +
			"Z0JsQzlpRHE3MGxxUnVQN1ExdHM2RXduQjdNOS96Qk9uT1lzWFBxDQo5SkxzVUg5WUZSSGczMFFz\r\n" +
			"S01FM00xWDNIcGxXQ2NNQjNzMll4SmNSWUpXZ1IwSXBpZEsvVkRLUmZMcWdvZmNrbVFLRHU5MlFI\r\n" +
			"dUxXDQoxYlYyODVxNUtPb0NnYi8zZGRWenVZbkFWeWZhTTBSdWI1aURBRlFhbFYvZnh5RzdQdmZn\r\n" +
			"cmc5L29Fd0RVVnJoYzNqLzdYY1REQTk0DQpJeWZUUVJmSzJzcm5wUUVlWXJYb3piOXhXdFRVbU1n\r\n" +
			"Q0IwL05pMXBXKzNqdjJNdGZySld5aDVES2xZNGJ4am9xa2hMSVg0YTBrdnVlDQpwdU92R0ZMQS92\r\n" +
			"S1ppOGdvRjFLN0VNekZQR1B3b2M5Q3RpUkVyWUJQdE5rMi9xbGZ2NzU0YjU2NW10Q3FSbVlIQWdN\r\n" +
			"QkFBR2pJVEFmDQpNQjBHQTFVZERnUVdCQlRTYlBSS1gvTnd2OXNNa2VoS2Z2SGptaGtCd0RBTkJn\r\n" +
			"a3Foa2lHOXcwQkFRc0ZBQU9DQVFFQUlpbWVQRkFwDQpBOUFZbnVxZnNZK0NLcjJRWGRrL0lrUHIz\r\n" +
			"YlU5MG1MVFVXVnpDTmF3VDNkZks0Y1loZndxU3ZySFlwN05DRFdWZHJRdThwQldac1BLDQoySkRs\r\n" +
			"K3cwVHhjNzQ4elZORWZ3QWRWbmErZjU3TnRkT1NUR3BKYUZiWUdrZTRaYkx6NmNpWTd2SGRQVG5G\r\n" +
			"MGN4N3ZISExlQ3Bxek51DQpnTTNpNmxTLytNSmdPbE1iTGlvQkNHTnAvL1pYSjBoa1lPb0ptM1JT\r\n" +
			"OERZYzlJUEpHL0l2dDdtMm1qOEIzeTRTaElrUXJNZkFJbXFrDQpybmcxK05VQjk4bFozRnhyenRp\r\n" +
			"SUxDSXluQkFERDh2Q3cvSmRHcFFYOUZKTnQ3eGdLRnB2NjV1bmlzbmk3aVllUkJHU3JDcGNoMjJp\r\n" +
			"DQpWL1NkMTJsUEo2UG81MVB4aGwwRGM3RHNiUC8ySmc9PQ0KLS0tLS1FTkQgQ0VSVElGSUNBVEUt\r\n" +
			"LS0tLQ0K";
	
	public static PublicKey publicKey = null;
	public static PrivateKey privateKey = null;
    
	public static String Keystore_File_Path = "keystore/engine001.keystore";
	
	static {
		try {
				File f = new File("/");
				System.out.println("CurrentPath1: " + f.getAbsolutePath());
				System.out.println("CurrentPath2: " + new File(".").getAbsolutePath());
	          //读取keystore文件到KeyStore对象
	           FileInputStream in = new FileInputStream(Keystore_File_Path);
	           KeyStore ks = KeyStore.getInstance("JKS");// JKS: Java KeyStoreJKS，可以有多种类型
	           ks.load(in,"123456".toCharArray());
	           in.close();

	           //从keystore中读取证书和私钥
	           String alias= "engine001.keystore";  // 记录的别名
	           String pswd= "111111";   // 记录的访问密码

	           java.security.cert.Certificate cert = ks.getCertificate(alias);
	           publicKey = cert.getPublicKey();
	           privateKey = (PrivateKey) ks.getKey(alias, pswd.toCharArray());
	           
	           System.out.println("Init public and private key success");

	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	            e.printStackTrace();
	        }
	}
	
	
	public static String generateSecureCommandStr(String commandStr) {
		String secureCommandStr = "";
        try {
            
            XMLSignatureFactory xmlSigFactory = XMLSignatureFactory.getInstance("DOM");
            Reference ref = null;
            SignedInfo signedInfo = null;
            try {
                ref = xmlSigFactory.newReference("", xmlSigFactory.newDigestMethod(DigestMethod.SHA1, null),
                        Collections.singletonList(xmlSigFactory.newTransform(Transform.ENVELOPED, (TransformParameterSpec) null)
                        ), null, null);

                signedInfo = xmlSigFactory.newSignedInfo(
                        xmlSigFactory.newCanonicalizationMethod(CanonicalizationMethod.INCLUSIVE, (C14NMethodParameterSpec) null),
                        xmlSigFactory.newSignatureMethod(SignatureMethod.RSA_SHA1, null), Collections.singletonList(ref));

            } catch (NoSuchAlgorithmException ex) {
                ex.printStackTrace();
            } catch (InvalidAlgorithmParameterException ex) {
                ex.printStackTrace();
            }

            // Pass the Public Key File Path
            KeyValue keyValue = null;
            KeyInfoFactory keyInfoFact = xmlSigFactory.getKeyInfoFactory();
            try {
                keyValue = keyInfoFact.newKeyValue(publicKey);
            } catch (KeyException ex) {
                ex.printStackTrace();
            }
            KeyInfo keyInfo = keyInfoFact.newKeyInfo(Collections.singletonList(keyValue));

            StringBuffer xmlContent = new StringBuffer()
            	.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n")
            	.append("<Body type=\"Command String\" version=\"1.0\">\r\n")
            	.append("<command>")
            	.append(commandStr)
            	.append("</command>\r\n")
            	.append("</Body>\r\n");
            System.out.println("Before signture xmlContent: " + xmlContent.toString());

            // Get the XML Document object
            Document doc = getXmlDocument(xmlContent.toString());            
            try {
                // Sign the document
                DOMSignContext domSignCtx = new DOMSignContext(privateKey, doc.getDocumentElement());
                XMLSignature xmlSignature = xmlSigFactory.newXMLSignature(signedInfo, keyInfo);
                xmlSignature.sign(domSignCtx);
            } catch (MarshalException ex) {
                ex.printStackTrace();
            } catch (XMLSignatureException ex) {
                ex.printStackTrace();
            }

            // Store the digitally signed document inta a location
            TransformerFactory transFactory = TransformerFactory.newInstance();
            Transformer trans = null;
            try {
                trans = transFactory.newTransformer();
            } catch (TransformerConfigurationException ex) {
                ex.printStackTrace();
            }
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            try {            	
                StreamResult streamRes = new StreamResult(baos);
                trans.transform(new DOMSource(doc), streamRes);
            } catch (TransformerException ex) {
                ex.printStackTrace();
            }
            byte[] data = baos.toByteArray();
            secureCommandStr = new Base64().encodeToString(data);
            baos.close();
            System.out.println("Signture success: " + secureCommandStr);
            
        } catch (Exception e) {
        	System.out.println(e.getMessage());
        	e.printStackTrace();
        }
        
        return secureCommandStr;
	}
	
    public static Document getXmlDocument(String commandStr) {
        Document doc = null;
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setNamespaceAware(true);
        try {
            InputStream licenseStrIS = new ByteArrayInputStream(new Base64().decode(commandStr.getBytes()));
            doc = dbf.newDocumentBuilder().parse(licenseStrIS);
            licenseStrIS.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return doc;
    }
	
    
    
    
    
    public static Node getSignatureNodeFromEncodeFileContent(String licenseFileContent) throws Exception {

        Document signedDoc = getXmlDocument(licenseFileContent);
        NodeList signatureNode = signedDoc.getElementsByTagNameNS(XMLSignature.XMLNS, "Signature");
        if (signatureNode.getLength() == 0) {
            throw new Exception("No XML Digital Signature Found, document is discarded");
        }

        return signatureNode.item(0);
    }

    public static boolean isSignatureValid(PublicKey publicKey, Node signatureNode) throws MarshalException, XMLSignatureException {

        DOMValidateContext valContext = new DOMValidateContext(publicKey, signatureNode);
        XMLSignatureFactory factory = XMLSignatureFactory.getInstance("DOM");
        XMLSignature signature = factory.unmarshalXMLSignature(valContext);
        return signature.validate(valContext);
    }

    public static String getNodeTextContent(NodeList nodelist) {
        String textContent = "";
        if (nodelist != null && nodelist.item(0) != null) {
            textContent = nodelist.item(0).getTextContent();
        }
        return textContent.trim();
    }

    public static String getNodeContentByTagName(Document signedDoc, String tagName) {
        NodeList nodelist = signedDoc.getElementsByTagName(tagName);
        return getNodeTextContent(nodelist);
    }
}
