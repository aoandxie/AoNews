package Crawl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import service.HandleTable;

public class newsCrawl {
	private LinkedList ImgUrls = new LinkedList();// 用于存放图片URL

	
	private int count = 0;

	public void startCrawl() throws Exception {
		HandleTable db = new HandleTable();
		News news = new News("http://edu.ifeng.com/", "education", "fenghuang");
		News news1 = new News("http://news.ifeng.com/mil/","war","fenghuang");
		News news2 = new News("http://sports.ifeng.com/","sports","fenghuang");
		News news3 = new News("http://news.ifeng.com/history/","history","fenghuang");
		News news4 = new News("http://fashion.ifeng.com/","lady","fenghuang");
		News news5 = new News("http://games.ifeng.com/","play","fenghuang");
		News news6 = new News("http://photo.ifeng.com/","photo","fenghuang");
		News news7 = new News("http://culture.ifeng.com/","culture","fenghuang");
		News news8 = new News("http://news.ifeng.com/world/","world","fenghuang");
		News news9 = new News("http://news.ifeng.com/listpage/11502/0/1/rtlist.shtml","news","fenghuang");
		News news10 = new News("http://edu.163.com/", "education", "wangyi");
		News news11 = new News("http://war.163.com/","war","wangyi");
		News news12 = new News("http://sports.163.com/","sports","wangyi");
		News news13 = new News("http://lady.163.com/","lady","wangyi");
		News news14 = new News("http://news.163.com/world/","world","wangyi");
		News news15 = new News("http://news.163.com/rank/","news","wangyi");
		News news16 = new News("http://mil.qq.com/mil_index.htm","war","tengxun");
		News news17 = new News("http://sports.qq.com/","sports","tengxun");
		News news18 = new News("http://history.news.qq.com/","history","tengxun");
		News news19 = new News("http://fashion.qq.com/","lady","tengxun");
		News news20 = new News("http://news.qq.com/photo.shtml","photo","tengxun");
		News news21 = new News("http://cul.qq.com/","culture","tengxun");
		News news22 = new News("http://news.qq.com/world_index.shtml","world","tengxun");
		News news23 = new News("http://roll.news.qq.com/","news","tengxun");
		newsCrawl test = new newsCrawl();
		try {
			test.getCrawl(news,db);
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			System.out.println("website error.");
		}
		try {
			test.getCrawl(news1,db);
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			System.out.println("website error.");
		}
		try {
			test.getCrawl(news2,db);
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			System.out.println("website error.");
		}
		try {
			test.getCrawl(news3,db);
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			System.out.println("website error.");
		}
		try {
			test.getCrawl(news4,db);
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			System.out.println("website error.");
		}
		try {
			test.getCrawl(news5,db);
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			System.out.println("website error.");
		}
		try {
			test.getCrawl(news6,db);
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			System.out.println("website error.");
		}
		try {
			test.getCrawl(news7,db);
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			System.out.println("website error.");
		}
		try {
			test.getCrawl(news8,db);
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			System.out.println("website error.");
		}
		try {
			test.getCrawl(news9,db);
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			System.out.println("website error.");
		}
		try {
			test.getCrawl(news10,db);
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			System.out.println("website error.");
		}
		try {
			test.getCrawl(news11,db);
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			System.out.println("website error.");
		}
		try {
			test.getCrawl(news12,db);
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			System.out.println("website error.");
		}
		try {
			test.getCrawl(news13,db);
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			System.out.println("website error.");
		}
		try {
			test.getCrawl(news14,db);
		} catch (SQLException | IOException e1) {
			// TODO Auto-generated catch block
			System.out.println("website error.");
		}
		try {
			test.getCrawl(news15,db);
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			System.out.println("website error.");
		}
		try {
			test.getCrawl(news16,db);
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			System.out.println("website error.");
		}
		try {
			test.getCrawl(news17,db);
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			System.out.println("website error.");
		}
		try {
			test.getCrawl(news18,db);
		} catch (SQLException | IOException e) {
			System.out.println("website error.");
		}
		try {
			test.getCrawl(news19,db);
		} catch (SQLException | IOException e) {
			System.out.println("website error.");
		}
		try {
			test.getCrawl(news20,db);
		} catch (SQLException | IOException e) {
			System.out.println("website error.");
		}
		try {
			test.getCrawl(news21,db);
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			System.out.println("website error.");
		}
		try {
			test.getCrawl(news22,db);
		} catch (SQLException | IOException e) {
			System.out.println("website error.");
		}
		try {
			test.getCrawl(news23,db);
		} catch (SQLException | IOException e) {
			System.out.println("website error.");
		}
	}

