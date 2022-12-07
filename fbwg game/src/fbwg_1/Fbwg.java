package fbwg_1;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Label;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Fbwg  extends JFrame{
   
//   private Image screenImage;
//   private Graphics screenGraphic;
   
	static JPanel page1=new JPanel() {
	   Image startback= new ImageIcon(Main.class.getResource("../images/startback.png")).getImage();
	   Image title = new ImageIcon(Main.class.getResource("../images/title.png")).getImage();
	   Image beam = new ImageIcon(Main.class.getResource("../images/Beam.png")).getImage();
	   public void paint(Graphics g) {

			  g.drawImage(startback, 0, 0, null);
			  g.drawImage(beam,420,-100,null);
			  g.drawImage(beam,300,-200,null);
			  g.drawImage(beam,540,-200,null);
			  g.drawImage(title, 70, 70, null);
		   }
   };
   static JPanel page2=new JPanel() {
	   Image levelback= new ImageIcon(Main.class.getResource("../images/levelback.png")).getImage();
	   public void paint(Graphics g) {
		   g.drawImage(levelback, 0, 0, null);
	   }
   };
//   private Image startback= new ImageIcon(Main.class.getResource("../images/startback.png")).getImage();
//   private Image title = new ImageIcon(Main.class.getResource("../images/title.png")).getImage();
//   private Image beam = new ImageIcon(Main.class.getResource("../images/Beam.png")).getImage();
   private ImageIcon play =new ImageIcon(Main.class.getResource("../images/play.png"));
   private ImageIcon play2 = new ImageIcon(Main.class.getResource("../images/play2.png"));
   private JButton playBt = new JButton(play);
   //private JLabel plabel = new JLabel(play);
   
   
   public Fbwg() {
      setTitle("Fireboy and Watergirl");
      setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
      setResizable(false); //사이즈 변경 막기
      setLocationRelativeTo(null); //컴퓨터 중앙에 창 뜨기
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //게임창 종료시 프로그램 종료 (중요)
      setVisible(true); //화면출력
      setLayout(null);
      page1.setLayout(null);
      page1.setBounds(0, 0, Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
      setpanel();
      btn();
   }

   public void setpanel() {
		/*위치 설정*/
		playBt.setBounds(360, 400, 264, 131);
//		playBt.setBorderPainted(false); // 테두리
//		playBt.setContentAreaFilled(false); // 배경
//		playBt.setFocusPainted(false); // 포커스 표시
		playBt.setIcon(play);
		//playBt.setOpaque(false);
		playBt.setLayout(null);
		page1.setBounds(0, 0, Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);//패널1의 위치 설정
	   page2.setBounds(0, 0, Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);//패널2의 위치 설정
		/*레이아웃 지정*/
	   page2.setLayout(null);//레이아웃 설정
	   page1.setLayout(null);//레이아웃 설정
		/*visible*/
	   page2.setVisible(false);//창이 보이지 않게
		/*패널이나 프레임에 추가*/
	   add(page1);//프레임에 패널을 추가
	   add(page2);//프레임에 패널을 추가
	   page1.add(playBt);//패널1에 버튼을 추가
	   
	   //plabel.setBounds(360, 400, 264, 131);
	   //page1.add(plabel);
	   //plabel.setVisible(true);
   }
   public void btn() {
//	  playBt.setBounds(360,400,264,131); //위치, 크기
//	  playBt.setBorderPainted(false); //테두리
//	  playBt.setContentAreaFilled(false); //배경
//	  playBt.setFocusPainted(false); //포커스 표시
//	  playBt.setOpaque(false);
//	  playBt.setLayout(null);
	  playBt.addMouseListener(new MouseAdapter() {
	     @Override
	     public void mouseEntered(MouseEvent e) {
	        playBt.setIcon(play2);
	        //plabel.setIcon(play2);
	     }
	     @Override
	     public void mouseExited(MouseEvent e) {
	        playBt.setIcon(play);
	    	 //plabel.setIcon(play);
	     }
	     @Override
	     public void mousePressed(MouseEvent e) {
	        //클릭 시 이벤트 처리
	    	page1.setVisible(false);//창이 보이게
			page2.setVisible(true);//창이 보이게
	     }
	  });
   }
//   public void paint(Graphics g) {
////	  screenImage = createImage(Main.SCREEN_WIDTH,Main.SCREEN_HEIGHT);
////	  screenGraphic = screenImage.getGraphics();
////      screenDraw(screenGraphic);
////      g.drawImage(screenImage, 0,0,null);
//	  g.drawImage(startback, 0, 0, null);
//	  g.drawImage(beam,420,-100,null);
//	  g.drawImage(beam,300,-200,null);
//	  g.drawImage(beam,540,-200,null);
//	  g.drawImage(title, 70, 70, null);
//   }
   
//   public void screenDraw(Graphics g) {
//      g.drawImage(startback, 0, 0, null);
//      g.drawImage(beam,420,-100,null);
//      g.drawImage(beam,300,-200,null);
//      g.drawImage(beam,540,-200,null);
//      g.drawImage(title, 70, 70, null);
//
//      paintComponents(g); //JLabel 그려줌
//      
//      this.repaint();
//   }
}