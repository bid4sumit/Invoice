package com.zabuza.zabuza;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;



public class Zabuza {
	
    public static void main( String[] args ) throws InvalidFormatException, IOException
    {
    	System.out.println(1);
    	XWPFDocument doc = new XWPFDocument(OPCPackage.open("C:\\Users\\Sumit\\Desktop\\tt.docx"));
    	
    	doc = Util.replace(doc,"<name>","Sumit");
    	doc = Util.replace(doc,"<state>","Maharashtra");
     	doc = Util.replace(doc,"addr","Address line 1");
    	doc = Util.replace(doc,"adressline3","Address line 3");
     	doc = Util.replace(doc,"add2r","Address line 2");
     	doc = Util.replace(doc,"<invoice date>","01-31-2019");
     	doc = Util.replace(doc,"<from>","01-31-2019");
     	doc = Util.replace(doc,"todate","01-31-2019");
     	
    	doc = Util.replace(doc,"gstno","121552");  	
     	     
    	doc = Util.replace(doc,"<serial1>"," 1 ");
    	doc = Util.replace(doc,"<particuar1>","product");
       	doc = Util.replace(doc,"<charges1>","100");
       	
       	doc = Util.replace(doc,"<serial2>"," 1 ");
    	doc = Util.replace(doc,"<particuar2>","product");
       	doc = Util.replace(doc,"<charges2>","100");
       	
       	doc = Util.replace(doc,"<serial3>"," 1 ");
    	doc = Util.replace(doc,"<particuar3>","product");
       	doc = Util.replace(doc,"<charges3>","100");
       	
       	doc = Util.replace(doc,"<serial4>"," 1 ");
    	doc = Util.replace(doc,"<particuar4>","product");
       	doc = Util.replace(doc,"<charges4>","100");
       	
       	doc = Util.replace(doc,"<serial5>"," 1 ");
    	doc = Util.replace(doc,"<particuar5>","product");
       	doc = Util.replace(doc,"<charges5>","100");
       	
       	doc = Util.replace(doc,"<serial6>"," 1 ");
    	doc = Util.replace(doc,"<particuar6>","product");
       	doc = Util.replace(doc,"<charges6>","100");
       	
       	doc = Util.replace(doc,"<serial7>"," 1 ");
    	doc = Util.replace(doc,"<particuar7>","product");
       	doc = Util.replace(doc,"<charges7>","100");
       	
       	doc = Util.replace(doc,"<serial8>"," 1 ");
    	doc = Util.replace(doc,"<particuar8>","product");
       	doc = Util.replace(doc,"<charges8>","100");
       	      	
       	doc = Util.replace(doc,"rupee",Util.convert(3432)+" only");
    	doc = Util.replace(doc,"gtotal","130");
    	doc = Util.replace(doc,"sc","13");
    	doc = Util.replace(doc,"igst","10");
    	doc = Util.replace(doc,"sgst","10");
    	doc = Util.replace(doc,"all","100"); 
    	doc = Util.replace(doc,"<invoice number>","100");
    	doc = Util.replace(doc,"cgst","10");  
    	   	
    	doc.write(new FileOutputStream("C:\\Users\\Sumit\\Desktop\\IrtNVOICE_DSCfgd.docx"));
 
    }

}
