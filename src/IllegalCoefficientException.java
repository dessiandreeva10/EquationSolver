public class IllegalCoefficientException extends IllegalArgumentException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public IllegalCoefficientException(){
		super();
	}
	  
	public String getMessage(){
		return "Wrong value entered! First coefficient cannot be 0!Enter another value or try with linear equation instead!";
	}
}
