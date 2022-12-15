package fbwg_1;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;


public class Stage extends Thread{
	
	//아이템 담을 리스트
	private ArrayList<FWItem> itemList = new ArrayList<>();
	//장애물
	private ArrayList<Fire> fireList = new ArrayList<>();
	private ArrayList<Water> waterList = new ArrayList<>();
	private ArrayList<Bog> bogList = new ArrayList<>();
	
	//블록
	private Image bt1 = new ImageIcon(Main.class.getResource("../images/buttonP.png")).getImage();
	private Image bt2 = new ImageIcon(Main.class.getResource("../images/buttonP.png")).getImage();
	private ArrayList<Block> blockList = new ArrayList<>();

//	private Gameover gameover= new Gameover();
	
	public ArrayList<Water> getWaterList(){
		return waterList;
	}
	public ArrayList<Fire> getFireList(){
		return fireList;
	}
	public ArrayList<Bog> getBogList(){
		return bogList;
	}
	public ArrayList<Block> getBlockList(){
		return blockList;
	}
	
	public ArrayList<FWItem> getItemList(){
		return itemList;
	}
	public void makeItems(FWItem item) {
		itemList.add(item);
	}
	
	public void makeFire(Fire fire) {
		fireList.add(fire);
	}
	public void makeWater(Water water) {
		waterList.add(water);
	}
	public void makeBog(Bog bog) {
		bogList.add(bog);
	}
	
	public void makeBlock(Block block) {
		blockList.add(block);
	}
	
