package zadaci;

import zadaci.ConsoleWindowManager;

public class Main {

	public static void main(String[] args) {
		ConsoleWindowManager ekran = new ConsoleWindowManager(50,8);		
		
		ekran.drawWindow(0, 6, 6, 9, "PIA\nBER");
		ekran.drawWindow(20, 6, 6, 9, "\nLET");
		ekran.drawWindow(40, 6, 6, 9, "\nNIST");
		ekran.drawWindow(10, 2, 3, 7, "\nFCK");

		ekran.print(ekran.screen);

	}
}
