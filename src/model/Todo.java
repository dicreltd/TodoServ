package model;

import java.sql.Timestamp;

public class Todo {
	private int tid;
	private String title;
	private Timestamp atime;
	private int tcheck;

	public Todo() {
		super();
	}

	public Todo(int tid, String title, int tcheck) {
		super();
		this.tid = tid;
		this.title = title;
		this.tcheck = tcheck;
	}

	public Todo(int tid, String title, Timestamp atime, int tcheck) {
		super();
		this.tid = tid;
		this.title = title;
		this.atime = atime;
		this.tcheck = tcheck;
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Timestamp getAtime() {
		return atime;
	}

	public void setAtime(Timestamp atime) {
		this.atime = atime;
	}

	public int getTcheck() {
		return tcheck;
	}

	public void setTcheck(int tcheck) {
		this.tcheck = tcheck;
	}

	public String getStatus() {
		if( this.tcheck==0) {
			return "未";
		}else {
			return "済み";
		}
	}

}
