package levelmap_1;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JButton;



public class LevelMap extends JFrame{
		

	
	private ImageIcon img = new ImageIcon(LevelMap.class.getResource("../image/btn.png"));
	private Image level = new ImageIcon(LevelMap.class.getResource("../image/levelMap3.png")).getImage();//배경화면 
	static JButton btnImg = new JButton("버튼");
	
	public LevelMap() {
		Map();
		btn();
		
	}
	public void Map() {
		setTitle("Fireboy and Watergirl");
	    setSize(MainLev.SCREEN_WIDTH, MainLev.SCREEN_HEIGHT);
	    setResizable(false); //사이즈 변경 막기
	    setLocationRelativeTo(null); //컴퓨터 중앙에 창 뜨기
	    setVisible(true); //화면출력
	    setLayout(null);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //게임창 종료시 프로그램 종료 (중요)
	    
	}
	public void btn() {
		btnImg.setLayout(null);
		btnImg.setBounds(445,650,100,100);
		btnImg.setIcon(img);
	    btnImg.setContentAreaFilled(false); //내용영역 채우기 없애줌.
		btnImg.setOpaque(false); //이미지 외에 영역을 투명하게 만들어줌
	    add(btnImg);
	    
	}
	public void paint(Graphics g) {
		g.drawImage(level,0,25,null);
	} 
	
	
	

}
