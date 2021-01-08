package Tests;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import exceptions.InvalidPortNumberException;
import server.ConfigurationHandler;

class ConfigHandlerMockTest {
	private ConfigurationHandler mockConfigManager = mock(ConfigurationHandler.class);
	  
	@Test
	public void setChangePort() throws InvalidPortNumberException {
		mockConfigManager.setPort(80);
		when(mockConfigManager.getPort()).thenReturn(80);
		assertEquals(80, mockConfigManager.getPort());
	}
	
	@Test
	public void setChangePort2() throws InvalidPortNumberException {
		mockConfigManager.setPort(80);
		assertEquals(0, mockConfigManager.getPort());
	}
}