package zadaci;

import zadaci.ConsoleWindowManager;

public class Main {

	public static void main(String[] args) {
		ConsoleWindowManager ekran = new ConsoleWindowManager(50,8);		
		
		ekran.drawWindow(0, 6, 6, 9, "PIA\nBER");
		ekran.print(ekran.screen);

	}
	public static void Stopanje(int milisekundi) {
		try        
		{
		    Thread.sleep(milisekundi);
		} 
		catch(InterruptedException ex) 
		{
		    ex.printStackTrace();
		    Thread.currentThread().interrupt();
		}
	}
}
