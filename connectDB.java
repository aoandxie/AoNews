package DBconnect;

import java.sql.Connection;
import java.sql.DriverManager;
import service.*;
import java.util.Scanner;

public class connectDB {
	// mysql数据库驱动，固定写法。连接Oracle时又与之不同,为："oracle.jdbc.driver.OracleDriver"
	private static final String driver = "com.mysql.jdbc.Driver";

	/**
	 * 如下是连接数据库的URL地址， 其中，"jdbc:mysql://" 为固定写法
	 * "localhost"是连接本机数据库时的写法，当不是连接本机数据库时，要写数据库所在计算机的IP地址。如：172.26.132.253
	 * "shopping"是数据库的名称，一定要根据自己的数据库更改。
	 * "?useUnicode=true&characterEncoding=UTF-8" 指定编码格式，无需时可省略，
	 * 即地址直接为："jdbc:mysql://localhost:3306/shopping"
	 */
	private static final String url = "jdbc:mysql://localhost:3306/aonews?useUnicode=true&characterEncoding=UTF-8";

	private static final String username = "root";// 数据库的用户名
	// private static final String
	// password="123456";//数据库的密码:这个是自己安装数据库的时候设置的，每个人不同。

	private static Connection conn = null; // 声明数据库连接对象

	// 静态代码块负责加载驱动
	static {
		try {
			Class.forName(driver);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	// 单例模式返回数据库连接对象，供外部调用
	public static Connection getConnection() throws Exception {
		if (conn == null) {
			System.out.println("请输入本地mysql数据库的根用户密码：\n");
			Scanner in = new Scanner(System.in);
			String password = in.nextLine();

			conn = DriverManager.getConnection(url, username, password); // 连接数据库
			return conn;
		}
		return conn;
	}

	// 写main方法测试是否连接成功，可将本类运行为Java程序先进行测试，再做后续的数据库操作。
}
