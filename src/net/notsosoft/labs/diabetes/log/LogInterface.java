/**
 * 
 */
package net.notsosoft.labs.diabetes.log;

import java.util.ArrayList;

/**
 * @author Michael D. Stemle, Jr. (manchicken -AT- notsosoft.net)
 *
 */
public interface LogInterface {
	/**
	 * Which local storage mechanism are we using? SQLite? Text-based w/JSON? 
	 * 
	 * @return Returns the local storage method for this instance
	 */
	public LogStorageMechanism getLocalStorageMechanism();
	
	/**
	 * Change the local storage mechanism
	 * 
	 * @param newStorageMechanism
	 */
	public void setLocalStorageMechanism(LogStorageMechanism newStorageMechanism);
	
	/**
	 * Set the entries in the log
	 * 
	 * @param entries The entries to set
	 * @throws IllegalArgumentException If the entries are not instances of the expected class, IllegalArgumentException will be thrown.
	 */
	public void setEntries(ArrayList<?> entries) throws IllegalArgumentException;
	
	/**
	 * Get the entries of the instance
	 * 
	 * @return Return an ArrayList of entries
	 */
	public ArrayList<?> getEntries();
	
	/**
	 * @return Returns a count of the entries for the instance
	 */
	public int countEntries();
	
	/**
	 * Add an entry to the collection in the instance
	 * 
	 * @param entry The entry to add to the instance
	 */
	public void addEntry(Object entry);
	
	/**
	 * @param entry The entry to remove
	 */
	public void removeEntry(Object entry);
}
