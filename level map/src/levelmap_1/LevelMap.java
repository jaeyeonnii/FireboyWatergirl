package levelmap_1;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JButton;



public class LevelMap extends JFrame{
		

	
	private ImageIcon img = new ImageIcon(LevelMap.class.getResource("../image/btn.png"));
	private Image level = new ImageIcon(LevelMap.class.getResource("../image/levelMap3.png")).getImage();//���ȭ�� 
	static JButton btnImg = new JButton("��ư");
	
	public LevelMap() {
		Map();
		btn();
		
	}
	public void Map() {
		setTitle("Fireboy and Watergirl");
	    setSize(MainLev.SCREEN_WIDTH, MainLev.SCREEN_HEIGHT);
	    setResizable(false); //������ ���� ����
	    setLocationRelativeTo(null); //��ǻ�� �߾ӿ� â �߱�
	    setVisible(true); //ȭ�����
	    setLayout(null);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //����â ����� ���α׷� ���� (�߿�)
	    
	}
	public void btn() {
		btnImg.setLayout(null);
		btnImg.setBounds(445,650,100,100);
		btnImg.setIcon(img);
	    btnImg.setContentAreaFilled(false); //���뿵�� ä��� ������.
		btnImg.setOpaque(false); //�̹��� �ܿ� ������ �����ϰ� �������
	    add(btnImg);
	    
	}
	public void paint(Graphics g) {
		g.drawImage(level,0,25,null);
	} 
	
	
	

}
