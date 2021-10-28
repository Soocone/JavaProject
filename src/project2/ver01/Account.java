package project2.ver01;

import java.util.Scanner;

public class Account
{
	public String accountID; //계좌번호
	public String customName; //고객이름
	public int accMoney; //잔고
	
	public Account(String accountID, String customName, int accMoney)
	{
		this.accountID = accountID;
		this.customName = customName;
		this.accMoney = accMoney;
	}
	
	//객체 배열 생성
	public Account[] myAccount;
	public int numOfAccount;
	
	public Account(int num)
	{
		myAccount = new Account[num];
		numOfAccount = 0;
	}
	
	Scanner scanner = new Scanner(System.in);
	
	//계좌 개설
	public void makeAccount() {
		System.out.println("┌──────신규개설계좌선택──────┐");
		System.out.println("│ 1.보통계좌  2.신용신뢰계좌 │");
		System.out.println("└────────────────────────────┘");
		int select = scanner.nextInt();
		scanner.nextLine();
		makeAccount(select);
	}
	
	public void makeAccount(int select) {
		System.out.print("계좌번호: ");	accountID = scanner.nextLine();
		System.out.print("예금주: "); customName = scanner.nextLine();
		System.out.print("잔고: ");	accMoney = scanner.nextInt();
		
		myAccount[numOfAccount++] = 
				new Account(accountID, customName, accMoney);
		
		System.out.println("계좌 개설이 완료되었습니다.");
	}
	
	
	//계좌 입금
	public void depositMoney() {
		scanner.nextLine();
		
		System.out.println("계좌번호와 입금할 금액을 입력하세요.");
		System.out.print("계좌번호: ");
		String accountNo = scanner.nextLine();
		System.out.print("입금액: ");
		int deposit = scanner.nextInt();
		
		//입금액이 0원 이상일 때, 계좌보유여부 확인후 입금처리
		if(deposit>0) {
			for(int i=0 ; i<numOfAccount ; i++) {
				if(accountNo.compareTo(myAccount[i].accountID)==0) {
					myAccount[i].accMoney += deposit;
					System.out.println("입금이 완료되었습니다.");
				}
			}
		}
		else
			System.out.println("0원 이상의 금액을 입력해주세요.");
	}
	
	
	//계좌 출금
	public void withdrawMoney() {
		scanner.nextLine();
		
		System.out.println("계좌번호와 출금할 금액을 입력하세요.");
		System.out.print("계좌번호: ");
		String accountNo = scanner.nextLine();
		System.out.print("출금액: ");
		int withdraw = scanner.nextInt();
		
		if(withdraw>0) {
			for(int i=0 ; i<numOfAccount ; i++) {
				if(accountNo.compareTo(myAccount[i].accountID)==0) {
					myAccount[i].accMoney -= withdraw;
					System.out.println("출금이 완료되었습니다.");
				}
			}
		}
		else
			System.out.println("0원 이상의 금액을 입력해주세요.");
	}
	
	//계좌정보 출력
	public void showAccInfo() {
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println(" 계좌번호: "+ accountID);
		System.out.println(" 예금주: "+ customName);
		System.out.println(" 잔고: "+ accMoney);
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━┛");
	}
	
	
	//전체정보 출력
	public void showAllInfo() {
		for(int i=0 ; i<numOfAccount ; i++) {
			myAccount[i].showAccInfo();
		}
		System.out.println("==전체 정보가 출력되었습니다.==");
	}
	
}
