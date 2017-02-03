/**
 * UnknownOperatorException.java
 * @author Evan Hicks
 *Handles exceptions of unknown operator.
 */
public class UnknownOperatorException extends Exception {
	public UnknownOperatorException() {
		super("Exception: That is an unknown operator.");
	}
	public UnknownOperatorException(String message) {
		super(message);
	}
}
