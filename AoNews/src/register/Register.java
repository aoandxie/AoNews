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
@WebServlet("/Register")
public class Register extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.print(
				"<!DOCTYPE html><html><head><meta charset=\"UTF-8\"><title>loading. . .</title></head><body><img src=\"wait.gif\"></body></html>");

		String name = request.getParameter("new_user");
		String email = request.getParameter("new_email");
		String pswd = request.getParameter("new_pswd");
		try {
			if (HandleTable.isNameExist(name)) {
				JOptionPane.showMessageDialog(null, "Name has existed");
				response.sendRedirect("register.html");
			} else {
				HandleTable.register(name, email, pswd);
				out.print("Register Success");
				response.sendRedirect("faction.html");
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