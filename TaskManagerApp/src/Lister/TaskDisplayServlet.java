package Lister;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import model.Todolist;


/**
 * Servlet implementation class TaskDisplayServlet
 */
@WebServlet("/TaskDisplayServlet")
public class TaskDisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TaskDisplayServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		double totalCost = 0, cost = 0;
		int itemCounter = 0;
		HttpSession session = request.getSession();
		String name = (String) session.getAttribute("username");
		if (session.getAttribute("username") == null)
			response.sendRedirect("Login.jsp");
		else {

			if (name.equalsIgnoreCase("admin")) {

				response.sendRedirect("AdminServlet");

			} else {

				PrintWriter out = response.getWriter();
				ArrayList<Todolist> dataset = new ArrayList<Todolist>();

				dataset = ListDB.PullList((String) session
						.getAttribute("username"));
				
				String message = "";
				for (int i = 0; i < dataset.size(); i++) {
					itemCounter++;
					String stat = ListDB.getStatus(dataset.get(i).getStatusid().toBigInteger());
					if(dataset.get(i).getCompdate()!=null)
					{
					message = message + "<br><tr><td>"
							+ dataset.get(i).getDuedate() + "</td><td>"
							+ dataset.get(i).getTaskdescription()+ "</td><td>"
									+ dataset.get(i).getTaskpriority()+ "</td><td>"
											+ stat + "</td><td>"
													+ dataset.get(i).getCompdate()  + "</td></tr><br>";}
					else
					{
						message = message + "<br><tr><td>"
								+ dataset.get(i).getDuedate() + "</td><td>"
								+ dataset.get(i).getTaskdescription()+ "</td><td>"
										+ dataset.get(i).getTaskpriority()+ "</td><td>"
												+ stat + "</td><td>"
														+ "<a href=\"TaskCompleteServlet?taskid="+dataset.get(i).getTaskid()+"\" class=\"btn btn-info\" role=\"button\">Completed</a>" + "</td></tr><br>";
						}
						
					

					
				}
				request.setAttribute("message", message);
				
				request.setAttribute("noOfItems", itemCounter);
				getServletContext().getRequestDispatcher("/TaskDisplay.jsp")
						.forward(request, response);
			}
		}
	}
}
