package view;

import java.io.PrintWriter;

public class ResultView implements View{

	public void print(PrintWriter pw, String score, String username) {

		String grade[] = {"Fail","Poor","Pass","Good","Excelent"};
		String values[] = {"Back to the Test","All user Reports"};
		String href[] = {"validation.html","FormController"};
		int numValues = 2;
		int numScore = Integer.parseInt(score);
		String text= "/4 \t\t\t" + grade[numScore];
		//head
		pw.println(Utilities.DOCTYPE);
		pw.println(Utilities.head("Score","css/style.css","css/bootstrap.min.css"));
		
		//header
		pw.println(Utilities.STARTBODY);
		pw.println(Utilities.header());
		pw.println(Utilities.headButtons(2, values,href));
		
		//Scores
		pw.println(Utilities.classTitle("Your score"));
		pw.println(Utilities.columText("Your name is:",username,""));
		
		pw.println(Utilities.columText("Your score is:",score,text));
		pw.println(Utilities.CLASSEND);
		
		//footer
		pw.println(Utilities.footer(numValues, values,href));
		pw.println(Utilities.FIN);
	}
	public void print(PrintWriter pw) {
		// TODO Auto-generated method stub
		
	}
	
	

}
