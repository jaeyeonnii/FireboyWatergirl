package fbwg_1;

import java.awt.Image;

import javax.swing.ImageIcon;

public class FireDoor extends Thread {
	private Image fireDoor1 = new ImageIcon(Main.class.getResource("../images/doorF1.png")).getImage();
	private Image fireDoor2 = new ImageIcon(Main.class.getResource("../images/doorF2.png")).getImage();
	private Image fireDoor3 = new ImageIcon(Main.class.getResource("../images/door3.png")).getImage();
	
	private int x=805, y=75;

	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	private Image nowImage = fireDoor1;
	
	public Image getimage() {
		return nowImage;
	}
	
	
	public boolean come = false; //캐릭터 감지
	
	public void comming() {
		come = true;
//		System.out.println("hi");
	}
		public FireDoor() {
			
		}
		@Override
		public void run() {
			while(true) {
		
					if(nowImage!=fireDoor3) {
						new Music("Door.mp3", false).start();
						for(int i=0;i<3;i++) {
							if(i==1)
								nowImage=fireDoor2;
							else if(i==2) {
								nowImage=fireDoor3;
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
