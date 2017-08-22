package com.oliveiradouglas.parking.src;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class NumberConverter {
	public static Double convertStringToDouble(String number) throws ParseException {
		NumberFormat nf = NumberFormat.getNumberInstance(new Locale("pt", "BR"));
		return nf.parse(number.replaceAll("[ ]", "")).doubleValue();
	}
}
