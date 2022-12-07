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
      setResizable(false); //������ ���� ����
      setLocationRelativeTo(null); //��ǻ�� �߾ӿ� â �߱�
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //����â ����� ���α׷� ���� (�߿�)
      setVisible(true); //ȭ�����
      setLayout(null);
      page1.setLayout(null);
      page1.setBounds(0, 0, Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
      setpanel();
      btn();
   }

   public void setpanel() {
		/*��ġ ����*/
		playBt.setBounds(360, 400, 264, 131);
//		playBt.setBorderPainted(false); // �׵θ�
//		playBt.setContentAreaFilled(false); // ���
//		playBt.setFocusPainted(false); // ��Ŀ�� ǥ��
		playBt.setIcon(play);
		//playBt.setOpaque(false);
		playBt.setLayout(null);
		page1.setBounds(0, 0, Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);//�г�1�� ��ġ ����
	   page2.setBounds(0, 0, Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);//�г�2�� ��ġ ����
		/*���̾ƿ� ����*/
	   page2.setLayout(null);//���̾ƿ� ����
	   page1.setLayout(null);//���̾ƿ� ����
		/*visible*/
	   page2.setVisible(false);//â�� ������ �ʰ�
		/*�г��̳� �����ӿ� �߰�*/
	   add(page1);//�����ӿ� �г��� �߰�
	   add(page2);//�����ӿ� �г��� �߰�
	   page1.add(playBt);//�г�1�� ��ư�� �߰�
	   
	   //plabel.setBounds(360, 400, 264, 131);
	   //page1.add(plabel);
	   //plabel.setVisible(true);
   }
   public void btn() {
//	  playBt.setBounds(360,400,264,131); //��ġ, ũ��
//	  playBt.setBorderPainted(false); //�׵θ�
//	  playBt.setContentAreaFilled(false); //���
//	  playBt.setFocusPainted(false); //��Ŀ�� ǥ��
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
	        //Ŭ�� �� �̺�Ʈ ó��
	    	page1.setVisible(false);//â�� ���̰�
			page2.setVisible(true);//â�� ���̰�
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
//      paintComponents(g); //JLabel �׷���
//      
//      this.repaint();
//   }
}