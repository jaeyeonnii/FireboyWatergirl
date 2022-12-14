package fbwg_1;

import java.awt.Image;

import javax.swing.ImageIcon;


public class Bog extends Thread{
	//����� �̹���
	private Image bog1 = new ImageIcon(Main.class.getResource("../images/lava1.png")).getImage();
	private Image bog2 = new ImageIcon(Main.class.getResource("../images/lava2.png")).getImage();
	
	//��ġ
	private int x, y;

	private boolean step = false;
	private Image nowState = bog1;
	//������
	public Bog(int x, int y) {
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
				nowState = bog1;
				step = true;
			}
			else {
				nowState = bog2;
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
