package service;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class ReadAllClass extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();

		out.println("<!DOCYTPE html><html><head><title>Servelet</title><meta charset=utf8/></head><body>");

		File file = new File("/home/xmingest/桌面/apache-tomcat-9.0.0.M11/webapps/xmweb/WEB-INF/classes/");
		if (file.isDirectory()) {
			File[] files = file.listFiles();
			ArrayList<String> fileList = new ArrayList<String>();
			ArrayList<String> classList = new ArrayList<String>();
			File xmlFile = new File("/home/xmingest/桌面/apache-tomcat-9.0.0.M11/webapps/xmweb/WEB-INF/web.xml");
			if(xmlFile.canRead()){
				Scanner xmlIn = new Scanner(xmlFile);
				while(xmlIn.hasNext()){
					String line = xmlIn.nextLine();
					if(line.contains("<url-pattern>/"))
						fileList.add(line.substring(line.lastIndexOf("<url-pattern>/") + 14, line.indexOf("</url-pattern>")));
				}
				xmlIn.close();
			}
			for (File f: files) {
				if (f.isFile() && f.getName().endsWith(".class")) {
					String tempStr = f.getName().substring(0, f.getName().lastIndexOf(".class"));
					if(fileList.contains(tempStr)){
						out.println("<li><a href=\"../" + tempStr + "\">" + tempStr + "</a></li>");
						classList.add(tempStr);
					}
					else
						out.println("<li>" + tempStr + " not found in web.xml</li>");
				}
			}
			for(String className: fileList)
				if(!classList.contains(className) && !className.contains("/"))
					out.println("<li>" + className + " not found in classes</li>");
		}

		out.println("<li><a href=\"../\">return</a></li></body></html>");
	}
}