package news;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import service.NewsHtml;

@SuppressWarnings("serial")
public class ReadNews extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*******************************/
		/*标题我是不知道的，所以随便打了一个*/
		/*******************************/
		NewsHtml html = new NewsHtml("need to select from database");
		
		/******************************************************/
		/* 读取localhost:8080/AoNews/ReadNews?newsid=后面的那部分
		 * 后期应该修改为相应的数据库主键
		 * 暂时先直接输入新闻目录下的文件夹 */
		/******************************************************/
		String newsid = req.getParameter("newsid");
		
		/**********************************************/
		/*图片以及文字路径，暂时没有合成一个，可以在这里改一下*/
		/**********************************************/
		File imgPath = new File("/home/user/apache/apache-tomcat-6.0.53/webapps/AoNews/MyCrawl/" + newsid + "/Img/");
		File textPath = new File("/home/user/apache/apache-tomcat-6.0.53/webapps/AoNews/MyCrawl/" + newsid + "/Text/");
		
		if (!imgPath.isDirectory() || !textPath.isDirectory()) {
			JOptionPane.showMessageDialog(null, "文件夹不存在");
		} else {
			String[] imgList = imgPath.list();
			String[] textList = textPath.list();
			boolean found = false;
			for (int i = 0; i < imgList.length + textList.length; i++) {
				for (String img : imgList)
					if (img.matches(i + ".*")) {
						html.addImgBody("MyCrawl/" + newsid + "/Img/" + img);
						found = true;
						break;
					}
				if (found) {
					found = false;
					continue;
				}
				for (String text : textList)
					if (text.matches(i + ".*")) {
						File textFile = new File(textPath + "/" + text);
						if (!textFile.isFile()) {
							JOptionPane.showMessageDialog(null, "文件不存在");
						} else {
							BufferedReader inBr = new BufferedReader(new FileReader(textFile));
							String line;
							while ((line = inBr.readLine()) != null) {
								html.addTextBody(line);
							}
							inBr.close();
						}
						found = true;
						break;
					}
				if (found) {
					found = false;
					continue;
				}
			}
		}
		PrintWriter out = resp.getWriter();
		out.print(html);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
