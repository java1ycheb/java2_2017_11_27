package javaapp2;

public class Javaaap2 {
	public static void main(String[] args) throws InterruptedException {
		CancelDemo th = new CancelDemo(0,"CancelDemo");
		th.start();
		th.join(1000);
		th.stop();
		//th.interrupt();
		System.out.println("end of main");
	}

}

