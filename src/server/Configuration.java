package server;

import exceptions.InvalidPathException;
import exceptions.InvalidPortNumberException;

public class Configuration {
		private String path;
		private int portNumber;
		
		public Configuration() {
			this.path = "C:\\Users\\lazin\\OneDrive\\Desktop\\SVV - project";
			this.portNumber = 123;
		}
		
		public Configuration(String path, int portNo) throws InvalidPortNumberException, InvalidPathException{
			if(path == null || path.isEmpty()) {
				throw new InvalidPathException();
			}
			else {
				this.path = path;
			}
			if(portNo < 0 || portNo > 65535) {
				throw new InvalidPortNumberException();
			}else {
				this.portNumber = portNo;
			}
		}
		
		public int getPortNumber() {
			return this.portNumber;
		}
		
		public String getPath() {
			return this.path;
		}
		
		public void setPortNumber(int port) throws InvalidPortNumberException {
			if(port < 0 || port > 65535) {
				throw new InvalidPortNumberException();
			}
			else {
				this.portNumber = port;
			}
		}
		
		
		public void setPath(String path) throws InvalidPathException{
			if(path == null || path.isEmpty()) {
				throw new InvalidPathException();
			}
			else {
				this.path = path;
			}
		}
		
}
