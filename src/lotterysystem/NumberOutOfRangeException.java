package lotterysystem;

public class NumberOutOfRangeException extends IllegalArgumentException {
	
	private static final long serialVersionUID = 1L;

	public NumberOutOfRangeException () {
		super();
	}
	
	public NumberOutOfRangeException (String s) {
		super(s);
	}
}
