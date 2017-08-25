package com.oliveiradouglas.parking.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.sql.SQLException;

import org.junit.Test;

import com.oliveiradouglas.parking.models.Setting;

public class SettingDAOTest {
	@Test
	public void testFindSettingMustLoadSettingOfDatabase() {
		SettingDAO dao = new SettingDAO();
		
		Setting setting = new Setting();
		setting.setParkingName("Estrela parking");
		setting.setFirstHourValue(10D);
		setting.setOtherHoursValue(5D);
		
		try {
			dao.insert(setting);
			Setting savedSetting = dao.findSetting();
			assertEquals(setting, savedSetting);

			dao.delete(setting);
		} catch (SQLException e) {
			fail(e.getMessage());
		}
	}
}