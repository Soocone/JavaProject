package project2;

import java.util.Scanner;
import project2.ver01.Account;
import project2.ver01.MenuChoice;

public class BankingSystemVer01
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		Account account = new Account(50);
		
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
				account.showAllInfo();
				break;
			case MenuChoice.EXIT:
				System.out.println("프로그램종료");
				return;
			}
		}
	}
}
