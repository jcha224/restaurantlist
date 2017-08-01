package jcha224_pr2;

import java.util.LinkedList;
import java.util.List;


public class Driver {

    public static void main(String[] args) {
        
        // The number of waiting customers that qualifies for a new register to be open.
        int queueTNum = 5;
        
        // Max number of registers available in the store.
        int maxRNum = 3;
        
        // Counter to control simulation.
        int minutes = 0;
        
        // A flag that determines whether a customer arrives any given minute.
        boolean customerArrives = false;
        
        // Customer food order preparation time.
        int orderTime;
        
        // Customer sales register time.
        int registerTime;
        
        // Overall simulation time.
        int simulationTime = 100;
        
        // List of restaurants.
        List<Restaurant> storeCompare = new LinkedList<Restaurant>();
        
        // Initialize 10 different restaurants and add to a restaurant list.
        for (int i = 0; i < 10; i++) {
            
            Restaurant store = new Restaurant(queueTNum, maxRNum);
            storeCompare.add(store);
            
            // Either increment the max number of registers or the threshold value of customers
            if (i % 2 == 0)
                queueTNum++;
            else
                maxRNum++;
        
        }        
        
        // while the simulation is running
        while (minutes < simulationTime) {
            
            //update each store
            for (Restaurant store : storeCompare) {
            	
            	// update actual lines based on customers and registers data: 
                /* algorithm to implement in updateLines, in this order
  				1.   Release first 4 customers from food waiting line if they are done and add them to finish list.               
				2.	Remove the customers who finished ordering from registers and add them to food waiting line
				3.	Calculate the number of registers that should be open based on the current size of the queue.
				4.	If shouldbeopen < open, close one empty register but don't go below 1
   				5.  Fill empty registers with customers from the waiting queue
				6.	If shouldbeopen > open, open one new register, if available, and fill with a customer from the waiting queue
                 */
                store.updateLines();
                
                // update times of customers and registers in all the lines
                store.updateTimes();   
                               
                customerArrives = true; // this is normally assigned based on some probability
                                
                if (customerArrives && !store.waitLineFull()) {          
                	orderTime = 3;          // this is normally assigned based on some random number within a specified range
                    registerTime = 2;       // this is normally assigned based on some random number within a specified range
                    store.addCustomer(orderTime, registerTime);                      
                }
                else if (customerArrives && store.waitLineFull())
                	store.incrementNotServed();               
            }
            
            minutes++;
        }
        
        for (Restaurant store : storeCompare) {
            store.writeStats();
        }

    }

}
