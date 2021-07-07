package view;

public class Utilities {
	
	public static final String DOCTYPE = "<!DOCTYPE html>";
	public static final String STARTBODY = "<body class=\"main-layout \">\n<html>\n";
	public static final String FIN = "</body>\n</html>";
	public static final String CLASSEND = "</div>";
	
	public static String head(String title,String styleSheetFileName, String bootstrapcss) {
		
		StringBuilder str = new StringBuilder();
		str.append("<head>\n");
		str.append("<meta charset=\"utf-8\">\n");
		str.append("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">");
		str.append("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
		str.append("<meta name=\"viewport\" content=\"initial-scale=1, maximum-scale=1\">\n");
		str.append("<title>");
		str.append(title);
		str.append("</title>\n");
		str.append("<link rel=\"stylesheet\" type=\"text/css\" href=");
		str.append(bootstrapcss);
		str.append(">\n");
		str.append("<link rel=\"stylesheet\" type=\"text/css\" href=");
		str.append(styleSheetFileName);
		str.append(">\n");
		str.append("</head>\n");
		return str.toString();
	}
	
	public static String header() {
		StringBuilder str = new StringBuilder();
		str.append("<div class=\"header\">\n");
		str.append("<div class=\"container\">\n");
		str.append("<div class=\"row\">\n");
		str.append("<div class=\"col-xl-3 col-lg-3 col-md-3 col-sm-12 col logo_section\">\n");
		str.append("<div class=\"full\">\n");
		str.append("<div class=\"center-desk\">\n");
		str.append("<div class=\"logo\">\n");
		str.append("<a href=\"validation.html\"><img src=\"images/logo.png\" alt=\"#\"></a>\n");
		str.append("</div></div></div></div></div></div></div>\n");
		return str.toString();
	}
	
	public static String classTitle(String title) {
		StringBuilder str = new StringBuilder();
		str.append("<div id=\"registration1\" class=\"about\">\n");
		str.append("<div class=\"container\">\n");
		str.append("<div class=\"row\">\n");
		str.append("<div class=\"col-md-12\">\n");
		str.append("<div class=\"title\">\n");
		str.append("<h2>");
		str.append(title);
		str.append("</h2>\n");
		str.append("</div></div></div></div>\n");
		return str.toString();
	}
	
	public static String columText(String title, String subtitle, String text) {
		StringBuilder str = new StringBuilder();
		str.append("<div class=\"container\">\n");
		str.append("<div class=\"row\">\n");
		str.append("<div class=\"col-md-12\">\n");
		str.append("<div class=\"about_box\">\n");
		str.append("<h3>");
		str.append(title);
		str.append("<br><strong class=\"black\">");
		str.append(subtitle);
		str.append("</strong></h3>\n");
		str.append("<p>");
		str.append(text);
		str.append("</p>\n");
		str.append("</div></div></div></div>\n");
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
	
	public static String copyright() {
		
		StringBuilder str = new StringBuilder();
		str.append("<div class=\"copyright\">\n");
		str.append("<div class=\"container\">\n");
		str.append("<p>© 2021 All Rights Reserved.\n");
		str.append(" Design template based on\n");
		str.append("<a href=\"https://www.free-css.com/free-css-templates/page264/moon\"> free-css.com</a></p>\n");
		str.append("</div></div>");
		
		return str.toString();
	}

}
