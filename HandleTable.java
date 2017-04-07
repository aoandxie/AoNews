package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import DBconnect.connectDB;

public class HandleTable {

	private static Connection conn = null;
	// PreparedStatement对象用来执行SQL语句
	private static PreparedStatement pst = null;

	public HandleTable() throws Exception {
		conn = connectDB.getConnection();
	}

	public boolean setNews(String id, String title, String src, String time) throws SQLException {
		if (id == null)
			return false;
		pst = conn.prepareStatement("insert News value('" + id + "','" + title + "','" + src + "','" + time + "')");
		pst.execute();
		return true;
	}

	public boolean setNewsKeyword(String id, String word) throws SQLException {
		if (id == null || word == null)
			return false;
		pst = conn.prepareStatement("insert NewsKeyword value('" + id + "','" + word + "')");
		pst.execute();
		return true;
	}
}
