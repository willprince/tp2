package tp;

import java.net.UnknownHostException;

public class main {

	public static void main(String[] args) throws UnknownHostException 
	{
		int HOST_PORT = 18020;
		int MAIN_ROUTER_PORT = 19020;
		
		String msg = "Hello world";
		
		//Starting all the routers
		Router ROUTER_A = new Router("A", MAIN_ROUTER_PORT, MAIN_ROUTER_PORT + 1);new Receiver(ROUTER_A);new Sender(ROUTER_A);

		//Starting the host(sender)
		HostSender hostSender = new HostSender(msg, HOST_PORT, MAIN_ROUTER_PORT);
		
	}

}
