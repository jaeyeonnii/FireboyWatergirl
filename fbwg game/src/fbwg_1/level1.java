package fbwg_1;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class level1 extends JFrame {
	
	public level1() {
		setTitle("Fireboy and Watergirl");
	      setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
	      setResizable(false); //사이즈 변경 막기
	      setLocationRelativeTo(null); //컴퓨터 중앙에 창 뜨기
	      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //게임창 종료시 프로그램 종료 (중요)
	      setVisible(true); //화면출력
	      setLayout(null);
	}
}
