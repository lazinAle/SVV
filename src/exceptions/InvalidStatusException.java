package exceptions;

public class InvalidStatusException extends Exception{

	private static final long serialVersionUID = 1L;

	public InvalidStatusException() {
		super("Invalid Status");
	}
}
