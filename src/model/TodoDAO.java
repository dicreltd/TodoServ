package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

public class TodoDAO {
	static final String SRC =  "jdbc:mysql://localhost/todo?useSSL=false";
	static final String USER = "java";
	static final String PASS = "pass";

	public void insert(Todo t) {
		try(Connection con = DriverManager.getConnection(SRC,USER,PASS);){

			String sql = "INSERT INTO todo (title,atime,tcheck) VALUES(?,now(),?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, t.getTitle());
			stmt.setInt(2, t.getTcheck());

			stmt.executeUpdate();

			stmt.close();

		} catch (SQLException e) {
			System.out.println("INSERTエラー:" + e.getMessage());
		}
	}

	public void update(Todo t) {
		try(Connection con = DriverManager.getConnection(SRC,USER,PASS);){

			String sql = "UPDATE todo SET title=?,tcheck=? WHERE tid=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, t.getTitle());
			stmt.setInt(2, t.getTcheck());
			stmt.setInt(3, t.getTid());
			stmt.executeUpdate();

			stmt.close();

		} catch (SQLException e) {
			System.out.println("UPDATEエラー:" + e.getMessage());
		}
	}

	public void delete(int tid) {
		System.out.println("DELETE");
		try(Connection con = DriverManager.getConnection(SRC,USER,PASS);){

			String sql = "DELETE FROM todo WHERE tid=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, tid);
			stmt.executeUpdate();

			stmt.close();

		} catch (SQLException e) {
			System.out.println("DELETEエラー:" + e.getMessage());
		}
	}

	public Todo findByTid(int tid) {
		Todo t=null;
		try(Connection con = DriverManager.getConnection(SRC,USER,PASS);){

			String sql = "SELECT * FROM todo WHERE tid=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, tid);
			ResultSet rs = stmt.executeQuery();

			if(rs.next()) {
				String title = rs.getString("title");
				Timestamp atime = rs.getTimestamp("atime");
				int tcheck = rs.getInt("tcheck");

				t = new Todo(tid, title, atime, tcheck);
			}
			stmt.close();

		} catch (SQLException e) {
			System.out.println("findエラー:" + e.getMessage());
		}
		return t;
	}
	public ArrayList<Todo> findAll() {
		ArrayList<Todo> list = new ArrayList<Todo>();

		try(Connection con = DriverManager.getConnection(SRC,USER,PASS);){

			String sql = "SELECT * FROM todo";
			PreparedStatement stmt = con.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			while(rs.next()) {
				int tid = rs.getInt("tid");
				String title = rs.getString("title");
				Timestamp atime = rs.getTimestamp("atime");
				int tcheck = rs.getInt("tcheck");

				Todo t = new Todo(tid, title, atime, tcheck);
				list.add(t);
			}
			stmt.close();

		} catch (SQLException e) {
			System.out.println("findAllエラー:" + e.getMessage());
		}
		return list;
	}

}
