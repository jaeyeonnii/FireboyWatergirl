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
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			Level1.charmove.moveFireLeft();
			pressedLeftKey = true;
		}
		
		else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			Level1.charmove.moveFireRight();
			pressedRightKey = true;
		}
		
		else if (e.getKeyCode() == KeyEvent.VK_UP) {
			Level1.charmove.upper();
		}
		
		else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			Level1.charmove.lower();
		}
		
		else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			Level1.charmove.jump();
			//sound = new Music("jumpSound.mp3", false);
			//sound.start();
			
		}
	}
	
	//키를 뗐을 때 작동하는 부분
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			Level1.charmove.keyRelease();
			pressedLeftKey = false;
		}
		
		else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			Level1.charmove.keyRelease();
			pressedRightKey = false;
		}
		
		else if (e.getKeyCode() == KeyEvent.VK_UP) {
			
		}
		
		else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			
		}
		
		else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			Level1.charmove.descend();
		}
	}
}
