package exceptions;

public class InvalidPathException extends ConfigurationException {
	
	private static final long serialVersionUID = 1L;
	
	public InvalidPathException() {
		super("Invalid Path");
	}
}