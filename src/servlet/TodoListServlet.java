package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Todo;
import model.TodoDAO;

/**
 * Servlet implementation class TodoListServlet
 */
@WebServlet("/todolist")
public class TodoListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public TodoListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TodoDAO dao = new TodoDAO();
		ArrayList<Todo> list = dao.findAll();

		request.setAttribute("list", list);

		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/todolist.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 文字化け対策
		request.setCharacterEncoding("UTF-8");

		String title = request.getParameter("title");

		TodoDAO dao = new TodoDAO();
		Todo t = new Todo(0,title,0);
		dao.insert(t);

		response.sendRedirect("todolist");
	}

}
