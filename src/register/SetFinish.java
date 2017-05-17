package register;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import service.HandleTable;

@SuppressWarnings("serial")
@WebServlet("/Login")
public class SetFinish extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		out.print("<html><body><img src=\"res\\wait.gif\"></body></html>");
		Cookie[] cookies = req.getCookies();

		String name = null; // 即用户登录的id
		try {
			name = Faction.checkCookies(cookies);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "数据库正在紧急施工");
			resp.sendRedirect("index.html");
		}

		if (name == null) {
			JOptionPane.showMessageDialog(null, "登录状态异常，请重新登录");
			resp.sendRedirect("index.html");
		}

		Map<String, String[]> pMp = req.getParameterMap();
		ArrayList<String> oldWords = new ArrayList<String>();
		try {
			oldWords = HandleTable.getUserKeyword(name);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "数据库正在紧急施工");
			resp.sendRedirect("index.html");
		}
		ArrayList<String> newWords = new ArrayList<String>();

		// 添加不存在的关键词
		for (String value : pMp.get("word")) {
			newWords.add(value);
			if (!oldWords.contains(value)) {
				try {
					HandleTable.addUserKeyword(name, value);
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, "数据库正在紧急施工");
					resp.sendRedirect("index.html");
				}
			}
		}

		// 删除存在但被用户取消的关键词
		for (String value : oldWords) {
			if (!newWords.contains(value)) {
				try {
					HandleTable.deleteUserKeyword(name, value);
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, "数据库正在紧急施工");
					resp.sendRedirect("index.html");
				}
			}
		}

		JOptionPane.showMessageDialog(null, "设置成功，正在返回首页");
		resp.sendRedirect("Faction");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
