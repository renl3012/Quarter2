package pong;

import java.awt.Color;
import java.awt.Graphics;

public class Paddle extends Block
{
   //instance variables
   private int speed;

   public Paddle()
   {
		super(10,10);
		setWidth(15);
		setHeight(40);
		speed = 5;
		
   }


   //add the other Paddle constructors

   public Paddle(int x, int y){
	   super(x, y);
	   setWidth(15);
	   setHeight(40);
	   speed = 5;
	   setColor(Color.RED);
   }

   public Paddle(int x, int y, int s){
	   super(x, y);
	   setWidth(15);
	   setHeight(40);
	   speed = s;
	   setColor(Color.RED);
   }
   
   public Paddle(int x, int y, int w, int h, int s){
	   super(x, y);
	   setWidth(w);
	   setHeight(h);
	   speed = s;
	   setColor(Color.RED);
   }
   
   public Paddle(int x, int y, int w, int h, Color c, int s){
	   super(x, y);
	   setWidth(w);
	   setHeight(h);
	   speed = s;
	   setColor(c);
   }

   public void moveUpAndDraw(Graphics window)
   {
	   //draw a white ball at old ball location
	   draw(window, Color.WHITE);
	     
	   //setY
	   setY(getY()-speed);

	   //draw the ball at its new location
	   draw(window);

   }

   public void moveDownAndDraw(Graphics window)
   {
	   //draw a white ball at old ball location
	   draw(window, Color.WHITE);
	     
	   //setY
	   setY(getY()+speed);

	   //draw the ball at its new location
	   draw(window);

   }

   //add get methods
   public int getSpeed(){
	   return speed;
   }
   
   //add a toString() method
   public String toString(){
	   String output = getX() + " " + getY() + " " + getWidth() + " " + getHeight() + " " + getColor() + "\t" + getSpeed();
		return output;
   }
   
}