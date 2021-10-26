package project2.ver02;

public class HighCreditAccount extends NormalAccount
{
	public int rate; //이율
	public String grade; //신용등급
	
	public HighCreditAccount(String accountID, String customName, int accMoney, 
			int rate, String grade)
	{
		super(accountID, customName, accMoney);
		this.rate = rate;
		this.grade = grade;
	}
	
	
	@Override
	public void deposit(int deposit)
	{
		if(grade =="A") 
			accMoney = accMoney + (accMoney*(rate+7)/100) + deposit;
		else if(grade =="B") 
			accMoney = accMoney + (accMoney*(rate+4)/100) + deposit;
		else if(grade =="C") 
			accMoney = accMoney + (accMoney*(rate+2)/100) + deposit;
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
