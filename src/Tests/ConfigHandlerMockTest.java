package Tests;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import exceptions.InvalidPathException;
import exceptions.InvalidPortNumberException;
import server.ConfigurationHandler;

class ConfigHandlerMockTest {
	private ConfigurationHandler mockConfigManager = mock(ConfigurationHandler.class);
	  
	@Test
	public void testSetPort() throws InvalidPortNumberException {
		mockConfigManager.setPort(8000);
		when(mockConfigManager.getPort()).thenReturn(8000);
		assertEquals(8000, mockConfigManager.getPort());
	}
	
	@Test
	public void testSetPort2() throws InvalidPortNumberException {
		mockConfigManager.setPort(8000);
		assertEquals(0, mockConfigManager.getPort());
	}
	
	@Test
	public void testSetPath() throws InvalidPathException {
		mockConfigManager.setPath("C:\\Users\\lazin\\OneDrive\\Desktop\\SVV - project");
		when(mockConfigManager.getPath()).thenReturn("C:\\Users\\lazin\\OneDrive\\Desktop\\SVV - project");
		assertEquals("C:\\Users\\lazin\\OneDrive\\Desktop\\SVV - project", mockConfigManager.getPath());
	}
	
	@Test
	public void testSetPath2() throws InvalidPathException {
		mockConfigManager.setPath("C:\\Users\\lazin\\OneDrive\\Desktop\\SVV - project");
		assertEquals(null, mockConfigManager.getPath());
	}
}