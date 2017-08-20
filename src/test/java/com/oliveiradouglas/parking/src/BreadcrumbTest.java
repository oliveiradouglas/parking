package com.oliveiradouglas.parking.src;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

import com.oliveiradouglas.parking.src.Breadcrumb;

public class BreadcrumbTest {
	private static Breadcrumb breadcrumb;
	
	@BeforeClass
	public static void init() {
		breadcrumb = new Breadcrumb("#", "key", true);
	}
	
	@Test
	public void testGetLinkMustReturnLinkProvidedInConstructor() {
		assertEquals("#", breadcrumb.getLink());
	}
	
	@Test
	public void testGetMessageKeyMustReturnMessageKeyProvidedInConstructor() {
		assertEquals("key", breadcrumb.getMessageKey());
	}
	
	@Test
	public void testIsActiveMustReturnTrue() {
		assertTrue(breadcrumb.isActive());
	}
}
