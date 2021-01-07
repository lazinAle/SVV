package server;

import java.net.Socket;

public class ReqHandler implements Runnable{
		private Socket socket;
		
		public ReqHandler(Socket socket) {
	        this.socket = socket;
	    }
		
		public void run() {
	        try {
	            Request request = new Request(socket.getInputStream());
	            socket.close();
	        } catch (Exception e) {
	        	System.err.println("Error at Request Handling: " + e);
				System.exit(1);
	        }
	    }
	}
