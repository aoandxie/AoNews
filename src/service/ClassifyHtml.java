/*主要为Classify生成html*/
package service;

public class ClassifyHtml extends HtmlWriter {
	private String body1;
	private String body2;
	private String kwlist;

	public ClassifyHtml() {
		super("关键词");
		body1 = "<div class=\"Top\"><ul><a href=\"Faction\">个人</a></ul><ul class=\"Now\"><a>关键词</a></ul></div><div class=\"ClassBoxContainer\">";
		body2 = "</div>";
		kwlist = "";
	}

	public void addKeyword(String keyword) {
		kwlist += "<div class=\"ClassBox\"><a href=\"List?kywd=" + keyword + "\">" + keyword + "</a></div>";
	}

	@Override
	public String toString() {
		setHead("<link type=\"text/css\" rel=\"stylesheet\" href=\"css/topbar.css\"><link type=\"text/css\" rel=\"stylesheet\" href=\"css/classify.css\">");
		setBody(body1 + kwlist + body2);
		return super.toString();
	}
}
