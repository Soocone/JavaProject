package project2.ver05;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class AccConnect
{
	public String driver = "oracle.jdbc.OracleDriver";
	public String url = "jdbc:oracle:thin:@localhost:1521:xe";
	
	public Connection con;
	public Statement stmt;
	public PreparedStatement psmt;
	public ResultSet rs;
	
	//디폴트생성자
	public AccConnect()	{}
	
	//아이디, 패스워드를 인자로 받아 DB 연결
	public AccConnect(String user, String pass) {
		try	{
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, pass);
		} 
		catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
		}
		catch (SQLException e) {
			System.out.println("데이터베이스 연결 오류");
		}
	}	
	
	//사용자로부터 입력값을 받기 위한 메서드
	public String scanValue(String text)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print(text+": ");
		String inputStr = scanner.nextLine();
		
		return inputStr;
	}
	
	public int scanValue(int number)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print(number+": ");
		int inputInt = scanner.nextInt();
		
		return inputInt;
	}
	
}
