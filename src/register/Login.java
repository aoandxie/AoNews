package register;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

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
public class Login extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.print("<html><body><img src=\"res\\wait.gif\"></body></html>");
		String name = request.getParameter("user");
		String pswd = request.getParameter("pswd");
		try {
			if (!HandleTable.isNameExist(name)) {
				JOptionPane.showMessageDialog(null, "用户名不存在或者密码错误");
				response.sendRedirect("index.html");
			} else if (!HandleTable.login(name, pswd)) {
				JOptionPane.showMessageDialog(null, "用户名不存在或者密码错误");
				response.sendRedirect("index.html");
			} else {
				JOptionPane.showMessageDialog(null, "登录成功！");
				Cookie uid = new Cookie("uid", name);
				uid.setMaxAge(60 * 60 * 24);
				Cookie id = new Cookie("id", pswd);
				id.setMaxAge(60 * 60 * 24);
				response.addCookie(id);
				response.addCookie(uid);
				response.sendRedirect("Faction");
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "数据库正在紧急施工");
			response.sendRedirect("index.html");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
