/*主要为SetInterest生成html*/
package service;

public class SetInterestHtml extends HtmlWriter {
	private String body1;
	private String body2;
	private String kwlist1;
	private String kwlist2;

	public SetInterestHtml(String user) {
		super("用户设置");
		body1 = "<div class=\"Top\"><ul><a href=\"Faction\">个人</a></ul><ul class=\"Now\"><a>设置</a></ul></div><div class=\"personal\"><p>"
				+ user
				+ "<a href=\"Faction\"><button>退回</button></a></p></div><div class=\"InterestClassSelect\"><form action=\"SetFinish\" method=\"GET\"><p>";
		body2 = "</p><p class=\"Footer\"><input type=\"submit\"></p></form></div>";
		kwlist1 = "";
		kwlist2 = "";
	}

	public void addChoosenKeyword(String word) {
		kwlist1 += "<input type=\"checkbox\" name=\"word\" value=\"" + word + "\" checked=\"checked\">" + word;
	}

	public void addUnchoosenKeyword(String word) {
		kwlist2 += "<input type=\"checkbox\" name=\"word\" value=\"" + word + "\">" + word;
	}
	
	@Override
	public String toString() {
		setHead("<link type=\"text/css\" rel=\"stylesheet\" href=\"css/topbar.css\"><link type=\"text/css\" rel=\"stylesheet\" href=\"css/setinterest.css\">");
		setBody(body1 + kwlist1 + kwlist2 + body2);
		return super.toString();
	}
}
