package project2;

import java.util.Scanner;
import project2.ver05.Account;
import project2.ver05.MenuChoice;

public class BankingSystemVer05
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		Account account = new Account();
		
		while(true) {
			MenuChoice.showMenu();
			
			int choice = scanner.nextInt();
			
			switch(choice) {
			case MenuChoice.MAKE:
				account.makeAccount();
				break;
			case MenuChoice.DEPOSIT:
				account.depositMoney();
				break;
			case MenuChoice.WITHDRAW:
				account.withdrawMoney();
				break;
			case MenuChoice.INQUIRE:
				account.showAccInfo();
				break;
			case MenuChoice.EXIT:
				account.close();
				System.out.println("프로그램종료");
				return;
			}
		}
	}
}
