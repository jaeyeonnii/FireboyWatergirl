package fbwg_1;


import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;


public class Level1 extends JFrame {
//	private Image gameback= new ImageIcon(Main.class.getResource("../images/level1back.png")).getImage();
//	private ImageIcon lava1 = new ImageIcon(Main.class.getResource("../images/lava1.png"));
//	private ImageIcon lava2 = new ImageIcon(Main.class.getResource("../images/lava2.png"));


//	class MyThread extends Thread {
//		private JLabel label;
//		private String fname1, fname2;
//		private int x, y;
//		private boolean step = false;
//
//		public MyThread(String fname1, String fname2, int x, int y) {
//			this.x = x;
//			this.y = y;
//			this.fname1 = fname1;
//			this.fname2 = fname2;
//			label = new JLabel();	
//			label.setIcon(new ImageIcon(Main.class.getResource(fname1)));
//			label.setBounds(x, y, 195, 22);
//			add(label);
//		}
//
//		public void run() {
//			while(true) {
//
//				if(step == false) {
//					label.setIcon(new ImageIcon(Main.class.getResource(fname1)));
//					step = true;
//				}
//				else {
//					label.setIcon(new ImageIcon(Main.class.getResource(fname2)));
//					step = false;
//				}
//				label.setBounds(x, y, 195, 22);
//				repaint();
//				try {
//					Thread.sleep(100);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//	}
//	public void drawWave(Graphics g) {
//		g.drawImage(, )
//	}
//	public Level1() {
//		setTitle("Fireboy and Watergirl");
//		setSize(1000, 750);
//		setResizable(false); //������ ���� ����
//	      setLocationRelativeTo(null); //��ǻ�� �߾ӿ� â �߱�
//	      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //����â ����� ���α׷� ���� (�߿�)
//	      setLayout(null);
//	      //getContentPane().setBackground(Color.WHITE);
//
//	      //(new MyThread("../images/lava1.png", "../images/lava2.png", 10, 10)).start();
//	      
//	      setVisible(true); //ȭ�����
//	}
//	
	//���� ���۸��� Ȱ�� ���� ����
	private Image screenImage;
	private Graphics screenGraphic;
	
	//����� �̹���
	private Image background = new ImageIcon(Main.class.getResource("../images/level1back.png")).getImage();
	
	//�������� ����
	public static Stage stage = new Stage();
	
	//ĳ���� ����
	public static CharMove charmove = new CharMove();
	
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
		charmove.setDirection("left");
		charmove.setState(charmove.getfireLeftMove());
		
		stage.start();
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
		
		//ĳ���� �׸���
		g.drawImage(charmove.getState(), charmove.getPos_X(), charmove.getPos_Y(), null);
		
		//����Ʈ �Լ��� ���ư�
		this.repaint();
	}
}