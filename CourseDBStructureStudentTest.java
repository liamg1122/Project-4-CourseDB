import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Test for Structure Class
 * @author liamghershony
 *
 */

public class CourseDBStructureStudentTest {
	
    CourseDBStructure courseDatabase;


	@Before
	public void setUp() throws Exception {
		
		courseDatabase = new CourseDBStructure(10);
	}

	@After
	public void tearDown() throws Exception {
		courseDatabase = null;
	}

	   @Test
	    public void testAddAndGet() {
	        // Test adding and retrieving a course
	        CourseDBElement course1 = new CourseDBElement("MATH101", 11111, 3, "Room 1", "Silver Hair");
	        courseDatabase.add(course1);

	        try {
	            CourseDBElement course2 = courseDatabase.get(11111);
	            assertEquals(course1.getCRN(), course2.getCRN());
	        } catch (IOException e) {
	            fail("should not throw an exception.");
	        }
	    }
	   
	   @Test
	    public void testSize() {
		   
	        assertEquals( 7, courseDatabase.getTableSize());
		   
	   }
	   
	   @Test
	    public void testError() {
	        try {
	            CourseDBElement result = courseDatabase.get(22222);
	            fail("Should have thrown an exception for CRN.");
	        } catch (IOException e) {
	        }
	    }
	   
	    @Test
	    public void testShowAll() {
	    	courseDatabase.add(new CourseDBElement("CMSC", 11111, 4, "Room 01", "Professor Liam"));
	        courseDatabase.add(new CourseDBElement("PHYSICS", 22222, 4, "Room 02", "Professor Limeabeans"));

	        ArrayList<String> courses = courseDatabase.showAll();
	        assertTrue("Show all should have size 2", courses.size() == 2);
	    }

}
