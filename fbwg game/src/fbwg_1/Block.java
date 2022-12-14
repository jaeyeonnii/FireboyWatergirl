package fbwg_1;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Block extends Thread{
	private Image block = new ImageIcon(Main.class.getResource("../images/blockP.png")).getImage();
	private Image button = new ImageIcon(Main.class.getResource("../images/buttonP.png")).getImage();
}
