package service;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClassifyHtml extends HtmlWriter {
	private String body;

	public ClassifyHtml() throws SQLException {
		super("News Type");
		body = "<div class=\"Top\"><ul><a href=\"faction_demo.html\">个人</a></ul><ul class=\"Now\"><a>分类</a></ul></div>	<div class=\"ClassBoxContainer\">";
		ResultSet kwRst = HandleTable.getKeyword();
		while (kwRst.next()) {
			addKeyword(kwRst.getString("Word"));
		}
		body += "</div>";
	}

	private void addKeyword(String keyword) {
		body += "<div class=\"ClassBox\"><a>" + keyword + "</a></div>";
	}

	@Override
	public String toString() {
		setHead("<link type=\"text/css\" rel=\"stylesheet\" href=\"css/classify_style.css\">");
		setBody(body);
		return super.toString();
	}
	
	public static void main(String[] args) throws SQLException {
		System.out.print(new ClassifyHtml());
	}
}
