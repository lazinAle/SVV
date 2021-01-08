package server;

import exceptions.InvalidPathException;
import exceptions.InvalidPortNumberException;

public class ConfigurationHandler {
	private Configuration configuration;
	
	public ConfigurationHandler() {
		this.configuration = new Configuration();
	}

	public ConfigurationHandler(Configuration config) {
		this.configuration = config;
	}
	
	public Configuration getConfiguration() {
		return this.configuration;
	}
	
	public void setConfiguration(Configuration config) {
		this.configuration = config;
	}
	
	public int getPort(){
		return configuration.getPortNumber();
	}
	
	public void setPort(int portNumber) throws InvalidPortNumberException {
		if(portNumber < 0 || portNumber > 65535) {
			throw new InvalidPortNumberException();
		}
		this.configuration.setPortNumber(portNumber);
	}
	
	public String getPath() {
		return this.configuration.getPath();
	}
	
	public void setPath(String path) throws InvalidPathException{
		if(path == null || path.isEmpty()) {
			throw new InvalidPathException();
		}
		else {
			this.configuration.setPath(path);
		}
	}
	
}