	private void getCrawl(News news, HandleTable db) throws SQLException, IOException{

		String url = news.getUrl();
		Document Doc = Jsoup.connect(url).get();
		Elements href = Doc.select("a[href]");
		LinkedList<String> linkurls = new LinkedList<String>();
		
		if (news.getWebType() == "wangyi") {
			StringBuffer last = new StringBuffer();
			for (Element ready : href) {
				String newsurl = ready.attr("abs:href");
				if (newsurl.contains("/17/") && !(newsurl.equals(last.toString()))&& !linkurls.contains(newsurl)) {
					linkurls.add(newsurl);
					last.replace(0, newsurl.length(), newsurl);
					count++;
					Document doc;
					try {
						doc = Jsoup.connect(newsurl).get();
						String title = this.getnewTitle(doc);// 获取新闻标题
					    
						String time = this.getTime(doc);// 获取新闻发布时间
						this.getNewtext(doc, count);// 获取新闻内容
						//this.getImgurl(doc, count);// 获取图片链
						db.setNews("" + count, title, newsurl, time);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						System.out.println("connect error.");
					}
					db.setNewsKeyword("" + count, news.getNewsType());
				}
			}
		}
		else if (news.getWebType() == "tengxun") {
			StringBuffer last = new StringBuffer();
			for (Element ready : href) {
				String newsurl = ready.attr("abs:href");
				if (newsurl.contains("/a/") && !(newsurl.equals(last.toString())) && !linkurls.contains(newsurl)) {
					linkurls.add(newsurl);
					last.replace(0, newsurl.length(), newsurl);
					count++;
					Document doc;
					try {
						doc = Jsoup.connect(newsurl).get();
					
					String title = this.getnewTitle(doc);// 获取新闻标题
					String time = this.getTime_T(doc);// 获取新闻发布时间
					if(this.getNewtext_T(doc, count)){
						db.setNews("" + count, title, newsurl, time);
						db.setNewsKeyword("" + count, news.getNewsType());
					}
					else
						count--;// 获取新闻内容
					//this.getImgurl(doc, count);// 获取图片链

					} catch (Exception e) {
						// TODO Auto-generated catch block
						count--;
						System.out.println("url wrong or connect wrong.");
					}
				}
			}
		}

		else if (news.getWebType() == "fenghuang") {
			StringBuffer last = new StringBuffer();
			for (Element ready : href) {
				String newsurl = ready.attr("abs:href");
				if (newsurl.contains("/a/") && !(newsurl.equals(last.toString())) && !linkurls.contains(newsurl)) {
					linkurls.add(newsurl);
					last.replace(0, newsurl.length(), newsurl);
					count++;
					Document doc;
					try {
						doc = Jsoup.connect(newsurl).get();
					
					String title = this.getnewTitle(doc);// 获取新闻标题
					String time = this.getTime_F(doc);// 获取新闻发布时间
					if(this.getNewtext_F(doc, count)){
						db.setNews("" + count, title, newsurl, time);
						db.setNewsKeyword("" + count, news.getNewsType());
					}
					else
						count--;// 获取新闻内容
					//this.getImgurl(doc, count);// 获取图片链

					} catch (Exception e) {
						// TODO Auto-generated catch block
						count--;
						System.out.println("url wrong or connect wrong.");
					}
				}
			}
		}
	}
	
