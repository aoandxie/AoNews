/*这是用户察看所有的关键词的页面
 * 用户可以由主页通过右上方的关键词键进入此页面
 * 非用户理论上可以通过AoNews/Classify进入*/
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

import service.ClassifyHtml;
import service.HandleTable;

@SuppressWarnings("serial")
public class Classify extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 设置返回的编码集
		resp.setContentType("text/html; charset=utf8");

		// 创建返回的html文件
		ClassifyHtml html = null;
		html = new ClassifyHtml();
		ResultSet rs = null;
		try {
			rs = HandleTable.getKeyword();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "数据库正在紧急施工");
			resp.sendRedirect("index.html");
		}
		
		try {
			while(rs.next()){
				html.addKeyword(rs.getString("word"));
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
