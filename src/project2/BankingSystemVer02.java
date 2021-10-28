package project2;

import java.util.Scanner;
import project2.ver02.AccountManager;
import project2.ver02.MenuChoice;

public class BankingSystemVer02 
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		AccountManager accountManager = new AccountManager(50);
		
		while(true) {
			MenuChoice.showMenu();
			
			int choice = scanner.nextInt();
			
			switch(choice) {
			case MenuChoice.MAKE:
				scanner.nextLine();
				System.out.println("┌------신규개설계좌선택------┐");
				System.out.println("│ 1.보통계좌  2.신용신뢰계좌 │");
				System.out.println("└----------------------------┘");
				int select = scanner.nextInt();
				scanner.nextLine();
				accountManager.makeAccount(select);
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
	}
}
