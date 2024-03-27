import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * This class implements an interface for a hash table  to store CourseDBElement objects.
 * It uses a 4k+3 prime number algorithm size calculation for the hash table to help avoid collisions 
 * and utilizes buckets of linked lists to handle collisions.
 * 
 * @author Liam Ghershony
 */

public class CourseDBStructure implements CourseDBStructureInterface{
	
	private LinkedList<CourseDBElement>[] hashTable;
	private static final double LOAD_FACTOR = 1.5;
	private int size;
	
	
	
	/**
	 * Constructs a hash table of Linked Lists of course elements using the 4k+3 and load factor of 1.5 for the size.
	 * @param size
	 */
	public CourseDBStructure (int size) {
       
		this.size = nextPrime((int) Math.ceil(size / LOAD_FACTOR));	
       
        hashTable = (LinkedList<CourseDBElement>[]) new LinkedList[this.size];

		
	}
	
	
	 /**
     * Constructs a structure for testing with a direct given size. 
     * 
     * @param test --- string indicating test.
     * @param size --- size of hash table.
     */
	  public CourseDBStructure(String test, int size) {
		 
		  this.size = size;
		  
		  hashTable = (LinkedList<CourseDBElement>[]) new LinkedList[this.size];
		  
	    }
	  
	  
	  /**
	     * Determines if a number is prime.
	     * 
	     * @param n -- number to check
	     * @return true if prime, false if not.
	     */
	  
	public boolean isPrime(int n) {
	   
	    if (n <= 1) {
	        return false;
	    }

	    for (int i = 2; i < n; i++) {
	        if (n % i == 0) {
	            return false;
	        }
	    }

	    return true;
	}
	
	
	/**
	 * Finds the next prime number in 4k+3 form >= the initial given number (n).
	 * @param n -- initial number
	 * @return p -- Integer, the next prime number in the 4k+3 series
	 */
	
	public int nextPrime(int n) {
		if (n<=2) {
			return 3;
		}
		
		int p =n;
		
		if ((p-3) %4 != 0) 
		{
			p += (4-((p-3)%4));
		}
		
		while(true) {
			
			if(isPrime(p)) {
				
				return p;
			}
			
			p += 4;
		}
	}
	/**
	 * Calculates a hash index from a given CRN as a string.
	 * 
	 * @param crn being hashed
	 * @return hash index.
	 */
	private int getHashIndex(int crn) {
		
		 return String.valueOf(crn).hashCode() % size;		
	}
	
	/**
	 * Adds a linked list and given course db element to a given hash index if empty. If it's a duplicate crn, update that index with new element.
	 * If there's already a linked lists and non-duplicate CRN's just add the element to that linked list.
	 * 
	 * @param CourseDBElement element to add.
	 */
	@Override
	public void add(CourseDBElement element) {

		    int index = getHashIndex(element.getCRN());

		    if (hashTable[index] == null) {
		    	
		        hashTable[index] = new LinkedList<>();
		        
		    } else {
		    	
		        for (int i = 0; i < hashTable[index].size(); i++) {
		        	
		            CourseDBElement existing = hashTable[index].get(i);
		            
		            if (existing.getCRN() == element.getCRN()) {
		            	
		                hashTable[index].set(i, element);
		                
		                return; 
		            }
		        }
		    }

		    hashTable[index].add(element);
	}
	/**
     * Retrieve course object based on CRN.
     * 
     * @param crn of course to get
     * @return The course object w/ that CRN.
     * @throws IOException If the CRN was not found.
     */

	@Override
	public CourseDBElement get(int crn) throws IOException {
		
		int index = getHashIndex(crn);
		
		if(hashTable[index]!= null) {
			
		for(CourseDBElement element: hashTable[index]) {
			
			if(element.getCRN() == crn) {
				
				return element;
				
			}
		}}
		
		throw new IOException("CRN not found");

	}

	 /**
     * Creates an ArrayList of toString of all courses in the database.
     * 
     * @return An ArrayList of strings
     */
	
	@Override
	public ArrayList<String> showAll() {
		
		 ArrayList<String> elementsList = new ArrayList<>();
		    for (LinkedList<CourseDBElement> bucket : hashTable) {
		        if (bucket != null) {
		            for (CourseDBElement element : bucket) {
		                elementsList.add(element.toString());}}}
		    
		    return elementsList;
		        
	}
	/** 
	 * Gets the size of the database
	 * @return size
	 */
	@Override
	public int getTableSize() {
		return size;
	}

}
