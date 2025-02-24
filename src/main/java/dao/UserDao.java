package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import form.UserForm;

import static consts.DatabaseConnection.*;
import static consts.Consts.UserConst;

import model.User;

public class UserDao {

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("MySQL Driver not found", e);
		}
	}

	public List<User> getUsers() {

		List<User> users = new ArrayList<User>();
		String sql = " SELECT * from tbl_user";
		try {
			Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				users.add(new User(resultSet));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}
	
	public void createUser(UserForm user) {
		String sql = "INSERT INTO tbl_user (email, name, address, password, created_date, created_by, role) VALUES (?, ?, ?, ?, ?, ?, ?)";

		try {
			Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			setParamSql(user, preparedStatement);
			preparedStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void setParamSql(UserForm user, PreparedStatement preparedStatement) throws SQLException {
		preparedStatement.setString(1, user.getEmail());
		preparedStatement.setString(2, user.getName());
		preparedStatement.setString(3, user.getAddress());
		preparedStatement.setString(4, user.getPassword());

		LocalDateTime dateTime = LocalDateTime.now();
		preparedStatement.setTimestamp(5, Timestamp.valueOf(dateTime));

		preparedStatement.setString(6, "admin");
		preparedStatement.setString(7, "user");
	}
}
