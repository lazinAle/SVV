package exceptions;

public class InvalidReqException extends Exception{

	private static final long serialVersionUID = 1L;

	public InvalidReqException() {
		super("Invalid Request...");
	}
}
