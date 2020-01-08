package com.gwxtd.core.appbean;

public class RResult {
	private boolean success;
	private String errorMsg;
	private Object result;
	
	public RResult() {
		super();
	}
	public RResult(boolean success, String errorMsg, Object result) {
		super();
		this.success = success;
		this.errorMsg = errorMsg;
		this.result = result;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	public Object getResult() {
		return result;
	}
	public void setResult(Object result) {
		this.result = result;
	}
	
}
