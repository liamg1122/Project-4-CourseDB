import static org.junit.Assert.*;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Test for course manager
 * 
 * @author liamghershony
 *
 */

	
public class CourseDBManagerStudentTest {
	
	  private CourseDBManagerInterface liamManager;

	  @Before
	  public void setUp() throws Exception {
	        liamManager = new CourseDBManager();
	    }

	  @After
	  public void tearDown() throws Exception {
	        liamManager = null;
	    }

	 
	  @Test
	  public void testAddAndGetCourse() {
	        liamManager.add("ENGL101", 101010101, 3, "AH100", "Dr. Smith");
	        try {
	            CourseDBElement beepop = liamManager.get(101010101);
	            assertNotNull(beepop);
	            assertEquals("ENGL101", beepop.getID());
	            assertEquals("Dr. Smith", beepop.getInstructor());
	        } catch (Exception e) {
	            fail("should not throw an exception.");
	        }
	    }

	  
	    @Test
	    public void testReadFromFile() {
	        try {
	        	
	            File inputFile = new File("testData.txt");
	            PrintWriter outFile = new PrintWriter(inputFile);
	            
	            outFile.println("Quant3402121 343222 4 BH900 Dr. Einstein Turing");
	            outFile.println("PHYS300 34567 4 PH100 Dr. Krauss");
	            outFile.close();

	            liamManager.readFile(inputFile);
	            
	            assertEquals("Quant3402121", liamManager.get(343222).getID());
	            assertEquals("PHYS300", liamManager.get(34567).getID());

	            
	        } catch (Exception e) {
	            fail("Reading from a file should not throw an exception.");
	        }
	    }

	   
	    @Test
	    public void testShowAllWithMultipleCourses() {
	        liamManager.add("COMPSCI101", 1111111112, 3, "CS100", "Steven Even");
	        liamManager.add("HIST101", 56789, 3, "HS100", "Dr. Zoomie Zinn");
	        ArrayList<String> courses = liamManager.showAll();
	        
	        assertTrue(courses.stream().anyMatch(s -> s.contains("COMPSCI101") && s.contains("1111111112")));
	        assertTrue(courses.stream().anyMatch(s -> s.contains("HIST101") && s.contains("56789")));
	    }
	}

