package com.rushi.project.exception;


public enum Errorcode {

DATA_NOT_FOUND("001","data is not avaible in database"),INVALIDE_ID("002","Requesting id not presenr in data base");
	
	
	private final String code;
	private final String message;
	
	Errorcode(String code,String message){
		this.code=code;
		this.message=message;
	}

	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}
	
	
}
