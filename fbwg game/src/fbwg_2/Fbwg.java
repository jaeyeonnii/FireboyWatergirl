package fbwg_2;

import java.awt.Graphics;

import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Fbwg  extends JFrame{
	
	private Image screenImage;
	private Graphics screenGraphic;
	
	private Image startback;
	private Image title;
	
	private ImageIcon play =new ImageIcon(Main.class.getResource("../images/play.png"));
	private ImageIcon play2 = new ImageIcon(Main.class.getResource("../images/play2.png"));
	private JButton playBt = new JButton(play);
	
	
	
	public Fbwg() {
		setTitle("Fireboy and Watergirl");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false); //사이즈 변경 막기
		setLocationRelativeTo(null); //컴퓨터 중앙에 창 뜨기
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //게임창 종료시 프로그램 종료 (중요)
		setVisible(true); //화면출력
		setLayout(null);
		
		startback = new ImageIcon(Main.class.getResource("../images/startback.png")).getImage();
		title = new ImageIcon(Main.class.getResource("../images/title.png")).getImage();

		add(playBt);
		
		playBt.setBounds(360,400,264,131);
		playBt.setBorderPainted(false); //테두리
		playBt.setContentAreaFilled(false); //배경
		playBt.setFocusPainted(false); //포커스 표시
		playBt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				playBt.setIcon(play2);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				playBt.setIcon(play);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				//클릭 시 이벤트 처리
			}
		});
		
		
		
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
		paintComponents(g); //JLabel 그려줌
		
		this.repaint();
	}
}
