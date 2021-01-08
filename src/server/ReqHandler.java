package server;

import java.net.Socket;

public class ReqHandler implements Runnable{
		private Socket socket;
		
		public ReqHandler(Socket socket) {
	        this.socket = socket;
	        run();
	    }
		
		public void run() {
	        try {
	            Request request = new Request(socket.getInputStream());
	            Response response = new Response(request);
	            response.getResponse();
	            socket.close();
	        } catch (Exception e) {
	        	System.err.println("Error at Request Handling: " + e);
				System.exit(1);
	        }
	    }
	}
