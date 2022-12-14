package fbwg_1;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CharMove {
	// 이미지 파일
	private Image fireRightMove1= new ImageIcon(Main.class.getResource("../images/waterRight.png")).getImage(); //기본 캐릭(불)
    private Image fireLeftMove1= new ImageIcon(Main.class.getResource("../images/waterLeft.png")).getImage(); 
    private Image fireRightMove2= new ImageIcon(Main.class.getResource("../images/waterRight2.png")).getImage(); //stop
    private Image fireLeftMove2= new ImageIcon(Main.class.getResource("../images/waterLeft2.png")).getImage();  //stop
    private Image fireLeftJump= new ImageIcon(Main.class.getResource("../images/waterLeft2.png")).getImage(); 
    private Image fireRightJump= new ImageIcon(Main.class.getResource("../images/waterRight2.png")).getImage(); 
    private Image waterRightMove1= new ImageIcon(Main.class.getResource("../images/waterRight.png")).getImage(); //기본 캐릭(불)
    private Image waterLeftMove1= new ImageIcon(Main.class.getResource("../images/waterLeft.png")).getImage(); 
    private Image waterRightMove2= new ImageIcon(Main.class.getResource("../images/waterRight2.png")).getImage(); //기본 캐릭(불)
    private Image waterLeftMove2= new ImageIcon(Main.class.getResource("../images/waterLeft2.png")).getImage(); 
    private Image waterLeftJump= new ImageIcon(Main.class.getResource("../images/waterLeft2.png")).getImage(); 
    private Image waterRightJump= new ImageIcon(Main.class.getResource("../images/waterRight2.png")).getImage(); 
    private boolean left;
    private boolean right;
    int i =0;
    
    
   
    
	// 위치
	private int pos_X, pos_Y;
	
	//보고 있는 방향
	private String direction;
	
	//장애물을 만났는지 여부
	private boolean crash = false; 
	
	//표시할 이미지
	private Image state;
	
	public Image getState() {
		return state;
	}
	
	public void setState(Image image) {
		this.state = image;
	}

	public String getDirection() {
		return direction;
	}
	
	public void setDirection(String direction) {
		this.direction = direction;
	}

	public int getPos_X() {
		return pos_X;
	}
	
	public void setPos_X(int pos_X) {
		this.pos_X = pos_X;
	}

	public int getPos_Y() {
		return pos_Y;
	}
	
	public void setPos_Y(int pos_Y) {
		this.pos_Y = pos_Y;
	}
	
	public void setPosition(int pos_X, int pos_Y) {
		this.pos_X = pos_X;
		this.pos_Y = pos_Y;
	}
	
	public Image getfireLeftMove() { //getAlfyLeftMove
		return fireLeftMove1;
	}
	
	public Image getfireRightMove() {//getAlfyRightMove
		return fireRightMove1;
	}
	
	public Image getwaterLeftMove() { //getAlfyLeftMove
		return waterLeftMove1;
	}
	
	public Image getwaterRightMove() {//getAlfyRightMove
		return waterRightMove1;
	}
	

	public void moveFireRight() {
		right = true;
		
		new Thread(()->{
			while(right) {
				if (direction.equals("left")) {
					direction = "right";
				}
				
				if (pos_X <= 1000)
					pos_X += 10;
				if(i==0) {
					state = fireRightMove1; 
					i=1;
				}else {
					state = fireRightMove2; 
					i=0;
				}
				
				try {
					Thread.sleep(50);
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
		
		
		
	}
	
	public void moveFireLeft() {
		left = true;
		new Thread(()->{
			while(left) {
				if (direction.equals("right")) {
					direction = "left";
				}
				
				if (pos_X >= 0)
					pos_X -= 10;
				if(i==0) {
					state = fireLeftMove1; 
					i=1;
				}else {
					state = fireLeftMove2; 
					i=0;
				}
				try {
					Thread.sleep(50);
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
		
	}
	
	public void upper() {
		if (pos_Y > 116)  //보류!!!!!!!
			pos_Y -= 55;
	}
	
	public void lower() {
		if (pos_Y <= 422)
			pos_Y += 55;
	}
	
	public void jump() {
		
		if (direction.equals("left") && KeyListener.pressedLeftKey) {
			pos_X -= 100;
			pos_Y -= 60;
			state = fireLeftJump;
		}
		else if (direction.equals("right") && KeyListener.pressedRightKey) {
			pos_X += 100;
			pos_Y -= 60;
			state = fireRightJump;
		}	
		else if (direction.equals("left") && !KeyListener.pressedLeftKey) {
			pos_Y -= 60;
			state = waterLeftJump;
		}
		else if (direction.equals("right")) {
			pos_Y -= 60;
			state = waterRightJump;
		}
	}
	
	public void descend() { //캐릭터 멈춤 부분
		
		if (direction.equals("left") && KeyListener.pressedLeftKey) {
			pos_X -= 100;
			pos_Y += 60;
			state = fireLeftMove2;
		}
		else if (direction.equals("right") && KeyListener.pressedRightKey) {
			pos_X += 100;
			pos_Y += 60;
			state = fireRightMove2;
		}	
		else if (direction.equals("left") && !KeyListener.pressedLeftKey) {
			pos_Y += 60;
			state = fireLeftMove2;
		}
		else if (direction.equals("right")) {
			pos_Y += 60;
			state = fireRightMove2;
		}
	}
	
	public void keyRelease() {
		if (direction.equals("left"))
			state = fireLeftMove2;
		else if (direction.equals("right"))
			state = fireRightMove2;
	}
	
	public void checkLaddering() {
		if (300 <= getPos_X() && getPos_X() <= 360)
			crash = true;
		else
			crash = false;
	}
	
//	public void dropAlfy() {
//		if (528 <= getPos_X() && getPos_X()+64 <= 854 && 500 <= getPos_Y() + 120 
//				&& getPos_Y() + 120 <= 550) 
//		{
//			setPos_Y(552);
//			
//			//new Music("died.mp3", false).start();
//			
//			for (int i=0; i < Level1.stage.getMonList().size(); i++) {
//				Level1.stage.getMonList().get(i).close();
//			}
//			
//			try {
//				Thread.sleep(2000);
//			} catch (Exception e) {}
//			
//			Level1.stage.close();
//			Main.bal.restartStage();
//			
//		}
//		else if (523 <= getPos_X() && getPos_X()+64 <= 642 && 180 <= getPos_Y() + 110 
//				&& getPos_Y() + 110 <= 220) 
//		{
//			setPos_Y(552);
//			
//			//new Music("died.mp3", false).start();
//			
//			for (int i=0; i < Level1.stage.getMonList().size(); i++) {
//				Level1.stage.getMonList().get(i).close();
//			}
//			
//			try {
//				Thread.sleep(2000);
//			} catch (Exception e) {}
//			
//			Level1.stage.close();
//			Main.bal.restartStage();
//		}
//		else if (1064 <= getPos_X() && 180 <= getPos_Y() + 120 && getPos_Y() + 120 <= 220)
//			setPos_Y(252);
//		else if (getPos_X() + 64 <= 1063 && 250 <= getPos_Y() && getPos_Y() <= 252)
//			setPos_Y(422);
//	}
	}


