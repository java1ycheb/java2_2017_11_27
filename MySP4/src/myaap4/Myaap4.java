package myaap4;

public class Myaap4{
	public static void main(String[] args) throws InterruptedException {
	
		Test test = new Test();
		Runnable runner1= new Runnable() {
			
			@Override	
			public void run() {
			for (int i=0; i<10; i++) {
				System.out.println(Thread.currentThread().getName());
				test.increment();
				}
			}
			
			
		};
		Monitor m = new Monitor();
		
		Runnable runner2= new Runnable() {
			@Override	
			public void run() {
				for (int i=0;i<10;i++) {
					synchronized(m) {
						m.x++;
					}
				}
				
				
			}
		};
			
		Thread [] threads = new Thread[3] ;
		for (int i=0; i<3; i++) {
			threads[i] = new Thread(runner2, "Adder - " + (i+1));
			threads[i].start();
			
		}
		
		for (int i=0; i<3;i++) {
			threads[i].join();
			
		}
		
		System.out.println(test.getX());
		System.out.println(m.x);
	}

}
class Test {
	
	private int  x;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}
	
	public synchronized void increment() {
		x++;
	}
}	
class Monitor {
	public int x;
}

