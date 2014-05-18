package lotterysystem;

public class NumberOutOfRangeException extends IllegalArgumentException {
	
	public NumberOutOfRangeException () {
		super();
	}
	
	public NumberOutOfRangeException (String s) {
		super(s);
	}
}
