package com.lambda.bilan.domain;

public class BAP {

	private String periode;
	private String status;
	
	
	public BAP() {
		super();
	}
	public BAP(String periode, String status) {
		super();
		this.periode = periode;
		this.status = status;
	}
	public String getPeriode() {
		return periode;
	}
	public void setPeriode(String periode) {
		this.periode = periode;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	

}
