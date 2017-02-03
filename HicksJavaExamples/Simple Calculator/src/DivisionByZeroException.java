/**
 * DivisionByZeroException.java
 * @author Evan Hicks
 *Handles exceptions of division by zero.
 */
public class DivisionByZeroException extends Exception {
	public DivisionByZeroException() {
		super("Exception: Can not divide by zero.");
	}
	public DivisionByZeroException(String message) {
		super(message);
	}
}
