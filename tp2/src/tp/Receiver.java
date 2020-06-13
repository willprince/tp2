package tp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Receiver implements Runnable{
	
	Router router;
	byte[] receive = new byte[65535];
	DatagramPacket receivedPacket = new DatagramPacket(receive, receive.length);
	
	public Receiver(Router router) 
	{
		this.router = router;
		Thread thread = new Thread(this,"Receiver");
		thread.start();
	}

	@Override
	public void run() 
	{
		DatagramSocket Socket;
		try {
			Socket = new DatagramSocket(this.router.receivePort);
			while(true) 	
			{
				System.out.println("ROUTER_" + this.router.name + " is waiting to receive the LSP");

				Socket.receive(receivedPacket);
				
				System.out.println("ROUTER_" + this.router.name + " received packet");
				this.router.put(1);
			} 
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

		}
		
	}


