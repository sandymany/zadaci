package zadaci;

import zadaci.ConsoleWindowManager;

public class Main {

	public static void main(String[] args) {
		ConsoleWindowManager ekran = new ConsoleWindowManager(50,9);		
		
		ekran.addWindow(new Window(5, 4,3, 3, "PIA"));
		ekran.toggleGravity(false);
		ekran.print(ekran.screen);

	}
}
