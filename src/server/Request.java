package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import exceptions.InvalidReqException;

public class Request {
    private String requestType = null;
    private String path = "";
    
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
        String data = bufferReader.readLine();
        splitRequest(data);
        
    }

    public void splitRequest(String data) throws InvalidReqException {
    	String[] splited = data.split("\\");
        try {
        	requestType = splited[0];
        } catch (Exception e) {
        	throw new InvalidReqException();
        }
        if(splited.length > 0) {
        	path = splited[1];
        } else {
        	path = splited[0];
        }
    }
}