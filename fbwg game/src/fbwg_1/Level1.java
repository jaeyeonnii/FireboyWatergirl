package fbwg_1;

import javafx.stage.*;
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
//		setResizable(false); //사이즈 변경 막기
//	      setLocationRelativeTo(null); //컴퓨터 중앙에 창 뜨기
//	      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //게임창 종료시 프로그램 종료 (중요)
//	      setLayout(null);
//	      //getContentPane().setBackground(Color.WHITE);
//
//	      //(new MyThread("../images/lava1.png", "../images/lava2.png", 10, 10)).start();
//	      
//	      setVisible(true); //화면출력
//	}
//	
	//더블 버퍼링을 활용 변수 선언
	private Image screenImage;
	private Graphics screenGraphic;
	
	private Image background = new ImageIcon(Main.class.getResource("../images/level1back.png")).getImage();
	
	//스테이지 생성
	public static Stage stage = new Stage();
	
	public Level1() { //생성자
		setTitle("Fireboy and Watergirl");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   );
		setResizable(false); //사이즈 변경 막기
		setLocationRelativeTo(null); //컴퓨터 중앙에 창 뜨기
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //게임창 종료시 프로그램 종료 (중요)
		setLayout(null);
		setVisible(true); //화면출력
		stage.start();
	}
	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		screenGraphic =screenImage.getGraphics();
		screenDraw(screenGraphic);
		g.drawImage(screenImage, 0, 0, null);
	}
	private void screenDraw(Graphics g) {
		//맵을 오프스크린에 그림
		g.drawImage(background, 0, 0, null);
		
		//템 오프스크린에 그림
		stage.drawItems(g);
		
		//페인트 함수로 돌아감
		this.repaint();
	}
	public class Item {
		private int pos_x, pos_y;
		
		public Item(int pos_x, int pos_y) {
			this.pos_x = pos_x;
			this.pos_y = pos_y;
		}
		
		public int getPos_x() {
			return pos_x;
		}
		public void setPos_x(int pos_x) {
			this.pos_x= pos_x;
		}
		public int getPos_y() {
			return pos_y;
		}
		public void setPos_y(int pos_y) {
			this.pos_y= pos_y;
		}
	}
	public class Firetem extends Item {
		private Image firetem = new ImageIcon(Main.class.getResource("../images/fireitem.png")).getImage();
		
		public Firetem(int pos_x, int pos_y) {
			super(pos_x, pos_y);
		}
		public Image getFiretem() {
			return firetem;
		}
	}
	
	public class Watertem extends Item {
		private Image watertem = new ImageIcon(Main.class.getResource("../images/wateritem.png")).getImage();
		
		public Watertem(int pos_x, int pos_y) {
			super(pos_x, pos_y);
		}
		public Image getWatertem() {
			return watertem;
		}
	}
	
	public class Stage extends Thread{
		private ArrayList<Item> itemList = new ArrayList<>();
		
		public ArrayList<Item> getItemList(){
			return itemList;
		}
		public void makeItems(Item item) {
			itemList.add(item);
		}
	
		public void drawItems(Graphics g) {
			for (int i=0; i< itemList.size(); i++) {
				if(itemList.get(i) instanceof Firetem) {
					Firetem fir = (Firetem)itemList.get(i);
					g.drawImage(fir.getFiretem(), fir.getPos_x(), fir.getPos_y(), null);
				}
				else if(itemList.get(i) instanceof Watertem) {
					Watertem wa = (Watertem)itemList.get(i);
					g.drawImage(wa.getWatertem(), wa.getPos_x(), wa.getPos_y(), null);
				}
			}
		}
			@Override
			public void run() {
				makeItems(new Watertem(10,10));
				makeItems(new Firetem(100,10));
			}
		
	}
}

	
