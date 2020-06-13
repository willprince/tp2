package tp;

public class Sender implements Runnable{
	
	Router router;
	
	public Sender(Router router) 
	{
		this.router = router;
		Thread thread = new Thread(this,"Sender");
		thread.start();
	}

	@Override
	public void run() 
	{

		while(true) {
			router.get();
			try 
			{
				Thread.sleep(999);
			} catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
		}
		
	}

}
