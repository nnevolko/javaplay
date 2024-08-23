
public enum TransactionStatus {
	PROCESSING("Processing"), PENDING("Pending"), CANCELLED("Cancelled"), COMPLETED("Completed");
	private String name;
	
	private TransactionStatus(String name){
		this.name  = name;
	}
	public String toString(){
		return this.name;
	}

}
