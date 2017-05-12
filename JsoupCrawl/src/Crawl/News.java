package Crawl;

public class News {

	private String url;
	private String newsType;
	private String webType;
	
	public News(String Url, String NewsType, String WebType){
		url = Url;
		newsType = NewsType;
		webType = WebType;
	}
	
	public String getUrl(){
		return url;
	}
	
	public String getNewsType(){
		return newsType;
	}
	
	public String getWebType(){
		return webType;
	}
}
