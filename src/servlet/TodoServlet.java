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
 * Servlet implementation class TodoServlet
 */
@WebServlet("/todo")
public class TodoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public TodoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String tidStr = request.getParameter("tid");
		int tid = Integer.parseInt(tidStr);

		TodoDAO dao = new TodoDAO();
		Todo t = dao.findByTid(tid);

		request.setAttribute("todo", t);

		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/todo.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String tidStr = request.getParameter("tid");
		int tid = Integer.parseInt(tidStr);

		String title = request.getParameter("title");

		String tcheckStr = request.getParameter("tcheck");
		int tcheck = Integer.parseInt(tcheckStr);

		TodoDAO dao = new TodoDAO();
		Todo t = new Todo(tid, title, tcheck);
		dao.update(t);

		response.sendRedirect("todolist");
	}

}
