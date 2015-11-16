package Lister;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import model.Todolist;


/**
 * Servlet implementation class TaskAddServlet
 */
@WebServlet("/TaskAddServlet")
public class TaskAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TaskAddServlet() {
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
		HttpSession session = request.getSession();
		if (session.getAttribute("username") == null)
			response.sendRedirect("Login.jsp");
		else {
			String user = (String) session.getAttribute("username");
			Todolist p = new Todolist();
			SimpleDateFormat  formatter = new SimpleDateFormat("mm/dd/yyyy");
			Date date = new Date();
			try {
				date = formatter.parse(request.getParameter("duedate"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			p.setDuedate( date ); 
			int i = 0;
			BigDecimal bd = new BigDecimal(String.valueOf(i));
			p.setStatusid(bd);
			p.setTaskdescription(request.getParameter("description"));
			p.setTaskpriority(request.getParameter("priority"));
			p.setTaskuser(user);
			ListDB.addToList(p);

			response.sendRedirect("TaskDisplayServlet");
		}
	}
}
