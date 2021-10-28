package project2.ver05;

public interface MenuChoice
{
	int MAKE =1;
	int DEPOSIT=2;
	int WITHDRAW=3;
	int INQUIRE=4;
	int EXIT=5;
	
	public static void showMenu() {
		System.out.println("메뉴를 선택하세요.");
		System.out.println("┌─────────────Menu───────────────┐");
		System.out.println("│1.계좌개설  2.입 금  3.출 금    │");
		System.out.println("│4.계좌정보출력    5.프로그램종료│");
		System.out.println("└────────────────────────────────┘");
	}
}
