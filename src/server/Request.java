package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import exceptions.InvalidReqException;

public class Request {
    private String requestType;
    private String path;
    
    public String getRequestType() {
		return this.requestType;
	}
    
    public String getRequestPath() {
		return this.path;
	}
    
    public void setRequestPath(String path) {
    	this.path = path;
    }

    public Request(InputStream inputStream) throws IOException, InvalidReqException {
        BufferedReader bufferReader = new BufferedReader(new InputStreamReader(inputStream));
        String tmp = bufferReader.readLine();
        if(tmp != null) {
        	parseRequest(tmp);
        }
    }

    public void parseRequest(String request) throws InvalidReqException {
    	String[] split = request.split("\\s+");
        try {
        	requestType = split[0];
        } catch (Exception e) {
        	requestType = null;
        	throw new InvalidReqException();
        }
        path = split[1];
    }
}