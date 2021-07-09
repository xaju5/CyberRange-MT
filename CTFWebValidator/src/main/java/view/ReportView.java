package view;

import java.io.PrintWriter;

public class ReportView implements View {

	public void print(PrintWriter pw, String[][] arraytext,int csvArrayLenght) {

		String values[] = {"Back to Test"};
		String href[] = {"validation.html"};
		int numValues = 1;
		
		//head
		pw.println(Utilities.DOCTYPE);
		pw.println(Utilities.head("Report","css/style.css","css/bootstrap.min.css"));
		
		//header
		pw.println(Utilities.STARTBODY);
		pw.println(Utilities.header());
		pw.println(Utilities.headButtons(numValues, values,href));
		
		//Table
		pw.println(Utilities.classTitle("Users Report"));		
		pw.println(Utilities.table(arraytext, csvArrayLenght));
		pw.println(Utilities.CLASSEND);
		
		//footer
		pw.println(Utilities.footer(numValues, values,href));
		pw.println(Utilities.FIN);
	}
	
	public void print(PrintWriter pw) {
		// TODO Auto-generated method stub

	}

}
