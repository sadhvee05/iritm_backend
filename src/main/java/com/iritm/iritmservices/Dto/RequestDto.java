package com.iritm.iritmservices.Dto;

public class RequestDto {
	
	private Long id;
	private int data;
	private String zncd;

	public String getZncd() {
		return zncd;
	}

	public void setZncd(String zncd) {
		this.zncd = zncd;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


}
