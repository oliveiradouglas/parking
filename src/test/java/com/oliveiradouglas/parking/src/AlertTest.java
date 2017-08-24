package com.oliveiradouglas.parking.src;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.oliveiradouglas.parking.src.Alert;

public class AlertTest {
	@Test
	public void testConstructor() {
		Alert alert = new Alert("Mensagem", Alert.SUCCESS);
		assertEquals("Mensagem", alert.getMessage());
		assertEquals(Alert.SUCCESS, alert.getType());
	}
}
