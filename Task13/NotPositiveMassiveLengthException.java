package HomeWork;

public class NotPositiveMassiveLengthException extends Exception {
	private String details;
	
	public NotPositiveMassiveLengthException (String details)
	{
		this.details = details;
	}
	
	public String getMessage()
	{
		return details;
	}
}
