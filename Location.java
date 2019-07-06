/**
 * Location class
 * Implements collection to store views
 * and collection to store items in room*/

import java.util.HashMap;

public class Location {
	
	//creating room names
	private String giraffe = "giraffe.jpg";
	private String elephant = "elephant.jpg";
	private String rhino = "rhino.jpg";
	private String tent = "tent.jpg";
	private String bedroom = "bedroom.jpg";
	private String lounge = "lounge.jpg";
	private String dining = "dining.jpg";
	private String pool = "pool.jpg";
	
	private HashMap<Integer, String> myLocations;
	private HashMap<Integer, String> locationItems;
	
	public Location() {
		myLocations = new HashMap<>();
		locationItems = new HashMap<>();
	}
	
	public void createOutside() {	
		//initializing the location views
		createViews(1, tent);
		createViews(2, giraffe);
		createViews(3, rhino);
		createViews(4, elephant);
		
		locationItems.put(1, "binoculars.png");
		locationItems.put(2, "hat.png");
	}
	
	public void createInside() {
		//initializing the location views
		createViews(1, bedroom);
		createViews(2, pool);
		createViews(3, lounge);
		createViews(4, dining);
	}
	
	public void createViews(int picId, String picName) {
		myLocations.put(picId, picName);
	}
	
	public String getViewFromHashMap(int view) {
		return myLocations.get(view);
	}	

	public void dropItem(int itemId, String itemName) {
		locationItems.put(itemId, itemName);
	}
	
	public void pickItem(int itemId) {
		locationItems.remove(itemId);
	}
	
	public String getItem(int itemId) {
		return locationItems.get(itemId);
	}
	
	public boolean hasItem(int key) {
		if(locationItems.containsKey(key)) {
			return true;
		}
		else
			return false;
	}
	
}
