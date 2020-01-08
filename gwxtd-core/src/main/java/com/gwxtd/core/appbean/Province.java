package com.gwxtd.core.appbean;

public class Province {
	private String PROVINCE_CODE;
	private String PROVINCE_NAME;
	
	public Province() {
		super();
	}
	public Province(String pROVINCE_CODE, String pROVINCE_NAME) {
		super();
		PROVINCE_CODE = pROVINCE_CODE;
		PROVINCE_NAME = pROVINCE_NAME;
	}

	public String getPROVINCE_CODE() {
		return PROVINCE_CODE;
	}
	public void setPROVINCE_CODE(String pROVINCE_CODE) {
		PROVINCE_CODE = pROVINCE_CODE;
	}
	public String getPROVINCE_NAME() {
		return PROVINCE_NAME;
	}
	public void setPROVINCE_NAME(String pROVINCE_NAME) {
		PROVINCE_NAME = pROVINCE_NAME;
	}
	
}
