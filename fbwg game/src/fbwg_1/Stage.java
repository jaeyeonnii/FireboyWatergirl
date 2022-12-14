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
	
	public ArrayList<Water> getWaterList(){
		return waterList;
	}
	public ArrayList<Fire> getFireList(){
		return fireList;
	}
	public ArrayList<Bog> getbogList(){
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
	
		@Override
		public void run() {
			makeItems(new Watertem(685,650));
			makeItems(new Firetem(485,650));
			fireList.add(Level1.f1);
			waterList.add(Level1.w1);
			bogList.add(Level1.b1);
		}
	
}

