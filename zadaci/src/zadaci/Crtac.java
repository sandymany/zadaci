package zadaci;
import java.util.ArrayList;

public class Crtac {
	ArrayList <ArrayList<Character>> screen=new ArrayList<>();//screen=hashtagirano polje unutar kojeg se sve odvija
	ArrayList<ArrayList<Character>> centrirano=new ArrayList<>();
	int visina_screena;
	int sirina_screena;
	
	public void Ispis(ArrayList<ArrayList<Character>> lista) {
		for(int i=0;i<lista.size();i++) {
			for(int j=0;j<lista.get(i).size();j++) {
				System.out.print(lista.get(i).get(j));
			}
			System.out.println();
		}
	}
	
	public void Tockanje(int visina,int sirina) {
		screen.clear();
		visina_screena=visina;//kasnije mi treba kod provjeravanja jel moguce napravit zadani okvir unutar hashatagiranog polja
		sirina_screena=sirina;
		for(int i=0;i<visina;i++) {
			screen.add(new ArrayList<Character>());
			for(int j=0;j<sirina;j++) {
				screen.get(i).add('.');
			}
		}
	}

	public void Okviranje(int x,int y,int visina,int sirina) {
		System.out.println("visina okvira:"+visina+" sirina okvira:"+sirina);
		
		if ((x+sirina)>sirina_screena || x>=sirina_screena || y>=visina_screena || y+1<visina){
			System.out.print("Okvir nije unutar polja! Nem ni ispisival\n");
		}
		else {
			for (int i=visina_screena-y-1;i<visina_screena-y-1+visina;i++) {
				for(int j=x;j<sirina+x;j++) {
					if(i==visina_screena-y-1 || i==visina_screena-y-2+visina) {
						screen.get(i).set(j,'+');
					}
					else if(i!=visina_screena-y-1 || i!=visina_screena-y-2+visina) {
						if(j==x || j==sirina+x-1) {
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

	public void Centriranje_teksta(int x, int y, int redci,int stupci,String tekst) {
		String [] array=tekst.trim().split("\n");
		for(int i = 0; i < redci; i++) {
			centrirano.add(new ArrayList<Character>());
			for(int j = 0; j < stupci; j++) {
				if(i >= (redci-array.length)/2 &&
				   i < redci-(redci-array.length)/2 &&
				   i-(redci-array.length)/2 < array.length &&
				   j >= (stupci-array[i-(redci-array.length)/2].length())/2 &&
				   j < (stupci-array[i-(redci-array.length)/2].length())/2 + array[i-(redci-array.length)/2].length()){
					centrirano.get(i).add(array[i-(redci-array.length)/2].charAt(j-(stupci-array[i-(redci-array.length)/2].length())/2));
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
