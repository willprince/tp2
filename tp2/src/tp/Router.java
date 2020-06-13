package tp;
import java.util.*;

public class Router{
	
	//router config
	String name;
	int sendPort;
	int receivePort;
	
	int num;
	boolean valueSet = false;
	
	public Router(String name, int receivePort, int sendPort) {
		this.name = name;
		this.receivePort = receivePort;
		this.sendPort = sendPort;
	}
	
	public synchronized void put(int num) {
		
		while(this.valueSet) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("ROUTER_" + this.name + " Receiving: " + num);
		this.num = num;
		
		this.valueSet = true;
		notify(); //Notify Sender that data is ready for it to send
	}
	//Send will have to get the data it has to send
	public synchronized void get() {
		while(!valueSet) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("ROUTER_" + this.name + " is Sending: " + this.num);
		this.valueSet = false;
		notify(); //Notify Receiver that we got the data
	}
	
//	Thread receiver;
//	Thread sender;
	
//	public Router(String _name, int _sendPort, int _receivePort) {
//		name = _name;
//		sendPort = _sendPort;
//		receivePort = _receivePort;
//		
//		receiver = new Thread(new Receiver(name));
//		sender = new Thread(new Sender(name));
//
//	}
	
	
	
}