	private boolean getNewtext_F(Document doc, int number) throws IOException{
		int count = 0;
		// 获取新闻内容
		// String text = doc.select("#endText").text();
		Elements text = doc.select("div[id=main_content]");
		Document spread = Jsoup.parse(text.html());
		Elements result = spread.getAllElements();
		
		if(result.size() <= 5)
			return false;
		
		for (int i = 4; i < result.size(); i++) {
			

			String imgUrl = result.get(i).attr("abs:src");
			if(imgUrl.length() > 0 && (imgUrl.contains("jpeg") || imgUrl.contains("png") || (imgUrl.contains("jpg")))){

				String str = "F:\\MyCrawl\\" + number + "\\Img\\";// 保存下载图片文件夹

				File dir = new File(str);
				dir.mkdirs();
				downloadImg(imgUrl, count, number);
				
				count ++;
			}
			else{
				
			String linkText = result.get(i).text();
			if (linkText.length() > 3) {
				String str = "F:\\MyCrawl\\" + number + "\\Text\\";// 保存下载图片文件夹

				File dir = new File(str);
				dir.mkdirs();

				String way = str + count + ".txt";// 保存图片路径
				File file = new File(way); // 创建文件

				FileOutputStream out = new FileOutputStream(file); // 输出的文件流
				byte bt[] = new byte[1024];
				bt = linkText.getBytes();

				out.write(bt, 0, bt.length);


				out.close();
				
				count ++;
			}

		}
		}
		return true;
	}
	
	private String getTime_F(Document doc){
		Elements element = doc.select("span[itemprop=datePublished]");
		String time = element.text();
		return time;
	}
	
	private String getTime_T(Document doc){
		Elements element = doc.select("span.a_time");
		String time = element.text();
		return time;
	}
	
	private boolean getNewtext_T(Document doc, int number) throws IOException{
		int count = 0;
		// 获取新闻内容
		// String text = doc.select("#endText").text();
		Elements text = doc.select("div[bossZone=content]");
		Document spread = Jsoup.parse(text.html());
		Elements result = spread.getAllElements();
		
		if(result.size() <= 5)
			return false;
		
		for (int i = 4; i < result.size(); i++) {
			

			String imgUrl = result.get(i).attr("abs:src");
			if(imgUrl.length() > 0 && (imgUrl.contains("jpeg") || imgUrl.contains("png") || (imgUrl.contains("jpg")))){

				String str = "F:\\MyCrawl\\" + number + "\\Img\\";// 保存下载图片文件夹

				File dir = new File(str);
				dir.mkdirs();
				downloadImg(imgUrl, count, number);
				
				count ++;
			}
			else{
				
			String linkText = result.get(i).text();
			if (linkText.length() > 3) {
				String str = "F:\\MyCrawl\\" + number + "\\Text\\";// 保存下载图片文件夹

				File dir = new File(str);
				dir.mkdirs();

				String way = str + count + ".txt";// 保存图片路径
				File file = new File(way); // 创建文件

				FileOutputStream out = new FileOutputStream(file); // 输出的文件流
				byte bt[] = new byte[1024];
				bt = linkText.getBytes();

				out.write(bt, 0, bt.length);


				out.close();
				
				count ++;
			}

		}
		}
		return true;
	}
	

	private String getnewTitle(Document doc) {
		// 获取网页的标题
		String title = doc.title();
		return title;
	}

	

	private LinkedList getImgurl(Document doc, int number) throws IOException {
		// 获取图片地址，并保存在ImgUrls链表中
		String str = "F:\\MyCrawl\\" + number + "\\Img\\";// 保存下载图片文件夹

		File dir = new File(str);
		dir.mkdirs();

		int count = 0;
		Elements contents = doc.select("#endText");
		Elements pngs = contents.select("img[src]");
		for (Element img : pngs) {
			count++;
			String imgUrl = img.attr("abs:src");// 获取图片的绝对路径
			// imgUrl = img.absUrl("src");
			ImgUrls.add(imgUrl);
			// System.out.println(imgUrl);
			downloadImg(imgUrl, count, number);
		}
		return ImgUrls;
	}

