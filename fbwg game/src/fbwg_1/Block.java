package fbwg_1;

import java.awt.Image;

import javax.swing.ImageIcon;



public class Block extends Thread{
	private Image block = new ImageIcon(Main.class.getResource("../images/blockP.png")).getImage();

	
	private int x=20, y=390;
	private int max=470, min=390;
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public Image getimage() {
		return block;
	}
	//���� ��������
	public Image getblock() {
		return block;
	}
	
	
	private boolean push =false; //��ư ���� ����
	
	public void pushing() {
		push=true;
	}
	public void out() {
		push=false;
	}
		public Block() {
			
		}
		@Override
		public void run() {
			while(true) {
				if(push) {
					if(y<max) {
						y+=2;
					}
					if(y == min+2) {
						new Music("Pusher.mp3", false).start();
					}
					
					try {
						Thread.sleep(20);
					} catch (Exception e) {
					
					}
				}
				
				else{
					if(y>=min)
						y-=2;

					if(y==max-2)
						new Music("Pusher.mp3", false).start();
				
					try {
						Thread.sleep(20);
					} catch(Exception e) {
					
					}
				}
			}
			
		}


//private String direction = "right";
//		@Override
//		public void run() {
//			
//				if (direction.equals("left")) {
//					y -= 10;
//					
//					if (x <= min)
//						direction = "right";
//					
//					try {
//						Thread.sleep(20);
//					} catch (Exception e) {
//						
//					}
//				}
//				
//				else if (direction.equals("right")) {
//					x += 10;
//					
//					if (x >= max)
//						direction = "left";
//					
//					try {
//						Thread.sleep(20);
//					} catch (Exception e) {
//						
//					}
//				}
//			}
//		}
}
