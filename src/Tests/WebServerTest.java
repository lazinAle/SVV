package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;

import exceptions.InvalidPathException;
import exceptions.InvalidPortNumberException;
import exceptions.InvalidStatusException;
import server.WebServer;

class WebServerTest {

	@Test
	public void testGetSetPort() throws InvalidPortNumberException {
		WebServer.setPort(8080);
		assertEquals("8080",WebServer.getPort());
	}
	
	@Test
	public void testSetPath() throws InvalidPathException {
		WebServer.setPath("C:\\Users\\lazin\\OneDrive\\Desktop\\SVV - project");
		assertEquals("C:\\Users\\lazin\\OneDrive\\Desktop\\SVV - project",WebServer.getPath());
	}
	
	@Test
	public void testSetCorrectStatus() throws InvalidStatusException {
		WebServer.setStatus("RUNNING");
		assertEquals("RUNNING",WebServer.STATUS);
	}
	
	@Test
	public void testSetInorrectStatus() throws InvalidStatusException {
		InvalidStatusException exception = assertThrows(InvalidStatusException.class, () -> WebServer.setStatus("run"));
		assertEquals("Invalid Status",exception.getMessage());
	}
	
	//in order to test this method you must run the WebServer class and comment the Ignore annotation
//	@Ignore
	@Test
	public void testServerFunctionality() {
		WebServer.stop();
		assertEquals("STOPPED",WebServer.STATUS);
	}
	
	//in order to test this method you must run the WebServer class and comment the Ignore annotation
	@Ignore
	@Test
	public void testServerFunctionality2() throws Exception {
		WebServer.maintenance();
		assertEquals("MAINTENANCE",WebServer.STATUS);
	}
}
