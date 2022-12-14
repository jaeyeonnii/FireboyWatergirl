package fbwg_1;

import java.awt.Image;

import javax.swing.ImageIcon;


public class Water extends Thread{
	//사용할 이미지
	private Image water1 = new ImageIcon(Main.class.getResource("../images/water1.png")).getImage();
	private Image water2 = new ImageIcon(Main.class.getResource("../images/water2.png")).getImage();
	
	//위치
	private int x, y;

	private boolean step = false;
	private Image nowState = water1;
	//생성자
	public Water(int x, int y) {
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
				nowState = water1;
				step = true;
			}
			else {
				nowState = water2;
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