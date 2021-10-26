package project2.ver02;

public class HighCreditAccount extends Account
{
	
	public HighCreditAccount(String accountID, String customName, int accMoney, 
			int rate, String grade)
	{
		super(accountID, customName, accMoney, rate);
		this.grade = grade;
	}
	
	
	@Override
	public void deposit(int deposit)
	{
		if(grade =="A") 
			rate = (rate+7);
		else if(grade =="B") 
			rate = (rate+4);
		else if(grade =="C") 
			rate = (rate+2);
			
		accMoney = accMoney + (accMoney*rate/100) + deposit;
	}
	
	
	@Override
	public void showAccInfo() {
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println(" 계좌번호: "+ accountID);
		System.out.println(" 예금주: "+ customName);
		System.out.println(" 잔고: "+ accMoney);
		System.out.println(" 기본이율: "+ rate+"%");
		System.out.println(" 신용등급: "+ grade);
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━┛");
	}
}
