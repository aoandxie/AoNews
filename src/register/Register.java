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
import service.HtmlWriter;

@SuppressWarnings("serial")
@WebServlet("/Register")
public class Register extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		HtmlWriter html = new HtmlWriter("loading. . .");
		html.setBody("<img src=\"wait.gif\">");
		out.print(html);
		String name = request.getParameter("new_user");
		String email = request.getParameter("new_email");
		String pswd = request.getParameter("new_pswd");
		try {
			if (HandleTable.isNameExist(name)) {
				JOptionPane.showMessageDialog(null, "Name has existed");
				response.sendRedirect("register.html");
			} else {
				HandleTable.register(name, email, pswd);
				JOptionPane.showMessageDialog(null, "Register Success");
				response.sendRedirect("index.html");
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Register Fail");
			response.sendRedirect("index.html");
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
