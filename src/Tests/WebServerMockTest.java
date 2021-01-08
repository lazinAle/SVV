package Tests;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import exceptions.InvalidPathException;
import exceptions.InvalidPortNumberException;
import server.WebServer;

class WebServerMockTest {
	private WebServer mock = mock(WebServer.class);
	
	@Test
	public void testSetPort() throws InvalidPortNumberException {
		mock.setPort1(8000);
		when(mock.getPort1()).thenReturn(8000);
		assertEquals(8000, mock.getPort1());
	}
	
	@Test
	public void testFailSetPort() throws InvalidPortNumberException {
		mock.setPort1(8000);
		assertEquals(0, mock.getPort1());
	}

	@Test
	public void testSetPath() throws InvalidPathException {
		mock.setPath1("C:\\Users\\lazin\\OneDrive\\Desktop\\SVV - project");
		when(mock.getPath1()).thenReturn("C:\\Users\\lazin\\OneDrive\\Desktop\\SVV - project");
		assertEquals("C:\\Users\\lazin\\OneDrive\\Desktop\\SVV - project", mock.getPath1());
	}
	
	@Test
	public void testFailSetPath() throws InvalidPathException {
		mock.setPath1("C:\\Users\\lazin\\OneDrive\\Desktop\\SVV - project");
		assertEquals(null, mock.getPath1());
	}
}
