import java.io.File;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class manages database of courses.
 * Methods for adding courses, getting courses by CRN, reading course data sets from a text file,
 * and listing all courses in the database as strings.
 * 
 * @author liam ghershony
 */

public class CourseDBManager implements CourseDBManagerInterface {
	
	CourseDBStructure courseDatabase;
	
	 /**
     * Constructs a manager and initializes a database to a default cap of 100.
     * 
     */
	
	public CourseDBManager() {
		
		courseDatabase = new CourseDBStructure(100);
	}


    /**
     * Adds course to database.
     * 
     * @param id -- course id
     * @param crn -- course CRN
     * @param credits -- number of credits the course gives
     * @param roomNum -- room where the course is to be found
     * @param instructor -- name of the teacher of this course
     */
	
	@Override
	public void add(String id, int crn, int credits, String roomNum, String instructor) {
		CourseDBElement element = new CourseDBElement(id, crn, credits, roomNum, instructor);
		courseDatabase.add(element);
	}

	 /**
     * Gets a course using CRN to retrieve it.
     * 
     * @param crn of the course to be retrieved
     * @return The course object with that CRN, null if it's not found.
     */
	
	@Override
	public CourseDBElement get(int crn){
		try {
	        return courseDatabase.get(crn);
	    } catch (IOException e) {
	        return null; 
	    }}
	
	 /**
     * Reads course info from file and adds courses to the database.
     * 
     * @param input file from which to read the courses.
     * @throws FileNotFoundException if file can't be found.
     */

	@Override
	public void readFile(File input) throws FileNotFoundException {

			
		Scanner scanner = new Scanner(input); 
			
		    while (scanner.hasNextLine()) {
		        String dataBase[] = scanner.nextLine().split(" ",5);
		        if (dataBase.length == 5) {
		            add(dataBase[0], Integer.parseInt(dataBase[1]), Integer.parseInt(dataBase[2]), dataBase[3], dataBase[4]);
		        }}
		
	}

	/**
	 * Returns an arraylist of strings of all the courses in the database.
	 */
	@Override
	public ArrayList<String> showAll() {
		return courseDatabase.showAll();
	}

}
