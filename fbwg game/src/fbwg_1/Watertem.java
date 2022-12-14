package fbwg_1;

import java.awt.Image;

import javax.swing.ImageIcon;


public class Watertem extends FWItem {
	private Image watertem = new ImageIcon(Main.class.getResource("../images/wateritem.png")).getImage();
	
	public Watertem(int pos_x, int pos_y) {
		super(pos_x, pos_y);
	}
	public Image getWatertem() {
		return watertem;
	}
}
