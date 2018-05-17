

public class InvalidTripleException extends RuntimeException{

	public InvalidTripleException(){}

	public InvalidTripleException(String msg){
		super(msg);
	}

	public InvalidTripleException(Throwable cause){
		super(cause);
	}

	public InvalidTripleException(String msg, Throwable cause){
		super(msg, cause);	
	}
}