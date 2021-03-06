package zadaci;
import java.util.Arrays;

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
		for( int i = 0; i < screen.length; i++ )
			   Arrays.fill( screen[i], '.' );
		
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
							screen[i][j] = '\u2502';
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
					centrirano[i][j] = '.';
				}
			}
		}
		for(int i=screenHeight-y-1;i< screenHeight-y-1+rows; i++) {
			for(int j=x;j<columns+x;j++) {
				screen[i][j]=centrirano[i-(screenHeight-y-1)][j-x];
			}
		}
	}
}
