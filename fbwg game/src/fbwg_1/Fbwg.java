package fbwg_1;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Fbwg  extends JFrame{
	
	private Image screenImage;
	private Graphics screenGraphic;
	
	private Image startback;
	private Image title;
	
	
	public Fbwg() {
		setTitle("Fireboy and Watergirl");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false); //������ ���� ����
		setLocationRelativeTo(null); //��ǻ�� �߾ӿ� â �߱�
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //����â ����� ���α׷� ���� (�߿�)
		setVisible(true); //ȭ�����
		setLayout(null);
		
		startback = new ImageIcon(Main.class.getResource("../images/startback.png")).getImage();
		title = new ImageIcon(Main.class.getResource("../images/title.png")).getImage();

		
	} 
	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH,Main.SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);
		g.drawImage(screenImage, 0,0,null);
	}
	
	public void screenDraw(Graphics g) {
		g.drawImage(startback, 0, 0, null);
		g.drawImage(title, 70, 70, null);
		//g.drawImage(play, 360, 400, null);
		
		
		this.repaint();
	}
}