package project2.ver02;

public class Account
{
	public String accountID; //계좌번호
	public String customName; //고객이름
	public int accMoney; //잔고
	public int rate; //이율
	public String grade; //신용등급
	
	
	public Account(String accountID, String customName, int accMoney, int rate)
	{
		this.accountID = accountID;
		this.customName = customName;
		this.accMoney = accMoney;
		this.rate = rate;
	}
	
	public void showAccInfo() {
	}
	
	public void deposit(int deposit) {
	}
	
	
}
