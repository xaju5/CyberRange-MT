package view;

public class Utilities {
	
	public static final String DOCTYPE = "<!DOCTYPE html>";
	public static final String FIN = "</body>\n</html>";
	
	public static String headConTitleStyle(String tit,String styleSheetFileName) {
		
		StringBuilder str = new StringBuilder();
		str.append("<html>\n");
		str.append("<head>\n");
		str.append("<meta charset=\"utf-8\">\n");
		str.append("<title>");
		str.append(tit);
		str.append("</title>\n");
		str.append("<link rel=\"stylesheet\" type=\"text/css\" href=");
		str.append(styleSheetFileName);
		str.append(">\n");
		str.append("</head>\n");
		return str.toString();
	}
	
	public static String botonUrl(String url,String texto){
		
		StringBuilder str = new StringBuilder();
		str.append("<form method=");
		str.append("\"get\"");
		str.append(" action=");
		str.append(url);
		str.append(">\n");
		str.append("<button type=");
		str.append("\"submit\"");
		str.append(">");
		str.append(texto);
		str.append("</button>\n</form>");
		
		return str.toString();
		
	}

}
