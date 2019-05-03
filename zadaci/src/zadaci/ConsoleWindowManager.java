package zadaci;
import java.util.Arrays;
import java.util.Collections;
import java.util.ArrayList;
class ConsoleWindowManager {

	char[][] screen;
	char[][] centrirano;
	int screenHeight;
	int screenWidth;
	private ArrayList<Window> prozori;
	private ArrayList<Window> prozoriSGravitacijom;
	private boolean isGravityOn = false;
	
	public ConsoleWindowManager(int width, int height){
		prozori = new ArrayList<>();
		initScreen(height,width);//automatski zove initScreen
	}
	
	public void initScreen(int height, int width) {
		screenHeight =height;//kasnije mi treba kod provjeravanja
		screenWidth =width;
		screen = new char[height][width];
		for(int i = 0; i < screenHeight; i++){
			Arrays.fill(screen[i],'.');
		}
	}
	
	public void toggleGravity(boolean value) {
		isGravityOn = value;
	}
	
	public void print(char [][] array) {
		if(isGravityOn) {
			prozoriSGravitacijom = getWindowsWithGravityFromList(prozori);
			for(Window w : prozoriSGravitacijom) {
				drawWindow(w);
			}
		}
		else {
			for(Window w : prozori) {
				drawWindow(w);
			}
		}

		for(int i=0;i<array.length;i++) {
			for(int j=0;j<array[i].length;j++) {
				System.out.print(array[i][j]);
			}
			System.out.println();
		}
	}
	
	public void addWindow(Window w) {
		prozori.add(w);
	}
	
	private void drawWindow(Window w) {
		int height = w.height;
		int width = w.width;
		int x = w.x;
		int y = w.y;
		String tekstZaCentriranje = w.text;
		
		System.out.println("height okvira:"+height+" width okvira:"+width);

		if ((x+width)> screenWidth || x>= screenWidth || y>= screenHeight || y+1<height){
			System.err.print("Okvir nije unutar polja! Nem ni ispisival\n");
		}
		else {
			for (int i = screenHeight-y-1; i< screenHeight-y-1+height; i++) {
				for(int j=x;j<width+x;j++) {
					if(i== screenHeight -y-1 || i== screenHeight -y-2+height) {
						if(j==x || j==width+x-1) {
							screen[i][j]='*';
						}
						else {
							screen[i][j]='\u2500';
						}
					}
					else if(i!= screenHeight -y-1 || i!= screenHeight -y-2+height) {
						if(j==x || j==width+x-1) {
							screen[i][j] = '\u2502';//'|'
						}
					}
				}
			}
			drawText(x+1,y-1,height-2,width-2,tekstZaCentriranje);
		}
	}

	public void drawText(int x, int y, int rows, int columns, String tekst) {
		String [] array=tekst.trim().split("\n");
		centrirano = new char[rows][columns];
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < columns; j++) {
				if(i >= (rows-array.length)/2 &&
						i < rows-(rows-array.length)/2 &&
						i-(rows-array.length)/2 < array.length &&
						j >= (columns-array[i-(rows-array.length)/2].length())/2 &&
						j < (columns-array[i-(rows-array.length)/2].length())/2 + array[i-(rows-array.length)/2].length()){
					centrirano[i][j] = array[i-(rows-array.length)/2].charAt(j-(columns-array[i-(rows-array.length)/2].length())/2);
				}
				else {
					centrirano[i][j] = '\u00B7';//tocka
				}
			}
		}
		for(int i=screenHeight-y-1;i< screenHeight-y-1+rows; i++) {
			for(int j=x;j<columns+x;j++) {
				screen[i][j]=centrirano[i-(screenHeight-y-1)][j-x];
			}
		}
	}
	
	public void performUnsolidGravity(char [][] array) {
		
		for(int n=0;n<array.length;n++) {
			for(int i=array.length-1;i>0;i--) {
				for(int j=0;j<array[i].length;j++) {
					if (array[i][j]=='.' || array[i][j]=='\u00B7') {
						array[i][j]=array[i-1][j];
						array[i-1][j]='.';
					}
				}
			}
		}
	}
	
	private ArrayList<Window> getWindowsWithGravityFromList(ArrayList<Window> gWindows) {
		ArrayList<Window> passed=new ArrayList<>();
		gWindows=new ArrayList<Window>();
		Collections.sort(prozori);
		gWindows=prozori;
		boolean somethingBeneath;
		int temporary;
		for(Window window:gWindows) {
			temporary=0;
			somethingBeneath=false;
			for(Window prozor:passed) {
				if((window.x>=prozor.x && window.x<=prozor.x+prozor.width) || 
				   (window.x+window.width>=prozor.x && window.x+window.width <=prozor.x+prozor.width)||
				   (prozor.x>=window.x && prozor.x+prozor.width<=window.x+window.width)) {
					somethingBeneath=true;
					if(prozor.y>temporary) {temporary=prozor.y;}
				}
			}
			if(somethingBeneath) {
				window.y=window.y+1-(window.y+1-window.height-temporary);
			}
			else {
				window.y=window.height-1;
			}
			passed.add(window);
		}
		return gWindows;
	}
	
	
	
	
	
	
	
	
	
	
}
