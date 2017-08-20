package com.oliveiradouglas.parking.src;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class NumberHelper {
	public static Double convertStringToDouble(String number) throws ParseException {
		NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
		return (Double) nf.parse(number);
	}
}
