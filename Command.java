/**
 * Command class
 * author Eric Muthuri
 * evaluates view and location states and returns results to tourist*/
public class Command {

	
	public Command() {
	}

	public int turnLeft(int currentView) {
		return ((currentView % 4) + 1);
	}
	
	public int turnRight(int currentView) {
		int nextView = (((currentView + 4)-1)% 4);
		if(nextView == 0) {
			nextView = 4;
		}
		
		return nextView;
	}
	
	public Location goForward(Location currentLocation, Location outside, Location inside) {
		if(currentLocation == inside) {
			return outside;
		}
		else return inside;
	
	}

}
