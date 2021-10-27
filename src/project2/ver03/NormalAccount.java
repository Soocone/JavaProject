package project2.ver03;

public class NormalAccount extends Account
{
	public int rate; //이율
	
	public NormalAccount(String accountID, String customName, int accMoney)
	{
		super(accountID, customName, accMoney);
	}
	
	
	public NormalAccount(String accountID, String customName, int accMoney, int rate)
	{
		super(accountID, customName, accMoney);
		this.rate = rate;
	}
	
	@Override
	public void deposit(int deposit)
	{
		accMoney = accMoney + (accMoney*rate/100) + deposit;
	}
	
	
	@Override
	public void showAccInfo() {
		super.showAccInfo();
		System.out.println(" 기본이율: "+ rate+"%");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━┛");
	}
}
