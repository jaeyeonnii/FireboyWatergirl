package fbwg_1;


import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyListener extends KeyAdapter {
	//private Music sound;
	
	//점프 시 왼쪽 또는 오른쪽 방향키가 눌렸는지 확인하기 위해 선언
	public static boolean pressedLeftKey = false;
	public static boolean pressedRightKey = false;
	
	@Override
	//키를 눌렀을 때 작동하는 부분
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
	
	//키를 뗐을 때 작동하는 부분
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
