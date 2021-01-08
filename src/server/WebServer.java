package server;

import java.io.IOException;
import java.net.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import exceptions.InvalidPathException;
import exceptions.InvalidPortNumberException;
import exceptions.InvalidStatusException;


public class WebServer {
	private static ServerSocket SERVERSOCKET = null;
	private static ExecutorService EXECUTOR = Executors.newFixedThreadPool(2);
	private static Configuration CONFIGURATION = new Configuration();
	private Configuration config = new Configuration();
	public static String STATUS = "STOPPED";

	public static void main(String[] args) throws Exception {
		start();
	}
	
	public int getPort1() {
		return config.getPortNumber();
	}
	
	public String getPath1() {
		return config.getPath();
	}
	
	public void setPort1(int port) throws InvalidPortNumberException {
		config.setPortNumber(port);
	}	
	
	public void setPath1(String path) throws InvalidPathException {
		config.setPath(path);
	}
	
	public static int getPort() {
		return CONFIGURATION.getPortNumber();
	}
	
	public static String getPath() {
		return CONFIGURATION.getPath();
	}
	
	public static void setPort(int port) throws InvalidPortNumberException {
		CONFIGURATION.setPortNumber(port);
	}	
	
	public static void setPath(String path) throws InvalidPathException {
		CONFIGURATION.setPath(path);
	}
	
	public static void setStatus(String status) throws InvalidStatusException {
		if(status.equals("RUNNING") || status.equals("STOPPED") || status.equals("MAINTENANCE")) {
			STATUS = status;
		}else {
			throw new InvalidStatusException();
		}
	}

	public static void start() throws Exception {
		if(!STATUS.equals("RUNNING")) {
			if(STATUS.equals("STOPPED")) {
				SERVERSOCKET = new ServerSocket(CONFIGURATION.getPortNumber());
			}
			STATUS = "RUNNING" ;			
	        while(STATUS.equals("RUNNING")) {
	        	System.out.println("Server is running...");
	        	EXECUTOR.submit(new ReqHandler(SERVERSOCKET.accept()));
	        }
		}
	}
	
	public static void stop() {
		if(!STATUS.equals("STOPPED")) {
			try {
				System.out.println("... Server stoped");
				SERVERSOCKET.close();
				STATUS = "STOPPED";
			} catch (Exception e) {
				System.err.println(e);
				System.exit(1);
			}
		}
	}
	
	public static void maintenance() throws InterruptedException, IOException {
		if(STATUS.equals("STOPPED")) {
			SERVERSOCKET = new ServerSocket(CONFIGURATION.getPortNumber());
		}
		STATUS = "MAINTENANCE";
		System.out.println("Maintenance - for 15 seconds");
	    TimeUnit.SECONDS.sleep(15);
	    System.out.println("Maintenance - done!");
	}
}
