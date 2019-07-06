/**
 * Controller Program
 * author Eric Muthuri
 * acts as interface between the user interface and the tourist class
 */

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;

public class WorldController {
	private Tourist tourist = new Tourist();

	@FXML
	private ImageView imageView;
	@FXML
	private ImageView firstItem;
	@FXML
	private ImageView secondItem;
	@FXML
	private Button goForward;
	@FXML
	private MenuItem pickUpBino;
	@FXML
	private MenuItem putDownBino;
	@FXML
	private MenuItem pickUpHat;
	@FXML
	private MenuItem putDownHat;

	public void Initialise() {
        leftView();
	}
	
	public void leftView() {
		String newView = tourist.getLeftView();
		disableForward(newView);
		setView(newView);
		showItem1(1);
		showItem2(2);
	}
	
	public void rightView() {
		String newView = tourist.getRightView();
		disableForward(newView);
		setView(newView);
	}
	
	public void setView(String newView) {
		Image newImage = new Image(newView);
        imageView.setImage(newImage);
	}
	
	public void goForward() {
		tourist.goForward();
		leftView();
	}
	
	public void showItem1(int item) {
		if(tourist.locationItems(item) == true) {
			Image item1 = new Image("binoculars.png");
			firstItem.setImage(item1);
			putDownBino.setVisible(false);
	        pickUpBino.setVisible(true);
		}
		else {
			firstItem.imageProperty().set(null);
			putDownBino.setVisible(true);
	        pickUpBino.setVisible(false);
		}
	}
	
	public void showItem2(int item) {
		if(tourist.locationItems(item) == true) {
			Image item2 = new Image("hat.png");
			secondItem.setImage(item2);
			putDownHat.setVisible(false);
	        pickUpHat.setVisible(true);
		}
		else {
			secondItem.imageProperty().set(null);
			putDownHat.setVisible(true);
	        pickUpHat.setVisible(false);
		}
	}
	
	public void disableForward(String newView) {
		if(newView.equals("tent.jpg") || newView.equals("lounge.jpg")) {
			goForward.setDisable(false);
		}
		else {
			goForward.setDisable(true);
		}
	}

	public void pickUp() {
		firstItem.imageProperty().set(null);
		tourist.pickUp(1);
		pickUpBino.setVisible(false);
		putDownBino.setVisible(true);
	}
	
    public void putDown(ActionEvent event) {
    	if(tourist.carriedItems(1) == true) {
    		Image item1 = new Image("binoculars.png");
            firstItem.setImage(item1);
            tourist.putDown(1);
    		pickUpBino.setVisible(true);
            putDownBino.setVisible(false);
    	}
   }

 	public void pickUp2() {
		secondItem.imageProperty().set(null);
		tourist.pickUp(2);
		pickUpHat.setVisible(false);
        putDownHat.setVisible(true);	
	}
	
     public void putDown2(ActionEvent event) {
    	if(tourist.carriedItems(2) == true) {
    	Image item1 = new Image("hat.png");
        secondItem.setImage(item1);
        tourist.putDown(2);
		pickUpHat.setVisible(true);
        putDownHat.setVisible(false);
    	}
    }
}