package service;

public class NewsHtml extends HtmlWriter {
	private String time;
	private String srcWeb;
	private String mainBody;

	public NewsHtml() {
		this("Unnamed News");
	}

	public NewsHtml(String title) {
		super(title);
		setHead("<link type=\"text/css\" rel=\"stylesheet\" href=\"news_style.css\">");
		time = srcWeb = "Undefined";
		mainBody = "";
	}

	public void addTextBody(String text) {
		mainBody = mainBody + "<p>" + text + "</p>";
	}

	public void addImgBody(String src) {
		mainBody = mainBody + "<img src=\"" + src + "\">";
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getSrcWeb() {
		return srcWeb;
	}

	public void setSrcWeb(String srcWeb) {
		this.srcWeb = srcWeb;
	}

	@Override
	public String toString() {
		setBody("<div class=\"paper\"><div class=\"title\"><p>" + getTitle() + "</p></div><div class=\"mainbody\">"
				+ mainBody + "</div></div><div class=\"foot\"><p>" + srcWeb + "</p><p>" + time + "</p></div>");
		return super.toString();
	}
}