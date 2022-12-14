package fbwg_1;

import java.awt.Image;

import javax.swing.ImageIcon;


public class Fire extends Thread{
	//사용할 이미지
	private Image fire1 = new ImageIcon(Main.class.getResource("../images/lava1.png")).getImage();
	private Image fire2 = new ImageIcon(Main.class.getResource("../images/lava2.png")).getImage();
	
	//위치
	private int x, y;

	private boolean step = false;
	private Image nowState = fire1;
	//생성자
	public Fire(int x, int y) {
		this.x=x;
		this.y=y;
	}
	public Image getNowState() {
		return nowState;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	@Override
	public void run() {
		while(true) {
			if(step == false) {
				nowState = fire1;
				step = true;
			}
			else {
				nowState = fire2;
				step = false;
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
