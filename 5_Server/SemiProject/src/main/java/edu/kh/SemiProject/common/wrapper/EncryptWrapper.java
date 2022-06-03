package edu.kh.SemiProject.common.wrapper;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class EncryptWrapper extends HttpServletRequestWrapper{

	public EncryptWrapper(HttpServletRequest request) {
		super(request);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getParameter(String name) {
		String value = null;
		switch(name) {
		case "inputPW" : 
		case "memberPW" :
		case "password" :
		case "updatePW" :
		case "memberPw"	:
			value = getSha512(super.getParameter(name));
			break;
		default : value = super.getParameter(name);
		}
		
		return value;
	}
	//암호화 메소드 (sha-h12 해시함수)
	private String getSha512(String pw) {
		String encryptPW = null;
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA-512");
			byte[] bytes = pw.getBytes(Charset.forName("UTF-8"));
			md.update(bytes);
			encryptPW = Base64.getEncoder().encodeToString(md.digest());
			
		} catch(NoSuchAlgorithmException nsae) {
			nsae.printStackTrace();
		}
		return encryptPW;
	}
}
