package javaapp2;

public class CancelDemo implements Runnable {
	private Thread thread;
	private int data;
	private volatile boolean canWork = true;
	
	public CancelDemo ( int data, String name) {
		this.data = data;
		thread = new Thread (this,name);
		
	}
	public void start() {
		thread.start();
	}
	
	public void interrupt() {
		thread.interrupt();
	}
	
	public void stop() {
		canWork=false;
		
	}
	public void join(int millisec) throws InterruptedException {
		thread.join(millisec);
	}
	
	@Override	
	public void run() {
	//	while(true) {
	//	data++;
	//	System.out.println("Current data = " + data);
	//	try {
	//		Thread.sleep(1000);
	//	} catch (InterruptedException e) {
	//		e.printStackTrace();
	//		break;
	//		}
	//	}
		while(canWork) {
			data++;
			System.out.println("Current data = " + data);
		}
	}
}
