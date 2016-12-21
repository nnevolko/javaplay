// why do you want to create a custom exception
// name of the exception points to what is wrong, it will be helpful for handling in code and debugging
// if you throw the right exception.. maybe they can handle it
public class NikaException extends Exception {

	public NikaException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NikaException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public NikaException(String message, Throwable cause) {
		super(message, cause);
		// this is chaining, calling constructor //read chapter
		//cause.getCause()//
	}

	public NikaException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public NikaException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	// have to implement a constructor because otherwise you cannot customize it, cannot pass a 
	// custom message to the exception
	// 4 exception constructions


}
