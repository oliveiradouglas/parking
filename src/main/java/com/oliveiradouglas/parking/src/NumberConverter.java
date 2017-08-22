package com.oliveiradouglas.parking.src;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class NumberConverter {
	public static Double convertStringToDouble(String number) throws ParseException {
		NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
		
		System.out.println("parse " + nf.parse("10"));
		return (Double) nf.parse(number);
	}
}
