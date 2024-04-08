package com.rushi.project.exception;

public class Resourcenotfoundexception extends RuntimeException{
private static final long serialVersionUID = 9101260047776044554L;
private final String code;
public Resourcenotfoundexception(String code ,String message){
super(message);	
this.code=code;
}
public String getcode() {
return code;
	}
}
