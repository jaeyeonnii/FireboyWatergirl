package fbwg_1;


import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyListener extends KeyAdapter {
	//private Music sound;
	
	//���� �� ���� �Ǵ� ������ ����Ű�� ���ȴ��� Ȯ���ϱ� ���� ����
	public static boolean pressedLeftKey = false;
	public static boolean pressedRightKey = false;
	
	@Override
	//Ű�� ������ �� �۵��ϴ� �κ�
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			if(!Level1.watergirl.isLeft()) {
				Level1.watergirl.moveFireLeft();
			}
			break;
		case KeyEvent.VK_RIGHT:
			if(!Level1.watergirl.isRight()) {
				Level1.watergirl.moveFireRight();
			}
			break;
		case KeyEvent.VK_UP:
			Level1.watergirl.jump();
			break;
		case KeyEvent.VK_DOWN:
			Level1.watergirl.lower();
			break;
		}
//		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
//			Level1.watergirl.moveFireLeft();
//			pressedLeftKey = true;
//		}
//		
//		else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
//			Level1.watergirl.moveFireRight();
//			pressedRightKey = true;
//		}
//		
//		else if (e.getKeyCode() == KeyEvent.VK_UP) {
//			Level1.watergirl.jump();
//		}
//		
//		else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
//			Level1.watergirl.lower();
//		}
//		
		
	}
	
	//Ű�� ���� �� �۵��ϴ� �κ�
	public void keyReleased(KeyEvent e) {
//		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
//			Level1.watergirl.keyRelease();
//			pressedLeftKey = false;
//		}
//		
//		else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
//			Level1.watergirl.keyRelease();
//			pressedRightKey = false;
//		}
//		
//		else if (e.getKeyCode() == KeyEvent.VK_UP) {
//			Level1.watergirl.descend();
//		}
//		
//		else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
//			
//		}
		
		switch(e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			Level1.watergirl.setLeft(false);
			break;
		case KeyEvent.VK_RIGHT:
			Level1.watergirl.setRight(false);
			break;
		
		}
		
		
	}
}
