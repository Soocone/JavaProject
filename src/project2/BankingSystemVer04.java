package project2;

import java.util.InputMismatchException;
import java.util.Scanner;
import project2.ver04.AccountManager;
import project2.ver04.AutoSaverT;
import project2.ver04.MenuChoice;

public class BankingSystemVer04
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		AccountManager accountManager = new AccountManager();
		AutoSaverT autoSaver = null;
		
		while(true) {
			try{
				MenuChoice.showMenu();
				
				int choice = scanner.nextInt();
				if(choice<1 || choice>6) {
					NumErrException ex = new NumErrException();
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
				case MenuChoice.AUTOSAVE:
					if(autoSaver==null || (!autoSaver.isAlive())) {
						autoSaver = new AutoSaverT(accountManager);}
					accountManager.autoSave(autoSaver);
					break;
				case MenuChoice.EXIT:
					accountManager.saveAccInfo();
					System.out.println("프로그램을 종료합니다.");
					return;
				}
			}
			catch (InputMismatchException e) {
				scanner.nextLine();
				System.out.println("[오류발생] 올바른 메뉴를 선택해주세요.");
			}
			catch (NumErrException e) {
				System.out.println(e.getMessage());
			}
			catch(NullPointerException e) {
				
			}
		}
	}
}
class NumErrException extends Exception {
	public NumErrException() {
		super("[오류발생] 올바른 숫자를 입력해주세요.");
	}
}
