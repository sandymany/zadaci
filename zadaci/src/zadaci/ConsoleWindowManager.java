package zadaci;
import java.util.Arrays;
import java.util.ArrayList;

class ConsoleWindowManager {

	char[][] screen;
	char[][] centrirano;
	int screenHeight;
	int screenWidth;
	
	public ConsoleWindowManager(int width, int height){
		initScreen(height,width);//automatski zove initScreen, ne mora ga zvati objekt
	}
	
	public void print(char [][] array) {
		for(int i=0;i<array.length;i++) {
			for(int j=0;j<array[i].length;j++) {
				System.out.print(array[i][j]);
			}
			System.out.println();
		}
	}

	public void initScreen(int height, int width) {
		screenHeight =height;//kasnije mi treba kod provjeravanja jel moguce napravit zadani okvir unutar hashatagiranog polja
		screenWidth =width;
		screen = new char[height][width];
		for(int i = 0; i < screenHeight; i++){
			Arrays.fill(screen[i],'.');
		}
	}

	public void drawWindow(int x, int y, int height, int width,String tekstZaCentriranje) {
		
		System.out.println("height okvira:"+height+" width okvira:"+width);

		if ((x+width)> screenWidth || x>= screenWidth || y>= screenHeight || y+1<height){
			System.out.print("Okvir nije unutar polja! Nem ni ispisival\n");
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
	
	public void performSolidGravity(char[][] array) {
		ArrayList<Integer> zamjena=new ArrayList<Integer>();
		boolean zamjeniti=true;
		
		for(int n=0;n<array.length;n++) {
			for(int i=array.length-2;i>=0;i--) {
				int j=0;
				while(j!=array[i].length) {
					if(array[i][j]=='*' || array[i][j]=='\u2502') {
						zamjeniti=true;
						zamjena.clear();
						System.out.println("ulazim:"+i);
						zamjena.add(j);
						j++;
						while(array[i][j]!='*' && array[i][j]!='\u2502') {
							zamjena.add(j);
							j++;
						}
						zamjena.add(j);
						j++;
						for(int column:zamjena) {
							if(array[i+1][column]!='.') {
								zamjeniti=false;
							}
						}
						if(zamjeniti==true) {
							System.out.println("mjenjam");
							for(int stupac:zamjena) {
								array[i+1][stupac]=array[i][stupac];
								array[i][stupac]='.';
							}
							//zamjena.clear();
						}
					}
					else {j++;}
				}
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
}
