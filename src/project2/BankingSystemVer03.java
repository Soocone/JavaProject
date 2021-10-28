package project2;

import java.util.InputMismatchException;
import java.util.Scanner;
import project2.ver03.AccountManager;
import project2.ver03.MenuChoice;

public class BankingSystemVer03
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		AccountManager accountManager = new AccountManager(50);
		
		while(true) {
			try{
				MenuChoice.showMenu();
				
				int choice = scanner.nextInt();
				if(choice<1 || choice>5) {
					NumberException ex = new NumberException();
					throw ex;
				}
				
				switch(choice) {
				case MenuChoice.MAKE:
					accountManager.makeAccount();
					break;
				case MenuChoice.DEPOSIT:
					accountManager.depositMoney();
					break;
				case MenuChoice.WITHDRAW:
					accountManager.withdrawMoney();
					break;
				case MenuChoice.INQUIRE:
					accountManager.showAccInfo();
					break;
				case MenuChoice.EXIT:
					System.out.println("프로그램종료");
					return;
				}
			}
			catch (InputMismatchException e) {
				scanner.nextLine();
				System.out.println("[오류발생] 올바른 메뉴를 선택해주세요.");
			}
			catch (NumberException e) {
				System.out.println(e.getMessage());
			}
			
		}
		
	}
}
class NumberException extends Exception {
	public NumberException() {
		super("[오류발생] 올바른 숫자를 입력해주세요.");
	}
}
