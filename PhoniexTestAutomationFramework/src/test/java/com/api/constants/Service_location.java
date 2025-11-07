package com.api.constants;

public enum Service_location {
SERVICE_LOCATION_A(1),
SERVICE_LOCATION_B(2);

int code;
	
	Service_location(int code){
		this.code=code;
	}
	
	public int getcode() {
		return code;
	}
	
}
