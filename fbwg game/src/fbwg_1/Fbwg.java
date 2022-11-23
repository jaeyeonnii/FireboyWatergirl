package fbwg_1;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JFrame;

public class Fbwg  extends JFrame{
	
	private Image screenImage;
	private Graphics screenGraphic;
	
	private Image startback;
	
	public Fbwg() {
		setTitle("Fireboy and Watergirl");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false); //������ ���� ����
		setLocationRelativeTo(null); //��ǻ�� �߾ӿ� â �߱�
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //����â ����� ���α׷� ���� (�߿�
		setVisible(true); //ȭ�����
		setLayout(null);
		
		startback = new ImageIcon(Main.class.getResource("../images/startback.png")).getImage();
		
	} 
	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH,Main.SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);
		g.drawImage(screenImage, 0,0,null);
	}
	
	public void screenDraw(Graphics g) {
		g.drawImage(startback, 0, 0, null);
		this.repaint();
	}
}
