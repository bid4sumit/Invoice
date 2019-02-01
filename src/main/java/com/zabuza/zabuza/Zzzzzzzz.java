package com.zabuza.zabuza;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JSeparator;
import java.awt.Panel;
import java.awt.SystemColor;
import java.awt.Color;

public class Zzzzzzzz {

	private JFrame frame;
	private JTextField name;
	private JTextField addressline1;
	private JTextField addressline2;
	private JTextField addressline3;
	private JTextField invoideTextField;
	private JTextField invoideDateText;
	private JTextField billperiodfrom;
	private JTextField billperiodto;
	private JButton btnSubmit ;
	
	private JTextField[] serialno;
	/*
	 * private JTextField serialno[1]; private JTextField serialno[2]; private
	 * JTextField serialno[3]; private JTextField serialno[6]; private JTextField
	 * serialno[5]; private JTextField serialno[6]; private JTextField serialno[7];
	 */
	
	private JTextField[] particular;
	/*
	 * private JTextField particular[0]; private JTextField particular[1]; private
	 * JTextField particular[2]; private JTextField particular[3]; private JTextField
	 * particular[4]; private JTextField particular[5]; private JTextField particular[6];
	 * private JTextField particular[7];
	 */
	private JTextField[] charges;	
	
	/*
	 * private JTextField charges[0]; private JTextField charges[1]; private JTextField
	 * charges[2]; private JTextField charges[3]; private JTextField charges[4]; private
	 * JTextField charges[5]; private JTextField charges[6]; private JTextField
	 * charges[7];
	 */
	
	private Invoice invoice;
	
