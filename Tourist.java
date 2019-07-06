/**
 * Tourist class
 * Implements methods for user actions
 * collection stores items picked up by user
 * author Eric Muthuri
 */
import java.util.HashMap;

public class Tourist {
	Command command = new Command();
	
	private Location currentLocation;
	private int locationId;
	
	Location outside = new Location();
	Location inside = new Location();
	
	private HashMap<Integer, String> carriedItems;
	
	public Tourist() {
		createLocations();
		carriedItems = new HashMap<>();
		locationId = 3;
	}
	
	public void createLocations() {
		//initializing the location views
		outside.createOutside();
		inside.createInside();
				
		currentLocation = outside;
	}
	
	public String getLeftView() {
		locationId = command.turnLeft(locationId);
		String newLocation = currentLocation.getViewFromHashMap(locationId);
		return newLocation;	
	}
	
	public String getRightView() {
		locationId = command.turnRight(locationId);
		String newLocation = currentLocation.getViewFromHashMap(locationId);
		return newLocation;
	}
	
	public void goForward() {
		currentLocation = command.goForward(currentLocation, outside, inside);		
	}
	
	public boolean carriedItems(int key) {
		if(carriedItems.containsKey(key)) {
			return true;
		}
		else
			return false;
	}
	
	public boolean locationItems(int key) {
		if(currentLocation.hasItem(key) == true) {
			return true;
		}
		else
			return false;
	}

	public void pickUp(int itemId) {
		carriedItems.put(itemId, currentLocation.getItem(itemId));
		currentLocation.pickItem(itemId);
		
	}
	public void putDown(int itemId) {
		currentLocation.dropItem(itemId, carriedItems.get(itemId));
		carriedItems.remove(itemId);
	}
}
