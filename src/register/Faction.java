package register;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import service.FactionHtml;
import service.HandleTable;

@SuppressWarnings("serial")
public class Faction extends HttpServlet {
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

		FactionHtml html = new FactionHtml(name);

		/* 不妨假设推荐算法给出的是1 2 3 4 5 */
		String[] lovelinks = { "1", "2", "3", "4", "5" };
		for (String lovelink : lovelinks) {
			try {
				html.addLovelink(HandleTable.getNewsTitle(lovelink), lovelink);
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "数据库正在紧急施工");
				resp.sendRedirect("index.html");
			}
		}

		/* 不妨假设用户订阅关键词最热新闻是7 11 13 17 19 */
		String[] pswdlinks = { "7", "11", "13", "17", "19" };
		for (String pswdlink : pswdlinks) {
			try {
				html.addKywdlink(HandleTable.getNewsTitle(pswdlink), pswdlink);
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "数据库正在紧急施工");
				resp.sendRedirect("index.html");
			}
		}

		PrintWriter out = resp.getWriter();
		out.print(html);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

	public static String checkCookies(Cookie[] cookies) throws SQLException {
		if (cookies == null)
			return null;
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
