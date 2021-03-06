package Multithreading;

public class MultithreadingFinal {

	public static void main(String[] args) throws InterruptedException {
	
		Thread t1 = new Thread(() ->
		
		{
			for(int i=0;i<5;i++) {
				System.out.println("Hi " + Thread.currentThread().getPriority());
				try { Thread.sleep(1000);}catch (Exception e) {}
			}
		}, "Hi-Thread");
		
		Thread t2 = new Thread(() ->
		
		{
			for(int i=0;i<5;i++) {
				System.out.println("Hello " + Thread.currentThread().getPriority());
				try {Thread.sleep(1000);}catch(Exception e) {}
			}
		}, "Hello-Thread");
		
		System.out.println(t1.getName());
		System.out.println(t2.getName());
		
		t1.setPriority(Thread.MIN_PRIORITY);
		t2.setPriority(Thread.MAX_PRIORITY);
		
		System.out.println("t1-priority:"+t1.getPriority());
		System.out.println("t2-priority:"+t2.getPriority());
		
		t1.start();
		try {Thread.sleep(100);}catch(Exception e) {}
		t2.start();

		t1.join();
		t2.join();
		System.out.println("End");
	}

}
