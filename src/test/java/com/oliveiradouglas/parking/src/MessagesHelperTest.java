package com.oliveiradouglas.parking.src;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.Locale;

import org.junit.Test;

import com.oliveiradouglas.src.MessagesHelper;

public class MessagesHelperTest {
	@Test
	public void testGetMessageMustReturnMessageOfDefaultFile() {
		try {
			assertEquals("Configurações", MessagesHelper.getMessage("settings", null));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetMessageSpecifyingLocationMustReturnMessageOfSpecifiedLanguageFile() {
		try {
			assertEquals("Settings", MessagesHelper.getMessage("settings", Locale.US));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetMessageSpecifyingLocationMustReturnMessageOfDefaultFileIfLocationNotConfigured() {
		try {
			assertEquals("Configurações", MessagesHelper.getMessage("settings", Locale.CHINA));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
