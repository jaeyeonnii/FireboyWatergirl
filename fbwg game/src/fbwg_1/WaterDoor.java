package fbwg_1;

import java.awt.Image;

import javax.swing.ImageIcon;

public class WaterDoor extends Thread {
	private Image waterDoor1 = new ImageIcon(Main.class.getResource("../images/doorW1.png")).getImage();
	private Image waterDoor2 = new ImageIcon(Main.class.getResource("../images/doorW2.png")).getImage();
	private Image waterDoor3 = new ImageIcon(Main.class.getResource("../images/door3.png")).getImage();
	
	private int x=895, y=75;

	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	private Image nowImage = waterDoor1;
	
	public Image getimage() {
		return nowImage;
	}
	
	
	public boolean come = false; //캐릭터 감지
	
	public void comming() {
		come=true;
	}
		public WaterDoor() {
			
		}
		@Override
		public void run() {
			while(true) {
				
				if(nowImage!=waterDoor3) {
					new Music("Door.mp3", false).start();
					for(int i=0;i<3;i++) {
						if(i==1)
							nowImage=waterDoor2;
						else if(i==2) {
							nowImage=waterDoor3;
							come = false;
						}
						try {
							Thread.sleep(500);
						} catch(Exception e) {
						
						}
					}
				}
				
		}
		}
}
