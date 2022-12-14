package fbwg_1;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;


public class Stage extends Thread{
	
	//������ ���� ����Ʈ
	private ArrayList<FWItem> itemList = new ArrayList<>();
	//��ֹ�
	private ArrayList<Fire> fireList = new ArrayList<>();
	private ArrayList<Water> waterList = new ArrayList<>();
	private ArrayList<Bog> bogList = new ArrayList<>();
	
	private Image bt1 = new ImageIcon(Main.class.getResource("../images/buttonP.png")).getImage();
	private Image bt2 = new ImageIcon(Main.class.getResource("../images/buttonP.png")).getImage();
	private Block block = new Block();
	
	public ArrayList<Water> getWaterList(){
		return waterList;
	}
	public ArrayList<Fire> getFireList(){
		return fireList;
	}
	public ArrayList<Bog> getBogList(){
		return bogList;
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
		}
	}
	public void eatItems() { //������ �Ա�
		for (int i=itemList.size()-1;i>=0; i--) {
			if ( // �������� ���ʿ��� ������ ��
					itemList.get(i).getPos_x() <= Level1.watergirl.getPos_X()+64 
						&& Level1.watergirl.getPos_X()+64 <= itemList.get(i).getPos_x() + 56 
						&& Level1.watergirl.getPos_Y()+128 >= itemList.get(i).getPos_y() 
						&& Level1.watergirl.getPos_Y() <= itemList.get(i).getPos_y()
					// �������� �����ʿ��� ������ �� 
					|| Level1.watergirl.getPos_X() <= itemList.get(i).getPos_x() + 56 
						&& Level1.watergirl.getPos_X() >= itemList.get(i).getPos_x()
						&& Level1.watergirl.getPos_Y()+128 >= itemList.get(i).getPos_y() 
						&& Level1.watergirl.getPos_Y() <= itemList.get(i).getPos_y()) 
				{
//					if (itemList.get(i) instanceof watertem){
//						//new Music("eatBanana.mp3", false).start();
//						//���� ī����
//					}
//					else if (itemList.get(i) instanceof firetem) {
//						//new Music("eatGrape.mp3", false).start();
//						//���� ī����
//					}
//						
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
	
	public void drawblock(Graphics g) {
		g.drawImage(bt1,200,500,null);
		g.drawImage(bt2,300,370,null);
		g.drawImage(block.getblock(),block.getX(),block.getY(),null);
	}
	public void touchFire() {
		for (int i=fireList.size()-1; i >= 0; i--) {
			if ( // ������ ���ʿ��� ������ ��
				fireList.get(i).getX() <= Level1.watergirl.getPos_X()+50 
					&& Level1.watergirl.getPos_X()+64 <= fireList.get(i).getX()+45
					&& Level1.watergirl.getPos_Y()+128 >= fireList.get(i).getY() 
					&& Level1.watergirl.getPos_Y() <= fireList.get(i).getY()
				// ������ �����ʿ��� ������ ��
				|| Level1.watergirl.getPos_X() <= fireList.get(i).getX() + 45 
					&& Level1.watergirl.getPos_X() >= fireList.get(i).getX()
					&& Level1.watergirl.getPos_Y()+128 >= fireList.get(i).getY() 
					&& Level1.watergirl.getPos_Y() <= fireList.get(i).getY()) 
			{
					//new Music("died.mp3", false).start(); //������ �Ҹ�
					
//					for (int j=0; j < fireList.size(); j++) {
//						fireList.get(j).close();
//					}
					
					try {
						Thread.sleep(2000);
					} catch (Exception e) {}
					
//					close();
					Main.bal.restartStage();
					
				}
			}
		}
	public void touchButton() {
		
	}
		@Override
		public void run() {
			makeItems(new Watertem(685,665));
			makeItems(new Firetem(485,665));
			fireList.add(Level1.f1);
			waterList.add(Level1.w1);
			bogList.add(Level1.b1);
			
			while (itemList.size()>0) { //������ �Ա�
				eatItems();
				touchFire();
				Level1.watergirl.checkLaddering();
			}
		}
	
}

