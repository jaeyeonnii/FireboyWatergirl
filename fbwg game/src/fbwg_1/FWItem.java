package fbwg_1;

public class FWItem {
	private int pos_x, pos_y;
	
	public FWItem(int pos_x, int pos_y) {
		this.pos_x = pos_x;
		this.pos_y = pos_y;
	}
	
	public int getPos_x() {
		return pos_x;
	}
	
	public void setPos_x(int pos_x) {
		this.pos_x= pos_x;
	}
	
	public int getPos_y() {
		return pos_y;
	}
	
	public void setPos_y(int pos_y) {
		this.pos_y= pos_y;
	}
}