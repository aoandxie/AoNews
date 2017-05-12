package DBconnect;

import java.sql.Connection;
import java.sql.DriverManager;
import service.*;
import java.util.Scanner;

public class connectDB {
	// mysql���ݿ��������̶�д��������Oracleʱ����֮��ͬ,Ϊ��"oracle.jdbc.driver.OracleDriver"
	private static final String driver = "com.mysql.jdbc.Driver";

	/**
	 * �������������ݿ��URL��ַ�� ���У�"jdbc:mysql://" Ϊ�̶�д��
	 * "localhost"�����ӱ������ݿ�ʱ��д�������������ӱ������ݿ�ʱ��Ҫд���ݿ����ڼ������IP��ַ���磺172.26.132.253
	 * "shopping"�����ݿ�����ƣ�һ��Ҫ�����Լ������ݿ���ġ�
	 * "?useUnicode=true&characterEncoding=UTF-8" ָ�������ʽ������ʱ��ʡ�ԣ�
	 * ����ֱַ��Ϊ��"jdbc:mysql://localhost:3306/shopping"
	 */
	private static final String url = "jdbc:mysql://localhost:3306/aonews?useUnicode=true&characterEncoding=UTF-8";

	private static final String username = "root";// ���ݿ���û���
	// private static final String
	// password="123456";//���ݿ������:������Լ���װ���ݿ��ʱ�����õģ�ÿ���˲�ͬ��

	private static Connection conn = null; // �������ݿ����Ӷ���

	// ��̬����鸺���������
	static {
		try {
			Class.forName(driver);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	// ����ģʽ�������ݿ����Ӷ��󣬹��ⲿ����
	public static Connection getConnection() throws Exception {
		if (conn == null) {
			System.out.println("�����뱾��mysql���ݿ�ĸ��û����룺\n");
			Scanner in = new Scanner(System.in);
			String password = in.nextLine();

			conn = DriverManager.getConnection(url, username, password); // �������ݿ�
			return conn;
		}
		return conn;
	}

	// дmain���������Ƿ����ӳɹ����ɽ���������ΪJava�����Ƚ��в��ԣ��������������ݿ������
}
