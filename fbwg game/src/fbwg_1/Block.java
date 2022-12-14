package fbwg_1;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Block extends Thread{
	private Image block = new ImageIcon(Main.class.getResource("../images/blockP.png")).getImage();

	
	private int block_x=20, block_y=390;
	private int bt1_x, bt1_y;
	private int bt2_x, bt2_y;
	
	public int getX() {
		return block_x;
	}
	public int getY() {
		return block_y;
	}
	//사진 가져오기
	public Image getblock() {
		return block;
	}

	public boolean push =false; //버튼 눌림 감지
		public Block() {
			
		}
		@Override
		public void run() {
			while(true) {
				if(push==true) {
					for(;block_y<150;block_y++) {
					}
				}
				else {
					for(;block_y>=100;block_y--) {
					}
				}
				try {
					Thread.sleep(500);
				} catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	
}
