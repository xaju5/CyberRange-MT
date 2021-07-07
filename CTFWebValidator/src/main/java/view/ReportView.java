package view;

import java.io.PrintWriter;

public class ReportView implements View {

	public void print(PrintWriter pw, String[][] arraytext,int csvArrayLenght) {

		pw.println(Utilities.DOCTYPE);
		pw.println(Utilities.STARTBODY);
		pw.println(Utilities.head("Report","css/style.css","css/bootstrap.min.css"));
		pw.println(Utilities.header());
		pw.println(Utilities.classTitle("Users Report"));
		
		pw.println("<div class= table>");
		pw.println("<div class=\"container\">\n");
		pw.println("<div class=\"row\">\n");
		pw.println("<div class=\"col-md-12\">\n");
		pw.println("<table>\n");
		pw.println("<tr>\n");
		pw.println("<th>Name</th>\n<th>Score</th>\n");
		pw.println("</tr>\n");
		
		int csvLineLength = 2;
		for(int i=0; i<csvArrayLenght;i++){
			pw.println("<tr>\n");
			
			for(int j = 0; j < csvLineLength; j++) {
				pw.println("<td>");
				pw.println(arraytext[i][j]);
				pw.println("</td>\n");
			}
			pw.println("</tr>\n");
		}
		pw.println("</table>");
		pw.println("</div></div></div></div>");

		pw.println(Utilities.CLASSEND);
		pw.println(Utilities.copyright());
		pw.println(Utilities.FIN);
	}
	
	public void print(PrintWriter pw) {
		// TODO Auto-generated method stub

	}

}
