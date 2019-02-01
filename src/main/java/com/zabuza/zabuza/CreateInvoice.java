package com.zabuza.zabuza;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

public class CreateInvoice {
	
	
	 public static void createInvoice( Invoice invoice ) throws Exception
	    {
	    	System.out.println(1);
	    	//XWPFDocument doc = new XWPFDocument(OPCPackage.open("C:\\Users\\Sumit\\Desktop\\AshiTemplate.docx"));
	    	XWPFDocument doc = new XWPFDocument(OPCPackage.open("template\\AshiTemplate.docx"));
	    	
	    	doc = Util.replace(doc,"<name>",invoice.getName());
	    	doc = Util.replace(doc,"<state>",Util.returnCaps(invoice.getState()));
	     	doc = Util.replace(doc,"addr",invoice.getAddress1());
	    	doc = Util.replace(doc,"adressline3",Util.returnCaps(invoice.getAddress3()));
	     	doc = Util.replace(doc,"add2r",invoice.getAddress2());
	     	doc = Util.replace(doc,"<invoice date>",invoice.getInvoideDate());
	     	doc = Util.replace(doc,"<from>",invoice.getFrom());
	     	doc = Util.replace(doc,"todate",invoice.getTo());
	     	
	    	doc = Util.replace(doc,"gstno",invoice.getGstNo());    
	    	
	    	Particular temp[] = invoice.getParticular();
	    	
	    	for(int i=0;i<8;i++)
	    	{
	    		doc = Util.replace(doc,"<serial"+(i+1)+">",temp[i].getSno());
		    	doc = Util.replace(doc,"<particuar"+(i+1)+">",temp[i].getParticular());
		       	doc = Util.replace(doc,"<charges"+(i+1)+">",temp[i].getCharge());
	    		
	    	}     	
	       	
	    	//doc = Util.replace(doc,"rupee",Util.convert((int)Util.round(invoice.getGrandTotal()))+" only");
	    	doc = Util.replace(doc,"rupee",Util.decimal(invoice.getGrandTotal())+" only");	    
	    	//doc = Util.replace(doc,"gtotal",Double.toString(invoice.getGrandTotal()));
	    	doc = Util.replace(doc,"gtotal",Double.toString(Util.round(invoice.getGrandTotal()*100)/100));
	    	doc = Util.replace(doc,"igst","0");
	    	doc = Util.replace(doc,"sc",invoice.getStateCode());
	    	doc = Util.replace(doc,"sgst",Double.toString(invoice.getSgst()));
	    	doc = Util.replace(doc,"all",Double.toString(invoice.getTotal())); 
	    	doc = Util.replace(doc,"<invoice number>",invoice.getInvoiceNo());
	    	doc = Util.replace(doc,"cgst",Double.toString(invoice.getCgst()));
	        		    	
	    	try {
	    		//doc.write(new FileOutputStream("C:\\Users\\Sumit\\Desktop\\"+invoice.getInvoiceNo()+".docx"));
	    		doc.write(new FileOutputStream("Invoice\\"+invoice.getInvoiceNo()+".docx"));
	    	}catch(Exception e)
	    	{
	    	doc.write(new FileOutputStream("C:\\Users\\Sumit\\Desktop\\IrtNVOICE_DSCfgd.docx"));
	    	}
	    }
}
