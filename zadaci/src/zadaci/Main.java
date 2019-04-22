package zadaci;
import zadaci.Crtac;
//import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) {
		Crtac objekt=new Crtac();
		
		objekt.Tockanje(8, 20);//visina,sirina - stvaranje polja (tockanje)
		
		objekt.Okviranje(0,2,3,5);//x i y su koordinate gornjeg ljevog kuta okvira (0,0 bi bil donji ljevi kut polja)
		objekt.Ispis(objekt.screen);
		/*
		Stopanje(2000);
		for(int i=0;i<56;i++) {
			objekt.Hashtagiranje(19, 60);
			objekt.Okviranje(i,2,3,5);
			Stopanje(100);
		}
		int x=55;
		int y=1;
		for(int i=0;i<6;i++) {
			for(int j=0;j<8;j++) {
				if(j<4) {
					y++;
					objekt.Hashtagiranje(19, 60);
					objekt.Okviranje(x,y,3,5);
					Stopanje(100);
				}
				else {
					objekt.Hashtagiranje(19, 60);
					objekt.Okviranje(x,y,3,5);
					Stopanje(100);
					y--;
				}
				x--;
			}
		}*/
	}
	public static void Stopanje(int milisekundi) {
		try        
		{
		    Thread.sleep(milisekundi);
		} 
		catch(InterruptedException ex) 
		{
		    Thread.currentThread().interrupt();
		}
	}

	
}