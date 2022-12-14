package fbwg_1;

import java.awt.Image;

import javax.swing.ImageIcon;


public class Firetem extends FWItem {
	private Image firetem = new ImageIcon(Main.class.getResource("../images/fireitem.png")).getImage();
	
	public Firetem(int pos_x, int pos_y) {
		super(pos_x, pos_y);
	}
	public Image getFiretem() {
		return firetem;
	}
}
