package service;

import java.util.HashMap;

public class HtmlWriter {
	private HashMap<String, String> esChar;
	private String title;
	private String head;
	private String body;
	
	public HtmlWriter() {
		this("Unnamed Html");
	}
	
	public HtmlWriter(String title) {
		this.title = title;
		head = "";
		body = "";
		esChar = new HashMap<String, String>();
		esChar.put("\"", "&quot;");
		esChar.put("&", "&amp;");
		esChar.put("<", "&lt;");
		esChar.put(">", "&gt;");
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		title.replaceAll("<", "&lt");
		this.title = title;
	}

	public String getHead() {
		return head;
	}

	public void setHead(String head) {
		this.head = head;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
	
	public String escapeCharacter(String words, String oldCharacter) {
		if(esChar.containsKey(oldCharacter))
			words.replaceAll(oldCharacter, esChar.get(oldCharacter));
		return words;
	}
	
	@Override
	public String toString() {
		return ("<!DOCTYPE html><html><head><meta charset=\"UTF-8\"><title>" + getTitle() + "</title>" + getHead() + "</head><body>" + getBody() + "</body></html>");
	}
}
