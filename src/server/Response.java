package server;

public class Response {

	private Request request;
	
	public Response(Request request) {
		this.request = request;
	}

	public Request getRequest() {
		return request;
	}

	public void setRequest(Request request) {
		this.request = request;
	}

	public void getResponse() {
		System.out.println("This is a response");
	}
}
