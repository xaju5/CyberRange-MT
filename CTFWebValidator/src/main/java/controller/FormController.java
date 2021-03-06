package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ProgramLogic;
import view.ReportView;
import view.ResultView;

/**
 * Servlet implementation class FormController
 */
@WebServlet("/FormController")
public class FormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    //Returns the answers of all users
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProgramLogic pl = new ProgramLogic();
		String [][] arraytext = pl.readCSV();
		int csvArrayLenght = pl.getCsvArrayLenght();
		int csvLineLength = pl.getCsvLineLength();
		reportResponse(response, new ReportView(),arraytext,csvArrayLenght,csvLineLength);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	//Checks answers and returns the results of that form
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String flag1u = request.getParameter("flag1u");
		String flag1p = request.getParameter("flag1p");
		String flag2 = request.getParameter("flag2");
		String flag3u = request.getParameter("flag3u");
		String flag3p = request.getParameter("flag3p");
		String flag4 = request.getParameter("flag4");
		
		ProgramLogic pl = new ProgramLogic(username, flag1u, flag1p, flag2, flag3u, flag3p, flag4);
		String score = pl.checkResults();
		pl.saveCSV();
		
		formResponse(response, new ResultView(),score, username);
	}
	
	private void formResponse(HttpServletResponse response, ResultView view, String score, String username) {
		
		response.setContentType("text/html");
		PrintWriter out;
		
		try {
			out = response.getWriter();
			view.print(out,score, username);
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void reportResponse(HttpServletResponse response, ReportView view,String[][] arraytext,int csvArrayLenght,int csvLineLength) {
	
		response.setContentType("text/html");
		PrintWriter out;
		
		try {
			out = response.getWriter();
			view.print(out, arraytext, csvArrayLenght,csvLineLength);
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}

}
