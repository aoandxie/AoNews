package service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class WriteXML extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String className = req.getParameter("className");
		addClassXML(className);
		resp.getWriter().println("Successful");
		
	}

	public static void addClassXML(String className) throws FileNotFoundException {
		File xmlFile = new File("/home/xmingest/桌面/apache-tomcat-9.0.0.M11/webapps/xmweb/WEB-INF/web.xml");
		if (xmlFile.canRead()) {
			Scanner outXml = new Scanner(xmlFile);
			ArrayList<String> xmlDoc = new ArrayList<String>();
			while (outXml.hasNext()) {
				xmlDoc.add(outXml.nextLine());
			}
			outXml.close();
			if (xmlFile.canWrite()) {
				PrintWriter inXml = new PrintWriter(xmlFile);
				for (String line : xmlDoc) {
					if (line.contains("</web-app>")) {
						inXml.println("<servlet>\n<servlet-name>" + className + "</servlet-name>");
						inXml.println("<servlet-class>" + className + "</servlet-class>\n</servlet>");
						inXml.println("<servlet-mapping>\n<servlet-name>" + className + "</servlet-name>");
						inXml.println("<url-pattern>/" + className + "</url-pattern>\n</servlet-mapping>");
						inXml.print("</web-app>");
					} else {
						inXml.println(line);
					}
				}
				inXml.close();
			}
		}
	}
}