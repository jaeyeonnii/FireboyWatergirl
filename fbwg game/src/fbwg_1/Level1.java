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
	
	//����� ����
	public Music playMusic = new Music("Level Music.mp3", true);
	
	//�������� ����
	public static Stage stage = new Stage();
	
	//�� ����
	public static FireDoor firedoor = new FireDoor();
	public static WaterDoor waterdoor = new WaterDoor();
		
	//ĳ���� ����
	public static CharMove watergirl = new CharMove();
	public static CharMove fireboy = new CharMove();
	
	//â ����
//	private Gameover gameover= new Gameover();
//	private Gameclear gameclear= new Gameclear();
	//��ֹ� ����
	public static Fire f1 = new Fire(450,720);
	public static Water w1 = new Water(650,720);
	public static Bog b1 = new Bog(590,565);
	//��� ����
	public static Block bl = new Block();
	
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
		watergirl.setPosition(30, 540);
		watergirl.setDirection("right");
		watergirl.setState(watergirl.getwaterRightMove());
		
		fireboy.setPosition(30, 640);
		fireboy.setDirection("right");
		fireboy.setState(fireboy.getfireRightMove());
		
		stage.start();
		f1.start();
		w1.start();
		b1.start();
		bl.start();
		firedoor.start();
		waterdoor.start();
	
		playMusic.start();
		

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
		
		//�� ������ũ���� �׸�
		stage.drawItems(g);
		
		stage.drawblock(g);
//		�� �׸���
		stage.drawDoor(g);
		
		//ĳ���� �׸���
		g.drawImage(watergirl.getState(), watergirl.getPos_X(), watergirl.getPos_Y(), null);
		g.drawImage(fireboy.getState(), fireboy.getPos_X(), fireboy.getPos_Y(), null);
		//��ֹ� �׸���
		stage.drawFire(g);
		stage.drawWater(g);
		stage.drawBog(g);

//		stage.drawAgain(g);
		
		//����Ʈ �Լ��� ���ư�
		this.repaint();
	}
	//���ν��� ����ŸƮ
	public void restartStage() {
		stage.getFireList().clear();
		stage.getWaterList().clear();
		stage.getBogList().clear();
		stage.getItemList().clear();
		stage.getBlockList().clear();
		stage.getfdList().clear();
		stage.getwdList().clear();

		stage = new Stage();
		f1 = new Fire(450,720);
		w1 = new Water(650,720);
		b1 = new Bog(590,565);
		bl= new Block();
		watergirl.setPosition(30, 540);
		watergirl.setDirection("right");
		watergirl.setState(watergirl.getwaterRightMove());
		
		fireboy.setPosition(30, 640);
		fireboy.setDirection("right");
		fireboy.setState(fireboy.getfireRightMove());
		
		stage.start();
		f1.start();
		w1.start();
		b1.start();
		bl.start();
		firedoor.start();
		waterdoor.start();
	}

	
}