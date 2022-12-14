package fbwg_1;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Block extends Thread{
	private Image block = new ImageIcon(Main.class.getResource("../images/blockP.png")).getImage();

	
	private int block_x=20, block_y=390;
	private int max=470, min=390;
	
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
					if(block_y<max)
						block_y+=10;
					
					try {
						Thread.sleep(20);
					} catch (Exception e) {
					
					}
				}
				
				else if(push==false){
					if(block_y>=min)
						block_y-=10;
				
					try {
						Thread.sleep(20);
					} catch(Exception e) {
					
					}
				}
			}
		}
	
}
