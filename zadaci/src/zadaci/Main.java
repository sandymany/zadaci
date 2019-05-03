package zadaci;

import zadaci.ConsoleWindowManager;

public class Main {

	public static void main(String[] args) {
		ConsoleWindowManager ekran = new ConsoleWindowManager(50,8);		
		//ekran.addWindow(new Window(4, 6,4, 4, "LET"));
		//ekran.addWindow(new Window(22, 2,10, 3, "PIA"));
		//ekran.addWindow(new Window(30, 6, 7, 3, "BER"));
		ekran.addWindow(new Window(5, 3,3, 3, "FCK"));
		ekran.addWindow(new Window(2, 7,10, 3, "NIS"));
		
		ekran.toggleGravity(true);
		ekran.print(ekran.screen);

	}
}
