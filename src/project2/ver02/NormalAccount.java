package project2.ver02;

public class NormalAccount extends Account
{
	public NormalAccount(String accountID, String customName, int accMoney, int rate)
	{
		super(accountID, customName, accMoney, rate);
	}
	
	@Override
	public void deposit(int deposit)
	{
		accMoney = accMoney + (accMoney*rate/100) + deposit;
	}
	
	
	
	@Override
	public void showAccInfo() {
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println(" 계좌번호: "+ accountID);
		System.out.println(" 예금주: "+ customName);
		System.out.println(" 잔고: "+ accMoney);
		System.out.println(" 기본이율: "+ rate+"%");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━┛");
	}
}
