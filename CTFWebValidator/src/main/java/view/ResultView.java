package view;

import java.io.PrintWriter;

public class ResultView implements View{

	public void print(PrintWriter pw, String score, String username) {

		pw.println(Utilities.DOCTYPE);
		pw.println(Utilities.STARTBODY);
		pw.println(Utilities.head("Score","css/style.css","css/bootstrap.min.css"));
		pw.println(Utilities.header());
		pw.println(Utilities.classTitle("Your score"));
		pw.println(Utilities.columText("Username:",username,""));
		pw.println(Utilities.columText("Your score is:",score,""));
		pw.println(Utilities.CLASSEND);
		
		pw.println("<br><br><br><br>");
		//pw.println(Utilities.botonUrl("validation.html", "repeat form"));
		pw.println(Utilities.copyright());
		pw.println(Utilities.FIN);
	}
	public void print(PrintWriter pw) {
		// TODO Auto-generated method stub
		
	}
	
	

}
