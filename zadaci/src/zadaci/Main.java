package zadaci;

import zadaci.ConsoleWindowManager;

public class Main {

	public static void main(String[] args) {
		ConsoleWindowManager ekran = new ConsoleWindowManager(50,8);		
		
		ekran.drawWindow(1, 6, 4, 4, "PIA\nBER");
		ekran.drawWindow(6, 7, 3, 9, "LET");
		ekran.drawWindow(20,7, 3, 9, "PIA");
		ekran.drawWindow(27, 4, 3, 9, "FCK");
		ekran.performSolidGravity(ekran.screen);
		ekran.print(ekran.screen);

	}
}
