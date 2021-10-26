package project2.ver01;

public class Account
{
	private String accountID; //계좌번호
	private String customName; //고객이름
	private int accMoney; //잔고
	protected int rate; //이율
	protected String grade; //신용등급
	
	public Account(String accountID, String customName, int accMoney, int rate)
	{
		this.accountID = accountID;
		this.customName = customName;
		this.accMoney = accMoney;
		this.rate = rate;
	}
	
	public void showAccInfo() {
	}
	
	public void interest() {
	}
	
	
	public String getAccountID() 
		{return accountID;}
	public void setAccountID(String accountID)
		{this.accountID = accountID;}
	public String getCustomName()
		{return customName;}
	public void setCustomName(String customName)
		{this.customName = customName;}
	public int getAccMoney()
		{return accMoney;}
	public void setAccMoney(int accMoney)
		{this.accMoney = accMoney;}
	public int getRate()
		{return rate;}
	public void setRate(int rate)
		{this.rate = rate;}
	public String getGrade()
		{return grade;}
	public void setGrade(String grade)
		{this.grade = grade;}

	
}
