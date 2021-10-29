package project2.ver05;

import java.sql.SQLException;
import java.util.Scanner;

public class Account extends AccConnect
{	
	Scanner scanner = new Scanner(System.in);
	
	public String accountID; //계좌번호
	public String customName; //고객이름
	public int accMoney; //잔고
	
	
	//DB연결
	public Account() {	
		super("kosmo", "1234");
	}
	
	//계좌 개설
	public void makeAccount() {
		//쿼리문 작성
		String insSql = "INSERT INTO banking_tb VALUES (seq_banking.NEXTVAL, ?, ?, ?)";
		
		try	{
			scanner.nextLine();
			//prepared 객체 생성
			psmt = con.prepareStatement(insSql);
			
			//사용자로부터 정보 입력받음
			System.out.print("계좌번호: ");	accountID = scanner.nextLine();
			System.out.print("예금주: "); customName = scanner.nextLine();
			System.out.print("잔고: ");	accMoney = scanner.nextInt();
			
			//인파라미터 설정
			psmt.setString(1, accountID);
			psmt.setString(2, customName);
			psmt.setInt(3, accMoney);
			
			//쿼리실행
			int row = psmt.executeUpdate();
			
			//결과
			System.out.printf("%d개의 계좌가 개설되었습니다.\n",row);
			
		}
		
		catch (SQLException e){
			System.out.println("계좌 개설시 오류 발생");
			e.printStackTrace();
		}
	}
	
	
	
	//계좌 입금
	public void depositMoney() {
		scanner.nextLine();
		try {
			//금액을 변경하는 쿼리 작성
			String sql = "UPDATE banking_tb SET acc_money=? WHERE acc_id=?";
			//prepared 객체 생성
			psmt = con.prepareStatement(sql);
			
			System.out.println("계좌번호와 입금할 금액을 입력하세요.");
			System.out.print("계좌번호: ");
			String accountNo = scanner.nextLine();
			System.out.print("입금액: ");
			int deposit = scanner.nextInt();
			
			//입금액이 0원 이상일 때
			if(deposit>0) {
				//인파라미터 업데이트
				psmt.setString(2, accountNo);
				psmt.setInt(1, accMoney+=deposit);
				
				//쿼리실행
				psmt.executeUpdate();
				System.out.println("입금이 완료되었습니다.");
			}
			else
				System.out.println("0원 이상의 금액을 입력해주세요.");
		}
		catch (Exception e) {
			System.out.println("입금시 오류 발생");
		}
	}
	
	
	//계좌 출금
	public void withdrawMoney() {
		scanner.nextLine();
		try {
			//금액을 변경하는 쿼리 작성
			String sql = "UPDATE banking_tb SET acc_money=? WHERE acc_id=?";
			//prepared 객체 생성
			psmt = con.prepareStatement(sql);
			
			System.out.println("계좌번호와 출금할 금액을 입력하세요.");
			System.out.print("계좌번호: ");
			String accountNo = scanner.nextLine();
			System.out.print("출금액: ");
			int withdraw = scanner.nextInt();
			
			//출금액이 0원 이상일 때
			if(withdraw>0) {
				//인파라미터 업데이트
				psmt.setString(2, accountNo);
				psmt.setInt(1, accMoney-=withdraw);
				
				//쿼리실행
				psmt.executeUpdate();
				System.out.println("출금이 완료되었습니다.");
			}
			else
				System.out.println("0원 이상의 금액을 입력해주세요.");
		}
		catch (Exception e) {
			System.out.println("출금시 오류 발생");
		}
	}
	
	public void showAccInfo() {
		try {
			String sql = "SELECT acc_index, acc_id, cust_name, "
					+ " trim(to_char(acc_money, '999,999,000')) balance "
				    + " FROM banking_tb "
				    + " ORDER BY acc_index ";
			
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			
			System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
			System.out.println(" No     계좌번호     예금주        잔고    ");
			
			while(rs.next()){
				String acc_index = rs.getString("acc_index"); //숫자지만 어차피 String으로 출력되기 때문
				String acc_id = rs.getString("acc_id");
				String cust_name = rs.getString("cust_name");
				String acc_money = rs.getString("balance");
				
				System.out.printf(" %s  %-17s %-8s %s\n", 
						acc_index, acc_id, cust_name, acc_money);
			}	
			System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
			System.out.println("==전체 정보가 출력되었습니다.==");
		}
		catch (Exception e) {
			System.out.println("계좌정보 출력중 오류 발생");
			e.printStackTrace();
		}
	}
	
	
	public void close() {
		try {
			if(con!=null) con.close();
			if(psmt!=null) psmt.close();
			if(rs!=null) rs.close();
			System.out.println("자원 반납완료");
		}
		catch (Exception e) {
			System.out.println("자원반납시 오류 발생");
			e.printStackTrace();
		}
	}
}