	private void downloadImg(String ImgUrl, int count, int number) throws IOException {
		// 下载图片
		String str = "F:\\MyCrawl\\" + number + "\\Img\\";// 保存下载图片文件夹

		String ss = str + count + ".png";// 保存图片路径
		URL url = new URL(ImgUrl); // 构造URL
		URLConnection uc = url.openConnection(); // 打开连接
		InputStream is = uc.getInputStream(); // 输入流
		File file = new File(ss); // 创建文件
		FileOutputStream out = new FileOutputStream(file); // 输出的文件流
		byte[] bs = new byte[1024];
		// 读取到的数据长度
		int len;
		// 开始读取
		while ((len = is.read(bs)) != -1) {
			out.write(bs, 0, len);
		}
		// 完毕，关闭所有链接
		out.close();
		is.close();
	}

	private void getNewtext(Document doc, int number) throws IOException {
		int count = 0;
		// 获取新闻内容
		// String text = doc.select("#endText").text();
		Elements text = doc.select("#endText");
		Document spread = Jsoup.parse(text.html());
		Elements result = spread.getAllElements();
		
		for (int i = 4; i < result.size(); i++) {
			

			String imgUrl = result.get(i).attr("abs:src");
			if(imgUrl.length() > 0 && (imgUrl.contains("jpeg") || imgUrl.contains("png") || (imgUrl.contains("jpg")))){

				String str = "F:\\MyCrawl\\" + number + "\\Img\\";// 保存下载图片文件夹

				File dir = new File(str);
				dir.mkdirs();
				downloadImg(imgUrl, count, number);
				
				count ++;
			}
			else{
				
			String linkText = result.get(i).text();
			if (linkText.length() > 3) {
				String str = "F:\\MyCrawl\\" + number + "\\Text\\";// 保存下载图片文件夹

				File dir = new File(str);
				dir.mkdirs();

				String way = str + count + ".txt";// 保存图片路径
				File file = new File(way); // 创建文件

				FileOutputStream out = new FileOutputStream(file); // 输出的文件流
				byte bt[] = new byte[1024];
				bt = linkText.getBytes();

				out.write(bt, 0, bt.length);


				out.close();
				
				count ++;
			}

		}
		}
		
		/*String textHtml = text.html();
		Document spread = Jsoup.parse(text.html());
		Elements result = spread.getElementsByTag("p");
		for (Element link : result) {
			
			//link.getElementsByTag("img");
			
			String linkText = link.text();
			if (linkText.length() > 3) {
				String str = "F:\\MyCrawl\\" + number + "\\Text\\";// 保存下载图片文件夹

				File dir = new File(str);
				dir.mkdirs();

				String way = str + count + ".txt";// 保存图片路径
				File file = new File(way); // 创建文件

				FileOutputStream out = new FileOutputStream(file); // 输出的文件流
				byte bt[] = new byte[1024];
				bt = linkText.getBytes();

				out.write(bt, 0, bt.length);

				count++;

				out.close();
			}

		}*/

		// text = text.replace(Jsoup.parse(" ").text(), "");
		// return text;
	}

	private String getTime(Document doc) {
		// 获取新闻发布的时间
		// String time=null;
		Elements element = doc.select("div.post_time_source");// 此处是根据百度新闻的网页形式解析的新闻时间
		/*
		 * String
		 * rex="^(((20\\d{2})-(\\d{2})-(\\d{2}))) ((\\d{2}):(\\d{2}):(\\d{2}))$"
		 * ;//正则表达式用于匹配时间 Pattern pattern=Pattern.compile(rex); for(Element el:
		 * element){ String content = el.text(); Matcher
		 * matcher=pattern.matcher(content); if(matcher.matches()){
		 * time=content; System.out.println("新闻发布时间为："+content); } }
		 */
		String time = element.text();
		return time;
	}

	public static void main(String[] args) {
		newsCrawl test = new newsCrawl();
		try {
			test.startCrawl();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("error happened.");
		}
	}
}
