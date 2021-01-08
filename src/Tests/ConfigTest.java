package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import exceptions.InvalidPathException;
import exceptions.InvalidPortNumberException;
import server.Configuration;

class ConfigTest {


		@Test
		public void testConstructor1() {
			Configuration c = new Configuration();
			assertEquals(123,c.getPortNumber());
		}
		
		@Test
		public void testConstructor2() {
			Configuration c = new Configuration();
			assertEquals("C:\\Users\\lazin\\OneDrive\\Desktop\\SVV - project",c.getPath());
		}

		@Test
		public void testConstructor3() throws InvalidPortNumberException, InvalidPathException {
			InvalidPathException exception = assertThrows(InvalidPathException.class, () -> new Configuration("",12345));
			assertEquals("Invalid Path",exception.getMessage());
		}
		
		@Test
		public void testConstructor4() throws InvalidPortNumberException, InvalidPathException {
			InvalidPortNumberException exception = assertThrows(InvalidPortNumberException.class, () -> new Configuration("C:\\Users\\lazin\\OneDrive\\Desktop\\SVV - project",88888));
			assertEquals("Invalid Port Number",exception.getMessage());
		}
		
		@Test
		public void testConstructor5() throws InvalidPortNumberException, InvalidPathException {
			Configuration c = new Configuration("C:\\Users\\lazin\\OneDrive\\Desktop\\SVV - project",23);
			assertEquals("C:\\Users\\lazin\\OneDrive\\Desktop\\SVV - project",c.getPath());
			assertEquals(23, c.getPortNumber());
		}
		
		
		@Test
		public void testGetPortNumber() {
			Configuration c = new Configuration();
			assertEquals(123,c.getPortNumber());
		}
		
		@Test()
		public void testSetWrongPort() throws InvalidPortNumberException{
			Configuration c = new Configuration();
			InvalidPortNumberException exception = assertThrows(InvalidPortNumberException.class, () -> c.setPortNumber(65536));
			assertEquals("Invalid Port Number",exception.getMessage());
		}
		
		@Test
		public void testSetWrongPort2() throws InvalidPortNumberException{
			Configuration c = new Configuration();
			InvalidPortNumberException exception = assertThrows(InvalidPortNumberException.class, () -> c.setPortNumber(-123));
			assertEquals("Invalid Port Number",exception.getMessage());
		}
		
		@Test
		public void testSetWrongPort3() throws InvalidPortNumberException{
			Configuration c = new Configuration();
			InvalidPortNumberException exception = assertThrows(InvalidPortNumberException.class, () -> c.setPortNumber(88888));
			assertEquals("Invalid Port Number",exception.getMessage());
		}
		
		@Test
		public void testSetCorrectPort() throws InvalidPortNumberException{
			Configuration c = new Configuration();
			c.setPortNumber(8000);
			assertEquals(8000,c.getPortNumber());
		}
		
		@Test
		public void testSetInvalidPath() throws InvalidPathException {
			Configuration c = new Configuration();
			InvalidPathException exception = assertThrows(InvalidPathException.class, () -> c.setPath(null));
			assertEquals("Invalid Path",exception.getMessage());
		}
		
		@Test
		public void testSetInvalidPath2() throws InvalidPathException {
			Configuration c = new Configuration();
			InvalidPathException exception = assertThrows(InvalidPathException.class, () -> c.setPath(""));
			assertEquals("Invalid Path",exception.getMessage());
		}
		
		@Test
		public void testSetCorrectPath() throws InvalidPathException {
			Configuration c = new Configuration();
			c.setPath("C:\\Users\\lazin\\OneDrive\\Desktop\\SVV - project");
			assertEquals("C:\\Users\\lazin\\OneDrive\\Desktop\\SVV - project", c.getPath());
		}

}
