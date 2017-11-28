package myapp5;

public class Myapp5 {
	public static void main(String[] args) throws InterruptedException {
		Monitor m = new Monitor();
		
		Thread th1 = new Thread(new Runnable() {
			@Override	
			public void run() {
				for (int i=0;i<100;i++) {
					System.out.println(Thread.currentThread().getName()+" "+ i);
					synchronized(m) {
						m.x++;
						m.notify();
					}
				}
			}
		},"First");
		
		Thread th2 = new Thread(new Runnable() {
			@Override	
			public void run() {
				synchronized(m) {
					while(m.x<50) {
						try {
							m.wait();
						} catch (InterruptedException e) {
							System.out.println(e.getMessage());
						}
					}
				}
				for (int i=0;i<100;i++) {
					System.out.println(Thread.currentThread().getName()+" "+ i);
					synchronized(m) {
						m.x++;
					}
				}
			}	
		},"Second");
		
		
		th1.start();	
		th2.start();	
		
		th1.join();
		th2.join();
		
		System.out.println("x = " + m.x);
		
		
		
	}
}

class Monitor{
	public volatile int x;
}