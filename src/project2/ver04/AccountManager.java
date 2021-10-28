package project2.ver04;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;



public class AccountManager 
{	
	Scanner scanner = new Scanner(System.in);
	
	//계좌 정보 저장용 HashSet 컬렉션 생성
	HashSet<Account> accHashSet;
	
	
	
	public AccountManager(int num)
	{
		//멤버변수가 컬렉션으로 바뀌면서 HashSet<E> 생성
		accHashSet = new HashSet<Account>();
		
		//생성자 생성과 동시에 복원할 파일 읽어오기
		readAccInfo();
	}
	
	
	public AccountManager()
	{
	}


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
		String accountID, customName, grade;
		int accMoney, rate;
		
		
		System.out.print("계좌번호: ");	accountID = scanner.nextLine();
		System.out.print("예금주: "); customName = scanner.nextLine();
		System.out.print("잔고: ");	accMoney = scanner.nextInt();
		
		//일반계좌 개설
		if(select ==1) {
			scanner.nextLine();
			System.out.print("기본이자%(정수형태로입력): "); rate = scanner.nextInt(); 
			scanner.nextLine();
			//일반계좌 객체 생성후 컬렉션에 add. 인덱싱 필요 없음.
			NormalAccount nomAcc =
					new NormalAccount(accountID, customName, accMoney, rate);
			
			//중복계좌 체크
			boolean duplicateCheck = accHashSet.add(nomAcc);
			if(duplicateCheck==false) {
				System.out.println("이미 등록된 계좌번호입니다. 덮어쓸까요?(y or n)");
				String openAccount = scanner.nextLine();
				if(openAccount.equalsIgnoreCase("y")) {
					accHashSet.remove(nomAcc);
					accHashSet.add(nomAcc);
					System.out.println("계좌 개설이 완료되었습니다.");
				}
				else if(openAccount.equalsIgnoreCase("n")) {
					return;
				}
			}
			
		}
		
		//신용계좌 개설
		else if(select ==2) {
			scanner.nextLine();
			System.out.print("기본이자%(정수형태로입력): "); rate = scanner.nextInt(); 
			scanner.nextLine();
			System.out.print("신용등급(A,B,C등급): "); grade = scanner.nextLine();
			HighCreditAccount highAcc =
					new HighCreditAccount(accountID, customName, accMoney, rate, grade);
			//객체 생성과 동시에 컬렉션에 add하는 방법.
			//accHashSet.add(new HighCreditAccount(accountID, customName, accMoney, rate, grade));
			
			//중복계좌 체크
			boolean duplicateCheck = accHashSet.add(highAcc);
			if(duplicateCheck==false) {
				System.out.println("이미 등록된 계좌번호입니다. 덮어쓸까요?(y or n)");
				String openAccount = scanner.nextLine();
				if(openAccount.equalsIgnoreCase("y")) {
					accHashSet.remove(highAcc);
					accHashSet.add(highAcc);
					System.out.println("계좌 개설이 완료되었습니다.");
				}
				else if(openAccount.equalsIgnoreCase("n")) {
					return;
				}
			}
		}
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
			
			//이터레이터를 사용하여 계좌 보유여부 체크 및 입금
			Iterator<Account> itr = accHashSet.iterator();
			while(itr.hasNext()) {
				Account account = itr.next();
				if(accountNo.compareTo(account.accountID)==0) {
					account.deposit(deposit);
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
			
			//이터레이터를 사용하여 계좌 보유여부 체크 및 입금
			Iterator<Account> itr = accHashSet.iterator();
			while(itr.hasNext()) {
				Account account = itr.next();
				if(accountNo.compareTo(account.accountID)==0) {
					if(account.accMoney>withdraw) {
						account.accMoney -= withdraw;
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
								account.accMoney -= account.accMoney;
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
	
	//계좌정보 출력 (컬렉션을 활용한 확장for문)
	public void showAccInfo() {
		for(Account acc : accHashSet) {
			acc.showAccInfo();
		}
		System.out.println("==전체 정보가 출력되었습니다.==");
	}
	
	
	//계좌정보 직렬화
	public void saveAccInfo() {
		try {
			//인스턴스를 파일에 저장하기 위해 출력스트림 생성
			ObjectOutputStream out =
					new ObjectOutputStream(
							new FileOutputStream("src/project2/AccountInfo.obj"));
			
			for(Account acc : accHashSet) {
				out.writeObject(acc);
			}
			out.close();
		}
		catch (Exception e) {
			System.out.println("계좌 정보 파일 저장시 예외 발생");
		}
	}
	
	//복원(역직렬화)을 위한 스트림 생성
	public void readAccInfo() {
		try {
			ObjectInputStream in = 
					new ObjectInputStream(
						new FileInputStream("src/project2/AccountInfo.obj"));
			
			//데이터 복원
			while(true) {
				Account acc = (Account)in.readObject();
				//읽어와서 다시 컬렉션에 저장
				accHashSet.add(acc);
				if(acc ==null) break;
			}
			in.close();
		}
		catch (Exception e) {
			System.out.println("더이상 불러올 계좌가 없습니다.");
		}
		System.out.println("계좌 정보 복원 완료");
	}
	
	
	
	//자동저장 on / off
	public void autoSave(AutoSaverT autoThread) {
		System.out.println("┌───────자동저장옵션선택──────┐");
		System.out.println("│ 1.자동저장on  2.자동저장off │");
		System.out.println("└─────────────────────────────┘");
		int autoselec = scanner.nextInt();
		scanner.nextLine();
		
		//자동저장on
		if(autoselec == 1) {
			if(autoThread.isAlive()) {
				System.out.println("이미 자동저장이 실행중입니다.");
			}
			else {
				//독립쓰레드를 종속쓰레드로 만듦
				autoThread.setDaemon(true);
				//쓰레드 실행
				autoThread.start();
				System.out.println("자동 저장을 실행합니다.");
			}
		}
		
		//자동저장off
		else if(autoselec ==2) {
			if(autoThread.isAlive()) {
				autoThread.interrupt();
				System.out.println("자동 저장이 중지되었습니다.");
			}
		}
	}
	
	
	public void autoSaveFile() {
		try
		{
			PrintWriter out = new PrintWriter(
					new FileWriter("src/project2/AutoSaveAccount.txt"));
			
			for(Account acc: accHashSet) {
				if(acc instanceof HighCreditAccount) {
					out.printf("계좌번호:%s, 예금주:%s, 잔고:%d, 이율:%d, 신용등급:%s",
							((HighCreditAccount)acc).accountID, 
							((HighCreditAccount)acc).customName,
							((HighCreditAccount)acc).accMoney,
							((HighCreditAccount)acc).rate,
							((HighCreditAccount)acc).grade);
					out.println();
				}
				else if(acc instanceof NormalAccount) {
					out.printf("계좌번호:%s, 예금주:%s, 잔고:%d, 이율:%d",
							((NormalAccount)acc).accountID, 
							((NormalAccount)acc).customName,
							((NormalAccount)acc).accMoney,
							((NormalAccount)acc).rate);
					out.println();
				}
			}
			out.close();
			
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		
		
	}
}

//예외클래스) 숫자가 입력되지 않은 경우
class NgtNumberException extends Exception {
	public NgtNumberException() {
		super("[오류발생] 올바른 금액을 입력해주세요.");
	}
} 

//예외클래스) 금액 단위가 올바르지 않은 경우
class ErrMoneyException extends Exception {
	public ErrMoneyException() {
		super("[오류발생] 올바른 금액단위를 입력해주세요.");
	}
}