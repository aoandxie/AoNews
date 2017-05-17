/*这是查看某一个关键词下的新闻的地方，通过List?kywd=来访问*/
package news;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import service.HandleTable;
import service.ListHtml;

@SuppressWarnings("serial")
public class List extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String word = req.getParameter("kywd");
		ListHtml html = new ListHtml(word);

		ResultSet rs = null;
		try {
			rs = HandleTable.getKywdNews(word);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "数据库正在紧急施工");
			resp.sendRedirect("index.html");
		}

		try {
			while (rs.next()) {
				html.addLink(rs.getString("title"), rs.getString("newsId"));
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "数据库正在紧急施工");
			resp.sendRedirect("index.html");
		}

		PrintWriter out = resp.getWriter();
		out.print(html);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
