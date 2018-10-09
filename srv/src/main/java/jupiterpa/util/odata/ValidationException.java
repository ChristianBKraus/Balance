package jupiterpa.util.odata;

public class ValidationException extends Exception {
	private static final long serialVersionUID = 1L; 
	
	private String[] parameter;
	
	public ValidationException(String... message) {
		super(message[0]);
		int length = message.length - 1;
		this.parameter = new String[length];
		for (int i = 0; i < length; i++) {
			this.parameter[i] = message[i+1];
		}
	}
	public String[] getParameter() {
		return parameter;
	}

}
