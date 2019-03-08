package HomeWork;

public class OutOfIntegerRangeException extends Exception{
	private String details;
	
	public OutOfIntegerRangeException(String details)
	{
		this.details = details;
	}
	
	public String getMessage()
	{
		return details;
	}

}
