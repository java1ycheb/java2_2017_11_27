package javaapp6;

public class ThreadSum extends Thread {
	private int [] res;
	private final int [] data;
	private final int pos;
	private final int step;
	
	
		
	public ThreadSum(int[] res, int[] data, int pos, int step) {
		super();
		this.res = res;
		this.data = data;
		this.pos = pos;
		this.step = step;
	}



		@Override
	    public void run() {
			
			res[pos] = 0;
			for (int i =pos; i< ThreadSumConsts.ARRAY_SIZE; i+=step) {
				res[pos]  += data[i];
			}
			
			
			
		}
		
	}
	
	
	

