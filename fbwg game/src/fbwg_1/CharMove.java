package fbwg_1;
//ĳ���� �̵�

import java.awt.*;


import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;
import javax.swing.JLabel.*;
import java.util.*;

public class CharMove extends JLabel {
   public class Stage extends Thread{
      //private ArrayList<Fruit> itemlist = new ArrayList<>();
      
   }
   
   
//   public static Stage stage = new Stage();
//
//   public static Alfy alfy = new Alfy();
//   
   public class Alfy{
      private Image fireRight= new ImageIcon(Main.class.getResource("../images/play.png")).getImage(); //�⺻ ĳ��(��)
      private Image fireLeft= new ImageIcon(Main.class.getResource("../images/play.png")).getImage(); 
      private Image fireRightStop= new ImageIcon(Main.class.getResource("../images/play.png")).getImage(); 
      private Image fireLeftStop= new ImageIcon(Main.class.getResource("../images/play.png")).getImage(); 
      
//      private ImageIcon play2;//�⺻ ĳ��(��)
//      private ImageIcon jump1; //���� ���(��)
//      private ImageIcon jump2; //���� ���(��)
//      private ImageIcon dead1; //���� ���(��)
//      private ImageIcon dead2; //���� ���(��)
   //   
      
      private int pos_X,pos_Y; //��ġ
      private String direction; //���� �ִ� ����
      private boolean crash = false; //��ֹ��� �������� ����
      private Image state; //ǥ���� �̹���
      
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
         this.pos_X=pos_X;
      }
      
      public int getPos_Y() {
         return pos_Y;
      }
      
      public void setPos_Y(int pos_Y){
         this.pos_Y=pos_Y;
      }
      
      public Image fireRight() {
         return fireRight;
      }
      
      public Image fireLeft() {
         return fireLeft;
      }
      
      public void moveToRight() {
         if(direction.equals("left")){
            direction = "right";
         }
         if(pos_X <= 1000) pos_X += 30;
         
         state = fireRight;
      }
      
      public void moveToLeft() {
         if(direction.equals("right")){
            direction = "left";
         }
         if(pos_X >= 0) pos_X -= 30;
         
         state = fireLeft;
      }
      
      //�̵��ϴ� ������ �� �̹��� ������ ������� �ٲٴ� �޼���
      public void keyRelease() {
         if(direction.equals("left")) state = fireLeftStop;
         else if(direction.equals("right")) state = fireRightStop;
      }
      
      //��ֹ� �浹 �� 
//      public void crash() { 
//         if(300<= getPos_X() && getPos_X()<= 360)
//            crash = true;
//         else 
//            crash = false;
//      }
      
      
      
      public  boolean pressedLeftKey =false;
      public  boolean pressedRightKey = false;
      
      
//      public void keyPressed(KeyEvent e) {
//         if (e.getKeyCode() == KeyEvent.VK_LEFT){
//            CharMove.alfy.moveToLeft();
//            pressedLeftKey = true;
//         }
//         else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
//            CharMove.alfy.moveToRight();
//            pressedRightKey = true;
//         }
//         else if (e.getKeyCode() == KeyEvent.VK_UP) {
//            CharMove.alfy.upper ();
//         }
//         else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
//            CharMove.alfy.lower ();
//         }
//         else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
//            CharMove.alfy.jump();
//         }
//      }
      }
   
   }   