	public void drawItems(Graphics g) {
		for (int i=0; i< itemList.size(); i++) {
			if(itemList.get(i) instanceof Firetem) {
				Firetem fir = (Firetem)itemList.get(i);
				g.drawImage(fir.getFiretem(), fir.getPos_x(), fir.getPos_y(), null);
			}
			else if(itemList.get(i) instanceof Watertem) {
				Watertem wa = (Watertem)itemList.get(i);
				g.drawImage(wa.getWatertem(), wa.getPos_x(), wa.getPos_y(), null);
			}
			else if(itemList.get(i) instanceof Watertem) {
				Watertem wa = (Watertem)itemList.get(i);
				g.drawImage(wa.getWatertem(), wa.getPos_x(), wa.getPos_y(), null);
			}
		}
	}
	public void eatItems() { //아이템 먹기
		for (int i=itemList.size()-1;i>=0; i--) {
			if ( // 워터걸
					(itemList.get(i).getPos_x() <= Level1.watergirl.getPos_X()+30 
						&& Level1.watergirl.getPos_X() <= itemList.get(i).getPos_x() 
						&& Level1.watergirl.getPos_Y()+27 >= itemList.get(i).getPos_y() 
						)
					// 파이어 보이
					|| (Level1.fireboy.getPos_X() <= itemList.get(i).getPos_x() + 30 
						&& Level1.fireboy.getPos_X() >= itemList.get(i).getPos_x()
						&& Level1.fireboy.getPos_Y()+27 >= itemList.get(i).getPos_y() 
						)) 
				{
//					점수카운팅
					new Music("Diamond.mp3",false).start();
					itemList.remove(i);
				}
		}
	}
	public void drawFire(Graphics g) {
		for(int i= 0; i< fireList.size();i++) {
			g.drawImage(fireList.get(i).getNowState(),fireList.get(i).getX(),fireList.get(i).getY(),null);
		}
	}
	public void drawWater(Graphics g) {
		for(int i= 0; i< waterList.size();i++) {
			g.drawImage(waterList.get(i).getNowState(),waterList.get(i).getX(),waterList.get(i).getY(),null);
		}
	}
	public void drawBog(Graphics g) {
		
		for(int i= 0; i< bogList.size();i++) {
			g.drawImage(bogList.get(i).getNowState(),bogList.get(i).getX(),bogList.get(i).getY(),null);
		}
	}
//	public void drawAgain(Graphics g) {
//		g.drawImage(gameover.getImage(), gameover.getPos_x(), gameover.getPos_y(), null);
//	}
	public void drawblock(Graphics g) {
		g.drawImage(bt1,200,500,null);
		g.drawImage(bt2,300,370,null);
////		for(int i= 0; i< blockList.size();i++)
////		{
////			g.drawImage(blockList.get(i).getimage(),blockList.get(i).getX(),blockList.get(i).getY(),null);
////		}
//		g.drawImage(block.getimage(), block.getX(), block.getY(), null);
		for(int i= 0; i< blockList.size();i++) {
			g.drawImage(blockList.get(i).getimage(),blockList.get(i).getX(),blockList.get(i).getY(),null);
		}
	}
	public void touchBt() { //좌표 손봐야함
		for(int i=blockList.size()-1; i >= 0; i--)
		{
			
			if(( //버튼1(200 500) 버튼2(300 370)
				Level1.watergirl.getPos_X()>150 && Level1.watergirl.getPos_X()<220
				&&Level1.watergirl.getPos_Y()>420 && Level1.watergirl.getPos_Y()<436
				||Level1.watergirl.getPos_X()>250 && Level1.watergirl.getPos_X()<320
				&&Level1.watergirl.getPos_Y()>300 && Level1.watergirl.getPos_Y()<311
				) ||(Level1.fireboy.getPos_X()>150 && Level1.fireboy.getPos_X()<220
				&&Level1.fireboy.getPos_Y()>420 && Level1.fireboy.getPos_Y()<436
				||Level1.fireboy.getPos_X()>250 && Level1.fireboy.getPos_X()<320
				&&Level1.fireboy.getPos_Y()>300 && Level1.fireboy.getPos_Y()<311))
			{
			blockList.get(i).pushing();
			
			}
			else
				blockList.get(i).out();
		}
		
	}
	//워터걸 용암 빠질 때 또는 늪 //좌표 끝 완료
	public void touchFire() { 
		
		for (int i=fireList.size()-1; i >= 0; i--) {
			if ( (
				fireList.get(i).getX()-30 <= Level1.watergirl.getPos_X() //완
					&& Level1.watergirl.getPos_X()+50 <= fireList.get(i).getX()+150 //완
					&& Level1.watergirl.getPos_Y()+82 >= fireList.get(i).getY() //완
					)
				// 늪
				|| (bogList.get(i).getX()-30 <= Level1.watergirl.getPos_X()
					&& Level1.watergirl.getPos_X()+50 <= bogList.get(i).getX()+150
					&& Level1.watergirl.getPos_Y() +77>= bogList.get(i).getY()
					&& Level1.watergirl.getPos_Y() +70<= bogList.get(i).getY()))
			{
					new Music("Death.mp3", false).start(); //죽을때 소리
					
//					for (int j=0; j < fireList.size(); j++) {
//						fireList.get(j).close();
//					}
					
					try {
						Thread.sleep(2000);
						
						
					} catch (Exception e) {}
					
//					close();
					Fbwg.bal.restartStage();
					
				}
			}
		}
	//파이어보이 물 빠질 때 //좌표끝 완료
		public void touchWater() { 
			for (int i=waterList.size()-1; i >= 0; i--) {
				if ( //물
					(waterList.get(i).getX() <= Level1.fireboy.getPos_X()+30 //완
						&& Level1.fireboy.getPos_X()+50 <= waterList.get(i).getX()+150 //완
						&& Level1.fireboy.getPos_Y()+82 >= waterList.get(i).getY() //완
						)
					// 늪
					|| (bogList.get(i).getX()-30 <= Level1.fireboy.getPos_X() 
							&& Level1.fireboy.getPos_X() +50 <= bogList.get(i).getX()+150
							&& Level1.fireboy.getPos_Y()+77 >= bogList.get(i).getY()
							&& Level1.fireboy.getPos_Y() +70<= bogList.get(i).getY())) 
				{
						new Music("Death.mp3", false).start(); //죽을때 소리
						
//						for (int j=0; j < fireList.size(); j++) {
//							fireList.get(j).close();
//						}
						
						try {
							Thread.sleep(2000);
						} catch (Exception e) {}
						
//						close();
						Fbwg.bal.restartStage();
						
					}
				}
			}

		@Override
		public void run() {
			makeItems(new Watertem(685,665));
			makeItems(new Firetem(485,665));
			makeItems(new Gameover(50,200));
			fireList.add(Level1.f1);
			waterList.add(Level1.w1);
			bogList.add(Level1.b1);
			blockList.add(Level1.bl);
			
			while (itemList.size()>0) { //아이템 먹기
				eatItems();
				touchFire();
				touchWater();
				touchBt();
//				Level1.watergirl.checkLaddering();
			}
		}
	
}

