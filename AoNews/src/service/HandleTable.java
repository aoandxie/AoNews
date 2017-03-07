package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HandleTable {
	private static String password = ""; // input mysql root password
	private static Connection connection;
	private static Statement statement;
	
	private static void init() {
		// Load JDBC driver
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("driver failed");
			e.printStackTrace();
		}
		// Establish connection
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/aonews", "root", password);
		} catch (SQLException e) {
			System.out.println("connection failed");
			e.printStackTrace();
		}
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			System.out.println("statement failed");
			e.printStackTrace();
		}
	}

	public static boolean isNameExist(String name) throws SQLException {
		init();
		ResultSet rs = statement.executeQuery("select UserName from Login where UserName='" + name + "';");
		return rs.next();
	}

	public static void register(String name, String email, String pswd) throws SQLException {
		init();
		statement.executeUpdate(
				"insert into Login(UserName,Password,Mail) values('" + name + "','" + pswd + "','" + email + "');");
	}

	public static boolean login(String name, String pswd) throws SQLException {
		init();
		ResultSet rs = statement.executeQuery("select Password from Login where UserName='" + name + "';");
		if(rs.next())
			return (pswd.equals(rs.getString("Password")));
		else
			return false;
	}
	
	public static boolean setNews(String id, String title, String src, String time) throws SQLException {
		init();
		if (id == null)
			return false;
		statement.executeUpdate("insert News value('" + id + "','" + title + "','" + src + "','" + time + "')");
		return true;
	}
	
	public boolean setNewsKeyword(String id, String word) throws SQLException {
		if (id == null || word == null)
			return false;
		statement.executeUpdate("insert NewsKeyword value('" + id + "','" + word + "')");
		return true;
	}
}
