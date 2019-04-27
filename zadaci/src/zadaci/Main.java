package zadaci;

import zadaci.ConsoleWindowManager;

public class Main {

	public static void main(String[] args) {
		ConsoleWindowManager ekran = new ConsoleWindowManager(50,8);		
		
		ekran.drawWindow(3, 4, 4, 9, "PIA\nBER");
		ekran.drawWindow(6, 7, 3, 9, "PIA");
		ekran.drawWindow(20, 7, 3, 9, "PIA");
		ekran.drawWindow(30, 4, 3, 9, "PIA");
		ekran.performSolidGravity(ekran.screen);
		ekran.print(ekran.screen);

	}
}
