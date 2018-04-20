package yhy.study.Banking;

public class OverdraftException extends Exception{
	private double deficit;
	public double getDeficit() {
		return deficit;
	}
	
	public OverdraftException(String message,double deficit) {
		super();
		this.deficit = deficit;
	}
	
	
}
