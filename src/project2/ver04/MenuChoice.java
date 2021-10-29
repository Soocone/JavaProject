package project2.ver04;

public interface MenuChoice
{
	int MAKE =1;
	int DEPOSIT=2;
	int WITHDRAW=3;
	int INQUIRE=4;
	int AUTOSAVE=5;
	int EXIT=6;
	
	public static void showMenu() {
		System.out.println("메뉴를 선택하세요.");
		System.out.println("┌─────────────Menu─────────────────────────┐");
		System.out.println("│1.계좌개설  2.입금  3.출금  4.계좌정보출력│");
		System.out.println("│5.자동저장 옵션     6.프로그램 종료       │");
		System.out.println("└──────────────────────────────────────────┘");
	}
}
