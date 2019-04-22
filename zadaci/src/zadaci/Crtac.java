package zadaci;
import java.util.ArrayList;

public class ConsoleWindowManager {
	
	ArrayList <ArrayList<Character>> screen=new ArrayList<>();//screen=hashtagirano polje unutar kojeg se sve odvija
	//kaj ovo radi???
	//centrirano? kaj je to
	ArrayList<ArrayList<Character>> centrirano=new ArrayList<>();
	int screenHeight;
	int screenWidth;

	public void print() {
		for(int i=0;i<screen.size();i++) {
			for(int j=0;j<screen.get(i).size();j++) {
				System.out.print(screen.get(i).get(j));
			}
			System.out.println();
		}
	}

	public void initScreen(int height, int width) {
		screen.clear();
		screenHeight =height;//kasnije mi treba kod provjeravanja jel moguce napravit zadani okvir unutar hashatagiranog polja
		screenWidth =width;
		for(int i=0;i<height;i++) {
			screen.add(new ArrayList<Character>());
			for(int j=0;j<width;j++) {
				screen.get(i).add('.');
			}
		}
	}

	public void drawWindow(int x, int y, int height, int width) {
		System.out.println("height okvira:"+height+" width okvira:"+width);

		if ((x+width)> screenWidth || x>= screenWidth || y>= screenHeight || y+1<height){
			System.out.print("Okvir nije unutar polja! Nem ni ispisival\n");
		}
		else {
			for (int i = screenHeight -y-1; i< screenHeight -y-1+height; i++) {
				for(int j=x;j<width+x;j++) {
					if(i== screenHeight -y-1 || i== screenHeight -y-2+height) {
						screen.get(i).set(j,'+');
					}
					else if(i!= screenHeight -y-1 || i!= screenHeight -y-2+height) {
						if(j==x || j==width+x-1) {
							screen.get(i).set(j, '+');
						}
						else {
							screen.get(i).set(j, '.');
						}
					}
				}
			}
		}
	}

	public void drawText(int x, int y, int rows, int columns, String tekst) {
		String [] array=tekst.trim().split("\n");
		for(int i = 0; i < rows; i++) {
			centrirano.add(new ArrayList<Character>());
			for(int j = 0; j < columns; j++) {
				if(i >= (rows-array.length)/2 &&
						i < rows-(rows-array.length)/2 &&
						i-(rows-array.length)/2 < array.length &&
						j >= (columns-array[i-(rows-array.length)/2].length())/2 &&
						j < (columns-array[i-(rows-array.length)/2].length())/2 + array[i-(rows-array.length)/2].length()){
					centrirano.get(i).add(array[i-(rows-array.length)/2].charAt(j-(columns-array[i-(rows-array.length)/2].length())/2));
				}
				else {
					centrirano.get(i).add('.');
				}
			}
		}
	}

	public void UmetniCentrirano() {

	}
}
