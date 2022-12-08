package fbwg_1;
//캐릭터 이동

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
      private Image fireRight= new ImageIcon(Main.class.getResource("../images/play.png")).getImage(); //기본 캐릭(불)
      private Image fireLeft= new ImageIcon(Main.class.getResource("../images/play.png")).getImage(); 
      private Image fireRightStop= new ImageIcon(Main.class.getResource("../images/play.png")).getImage(); 
      private Image fireLeftStop= new ImageIcon(Main.class.getResource("../images/play.png")).getImage(); 
      
//      private ImageIcon play2;//기본 캐릭(물)
//      private ImageIcon jump1; //점프 모션(불)
//      private ImageIcon jump2; //점프 모션(물)
//      private ImageIcon dead1; //죽음 모션(물)
//      private ImageIcon dead2; //죽음 모션(불)
   //   
      
      private int pos_X,pos_Y; //위치
      private String direction; //보고 있는 방향
      private boolean crash = false; //장애물을 만났는지 여부
      private Image state; //표시할 이미지
      
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
      
      //이동하다 멈췄을 때 이미지 정지한 모습으로 바꾸는 메서도
      public void keyRelease() {
         if(direction.equals("left")) state = fireLeftStop;
         else if(direction.equals("right")) state = fireRightStop;
      }
      
      //장애물 충돌 시 
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