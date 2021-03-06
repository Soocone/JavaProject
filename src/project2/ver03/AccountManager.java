package project2.ver03;

import java.util.InputMismatchException;
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
	public void makeAccount() {
		System.out.println("┌------신규개설계좌선택------┐");
		System.out.println("│ 1.보통계좌  2.신용신뢰계좌 │");
		System.out.println("└----------------------------┘");
		int select = scanner.nextInt();
		scanner.nextLine();
		makeAccount(select);
	}
	
	
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
			scanner.nextLine();
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
		try {	
			boolean findAccount = false;
			scanner.nextLine();
			
			System.out.println("계좌번호와 입금할 금액을 입력하세요.");
			System.out.println("입금은 500원 단위만 가능합니다.");
			System.out.print("계좌번호: ");
			String accountNo = scanner.nextLine();
			System.out.print("입금액: ");
			int deposit = scanner.nextInt();
			if(deposit<0) {
				NgtNumberException e = new NgtNumberException();
				throw e;
			}
			if(deposit%500!=0) {
				ErrMoneyException e = new ErrMoneyException();
				throw e;
			}
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
		catch (InputMismatchException e) {
			scanner.nextLine();
			System.out.println("[오류발생] 문자는 입력할 수 없습니다.");
		}
		catch(NgtNumberException e){
			System.out.println(e.getMessage());
		}
		catch(ErrMoneyException e){
			System.out.println(e.getMessage());
		}
	}
	
	//계좌 출금
	public void withdrawMoney() {
		try {
			boolean findAccount = false;
			
			scanner.nextLine();
			System.out.println("계좌번호와 출금할 금액을 입력하세요.");
			System.out.println("출금은 1,000원 단위만 가능합니다.");
			System.out.print("계좌번호: ");
			String accountNo = scanner.nextLine();
			System.out.print("출금액: ");
			int withdraw = scanner.nextInt();
			if(withdraw<0) {
				NgtNumberException e = new NgtNumberException();
				throw e;
			}
			if(withdraw%1000!=0) {
				ErrMoneyException e = new ErrMoneyException();
				throw e;
			}
			
			//계좌번호 동일 여부 체크
			for(int i=0 ; i<numOfAccount ; i++) {
				if(accountNo.compareTo(myAccount[i].accountID) ==0) {
					if(myAccount[i].accMoney>withdraw) {
						myAccount[i].accMoney -= withdraw;
						System.out.println("출금이 완료되었습니다.");
						findAccount = true;
					}
					//잔액이 부족한 경우
					else {
						System.out.println("[잔액부족] 금액 전체를 출금할까요?");
						System.out.println("YES입력: 전체 잔액 출금처리");
						System.out.println("NO입력: 출금 요청 취소");
						while(true) {
							String withdrawChoice = scanner.nextLine();
							if(withdrawChoice.equalsIgnoreCase("yes")) {
								System.out.println("전체 잔액을 출금합니다.");
								myAccount[i].accMoney -= myAccount[i].accMoney;
								findAccount = true;
								break;
							}
							else if(withdrawChoice.equalsIgnoreCase("no")) {
								System.out.println("출금 요청이 취소되었습니다.");
								findAccount = true;
								break;
							}
						}
					}
				}
			}
			if(findAccount==false)
				System.out.println("등록되지 않은 계좌번호입니다.");
		}
		catch (InputMismatchException e) {
			scanner.nextLine();
			System.out.println("[오류발생] 문자는 입력할 수 없습니다.");
		}
		catch(NgtNumberException e){
			System.out.println(e.getMessage());
		}
		catch(ErrMoneyException e){
			System.out.println(e.getMessage());
		}
	}
	
	//계좌정보 출력
	public void showAccInfo() {
		for(int i=0 ; i<numOfAccount ; i++) {
			myAccount[i].showAccInfo();
		}
		System.out.println("==전체 정보가 출력되었습니다.==");
	}
	
}

//숫자가 입력되지 않은 경우
class NgtNumberException extends Exception {
	public NgtNumberException() {
		super("[오류발생] 올바른 금액을 입력해주세요.");
	}
} 

//금액 단위가 올바르지 않은 경우
class ErrMoneyException extends Exception {
	public ErrMoneyException() {
		super("[오류발생] 올바른 금액단위를 입력해주세요.");
	}
}