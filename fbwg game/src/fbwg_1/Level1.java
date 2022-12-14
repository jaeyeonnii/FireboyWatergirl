package fbwg_1;


import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;


public class Level1 extends JFrame {

	//���� ���۸��� Ȱ�� ���� ����
	private Image screenImage;
	private Graphics screenGraphic;
	
	//����� �̹���
	private Image background = new ImageIcon(Main.class.getResource("../images/level1back.png")).getImage();
	
	//�������� ����
	public static Stage stage = new Stage();
	
	//ĳ���� ����
	public static CharMove charmove = new CharMove();
	//��ֹ� ����
	public static Fire f1 = new Fire(450,720);
	public static Water w1 = new Water(650,720);
	public static Bog b1 = new Bog(570,565);
	
	public Level1() { //������
		setTitle("Fireboy and Watergirl");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   );
		setResizable(false); //������ ���� ����
		setLocationRelativeTo(null); //��ǻ�� �߾ӿ� â �߱�
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //����â ����� ���α׷� ���� (�߿�)
		setLayout(null);
		setVisible(true); //ȭ�����
		
		//Ű ������ ����
		addKeyListener(new KeyListener());
		
		//ĳ���� �ʱ� ����
		charmove.setPosition(165, 425);
		charmove.setDirection("right");
		charmove.setState(charmove.getfireRightMove());
		
		stage.start();
		f1.start();
		w1.start();
		b1.start();
	}
	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		screenGraphic =screenImage.getGraphics();
		screenDraw(screenGraphic);
		g.drawImage(screenImage, 0, 0, null);
		
	}
	private void screenDraw(Graphics g) {
		//���� ������ũ���� �׸�
		g.drawImage(background, 0, 0, null);
		
		//��, ��ֹ� ������ũ���� �׸�
		stage.drawItems(g);
		stage.drawFire(g);
		stage.drawWater(g);
		stage.drawBog(g);
		
		//ĳ���� �׸���
		g.drawImage(charmove.getState(), charmove.getPos_X(), charmove.getPos_Y(), null);
		
		//����Ʈ �Լ��� ���ư�
		this.repaint();
	}
}