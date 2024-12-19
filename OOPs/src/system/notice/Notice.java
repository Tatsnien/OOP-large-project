package system.notice;

import java.text.SimpleDateFormat;
import java.util.Date;

import personnel.Personnel;

public class Notice {
	private Date date;
	private String title;
	private String sender;
	
	public Notice() {
		this.sender = "System";
		date = new Date();
		title = "No title";
	}
	
	public Notice(Personnel person) {
		this.sender = person.getPosition() + " " + person.getName();
		date = new Date();
		title = "No title";
	}
	
	public Date getDate() {
		return date;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}

	public String getSender() {
		return sender;
	}
	
	public String printDate() {
		String toStringDate = new SimpleDateFormat("dd/MM/yyyy HH:mm").format(date);
		System.out.println(toStringDate);
		return toStringDate;
	}
	
}