	private JLabel lblGstinNo;
	private JLabel lblState;
	private JLabel lblStatecode;
	private JTextField gstinno;
	private JTextField state;
	private JTextField statecode;
	private JPanel panel_2;
	private JLabel lblTotal;
	private JTextField total;
	private JLabel lblCgst;
	private JLabel lblSgst;
	private JLabel lblIgst;
	private JLabel lblGrandTotal;
	private JTextField gtotal;
	private JTextField igst;
	private JTextField sgst;
	private JTextField cgst;
	private JButton btnClear;
	private JButton btnCalculate;
	private JLabel lblZabuza;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Zzzzzzzz window = new Zzzzzzzz();
					window.frame.setVisible(true);
								
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Zzzzzzzz() {
		initialize();
		btnCalculate.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
				double temptotal=0;
				for(int i=0;i<8;i++)
				{
					try {
					temptotal=temptotal+Double.parseDouble(charges[i].getText());
					}catch(Exception a)
					{
						
					}
				}
				invoice.setTotal(temptotal);
				invoice.setSgst((9*temptotal)/100);
				invoice.setCgst((9*temptotal)/100);
				invoice.setGrandTotal(temptotal+2*((9*temptotal)/100));
								
				sgst.setText(Double.toString((9*temptotal)/100));
				cgst.setText(Double.toString((9*temptotal)/100));
				total.setText(Double.toString(temptotal));
				gtotal.setText(Double.toString(temptotal+2*((9*temptotal)/100)));
				
				
			}
		});
		
		btnClear.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				cleardata();
				
			}
		});
	
		btnSubmit.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				// TODO Auto-generated method stub
				String inputname = name.getText();
				invoice.setName(name.getText().toString());
				invoice.setAddress1(addressline1.getText());
				invoice.setAddress2(addressline2.getText());
				invoice.setAddress3(addressline3.getText());
				invoice.setGstNo(gstinno.getText());
				invoice.setState(state.getText());
				invoice.setStateCode(statecode.getText());
				invoice.setInvoiceNo(invoideTextField.getText());
				invoice.setInvoideDate(invoideDateText.getText());
				invoice.setFrom(billperiodfrom.getText());
				invoice.setTo(billperiodto.getText());
				
				Particular temp[]=invoice.getParticular();
				
				for(int i=0;i<8;i++)
				{
				temp[i].setSno(serialno[i].getText());
				temp[i].setParticular(particular[i].getText());
				temp[i].setCharge(charges[i].getText());		
				}
				invoice.setParticular(temp);
				
				calculate();
				
				
				try {
					CreateInvoice.createInvoice(invoice);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
	
	}

	private void calculate() {
		// TODO Auto-generated method stub		
		double temptotal=0;
		for(int i=0;i<8;i++)
		{
			try {
			temptotal=temptotal+Double.parseDouble(charges[i].getText());
			}catch(Exception a)
			{
				
			}
		}
		invoice.setTotal(temptotal);
		invoice.setSgst((9*temptotal)/100);
		invoice.setCgst((9*temptotal)/100);
		invoice.setGrandTotal(temptotal+2*((9*temptotal)/100));
						
		sgst.setText(Double.toString((9*temptotal)/100));
		cgst.setText(Double.toString((9*temptotal)/100));
		total.setText(Double.toString(temptotal));
		gtotal.setText(Double.toString(temptotal+2*((9*temptotal)/100)));	
		
	}

	private void cleardata()
	{	invoice = new Invoice();
		for(int i=0;i<8;i++)
		{
			charges[i].setText("");
			particular[i].setText("");
			serialno[i].setText("");			
		}
		name.setText("");
		addressline1.setText("");
		addressline2.setText("");
		addressline3.setText("");
		gstinno.setText("");
		state.setText("");
		statecode.setText("");
		invoideDateText.setText("");
		invoideTextField.setText("");
		billperiodfrom.setText("");
		billperiodto.setText("");
		gtotal.setText("0");
		total.setText("0");
		cgst.setText("0");
		igst.setText("0");
		sgst.setText("0");
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		invoice = new Invoice();
		
		frame = new JFrame();
				frame.setBounds(100, 100, 1000, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(830, 597, 97, 25);
		frame.getContentPane().add(btnSubmit);
		
		lblZabuza = new JLabel("ZABUZA");
		lblZabuza.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblZabuza.setBounds(387, 13, 88, 16);
		frame.getContentPane().add(lblZabuza);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 225, 982, 16);
		frame.getContentPane().add(separator);
		
		Panel panel = new Panel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(40, 247, 887, 325);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Serial No");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(32, 13, 99, 16);
		panel.add(lblNewLabel_1);
		
		JLabel lblParticulars = new JLabel("Particulars");
		lblParticulars.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblParticulars.setBounds(283, 13, 240, 16);
		panel.add(lblParticulars);
		
		JLabel lblServiceCharges = new JLabel("Service Charges");
		lblServiceCharges.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblServiceCharges.setBounds(731, 13, 126, 16);
		panel.add(lblServiceCharges);
		
		serialno = new JTextField[8];
		
		serialno[0] = new JTextField();
		serialno[0].setText(" ");
		serialno[0].setBounds(32, 31, 116, 22);
		panel.add(serialno[0]);
		serialno[0].setColumns(10);
		
		serialno[1] = new JTextField();
		serialno[1].setText(" ");
		serialno[1].setBounds(32, 57, 116, 22);
		panel.add(serialno[1]);
		serialno[1].setColumns(10);
		
		serialno[2] = new JTextField();
		serialno[2].setText(" ");
		serialno[2].setBounds(32, 82, 116, 22);
		panel.add(serialno[2]);
		serialno[2].setColumns(10);
		
		serialno[3] = new JTextField();
		serialno[3].setText(" ");
		serialno[3].setBounds(32, 108, 116, 22);
		panel.add(serialno[3]);
		serialno[3].setColumns(10);
		
		serialno[4] = new JTextField();
		serialno[4].setText(" ");
		serialno[4].setBounds(32, 135, 116, 22);
		panel.add(serialno[4]);
		serialno[4].setColumns(10);
		
		serialno[5] = new JTextField();
		serialno[5].setText(" ");
		serialno[5].setBounds(32, 161, 116, 22);
		panel.add(serialno[5]);
		serialno[5].setColumns(10);
		
		serialno[6] = new JTextField();
		serialno[6].setText(" ");
		serialno[6].setBounds(32, 190, 116, 22);
		panel.add(serialno[6]);
		serialno[6].setColumns(10);
		
		serialno[7] = new JTextField();
		serialno[7].setText(" ");
		serialno[7].setBounds(32, 218, 116, 22);
		panel.add(serialno[7]);
		serialno[7].setColumns(10);
		
		particular = new JTextField[8];
		
		particular[0] = new JTextField();
		particular[0].setBounds(187, 31, 498, 22);
		panel.add(particular[0]);
		particular[0].setColumns(10);
		
		particular[1] = new JTextField();
		particular[1].setBounds(187, 57, 498, 22);
		panel.add(particular[1]);
		particular[1].setColumns(10);
		
		particular[2] = new JTextField();
		particular[2].setBounds(187, 82, 498, 22);
		panel.add(particular[2]);
		particular[2].setColumns(10);
		
		particular[3] = new JTextField();
		particular[3].setBounds(187, 108, 498, 22);
		panel.add(particular[3]);
		particular[3].setColumns(10);
		
		particular[4] = new JTextField();
		particular[4].setBounds(187, 135, 498, 22);
		panel.add(particular[4]);
		particular[4].setColumns(10);
		
		particular[5] = new JTextField();
		particular[5].setBounds(187, 161, 498, 22);
		panel.add(particular[5]);
		particular[5].setColumns(10);
		
		particular[6] = new JTextField();
		particular[6].setBounds(187, 190, 498, 22);
		panel.add(particular[6]);
		particular[6].setColumns(10);
		
		particular[7] = new JTextField();
		particular[7].setBounds(187, 218, 498, 22);
		panel.add(particular[7]);
		particular[7].setColumns(10);
		
		charges = new JTextField[8];
		
		charges[0] = new JTextField();
		charges[0].setBounds(731, 31, 116, 22);
		panel.add(charges[0]);
		charges[0].setColumns(10);
		
		charges[1] = new JTextField();
		charges[1].setBounds(731, 57, 116, 22);
		panel.add(charges[1]);
		charges[1].setColumns(10);
		
		charges[2] = new JTextField();
		charges[2].setBounds(731, 82, 116, 22);
		panel.add(charges[2]);
		charges[2].setColumns(10);
		
		charges[3] = new JTextField();
		charges[3].setBounds(731, 108, 116, 22);
		panel.add(charges[3]);
		charges[3].setColumns(10);
		
		charges[4] = new JTextField();
		charges[4].setBounds(731, 135, 116, 22);
		panel.add(charges[4]);
		charges[4].setColumns(10);
		
		charges[5] = new JTextField();
		charges[5].setBounds(731, 161, 116, 22);
		panel.add(charges[5]);
		charges[5].setColumns(10);
		
		charges[6] = new JTextField();
		charges[6].setBounds(731, 190, 116, 22);
		panel.add(charges[6]);
		charges[6].setColumns(10);
		
		charges[7] = new JTextField();
		charges[7].setBounds(731, 218, 116, 22);
		panel.add(charges[7]);
		charges[7].setColumns(10);
		
		lblTotal = new JLabel("TOTAL");
		lblTotal.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTotal.setBounds(642, 253, 56, 16);
		panel.add(lblTotal);
		
		total = new JTextField();
		total.setBounds(731, 251, 116, 22);
		panel.add(total);
		total.setColumns(10);
		
		lblCgst = new JLabel("CGST ");
		lblCgst.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCgst.setBounds(32, 280, 56, 16);
		panel.add(lblCgst);
		
		lblSgst = new JLabel("SGST");
		lblSgst.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSgst.setBounds(214, 280, 56, 16);
		panel.add(lblSgst);
		
		lblIgst = new JLabel("IGST");
		lblIgst.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblIgst.setBounds(421, 280, 56, 16);
		panel.add(lblIgst);
		
		lblGrandTotal = new JLabel("Grand Total");
		lblGrandTotal.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblGrandTotal.setBounds(606, 280, 87, 16);
		panel.add(lblGrandTotal);
		
		gtotal = new JTextField();
		gtotal.setBounds(731, 278, 116, 22);
		panel.add(gtotal);
		gtotal.setColumns(10);
		
		igst = new JTextField();
		igst.setText("0.0");
		igst.setBounds(478, 278, 87, 22);
		panel.add(igst);
		igst.setColumns(10);
		
		sgst = new JTextField();
		sgst.setBounds(270, 278, 87, 22);
		panel.add(sgst);
		sgst.setColumns(10);
		
		cgst = new JTextField();
		cgst.setBounds(77, 278, 87, 22);
		panel.add(cgst);
		cgst.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(40, 43, 375, 169);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		name = new JTextField();
		name.setBounds(77, 10, 116, 22);
		panel_1.add(name);
		name.setColumns(10);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(12, 13, 33, 16);
		panel_1.add(lblName);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(12, 42, 56, 16);
		panel_1.add(lblAddress);
		
		addressline1 = new JTextField();
		addressline1.setBounds(77, 39, 268, 22);
		panel_1.add(addressline1);
		addressline1.setColumns(10);
		
		addressline2 = new JTextField();
		addressline2.setBounds(77, 61, 268, 22);
		panel_1.add(addressline2);
		addressline2.setColumns(10);
		
		addressline3 = new JTextField();
		addressline3.setBounds(77, 85, 268, 22);
		panel_1.add(addressline3);
		addressline3.setColumns(10);
		
		lblGstinNo = new JLabel("GSTIN No");
		lblGstinNo.setBounds(12, 114, 56, 16);
		panel_1.add(lblGstinNo);
		
		lblState = new JLabel("State");
		lblState.setBounds(12, 140, 56, 16);
		panel_1.add(lblState);
		
		lblStatecode = new JLabel("StateCode");
		lblStatecode.setBounds(220, 140, 65, 16);
		panel_1.add(lblStatecode);
		
		gstinno = new JTextField();
		gstinno.setBounds(77, 111, 116, 22);
		panel_1.add(gstinno);
		gstinno.setColumns(10);
		
		state = new JTextField();
		state.setBounds(77, 137, 116, 22);
		panel_1.add(state);
		state.setColumns(10);
		
		statecode = new JTextField();
		statecode.setBounds(289, 137, 56, 22);
		panel_1.add(statecode);
		statecode.setColumns(10);
		
		panel_2 = new JPanel();
		panel_2.setBounds(439, 43, 480, 169);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblInvoiceNumber = new JLabel("Invoice number");
		lblInvoiceNumber.setBounds(64, 13, 118, 16);
		panel_2.add(lblInvoiceNumber);
		
		invoideTextField = new JTextField();
		invoideTextField.setBounds(194, 10, 207, 22);
		panel_2.add(invoideTextField);
		invoideTextField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Invoice Date");
		Date date = new Date();
		lblNewLabel.setBounds(64, 42, 106, 16);
		panel_2.add(lblNewLabel);
		
		invoideDateText = new JTextField();
		invoideDateText.setBounds(193, 39, 208, 22);
		int month=date.getMonth()+1;
		if(month<10){
			invoideDateText.setText(date.getDate()+"-0"+(date.getMonth()+1)+"-"+(date.getYear()+1900));
		}
		else {	invoideDateText.setText(date.getDate()+"-"+(date.getMonth()+1)+"-"+(date.getYear()+1900));
		}
		
		panel_2.add(invoideDateText);
		invoideDateText.setColumns(10);
		
		JLabel lblBillPeriod = new JLabel("Bill period");
		lblBillPeriod.setBounds(64, 71, 84, 16);
		panel_2.add(lblBillPeriod);
		
		JLabel lblFrom = new JLabel("From");
		lblFrom.setBounds(176, 81, 56, 16);
		panel_2.add(lblFrom);
		
		billperiodfrom = new JTextField();
		billperiodfrom.setBounds(234, 78, 167, 22);
		panel_2.add(billperiodfrom);
		billperiodfrom.setColumns(10);
		
		billperiodto = new JTextField();
		billperiodto.setBounds(234, 113, 167, 22);
		panel_2.add(billperiodto);
		billperiodto.setColumns(10);
		
		JLabel lblTo = new JLabel("To");
		lblTo.setBounds(186, 116, 34, 16);
		panel_2.add(lblTo);
		
		btnClear = new JButton("Clear");
		btnClear.setBounds(40, 597, 97, 25);
		frame.getContentPane().add(btnClear);
		
		btnCalculate = new JButton("Calculate");
		btnCalculate.setBounds(721, 597, 97, 25);
		frame.getContentPane().add(btnCalculate);
		
			

	}
}
