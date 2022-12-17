package fbwg_1;

import java.awt.Graphics;

import java.awt.Image;

import javax.swing.ImageIcon;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CharMove {
	// �̹��� ����
	private Image fireRightMove1= new ImageIcon(Main.class.getResource("../images/fireRight1.png")).getImage(); //�⺻ ĳ��(��)
    private Image fireLeftMove1= new ImageIcon(Main.class.getResource("../images/fireLeft1.png")).getImage(); 
    private Image fireRightMove2= new ImageIcon(Main.class.getResource("../images/fireRight2.png")).getImage(); //stop
    private Image fireLeftMove2= new ImageIcon(Main.class.getResource("../images/fireLeft2.png")).getImage();  //stop
    private Image waterRightMove1= new ImageIcon(Main.class.getResource("../images/waterRight.png")).getImage(); //�⺻ ĳ��(��)
    private Image waterLeftMove1= new ImageIcon(Main.class.getResource("../images/waterLeft.png")).getImage(); 
    private Image waterRightMove2= new ImageIcon(Main.class.getResource("../images/waterRight2.png")).getImage(); //�⺻ ĳ��(��)
    private Image waterLeftMove2= new ImageIcon(Main.class.getResource("../images/waterLeft2.png")).getImage(); 
    private boolean left;
    private boolean right;
    private boolean up;
    private boolean down;
    private final int SPEED = 10;
    private final int JUMPSPEED = 3;
    private int JUMPDOWN = 100;
    
    int i =0;
    
    
   
    
	// ��ġ
	private int pos_X, pos_Y;
	
	//���� �ִ� ����
	private String direction;
	
	//��ֹ��� �������� ����
	private boolean crash = false; 
	
	//ǥ���� �̹���
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
	
	
	public void back() {
		//���Ͱ� ���� �κ� ��������
		if(pos_Y==540&&pos_X>=290&&pos_X<=300) {
			down2();
		}
		
		if((pos_Y<=320&&pos_Y>=308&&pos_X<=498&&pos_X>=460)
			||(pos_Y>=25&&pos_Y<=27&&pos_X<350&pos_X>=295)
			||(pos_Y>=48&&pos_Y<=52&&pos_X<=360&pos_X>=350)) {
			
			JUMPDOWN = 25;
			down2();
		}
		
		if((pos_Y>=275&&pos_Y<=280&&pos_X<=850&&pos_X>498
			||(pos_Y<=155&&pos_Y>=153&&pos_X<=475&&pos_X>465)
			||(pos_Y>=150&&pos_Y<=152&&pos_X>=180&&pos_X<=182))
			||(pos_Y>=100&&pos_Y<=102&&pos_X>=120&&pos_X<=122)) {
			JUMPDOWN = 50;
			down2();
		}
		if(pos_Y>=205&&pos_Y<=208&&pos_X>=823&&pos_X<=910) {
			JUMPDOWN = 70;
			down2();
		}
//		if((pos_X<150&&pos_Y>=435-45&&pos_Y<=435-45+2&&Block.getpush()==false)) {
//			while(true) {
//				pos_Y=-2;
//				
//				if(pos_Y==310) break;
//			}
//		}
		
		
	}
	public void moveWall() {
		
		new Thread(()->{
			while(true) {
				if(pos_X<150&&pos_Y>310&&pos_Y<=435-45+2&&Block.getpush()==false)
					pos_Y-=2;

				try {
					Thread.sleep(4000);
				} catch(Exception e) {
				
				}
			}
		}).start();
		
	}
	public void moveFireRight() {
		right = true;
		
		new Thread(()->{
			while(pos_X<910&&right) {//!(pos_Y>=540&&pos_Y<=640&&pos_X>=830)
				back();
				moveWall();
				
				if (direction.equals("Fleft")) {
					direction = "Fright";
				}
				
				if (pos_X <= 1000)
					pos_X += SPEED;
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
			while(pos_X>10&left) {
				back();
				moveWall();
				if (direction.equals("Fright")) {
					direction = "Fleft";
				}
				
				if (pos_X >= 0)
					pos_X -= SPEED;
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
	
	public void moveWaterRight() {
		right = true;
		new Thread(()->{
			
			while(pos_X<910&&right) {//!(pos_Y>=580&&pos_Y<=640&&pos_X>=830)
				back();
				moveWall();
				if (direction.equals("Wleft")) {
					direction = "Wright";
				}
				
				if (pos_X <= 1000)
					pos_X += SPEED;
				if(i==0) {
					state = waterRightMove1; 
					i=1;
				}else {
					state = waterRightMove2; 
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
	
	public void moveWaterLeft() {
		left = true;
		new Thread(()->{
			while(pos_X>10&&left) {
				back();
				moveWall();
				if (direction.equals("Wright")) {
					direction = "Wleft";
				}
				
				if (pos_X >= 0)
					pos_X -= SPEED;
				if(i==0) {
					state = waterLeftMove1; 
					i=1;
				}else {
					state = waterLeftMove2; 
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
	
//	public void upper() {
//		if (pos_Y > 116)  //����!!!!!!!
//			pos_Y -= 55;
//	}
//	
//	public void lower() {
//		if (pos_Y <= 422)
//			pos_Y += 55;
//	}
	
	public void up() {
		up = true;
		new Thread(()->{
			for(int i =0; i<80/JUMPSPEED; i++) {
				pos_Y-=JUMPSPEED;
				try {
					Thread.sleep(18);
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
			up = false;
			down();
			
		}).start();
	}
	
	public void up2() {
		up = true;
		new Thread(()->{
			for(int i =0; i<80/JUMPSPEED; i++) {
				try {
					Thread.sleep(18);
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
			up = false;
			
		}).start();
	}	
//		if (direction.equals("left") && KeyListener.pressedLeftKey) {
//			pos_X -= 100;
//			pos_Y -= 60;
//			state = fireLeftJump;
//		}
//		else if (direction.equals("right") && KeyListener.pressedRightKey) {
//			pos_X += 100;
//			pos_Y -= 60;
//			state = fireRightJump;
//		}	
//		else if (direction.equals("left") && !KeyListener.pressedLeftKey) {
//			pos_Y -= 60;
//			state = waterLeftJump;
//		}
//		else if (direction.equals("right")) {
//			pos_Y -= 60;
//			state = waterRightJump;
//		}
	

	public void down() { //ĳ���� �ٿ�
		
		down = true;
		new Thread(()->{
			for(int i =0; i<80/JUMPSPEED; i++) {
				//ù��° ������ ����
				if(pos_X>=830&&pos_X<=910&&pos_Y<=580&&pos_Y>=560) break;
				//�� ��°�� ��ǥ
				if(pos_Y>=490&&pos_Y<=492&&pos_X<830&&pos_X>390) break;
				//�ι�°�� ��ư�ִ� �� ��ǥ
				if(pos_Y>=432&&pos_Y<=436&&pos_X<=390&&pos_X>10) break;
				//�����̴� �� ��ǥ
				if(pos_X<150&&pos_Y>=435-45&&pos_Y<=435-45+2&&Block.getpush()==true) break;
				
				//�� ��°�� ���� ��ǥ
				if(pos_Y>=312&pos_Y<=310&&pos_X<=460&&pos_X>10) break;
				//�� ��° ���� ������ �� ��ǥ
				if(pos_Y>=328&pos_Y<=330&&pos_X<=910&&pos_X>500) break;
				//�� ��°�� ������ �� ��ǥ
				if(pos_Y>=275&&pos_Y<=330&&pos_X<=910&&pos_X>850) break;
				//�� ��°�� ��ǥ
				if(pos_Y>=205&&pos_Y<=208&&pos_X<=823&&pos_X>700) break;
				//�� ��°��(2) ��ǥ
				if(pos_Y>=153&&pos_Y<=155&&pos_X<=700&&pos_X>=475) break;
				//�� ��°�� �� ��ǥ
				if(pos_Y>=150&&pos_Y<=152&&pos_X<=180&pos_X>=120) break;
				//�� ��°��(3) ��ǥ
				if(pos_Y>=100&&pos_Y<=102&&pos_X<=120&pos_X>=10) break;
				//�ټ� ��°�� ��ǥ
				if(pos_Y>=48&&pos_Y<=50&&pos_X<250&pos_X>=210) break;
				if(pos_Y>=25&&pos_Y<=27&&pos_X<=295&pos_X>=226) break;
				
				
				pos_Y+=JUMPSPEED;
				
				try {
					Thread.sleep(18);
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
			down=false;
		}).start();
		
	}
	
	public void down2() { //ĳ���� �ٿ�
			
		down = true;
		new Thread(()->{
			for(int i =0; i<JUMPDOWN/JUMPSPEED; i++) {
				
				pos_Y+=JUMPSPEED;
				try {
					Thread.sleep(17);
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
			down=false;
		}).start();
		
	}	
	
	
			
//		if (direction.equals("left") && KeyListener.pressedLeftKey) {
//			pos_X -= 100;
//			pos_Y += 60;
//			state = fireLeftMove2;
//		}
//		else if (direction.equals("right") && KeyListener.pressedRightKey) {
//			pos_X += 100;
//			pos_Y += 60;
//			state = fireRightMove2;
//		}	
//		else if (direction.equals("left") && !KeyListener.pressedLeftKey) {
//			pos_Y += 60;
//			state = fireLeftMove2;
//		}
//		else if (direction.equals("right")) {
//			pos_Y += 60;
//			state = fireRightMove2;
//		}
	
	
	public void keyRelease() {
		if (direction.equals("Fleft"))
			state = fireLeftMove2;
		else if (direction.equals("Fright"))
			state = fireRightMove2;
		else if (direction.equals("Wright"))
			state = waterRightMove2;
		else if (direction.equals("Wright"))
			state = waterRightMove2;
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


