package com.zabuza.zabuza;

public class Particular {
	
	private String sno="";
	private String particular="";
	private String charge="";
		
	public Particular() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Particular(String sno, String particular, String charge) {
		super();
		this.sno = sno;
		this.particular = particular;
		this.charge = charge;
	}
	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		this.sno = sno;
	}
	public String getParticular() {
		return particular;
	}
	public void setParticular(String particular) {
		this.particular = particular;
	}
	public String getCharge() {
		return charge;
	}
	public void setCharge(String charge) {
		this.charge = charge;
	}
	
	

}
