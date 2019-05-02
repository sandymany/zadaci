package zadaci;
public class Window implements Comparable<Window>{
	
	public int x;
	public int y;
	public int width;
	public int height;
	public String text;
	
	public Window(int x, int y, int w , int h, String text) {
		this.x = x;
		this.y  =y;
		width = w;
		height = h;
		this.text = text;
	}
	 public int compareTo(Window w) {
	        return this.y > w.y ? 1 : this.y < w.y ? -1 : 0;
	    }
}
