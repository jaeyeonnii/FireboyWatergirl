package fbwg_1;
//캐릭터 이동

import java.awt.*; 
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JLabel.*;
import java.util.*;

public class charMove extends JLabel {

	private int x;
	private int y;
	
	private ImageIcon play1; //기본 캐릭(불)
	private ImageIcon play2;//기본 캐릭(물)
	private ImageIcon jump1; //점프 모션(불)
	private ImageIcon jump2; //점프 모션(물)
	private ImageIcon dead1; //죽음 모션(물)
	private ImageIcon dead2; //죽음 모션(불)
	
	
	public charMove() {
		initObject();
		initSetting();
	}
	
	private void initObject() {
		play1= new ImageIcon("");
		play2= new ImageIcon("");
		jump1= new ImageIcon("");
		jump2= new ImageIcon("");
		dead1= new ImageIcon("");
		dead2= new ImageIcon("");
		
	}
	private void initSetting() {
		x = 55;
		y = 535;
		
		this.setIcon(play1);
		this.setSize(50,50);
		this.setLocation(x, y);
		
		
	}
}
