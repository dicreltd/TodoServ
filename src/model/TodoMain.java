package model;

public class TodoMain {

	public static void main(String[] args) {
		TodoDAO dao = new TodoDAO();
		dao.delete(4);
//		ArrayList<Todo> list = dao.findAll();
//		for(Todo t : list) {
//			System.out.println(t.getTitle());
//			System.out.println(t.getAtime());
//			System.out.println(t.getTcheck());
//		}
	}

}
