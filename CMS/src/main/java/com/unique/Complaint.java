package com.unique;

public class Complaint {
	private String userName;
	private String complaintText;
	private String status;


	public Complaint(String userName, String complaintText, String status) {
		this.userName = userName;
		this.complaintText = complaintText;
		this.status = status;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getComplaintText() {
		return complaintText;
	}

	public void setComplaintText(String complaintText) {
		this.complaintText = complaintText;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
