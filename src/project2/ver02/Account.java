package project2.ver02;

public class Account
{
	public String accountID; //계좌번호
	public String customName; //고객이름
	public int accMoney; //잔고
	
	
	public Account(String accountID, String customName, int accMoney)
	{
		this.accountID = accountID;
		this.customName = customName;
		this.accMoney = accMoney;
	}
	
	public void showAccInfo() {
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println(" 계좌번호: "+ accountID);
		System.out.println(" 예금주: "+ customName);
		System.out.println(" 잔고: "+ accMoney);
	}
	
	public void deposit(int deposit) {
	}
	
}
