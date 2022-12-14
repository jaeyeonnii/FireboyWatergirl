package fbwg_1;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Gameover extends FWItem {
	private Image gameover = new ImageIcon(Main.class.getResource("../images/gameover.png")).getImage();
	public Gameover(int pos_x, int pos_y) {
		super(pos_x, pos_y);
	}
	public Image getImage() {
		return gameover;
	}
}
