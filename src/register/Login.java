package register;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
		out.print(
				"<!DOCTYPE html><html><head><meta charset=\"UTF-8\"><title>loading. . .</title></head><body><img src=\"wait.gif\"></body></html>");

		String name = request.getParameter("user");
		String pswd = request.getParameter("pswd");
		try {
			if (!HandleTable.isNameExist(name)) {
				JOptionPane.showMessageDialog(null, "Name not exist");
				response.sendRedirect("index.html");
			} else if (!HandleTable.login(name, pswd)) {
				JOptionPane.showMessageDialog(null, "wrong name || wrong password");
				response.sendRedirect("index.html");
			} else {
				JOptionPane.showMessageDialog(null, "Login success!");
				/* 这里应该是生成个人主页的代码，但是未完工 */
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
