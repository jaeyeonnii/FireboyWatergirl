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
	
	//Ű�� ���� �� �۵��ϴ� �κ�
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
