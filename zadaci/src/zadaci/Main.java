package zadaci;
import zadaci.ConsoleWindowManager;

public class Main {

	public static void main(String[] args) {
		ConsoleWindowManager ekran = new ConsoleWindowManager(10,8);		
		//ekran.drawWindow(0,2,3,5,"BER\nPIA");//x i y su koordinate gornjeg ljevog kuta okvira (0,0 bi bil donji ljevi kut polja)
		//ekran.print(ekran.screen);
		//ekran.drawText(0, 0, 5, 5, "PIA\nBER");
		ekran.drawWindow(0, 3, 3, 3, "k");
		ekran.print();
	}
}
