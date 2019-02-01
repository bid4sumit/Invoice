package com.zabuza.zabuza;

import java.util.Date;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

public class Util {

	private static final String[] specialNames = { "", " thousand", " million", " billion", " trillion", " quadrillion",
			" quintillion" };

	private static final String[] tensNames = { "", " ten", " twenty", " thirty", " forty", " fifty", " sixty",
			" seventy", " eighty", " ninety" };

	private static final String[] numNames = { "", " one", " two", " three", " four", " five", " six", " seven",
			" eight", " nine", " ten", " eleven", " twelve", " thirteen", " fourteen", " fifteen", " sixteen",
			" seventeen", " eighteen", " nineteen" };

	private static String convertLessThanOneThousand(int number) {
		String current;

		if (number % 100 < 20) {
			current = numNames[number % 100];
			number /= 100;
		} else {
			current = numNames[number % 10];
			number /= 10;

			current = tensNames[number % 10] + current;
			number /= 10;
		}
		if (number == 0)
			return current;
		return numNames[number] + " hundred" + current;
	}

	public static String convert(int number) {

		if (number == 0) {
			return "zero";
		}

		String prefix = "";

		if (number < 0) {
			number = -number;
			prefix = "negative";
		}

		String current = "";
		int place = 0;

		do {
			int n = number % 1000;
			if (n != 0) {
				String s = convertLessThanOneThousand(n);
				current = s + specialNames[place] + current;
			}
			place++;
			number /= 1000;
		} while (number > 0);
		String temp = (prefix + current).trim();

		char s1 = temp.toUpperCase().charAt(0);
		temp = s1 + temp.toLowerCase().substring(1);

		return temp;
	}

	public static XWPFDocument replace(XWPFDocument doc, String tag, String data) {

		for (XWPFParagraph p : doc.getParagraphs()) {
			System.out.println(2);
			/*
			 * List runs = null; runs = p.getRuns();
			 */
			// if (runs != null) {
			for (XWPFRun r : p.getRuns()) {
				String text = r.getText(0);
				if (text != null && text.contains(tag)) {
					r.addBreak();
					text = text.replace(tag, data);
					r.setText(text, 0);
				}
			}
			// }
		}
		for (XWPFTable tbl : doc.getTables()) {
			for (XWPFTableRow row : tbl.getRows()) {
				for (XWPFTableCell cell : row.getTableCells()) {
					for (XWPFParagraph p : cell.getParagraphs()) {
						for (XWPFRun r : p.getRuns()) {
							String text = r.getText(0);
							if (text != null && text.contains(tag)) {
								text = text.replace(tag, data);
								r.setText(text, 0);
							}
						}
					}
				}
			}
		}
		return doc;
	}

	public static String returnCaps(String input) {
		try {
			char s1 = input.toUpperCase().charAt(0);
			input = s1 + input.toLowerCase().substring(1);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return input;
	}

	public static double round(double input) {
		double temp = 0;
		int pc = (int) input;

		temp = input - pc;
		if (temp < 0.5) {
			return input - temp;
		} else {

			return input + (1 - temp);
		}
	}

	public static String dateFormat(Date date) {
		String temp = "";
		int day = date.getDate();
		if (day < 10)
			temp = temp + "0" + day;
		else
			temp = temp + day;

		int mnth = date.getMonth() + 1;
		if (mnth < 10)
			temp = temp + "-0" + mnth;
		else
			temp = temp + "-" + mnth;

		return temp + "-" + (date.getYear() + 1900);
	}

	public static void main(String args[]) {
		Date tp = new Date();
		tp.setDate(7);
		tp.setMonth(2);

		System.out.println(dateFormat(tp));
		System.out.println(convert(2342));
		System.out.println(round(12.6));
		System.out.println(returnCaps("suMIT"));
		decimal(32312.74);

	}

	public static String decimal(double input) {

		double temp = 0;
		int pc = (int) input;
		temp = input - pc;
		System.out.println(temp);
		double tpp = round(temp * 100);
		System.out.println(tpp);
		int dec = (int) (tpp);
		String resp = "Rupees " + convert((int) (input - temp)) + " and paise " + convert(dec);
		System.out.println(resp);
		return resp;
	}
}
