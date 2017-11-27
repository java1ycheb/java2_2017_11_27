package javaapp3;

public class Counter implements Runnable {
	private Thread thread;
	private int counter,steps;
	public Counter(int counter,int steps){
		this.counter = counter;
		this.steps = steps;
		thread = new Thread (this);
		thread.start();
	}
	
	public void join() {
		
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override	
	public void run() {
		for (int i=0;i<steps; i++) {
			
			counter++;
			GlobalData.value++;
			GlobalData.aValue.getAndIncrement();
		}
		System.out.println("local counter = " + counter + " Global Counter = " + GlobalData.value);
	}
}
