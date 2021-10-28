package project2.ver04;


public class AutoSaverT extends Thread
{	
	AccountManager mgr;
	
	public AutoSaverT(AccountManager mgr) {
		this.mgr = mgr;
	}
	
	
	@Override
	public void run()
	{
		while(true) {
			try {
				mgr.autoSaveFile();
				sleep(5000); //5초 동안 블럭상태로 전환
				System.out.println("자동 저장...(5초)");
			}
			catch(InterruptedException e) {
				break;
			} 
		}
	}

}
