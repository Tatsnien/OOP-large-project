package personnel;

import java.util.*;
import system.notice.Notice;

public class Account {
	
	private String id;
	private String password;
	private List<Notice> notices = new ArrayList<>();
	
	public Account(String id, String password) {
		this.id = id;
		this.password = password;
	}

	public String getId() {
		return id;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public List<Notice> getNotices() {
		return notices;
	}

	public void setNotices(List<Notice> notices) {
		this.notices = notices;
	}
	
	public void addNotice(Notice notice) {
		notices.add(notice);
	}

	@Override
	public boolean equals(Object obj) {
		try {
			Account account = (Account) obj;
			return  this.id.equals(account.getId()) && 
					this.password.equals(account.getPassword());
		}
		catch (Exception e){
			return false;
		}
	}

}
