package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Todo;
import model.TodoDAO;

/**
 * Servlet implementation class TodoDelServlet
 */
@WebServlet("/tododel")
public class TodoDelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public TodoDelServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tidStr = request.getParameter("tid");
		int tid = Integer.parseInt(tidStr);

		TodoDAO dao = new TodoDAO();
		Todo t = dao.findByTid(tid);

		request.setAttribute("todo", t);
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/tododel.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tidStr = request.getParameter("tid");
		int tid = Integer.parseInt(tidStr);

		TodoDAO dao = new TodoDAO();
		dao.delete(tid);

		response.sendRedirect("todolist");
	}

}
