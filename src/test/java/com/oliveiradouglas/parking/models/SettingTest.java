package com.oliveiradouglas.parking.models;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import com.oliveiradouglas.parking.models.Setting;

public class SettingTest {
	private static Setting setting;


	@BeforeClass
	public static void before() {
		setting = new Setting();
	}
	
	@Test
	public void testGetAndSetId() {
		setting.setId(1);
		assertEquals(1, setting.getId());
	}
	
	@Test
	public void testGetAndSetParkingName() {
		setting.setParkingName("Nome");
		assertEquals("Nome", setting.getParkingName());
	}
	
	@Test
	public void testGetAndSetFirstHourValue() {
		setting.setFirstHourValue(10D);
		assertEquals(10D, setting.getFirstHourValue(), 0.000001);
	}

	@Test
	public void testGetAndSetOtherHoursValue() {
		setting.setFirstHourValue(5D);
		assertEquals(5D, setting.getFirstHourValue(), 0.000001);
	}
}
