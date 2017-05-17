/*主要为Faction生成html*/
package service;

public class FactionHtml extends HtmlWriter {
	private String body1;
	private String body2;
	private String body3;
	private String lovelink = "";
	private String kywdlink = "";

	public FactionHtml(String user) {
		super("个人主页");
		body1 = "<div class=\"Top\"><ul class=\"Now\"><a>个人</a></ul><ul><a href=\"Classify\">关键词</a></ul></div><div class=\"personal\"><p>"
				+ user
				+ "<a href=\"SetInterest\"><button>管理订阅</button></a></p></div><div class=\"newsbox\"><div class=\"newslink\"><p>可能喜欢</p>";
		body2 = "</div><div class=\"newslink\"><p>订阅类别</p>";
		body3 = "</div></div>";
	}

	public void addLovelink(String title, String newsId) {
		lovelink += "<a href=\"ReadNews?newsid=" + newsId + "\">" + super.escapeCharacter(title) + "</a>";
	}

	public void addKywdlink(String title, String newsId) {
		kywdlink += "<a href=\"ReadNews?newsid=" + newsId + "\">" + super.escapeCharacter(title) + "</a>";
	}

	@Override
	public String toString() {
		setHead("<link type=\"text/css\" rel=\"stylesheet\" href=\"css/topbar.css\"><link type=\"text/css\" rel=\"stylesheet\" href=\"css/faction.css\">");
		setBody(body1 + lovelink + body2 + kywdlink + body3);
		return super.toString();
	}
}
