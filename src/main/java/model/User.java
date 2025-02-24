package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import consts.Consts;

public class User {

	private String name;
	private String address;
	private String email;
	private String role;
	private LocalDateTime createdDate;
	private String createdBy;
	private String password;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public User() {
		
	}
	
	public User(ResultSet resultSet) throws SQLException {
		Timestamp timestamp = resultSet.getTimestamp(Consts.UserConst.CREATED_DATE);
		this.name = resultSet.getString(Consts.UserConst.NAME);
		this.address = resultSet.getString(Consts.UserConst.ADDRESS);
		this.email = resultSet.getString(Consts.UserConst.EMAIL);
		this.role = resultSet.getString(Consts.UserConst.ROLE);
		this.createdDate = timestamp.toLocalDateTime();
		this.createdBy = resultSet.getString(Consts.UserConst.CREATED_BY);
		this.password = resultSet.getString(Consts.UserConst.PASSWORD);
	}
	
	public User(String name, String address, String password, String email) {
		this.name = name;
		this.address = address;
		this.password = password;
		this.email = email;
	}
	
}
