package javaapp6;

import java.util.Random;

public class Javaapp6 {
	
	
	
	public static void main(String[] args) throws InterruptedException {
		
		int [] array = new int[ThreadSumConsts.ARRAY_SIZE];
		Random rnd = new Random();
		for (int i = 0; i< ThreadSumConsts.ARRAY_SIZE; i++) {
			array[i]=rnd.nextInt(10);
		}
		
		int checkSum;
		long t1 = System.currentTimeMillis();
		checkSum = countArraySum(array);
		long t2 = System.currentTimeMillis();
		
		int [] results = new int[ThreadSumConsts.THREADS_NUMBER];
		Thread [] threads = new Thread[ThreadSumConsts.THREADS_NUMBER];
		for (int i=0; i<ThreadSumConsts.THREADS_NUMBER; i++ ) {
			threads[i] = new ThreadSum(results,array,i,ThreadSumConsts.THREADS_NUMBER);
		}
		
		long t3 = System.currentTimeMillis();
		for (int i=0;i<ThreadSumConsts.THREADS_NUMBER;i++) {
			threads[i].start();
		}
		for (int i=0;i<ThreadSumConsts.THREADS_NUMBER;i++) {
			threads[i].join();
		}
		int finalSum = countArraySum(results);
		long t4 = System.currentTimeMillis();
		
		System.out.println("check sum = "+checkSum +" t " + (t2-t1));
		System.out.println("threads sum = "+ finalSum +" t "+ (t4-t3) );
		
	}

	private static int countArraySum(int[] array) {
		int s = 0;
		for (int i = 0; i<array.length; i++) {
			s+=array[i];
		}
		return s;
		
	}
	
	
}
