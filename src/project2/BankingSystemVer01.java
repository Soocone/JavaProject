package project2;

import java.util.Scanner;
import project2.ver01.AccountManager;
import project2.ver01.MenuChoice;

public class BankingSystemVer01 implements MenuChoice
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		AccountManager accountManager = new AccountManager(50);
		
		while(true) {
			MenuChoice.showMenu();
			
			int choice = scanner.nextInt();
			
			switch(choice) {
			case MAKE:
				System.out.println("┌------신규개설계좌선택------┐");
				System.out.println("│ 1.보통계좌  2.신용신뢰계좌 │");
				System.out.println("└----------------------------┘");
				scanner.nextLine();
				int select = scanner.nextInt();
				scanner.nextLine();
				accountManager.makeAccount(select);
				break;
			case DEPOSIT:
				accountManager.depositMoney();
				break;
			case WITHDRAW:
				accountManager.withdrawMoney();
				break;
			case INQUIRE:
				accountManager.showAccInfo();
				break;
			case EXIT:
				System.out.println("프로그램종료");
				return;
			}
		}
	}
}
