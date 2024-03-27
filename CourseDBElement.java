/** 
 * Class for creating course objects to be put into database.
 * 
 * @author liamghershony
 *
 */


public class CourseDBElement implements Comparable<CourseDBElement> {

	private String id;
	private int crn;
	private int credits;
	private String roomNum;
	private String instructor;
	
	/**
	 * Comparator for two course elements based on CRN.
	 * 
	 * @param CourseDBElement -- course to compare to.
	 * @return Integer - either 0,1,-1 depending on comparison of CRNS.
	 */
	
	@Override
	public int compareTo(CourseDBElement o) {
		// TODO Auto-generated method stub
		return Integer.compare(this.crn, o.crn);
	}
	
	public CourseDBElement() {
		
	}
	
	/**
	 * Parameterized constructor
	 * 
	 * @param id
	 * @param crn
	 * @param credits
	 * @param roomNum
	 * @param instructor
	 */
	public CourseDBElement(String id, int crn, int credits, String roomNum, String instructor) {
		this.id = id;
		this.crn =crn;
		this.roomNum = roomNum;
		this.instructor = instructor;
		this.credits = credits;
	}
	
	public int hashCode() {
		return String.valueOf(crn).hashCode();
	}
	/**
	 * Compares two courses to see if they're the same based on CRN
	 * 
	 * @param object - could be any object, but should be CourseDBElement. 
	 * 
	 * @return false if not an instance of CourseDBElement, true if elements are the same or if the crn is the same
	 */
	@Override
	public boolean equals(Object o) {
		if(this == o) {
			return true;
		}
		if(!(o instanceof CourseDBElement)) {
			return false;
		}
		CourseDBElement newDB = (CourseDBElement) o;
		return this.crn == newDB.crn;
	}
	
	 /**
     * Gets course ID.
     * 
     * @return id of the course.
     */
    public String getID() {
        return id;
    }

    /**
     * Sets course ID
     * 
     * @param id of the course.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets the crn for course.
     * 
     * @return crn of the course
     */
    public int getCRN() {
        return crn;
    }

    /**
     * Sets the Crn for the course
     * 
     * @param crn -- new crn
     */
    public void setCRN(int crn) {
        this.crn = crn;
    }

    /**
     * Gets amount of credits for this course
     * 
     * @return -- credits.
     */
    public int getCredits() {
        return credits;
    }

    /**
     * Set credits for course
     * 
     * @param credits -- number of credits for course
     */
    public void setCredits(int credits) {
        this.credits = credits;
    }

    /**
     * Gets the room number where the course is held.
     * 
     * @return -- room number for class
     */
    public String getRoomNum() {
        return roomNum;
    }

    /**
     * Sets room number for course.
     * 
     * @param roomNum -- room number for class
     */
    public void setRoomNum(String roomNum) {
        this.roomNum = roomNum;
    }

    /**
     * Gets the name of teacher.
     * 
     * @return -- instructor name 
     */
    public String getInstructor() {
        return instructor;
    }

    /**
     * Sets name of instructor
     * 
     * @param instructor -- new instructor name
     */
    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }
    /**
     * Converts course element into string.
     * @return String of identifying characteristics of a course.
     */
    @Override
    public String toString() {
        return "\nCourse:" + id + " CRN:" + crn + " Credits:" + credits +" Instructor:" + instructor+ " Room:" + roomNum;
    }


	
}
