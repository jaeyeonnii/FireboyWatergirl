package fbwg_1;
//ĳ���� �̵�

import java.awt.*; 
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JLabel.*;
import java.util.*;

public class charMove extends JLabel {

	private int x;
	private int y;
	
	private ImageIcon play1; //�⺻ ĳ��(��)
	private ImageIcon play2;//�⺻ ĳ��(��)
	private ImageIcon jump1; //���� ���(��)
	private ImageIcon jump2; //���� ���(��)
	private ImageIcon dead1; //���� ���(��)
	private ImageIcon dead2; //���� ���(��)
	
	
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
