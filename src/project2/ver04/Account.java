package project2.ver04;

import java.io.Serializable;
import java.util.HashSet;

public abstract class Account implements Serializable
{
	public String accountID; //계좌번호
	public String customName; //고객이름
	public int accMoney; //잔고
	
	public Account(HashSet<Account> accHashSet)
	{
	}
	
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
	
	@Override
	public int hashCode()
	{
		int idHCode = this.accountID.hashCode();
		return idHCode;
	}
	
	@Override
	public boolean equals(Object obj)
	{
		Account account = (Account)obj;
		if(this.accountID.equals(account.accountID)) {
			return true;
		}
		else
			return false;
	}
	
	
}
