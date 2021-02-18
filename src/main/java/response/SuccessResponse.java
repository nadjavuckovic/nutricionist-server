package response;


public class SuccessResponse {

	private boolean success;
	private String errorCode;
	private String errorMessage;

	public SuccessResponse() {
	}

	public SuccessResponse(boolean success) {
		this.success = success;
	}

	public SuccessResponse(boolean success, String errorCode, String errorMessage) {
		this.success = success;
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
