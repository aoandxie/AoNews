/*主要为List生成html*/
package service;

public class ListHtml extends HtmlWriter {
	private String body;
	private String links;

	public ListHtml(String word) {
		super(word);
		body = "<div class=\"Top\"><ul><a href=\"Faction\">个人</a></ul><ul class=\"Now\"><a>" + word + "</a></ul></div><div class=\"newslink\">";
		links = "";
	}

	public void addLink(String title, String newsId){
		links += "<a href=\"ReadNews?newsid=" + newsId + "\">" + title + "</a>";
	}

	@Override
	public String toString() {
		setHead("<link type=\"text/css\" rel=\"stylesheet\" href=\"css/topbar.css\"><link type=\"text/css\" rel=\"stylesheet\" href=\"css/list.css\">");
		setBody(body + links + "</div>");
		return super.toString();
	}
}
