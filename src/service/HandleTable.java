package service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class HandleTable {
	private static String password; // input mysql root password
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

		// Get mysql pswd
		File mysqlPswd = new File("/home/xmingest/mysql");
		try {
			BufferedReader br = new BufferedReader(new FileReader(mysqlPswd));
			password = br.readLine();
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Establish connection
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/aonews", "root", password);
		} catch (SQLException e) {
			System.out.println("connection failed");
			e.printStackTrace();
		}

		// Create statement
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			System.out.println("statement failed");
			e.printStackTrace();
		}
	}

	public static boolean isNameExist(String name) throws SQLException {
		init();
		ResultSet rs = statement.executeQuery("select loginId from User where loginId='" + name + "';");
		return rs.next();
	}

	public static void register(String name, String email, String pswd) throws SQLException {
		init();
		statement.executeUpdate(
				"insert into User(loginId,pswd,mail) values('" + name + "','" + pswd + "','" + email + "');");
	}

	public static boolean login(String name, String pswd) throws SQLException {
		init();
		ResultSet rs = statement.executeQuery("select pswd from User where loginId='" + name + "';");
		if (rs.next())
			return (pswd.equals(rs.getString("pswd")));
		else
			return false;
	}

	public static boolean setNews(String id, String title, String src, String time) throws SQLException {
		init();
		if (id == null)
			return false;
		statement.executeUpdate("insert News(newsId,title,srcUrl,srcTime) values('" + id + "','" + title + "','" + src
				+ "','" + time + "');");
		return true;
	}

	public static boolean setNewsKeyword(String id, String word) throws SQLException {
		if (id == null || word == null)
			return false;
		init();
		ResultSet rs1 = statement.executeQuery("select newsId from News where newsId='" + id + "';");
		if (!rs1.next()) {
			return false;
		}
		ResultSet rs2 = statement.executeQuery("select word from Keyword where word='" + word + "';");
		if (!rs2.next()) {
			statement.executeUpdate("insert Keyword(word) values('" + word + "');");
		}
		statement.executeUpdate("update News set word='" + word + "' where newsId='" + id + "';");
		return true;
	}

	public static ResultSet getKeyword() throws SQLException {
		init();
		return statement.executeQuery("select word from Keyword");
	}

	public static String getNewsTitle(String newsId) throws SQLException {
		init();
		ResultSet rs = statement.executeQuery("select title from News where newsId='" + newsId + "';");
		if (rs.next()) {
			return rs.getString("title");
		}
		return null;
	}

	public static void setHistory(String uid, String nid) throws SQLException {
		init();
		statement.executeUpdate("insert into History(uid,nid) values('" + uid + "','" + nid + "');");
	}

	public static String getNewsSrcUrl(String newsId) throws SQLException {
		init();
		ResultSet rs = statement.executeQuery("select srcUrl from News where newsId='" + newsId + "';");
		if (rs.next()) {
			return rs.getString("srcUrl");
		}
		return null;
	}

	public static String getNewsSrcTime(String newsId) throws SQLException {
		init();
		ResultSet rs = statement.executeQuery("select srcTime from News where newsId='" + newsId + "';");
		if (rs.next()) {
			return rs.getString("srcTime");
		}
		return null;
	}

	public static ResultSet getKywdNews(String word) throws SQLException {
		init();
		ResultSet rs = statement.executeQuery("select newsId,title from News where word='" + word + "';");
		return rs;
	}

	public static boolean addUserKeyword(String uid, String word) throws SQLException {
		init();
		ResultSet rs = statement.executeQuery("select word from Keyword where word='" + word + "';");
		if (!rs.next())
			return false;
		statement.executeUpdate("insert into Interest(uid,word) values('" + uid + "','" + word + "');");
		return true;
	}

	public static ArrayList<String> getUserKeyword(String uid) throws SQLException {
		init();
		ArrayList<String> words = new ArrayList<String>();
		ResultSet rs = statement.executeQuery("select uid,word from Interest where uid='" + uid + "';");
		while(rs.next()){
			words.add(rs.getString("word"));
		}
		return words;
	}

	public static void deleteUserKeyword(String uid, String word) throws SQLException {
		init();
		statement.executeUpdate("delete from Interest where uid='" + uid + "' and word='" + word + "';");
	}
}
