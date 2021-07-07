package view;

import java.io.PrintWriter;


public class ResultView implements View{

	public void print(PrintWriter pw, int score) {

		pw.println(Utilities.DOCTYPE);
		pw.println(Utilities.headConTitleStyle("Form submited","css/style.css"));
		pw.println("<body>");
		pw.println("<h1>Your score is: "+score+"</h1>");
		pw.println("<brn>");
		pw.println("<brn>");
		pw.println("<brn>");
		
		pw.println(Utilities.botonUrl("validation.html", "repeat form"));
		
		pw.println(Utilities.FIN);
	}
	public void print(PrintWriter pw) {
		// TODO Auto-generated method stub
		
	}
	
	

}
