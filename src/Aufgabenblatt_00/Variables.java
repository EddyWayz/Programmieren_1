package Aufgabenblatt_00;

public class Variables {

	public static void main(String[] args) {
		int myAge = 18;
		float mySize = 1.80F; 
		String myFirstName = "Edaurd";
		String myLastName = "Wayz";
		boolean iAmVegan = false;
		if(iAmVegan) { 
			System.out.println("Mein Name ist " + myFirstName + " " + myLastName +", ich bin " + myAge + " Jahre alt und bin ein Veganer. Außerdem bin ich \" + mySize + \" m groß.\"");
		} else {
			System.out.println("Mein Name ist " + myFirstName + " " + myLastName +", ich bin " + myAge + " Jahre alt und bin kein Veganer. Außerdem bin ich " + mySize + " m groß.");
		}
	}
		
}
