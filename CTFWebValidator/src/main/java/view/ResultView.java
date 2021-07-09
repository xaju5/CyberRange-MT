package view;

import java.io.PrintWriter;

public class ResultView implements View{

	public void print(PrintWriter pw, String score, String username) {

		String values[] = {"Back to Test","Reports"};
		String href[] = {"validation.html","FormController"};
		int numValues = 2;
		
		//head
		pw.println(Utilities.DOCTYPE);
		pw.println(Utilities.head("Score","css/style.css","css/bootstrap.min.css"));
		
		//header
		pw.println(Utilities.STARTBODY);
		pw.println(Utilities.header());
		pw.println(Utilities.headButtons(2, values,href));
		
		//Scores
		pw.println(Utilities.classTitle("Your score"));
		pw.println(Utilities.columText("Username:",username,""));
		pw.println(Utilities.columText("Your score is:",score,""));
		pw.println(Utilities.CLASSEND);
		
		//footer
		pw.println(Utilities.footer(numValues, values,href));
		pw.println(Utilities.FIN);
	}
	public void print(PrintWriter pw) {
		// TODO Auto-generated method stub
		
	}
	
	

}
