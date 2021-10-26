package project2.ver01;

public class HighCreditAccount extends Account
{
	
	public HighCreditAccount(String accountID, String customName, int accMoney, 
			int rate, String grade)
	{
		super(accountID, customName, accMoney, rate);
		this.grade = grade;
	}
	

	@Override
	public void interest()
	{
		if(grade =="A") 
			this.rate = (rate+7)/100;
		else if(grade =="B") 
			this.rate = (rate+4)/100;
		else if(grade =="C") 
			this.rate = (rate+2)/100;
	}
	
	
	
	@Override
	public void showAccInfo() {
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println(" 계좌번호: "+ getAccountID());
		System.out.println(" 예금주: "+ getCustomName());
		System.out.println(" 잔고: "+ getAccMoney());
		System.out.println(" 기본이율: "+ getRate()+"%");
		System.out.println(" 신용등급: "+ grade);
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━┛");
	}
}
