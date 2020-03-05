package se.rezaul.PointOfSale;


public class ResponseObject {
	int status;
    String message;
    Object result;
    
    public ResponseObject(int status, String message , Object result) {
    	this.status = status;
    	this.message = message;
    	this.result = result;
    }
    
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getResult() {
		return result;
	}
	public void setResult(Object result) {
		this.result = result;
	}
	
	@Override
	public String toString() {
		return "Alien [status=" + status + ", message=" + message + ", data=" + result + "]";
	}
}
