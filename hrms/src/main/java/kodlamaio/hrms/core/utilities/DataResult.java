package kodlamaio.hrms.core.utilities;

public class DataResult<T> extends Result{
	
	private T data;

	public DataResult(T data,boolean success, String message) {
		super(success, message);
		// base sınıfının constructor'larını çağırır.
		this.data = data;
	}
	
	public DataResult(T data,boolean success) {
		super(success);
		// base sınıfının constructor'larını çağırır.
		this.data = data;
	}
	
	public T getData() {
		return this.data;
	}
}
