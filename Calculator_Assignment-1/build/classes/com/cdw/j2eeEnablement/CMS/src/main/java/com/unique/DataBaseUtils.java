package com.unique;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DataBaseUtils {

	private static final String DB_URL = "jdbc:mysql://localhost:3306/complaint_management";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "pavi0902";

	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
	}

	public static void insertComplaint(String userName, String complaints) {
		try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
			String sql = "INSERT INTO complaints (user_email, complaint_text) VALUES (?, ?)";
			try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
				pstmt.setString(1, userName);
				pstmt.setString(2, complaints);
				pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static List<Complaint> getActiveComplaints() {
		List<Complaint> activeComplaints = new ArrayList<>();

		try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
			String sql = "SELECT * FROM complaints WHERE status='active'";
			try (PreparedStatement pstmt = connection.prepareStatement(sql);
					ResultSet resultSet = pstmt.executeQuery()) {

				while (resultSet.next()) {
					String userName = resultSet.getString("user_email");
					String complaintText = resultSet.getString("complaint_text");
					String status = resultSet.getString("status");
					Complaint complaint = new Complaint(userName, complaintText, status);
					activeComplaints.add(complaint);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return activeComplaints;
	}

	public static void takeAction() {
		getActiveComplaints().forEach(complaint -> {
			try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
				String sql = "UPDATE complaints SET status='action taken' WHERE user_email=? AND complaint_text=?";
				try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
					pstmt.setString(1, complaint.getUserName());
					pstmt.setString(2, complaint.getComplaintText());
					pstmt.executeUpdate();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		});
	}

}
