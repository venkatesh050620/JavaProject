package customexception;

public class InvalidChoiceExeception extends RuntimeException{
	private String message;
	public InvalidChoiceExeception(String message) {
		this.message = message;
	}
	@Override
	public String getMessage() {
		return message;
	}

}
