package javaaap11;

import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.scene.control.ProgressBar;
import javafx.stage.Stage;

public class Javaapp11 extends Application {
	public static void main(String[] args) throws Exception {
		Task<String> task = new MyTask();
		Thread th = new Thread(task);
		ProgressBar bar = new ProgressBar();
		bar.progressProperty().bind(task.progressProperty());
		
		th.setDaemon(true);
		th.start();
		Thread.sleep(50);
		for (int i = 0; i < 10; i++) {
			Thread.sleep(300);
			System.out.println(bar.getProgress());
		}
		//th.join();
		//System.out.println(task.get());
		System.exit(0);
		
	}

	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
}

class MyTask extends Task<String>{

	@Override
	protected String call() throws Exception {
		int i;
		 for  (i = 0; i <10; i++) {
			 updateProgress(i+1, 10);
			Thread.sleep(300);
		}
		return "Task done, i = " + i;
		
	}

	@Override
	protected void succeeded() {
		System.out.println("Task done!");
	}
	
	
}