package javaapp8;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Javaapp8 {
	
	public static void main(String[] args) throws Exception, ExecutionException {
		//ExecutorService exec = Executors.newFixedThreadPool(5);
		ExecutorService exec = Executors.newWorkStealingPool();
		ArrayList<Future<String>> results = new ArrayList<>();
		
		for (int i = 0; i<12 ; i++) {
			results.add(exec.submit(new Callable<String>() {
				
				@Override	
				public String call() throws Exception{
					Thread.sleep(500);
					System.out.println(Thread.currentThread().getName() + " - done");
					return Thread.currentThread().getName();
				}
			}));
		}
		exec.shutdown();
		for (Future<String> result : results) {
			System.out.println("end result: " + result.get());
		}
		
	}
}
