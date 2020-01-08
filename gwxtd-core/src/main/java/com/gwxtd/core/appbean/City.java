package com.gwxtd.core.appbean;

public class City {
	private String CITY_CODE;
	private String CITY_NAME;
	public City() {
		super();
	}
	public City(String cITY_CODE, String cITY_NAME) {
		super();
		CITY_CODE = cITY_CODE;
		CITY_NAME = cITY_NAME;
	}
	public String getCITY_CODE() {
		return CITY_CODE;
	}
	public void setCITY_CODE(String cITY_CODE) {
		CITY_CODE = cITY_CODE;
	}
	public String getCITY_NAME() {
		return CITY_NAME;
	}
	public void setCITY_NAME(String cITY_NAME) {
		CITY_NAME = cITY_NAME;
	}
	
}
