package project2.ver01;

public class NormalAccount extends Account
{
	public NormalAccount(String accountID, String customName, int accMoney, int rate)
	{
		super(accountID, customName, accMoney, rate);
	}
	
	
	
	@Override
	public void showAccInfo() {
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println(" 계좌번호: "+ getAccountID());
		System.out.println(" 예금주: "+ getCustomName());
		System.out.println(" 잔고: "+ getAccMoney());
		System.out.println(" 기본이율: "+ getRate()+"%");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━┛");
	}
}
