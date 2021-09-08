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
		str.append("</div></div></div></div></div>\n");
		return str.toString();
	}
	
public static String headButtons(int numValues, String [] values, String [] href) {
		
		StringBuilder str = new StringBuilder();
		str.append("<div class=\"row\">\n");
		str.append("<div class=\"col-md-12 location_icon_bottum\">\n");
		str.append("<div class=\"row\">\n");
		str.append("<div class=\"col-md-8 \">\n");
		str.append("<div class=\"menu-area\">\n");
		str.append("<div class=\"limit-box\">\n");
		str.append("<nav class=\"main-menu\">\n");
		str.append("<ul class=\"menu-area-main\">\n");
		
		for(int i = 0; i < numValues; i++) {
			str.append("<li><a href=");
			str.append(href[i]);
			str.append(">");
			str.append(values[i]);
			str.append("</a></li>\n");
		}
		str.append("</ul></nav>\n");
		str.append("<div class=\"row\"></div></div></div></div></div></div></div></div></div>\n");
		
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
		//str.append("<div class=\"about\">\n");
		str.append("<div class=\"container\">\n");
		str.append("<div class=\"row\">\n");
		str.append("<div class=\"col-xl-5 col-lg-5 col-md-5 co-sm-l2\">\n");
		str.append("<div class=\"about_box\">\n");
		str.append("<h2>");
		str.append(title);
		str.append("<br><strong class=\"black\">");
		str.append(subtitle + text);
		str.append("</strong></h2>\n");
		str.append("</div></div></div></div>\n");
		return str.toString();	
	}
	
	public static String table(String[][] arraytext,int csvArrayLenght,int csvLineLength) {
		
		StringBuilder str = new StringBuilder();
		str.append("<div class= table>");
		str.append("<div class=\"container\">\n");
		str.append("<div class=\"row\">\n");
		str.append("<div class=\"col-md-12\">\n");
		str.append("<table>\n");
		str.append("<tr>\n");
		str.append("<th>Name</th><th>Total Score</th><th>Exercise 1</th><th>Exercise 2</th><th>Exercise 3</th><th>Exercise 4</th>\n");
		str.append("</tr>\n");

		for(int i=0; i<csvArrayLenght;i++){
			str.append("<tr>\n");
			
			for(int j = 0; j < csvLineLength; j++) {
				str.append("<td>");
				str.append(arraytext[i][j]);
				str.append("</td>\n");
			}
			str.append("</tr>\n");
		}
		str.append("</table>");
		str.append("</div></div></div></div>");
		
		return str.toString();
	}
	
	public static String Urlbutton(String url,String texto){
		
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
		str.append("</button>\n</form>\n");
		
		return str.toString();
		
	}
	
	public static String footer(int numValues, String [] values, String [] href) {
		
		String text = "This website has been developed for a Master's Thesis at the University of the Basque Country EHU/UPV.";
		String text2 = "If you need help contact the developer in the following email";
		
		StringBuilder str = new StringBuilder();
		str.append("<footer>\n");
		str.append(" <div class=\"footer top_layer \">\n");
		str.append("<div class=\"container\">\n");
		str.append("<div class=\"row\">\n");
		str.append("<div class=\"col-xl-3 col-lg-3 col-md-6 col-sm-12\">\n");
		
		str.append("<div class=\"address\">\n");
		str.append("<a href=\"validation.html\"> <img src=\"images/logo.png\" alt=\"logo\" /></a>\n");
		str.append("<p>" + text + "</p>\n");
		str.append("</div></div>\n");
		
		str.append(" <div class=\"col-xl-3 col-lg-3 col-md-6 col-sm-12\">\n");
		str.append("<div class=\"address\">\n");
		str.append("<h3>Quick links</h3>\n");
		str.append("<ul class=\"Links_footer\">\n");
		for(int i = 0; i < numValues; i++) {
			str.append("<li><img src=\"icon/3.png\" alt=\"#\" /> <a href=");
			str.append(href[i]);
			str.append(">");
			str.append(values[i]);
			str.append("</a></li>\n");
		}
		str.append("</ul></div></div>\n");
		
		str.append("<div class=\"col-xl-3 col-lg-3 col-md-6 col-sm-12\">\n");
		str.append("<div class=\"address\">\n");
		str.append("<h3>Contact email</h3>\n");
		str.append("<p>" + text2 + "</p>\n");
		str.append("</div></div>\n");
		
		str.append("<div class=\"col-xl-3 col-lg-3 col-md-6 col-sm-12\">\n");
		str.append("<div class=\"address\">\n");
		str.append("<h3>Developer info</h3>\n");
		str.append("<ul class=\"loca\">\n");
		str.append("<li>\n");
		str.append("<a href=\"#\"><img src=\"icon/email.png\" alt=\"#\" /></a>user@mail.org\n");
		str.append("</li></ul></div></div></div></div></div>\n");
		
		str.append(copyright());
		str.append("</footer>\n");
		return str.toString();
	}
	
	public static String copyright() {
		
		StringBuilder str = new StringBuilder();
		str.append("<div class=\"copyright\">\n");
		str.append("<div class=\"container\">\n");
		str.append("<p>© 2021 All Rights Reserved.\n");
		str.append(" Design template based on\n");
		str.append("<a href=\"https://www.free-css.com/free-css-templates/page264/moon\"> free-css.com</a></p>\n");
		str.append("</div></div>\n");
		
		return str.toString();
	}
	
	

}
