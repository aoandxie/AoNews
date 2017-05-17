/*设置感兴趣的新闻关键词*/
package news;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import service.HandleTable;
import service.SetInterestHtml;

@SuppressWarnings("serial")
public class SetInterest extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cookie[] cookies = req.getCookies();

		String name = null; // 即用户登录的id
		try {
			name = checkCookies(cookies);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "数据库正在紧急施工");
			resp.sendRedirect("index.html");
		}

		if (name == null) {
			JOptionPane.showMessageDialog(null, "访问状态异常，请重新登录");
			resp.sendRedirect("index.html");
		}
		
		SetInterestHtml html = new SetInterestHtml(name);
		
		try {
			ArrayList<String> userWords = HandleTable.getUserKeyword(name);
			ResultSet rs = HandleTable.getKeyword();
			while(rs.next()){
				String word = rs.getString("word");
				if(userWords.contains(word)){
					html.addChoosenKeyword(word);
				}else{
					html.addUnchoosenKeyword(word);
				}
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "数据库正在紧急施工");
			resp.sendRedirect("index.html");
		}
		
		PrintWriter out = resp.getWriter();
		out.print(html);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

	public static String checkCookies(Cookie[] cookies) throws SQLException {
		String name = null;
		String pswd = null;
		for (Cookie cookie : cookies)
			if (cookie.getName().equals("uid")) {
				name = cookie.getValue();
			} else if (cookie.getName().equals("id")) {
				pswd = cookie.getValue();
			}
		if (name == null || pswd == null || !HandleTable.login(name, pswd)) {
			return null;
		} else {
			return name;
		}
	}
}
