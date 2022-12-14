package fbwg_1;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Stage extends Thread{
	
	//아이템 담을 리스트
	private ArrayList<FWItem> itemList = new ArrayList<>();
	
	public ArrayList<FWItem> getItemList(){
		return itemList;
	}
	public void makeItems(FWItem item) {
		itemList.add(item);
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
		@Override
		public void run() {
			makeItems(new Watertem(500,200));
			makeItems(new Watertem(600,170));
			makeItems(new Firetem(100,100));
		}
	
}

