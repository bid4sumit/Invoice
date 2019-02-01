package com.zabuza.zabuza;

public class Invoice {
	
	private String name="";
	private String address1="";
	private String address2="";
	private String address3="";	
	private String gstNo="";
	private String state="";
	private String stateCode="";
	private String invoiceNo="";
	private String invoideDate="";
	private String from = "";
	private String to="";
	Particular particular[];
	private double total=0;
	private double cgst=0;
	private double sgst=0;
	private double grandTotal=0;
	
	
		
	public Invoice() {
		super();
		particular = new Particular[8];
		for(int i=0;i<8;i++)
		{
			particular[i]= new Particular();
		}
		// TODO Auto-generated constructor stub
	}	
	
	
	public Invoice(String name, String address1, String address2, String address3, String gstNo, String state,
			String stateCode, String invoiceNo, String invoideDate, String from, String to, Particular[] particular,
			int total, int cgst, int sgst, int grandTotal) {
		super();
		this.name = name;
		this.address1 = address1;
		this.address2 = address2;
		this.address3 = address3;
		this.gstNo = gstNo;
		this.state = state;
		this.stateCode = stateCode;
		this.invoiceNo = invoiceNo;
		this.invoideDate = invoideDate;
		this.from = from;
		this.to = to;
		this.particular = particular;
		this.total = total;
		this.cgst = cgst;
		this.sgst = sgst;
		this.grandTotal = grandTotal;
	}


	
	public double getTotal() {
		return total;
	}


	public void setTotal(double total) {
		this.total = total;
	}


	public double getCgst() {
		return cgst;
	}


	public void setCgst(double cgst) {
		this.cgst = cgst;
	}


	public double getSgst() {
		return sgst;
	}


	public void setSgst(double sgst) {
		this.sgst = sgst;
	}


	public double getGrandTotal() {
		return grandTotal;
	}


	public void setGrandTotal(double grandTotal) {
		this.grandTotal = grandTotal;
	}


	public void setGrandTotal(int grandTotal) {
		this.grandTotal = grandTotal;
	}
	public String getStateCode() {
		return stateCode;
	}
	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}
	public Particular[] getParticular() {
		return particular;
	}

	public void setParticular(Particular[] particular) {
		this.particular = particular;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getAddress3() {
		return address3;
	}
	public void setAddress3(String address3) {
		this.address3 = address3;
	}
	public String getGstNo() {
		return gstNo;
	}
	public void setGstNo(String gstNo) {
		this.gstNo = gstNo;
	}
	public String getInvoiceNo() {
		return invoiceNo;
	}
	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}
	public String getInvoideDate() {
		return invoideDate;
	}
	public void setInvoideDate(String invoideDate) {
		this.invoideDate = invoideDate;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
}
