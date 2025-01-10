package data;

import personnel.Personnel;

public class Notice {
	private CustomDate date;
	private String title;
	private String sender;
	private String receiver;
	private String content;
	
	public Notice(Personnel receiver) {
		this.sender = "System";
		this.receiver = receiver.getPosition() + " " + receiver.getName();
		this.date = new CustomDate();
		this.title = "No title";
	}
	
	public Notice(Personnel sender, Personnel receiver) {
		this.sender = sender.getPosition() + " " + sender.getName();
		this.receiver = receiver.getPosition() + " " + receiver.getName();
		this.date = new CustomDate();
		this.title = "No title";
	}
	
	public Notice(Personnel sender, Personnel receiver, String title) {
		this.sender = sender.getPosition() + " " + sender.getName();
		this.receiver = receiver.getPosition() + " " + receiver.getName();
		this.date = new CustomDate();
		this.title = title;
	}
	
	public CustomDate getnewDate() {
		return date;
	}
	
	public void setDate(String date) {
		this.date = new CustomDate(date);
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
	
	public String getReceiver() {
		return receiver;
	}
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String printDate() {
		System.out.println(date.toString());
		return date.toString();
	}
	
}
