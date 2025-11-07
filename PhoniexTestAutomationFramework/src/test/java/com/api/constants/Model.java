package com.api.constants;

public enum Model {
Nexus_2_BLUE(1) , GALAXY(2);
	
	int code;
	
	 Model(int code) {
		this.code=code;
	}
	 
	 public int getCode() {
		 return code;
	 }
}
