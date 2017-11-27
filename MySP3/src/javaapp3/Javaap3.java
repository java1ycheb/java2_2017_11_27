package javaapp3;

public class Javaap3 {
	public static void main(String[] args) {
		GlobalData.value = 0;
		Counter th1 = new Counter (0,1000);
		Counter th2 = new Counter (0,1000);
		
		th1.join();
		th2.join();
		
		System.out.println("global counter in main = " + GlobalData.value);
		System.out.println("global atomic counter = " + GlobalData.aValue.get());
	}
	
}
