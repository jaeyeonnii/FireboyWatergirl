package fbwg_1;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class level1 extends JFrame {
	
	public level1() {
		setTitle("Fireboy and Watergirl");
	      setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
	      setResizable(false); //������ ���� ����
	      setLocationRelativeTo(null); //��ǻ�� �߾ӿ� â �߱�
	      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //����â ����� ���α׷� ���� (�߿�)
	      setVisible(true); //ȭ�����
	      setLayout(null);
	}
}
