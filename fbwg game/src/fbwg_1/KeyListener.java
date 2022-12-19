package fbwg_1;


import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyListener extends KeyAdapter {
	private Music sound;
	

	
	@Override
	//키를 눌렀을 때 작동하는 부분
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			if(!Level1.fireboy.isLeft()) {
				Level1.fireboy.moveFireLeft();
			}
			break;
		case KeyEvent.VK_RIGHT:
			if(!Level1.fireboy.isRight()) {
				Level1.fireboy.moveFireRight();
			}
			break;
		case KeyEvent.VK_UP:
			Level1.fireboy.up();
			sound =new Music("Jump fb.mp3", false);
			sound.start();
			break;
		case KeyEvent.VK_A:
			if(!Level1.watergirl.isLeft()) {
				Level1.watergirl.moveWaterLeft();
			}
			break;
		case KeyEvent.VK_D:
			if(!Level1.watergirl.isRight()) {
				Level1.watergirl.moveWaterRight();
			}
			break;
		case KeyEvent.VK_W:
			Level1.watergirl.up();
			sound =new Music("Jump wg.mp3", false);
			sound.start();
			break;
		
		}

		
	}
	
	//키를 뗐을 때 작동하는 부분
	public void keyReleased(KeyEvent e) {
		
		switch(e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			Level1.fireboy.setLeft(false);
			break;
		case KeyEvent.VK_RIGHT:
			Level1.fireboy.setRight(false);
			break;
		case KeyEvent.VK_A:
			Level1.watergirl.setLeft(false);
			break;
		case KeyEvent.VK_D:
			Level1.watergirl.setRight(false);
			break;
		
		}
		
		
	}
}
