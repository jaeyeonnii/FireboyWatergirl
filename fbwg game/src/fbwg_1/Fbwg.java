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
		setResizable(false); //사이즈 변경 막기
		setLocationRelativeTo(null); //컴퓨터 중앙에 창 뜨기
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //게임창 종료시 프로그램 종료 (중요
		setVisible(true); //화면출력
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
