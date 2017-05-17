/*主要为ReadNews生成html*/
package service;

public class NewsHtml extends HtmlWriter {
	private String time;
	private String srcWeb;
	private String mainBody;

	public NewsHtml(String title) {
		super(title);
		time = srcWeb = "Undefined";
		mainBody = "";
	}

	public void addTextBody(String text) {
		mainBody = mainBody + "<p>" + super.escapeCharacter(text) + "</p>";
	}

	public void addImgBody(String src) {
		mainBody = mainBody + "<img src=\"" + super.escapeCharacter(src) + "\">";
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = super.escapeCharacter(time);
	}

	public String getSrcWeb() {
		return srcWeb;
	}

	public void setSrcWeb(String srcWeb) {
		this.srcWeb = super.escapeCharacter(srcWeb);
	}

	@Override
	public String toString() {
		setHead("<link type=\"text/css\" rel=\"stylesheet\" href=\"css/topbar.css\"><link type=\"text/css\" rel=\"stylesheet\" href=\"css/news.css\">");
		// 回到首页
		setBody("<div class=\"Top\"><ul><a href=\"\">个人</a></ul><ul class=\"Now\"><a>新闻</a></ul>	</div><div class=\"paper\"><div class=\"title\"><p>"
				+ getTitle() + "</p></div><div class=\"mainbody\">" + mainBody + "</div></div><div class=\"foot\"><p>"
				+ srcWeb + "</p><p>" + time + "</p></div>");
		return super.toString();
	}
}