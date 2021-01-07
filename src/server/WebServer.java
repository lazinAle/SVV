package server;

import java.net.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import exceptions.InvalidPathException;
import exceptions.InvalidPortNumberException;
import exceptions.InvalidStatusException;


public class WebServer {
	public static ServerSocket SERVERSOCKET = null;
	private static ExecutorService EXECUTOR = Executors.newFixedThreadPool(2);
	private static Configuration CONFIGURATION = new Configuration();
	public static String STATUS = "STOPPED";

	public static void main(String[] args) throws Exception {
		//uncomment and change the following lines, if necessary
		//initialize.setPath(...); 
		//initialize.setPortNumber(...); //default is 10008
		
		//uncomment the line below to test the stopServer() method
		//start();
	}
	
	public static String getPort() {
		return String.valueOf(CONFIGURATION.getPortNumber());
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
	        	EXECUTOR.submit(new ReqHandler(SERVERSOCKET.accept()));
	        }
		}
	}
	
	public static void stopServer() {
		if(!STATUS.equals("STOPPED")) {
			try {
				SERVERSOCKET.close();
				STATUS = "STOPPED";
			} catch (Exception e) {
				System.err.println("Error at STOP: " + e);
				System.exit(1);
			}
		}
	}
	
	public static void maintenance() throws Exception {
		if(!STATUS.equals("MAINTENANCE")) {
			if(STATUS.equals("STOPPED")) {
				SERVERSOCKET = new ServerSocket(CONFIGURATION.getPortNumber());
			}
			STATUS = "MAINTENANCE";
	        while(STATUS.equals("MAINTENANCE")) {
	        	EXECUTOR.submit(new ReqHandler(SERVERSOCKET.accept()));
	        }
		}
	}
}
