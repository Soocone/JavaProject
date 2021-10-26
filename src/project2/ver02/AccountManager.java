package project2.ver02;

import java.util.Scanner;

public class AccountManager
{	
	Scanner scanner = new Scanner(System.in);
	
	private Account[] myAccount;
	private int numOfAccount;
	
	public AccountManager(int num)
	{
		myAccount = new Account[num];
		numOfAccount = 0;
	}
	
	
	//계좌 개설
	public void makeAccount(int select) {
		
		String accountID, customName, grade;
		int accMoney, rate;
		
		System.out.print("계좌번호: ");	accountID = scanner.nextLine();
		System.out.print("예금주: "); customName = scanner.nextLine();
		System.out.print("잔고: ");	accMoney = scanner.nextInt();
		
		if(select ==1) {
			scanner.nextLine();
			System.out.print("기본이자%(정수형태로입력): "); rate = scanner.nextInt(); 
			scanner.nextLine();
			myAccount[numOfAccount++] = 
					new NormalAccount(accountID, customName, accMoney, rate);
		}
		else if(select ==2) {
			System.out.print("기본이자%(정수형태로입력): "); rate = scanner.nextInt(); 
			scanner.nextLine();
			System.out.print("신용등급(A,B,C등급): "); grade = scanner.nextLine();
			myAccount[numOfAccount++] = 
					new HighCreditAccount(accountID, customName, accMoney, rate, grade);
		}
		
		System.out.println("계좌 개설이 완료되었습니다.");
	}
	
	//계좌 입금
	public void depositMoney() {
		boolean findAccount = false;
		scanner.nextLine();
		
		System.out.println("계좌번호와 입금할 금액을 입력하세요.");
		System.out.print("계좌번호: ");
		String accountNo = scanner.nextLine();
		System.out.print("입금액: ");
		int deposit = scanner.nextInt();
		
		for(int i=0 ; i<numOfAccount ; i++) {
			if(accountNo.compareTo(myAccount[i].accountID)==0) {
				myAccount[i].deposit(deposit);
				System.out.println("입금이 완료되었습니다.");
				findAccount = true;				
			}
		}
		
		if(findAccount==false)
			System.out.println("등록되지 않은 계좌번호입니다.");
	}
	
	//계좌 출금
	public void withdrawMoney() {
		boolean findAccount = false;
		
		scanner.nextLine();
		System.out.println("계좌번호와 출금할 금액을 입력하세요.");
		System.out.print("계좌번호: ");
		String accountNo = scanner.nextLine();
		System.out.print("출금액: ");
		int withdraw = scanner.nextInt();
		
		for(int i=0 ; i<numOfAccount ; i++) {
			if(accountNo.compareTo(myAccount[i].accountID) ==0) {
				myAccount[i].accMoney -= withdraw;
				System.out.println("출금이 완료되었습니다.");
				findAccount = true;
			}
		}
		if(findAccount==false)
			System.out.println("등록되지 않은 계좌번호입니다.");
	}
	
	//계좌정보 출력
	public void showAccInfo() {
		for(int i=0 ; i<numOfAccount ; i++) {
			myAccount[i].showAccInfo();
		}
		System.out.println("==전체 정보가 출력되었습니다.==");
	}
	
}
