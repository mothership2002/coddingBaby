package edu.kh.SemiProject.common;

public class Util {

//	defend xss
	public static String XSSHandling(String content) {
		if(content != null) {
			content = content.replaceAll("&", "&amp;");
			content = content.replaceAll("<", "&lt;");
			content = content.replaceAll(">", "&gt;");
			content = content.replaceAll("\"", "&quot;");
		}
		return content;
	}
	
	public static String newLineHandlling(String content) {
//		reply.setReplyContent(reply.getReplyContent().replaceAll("(\n|\r|\r\n|\n\r)", "<br>"));
		return content.replaceAll("(\n|\r|\r\n|\n\r)", "<br>");
	}
}
