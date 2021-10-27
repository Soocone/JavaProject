package project2.ver04;


public class AutoSaverT extends Thread
{
	String accThread;
	AccountManager mgr;
	
	public AutoSaverT(String name, AccountManager mgr) {
		accThread = name;
		this.mgr = mgr;
	}
	
	
	@Override
	public void run()
	{
		while(true) {
			try {
				mgr.autoSaveFile(mgr);
				sleep(5000); //5초 동안 블럭상태로 전환
				System.out.println("자동 저장...(5초)");
			}
			catch(InterruptedException e) {
				System.out.println("자동 저장이 중지되었습니다.");
				break;
			} 
		}
	}

}
