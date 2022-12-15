package fbwg_1;


import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;




public class Level1 extends JFrame {

	//더블 버퍼링을 활용 변수 선언
	private Image screenImage;
	private Graphics screenGraphic;
	
	//사용할 이미지
	private Image background = new ImageIcon(Main.class.getResource("../images/level1back.png")).getImage();
	
	//사용할 음악
	public Music playMusic = new Music("Level Music.mp3", true);
	
	//스테이지 생성
	public static Stage stage = new Stage();
	
	//문 생성
	public static FireDoor firedoor = new FireDoor();
	public static WaterDoor waterdoor = new WaterDoor();
		
	//캐릭터 생성
	public static CharMove watergirl = new CharMove();
	public static CharMove fireboy = new CharMove();
	
	//창 생성
//	private Gameover gameover= new Gameover();
//	private Gameclear gameclear= new Gameclear();
	//장애물 생성
	public static Fire f1 = new Fire(450,720);
	public static Water w1 = new Water(650,720);
	public static Bog b1 = new Bog(590,565);
	//블록 생성
	public static Block bl = new Block();
	
	public Level1() { //생성자
		setTitle("Fireboy and Watergirl");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   );
		setResizable(false); //사이즈 변경 막기
		setLocationRelativeTo(null); //컴퓨터 중앙에 창 뜨기
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //게임창 종료시 프로그램 종료 (중요)
		setLayout(null);
		setVisible(true); //화면출력
		
		//키 리스너 생성
		addKeyListener(new KeyListener());
		
		//캐릭터 초기 설정
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
		//맵을 오프스크린에 그림
		g.drawImage(background, 0, 0, null);
		
		//템 오프스크린에 그림
		stage.drawItems(g);
		
		stage.drawblock(g);
//		문 그리기
		stage.drawDoor(g);
		
		//캐릭터 그리기
		g.drawImage(watergirl.getState(), watergirl.getPos_X(), watergirl.getPos_Y(), null);
		g.drawImage(fireboy.getState(), fireboy.getPos_X(), fireboy.getPos_Y(), null);
		//장애물 그리기
		stage.drawFire(g);
		stage.drawWater(g);
		stage.drawBog(g);

//		stage.drawAgain(g);
		
		//페인트 함수로 돌아감
		this.repaint();
	}
	//새로시작 리스타트
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