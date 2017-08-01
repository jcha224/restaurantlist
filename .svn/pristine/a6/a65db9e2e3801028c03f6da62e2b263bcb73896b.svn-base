package jcha224_pr2;


/**
 * Represents basic cash register for restaurant simulation.
 * @author John Chang
 * @version Autumn 2016
 */
public class Register {

	// Represents the customer at this register.
	private Customer myCurrent;
	
	// Represents whether or not there is a customer at this register.
	private boolean myPresent;
	
	// Represents the time the customer spends here
	private int myRegisterTime;
	
	// Represents whether this register is open.
	private boolean myStatus;
	
	/**
	 * Constructs a register.
	 */
	public Register() {
		myCurrent = new Customer();
		myRegisterTime = 0;
		myPresent = false;
		myStatus = false;
	}
	
	/**
	 * Returns whether the customer is finished ordering.
	 * @return true when customer is done and false otherwise.
	 */
	public boolean checkFinish() {
		return myRegisterTime >= myCurrent.getServingTime();
	}
	
	/**
	 * Returns whether a customer is present at this register.
	 * @return true if there is a customer and false otherwise.
	 */
	public boolean getPresent() {
		return myPresent;
	}
	
	/**
	 * Sets the status when a customer comes and leaves from the register.
	 * @param theStatus whether or not the customer is present
	 */
	public void setPresent(boolean theStatus) {
		myPresent = theStatus;
	}
	
	/**
	 * Updates the wait time.
	 */
	public void updateRegister() {
		myRegisterTime++;
	}
	
	/**
	 * Returns whether or not the register is open.
	 * @return true if it is open and false when closed.
	 */
	public boolean getStatus() {
		return myStatus;
	}
	
	/**
	 * Sets whether the register is closed or open.
	 * @param theStatus true when open and false when closed.
	 */
	public void setStatus(boolean theStatus) {
		myStatus = theStatus;
	}
	
	/**
	 * Removes and returns the customer.
	 * @return the customer
	 */
	public Customer getCustomer() {
		myPresent = false;
		return myCurrent;
	}
	
	/**
	 * Allows the user to view the current customer.
	 * @return the customer
	 */
	public Customer checkCustomer() {
		return myCurrent;
	}
	
	/**
	 * Places a new customer at this register.
	 * @param theCustomer the new customer.
	 */
	public void addCustomer(Customer theCustomer) {
		myCurrent = theCustomer;
		myRegisterTime = 0;
		myPresent = true;
		
	}
}
