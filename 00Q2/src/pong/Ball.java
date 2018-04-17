package pong;

import java.awt.Color;
import java.awt.Graphics;

public class Ball extends Block implements Collidable
{
	private int xSpeed;
	private int ySpeed;

	public Ball()
	{
		super(200,200);
		xSpeed = 3;
		ySpeed = 1;
	}

	//add the other Ball constructors
	
	public Ball(int x, int y){
		super(x, y);
		xSpeed = 3;
		ySpeed = 1;
	}
	
	public Ball(int x, int y, int w, int h){
		super(x, y, w, h);
		xSpeed = 3;
		ySpeed = 1;
	}
	
	public Ball(int x, int y, int w, int h, Color c){
		super(x, y, w, h, c);
		xSpeed = 3;
		ySpeed = 1;
	}
	
	public Ball(int x, int y, int w, int h, int xSpd, int ySpd){
		super(x, y, w, h);
		xSpeed = xSpd;
		ySpeed = ySpd;
	}
	public Ball(int x, int y, int w, int h, Color c, int xSpd, int ySpd){
		super(x, y, w, h, c);
		xSpeed = xSpd;
		ySpeed = ySpd;
	}
	   
   //add the set methods
   
	public void setXSpeed(int xSpd){
		xSpeed = xSpd;
	}
	
	public void setYSpeed(int ySpd){
		ySpeed = ySpd;
	}

   public void moveAndDraw(Graphics window)
   {
   	//draw a white ball at old ball location
	 
	 draw(window, Color.WHITE);

     setX(getX()+xSpeed);
		//setY
     setY(getY()+ySpeed);

     //draw the ball at its new location
     draw(window);
   }
   
	public boolean equals(Object obj)
	{
		Ball o = (Ball) obj;
		if (getX() == o.getX() && getY() == o.getY() && getWidth() == o.getWidth() && getHeight() == o.getHeight() && getXSpeed() == o.getXSpeed() && getYSpeed() == o.getYSpeed() && getColor() == o.getColor()){
			return true;
		}

		return false;
	}   

   //add the get methods
	
	public int getXSpeed(){
		return xSpeed;
	}

	public int getYSpeed(){
		return ySpeed;
	}
	
	public boolean didCollideLeft(Object o){
		Paddle p = (Paddle)o;
		if(getX() >= p.getX() - getWidth() - Math.abs(getXSpeed())){
			return true;
		}
		return false;
	}
	
	public boolean didCollideRight(Object o){
		Paddle p = (Paddle)o;
		if(getX() <= p.getX() +p.getWidth() + Math.abs(getXSpeed())){
			return true;
		}
		return false;
	}
	
	public boolean didCollideTop(Object o){
		Paddle p = (Paddle)o;
		if(getY() >= p.getY() && getY() <= p.getY() + p.getHeight()){
			return true;
		}
		return false;
	}
	
	public boolean didCollideBottom(Object o){
		Paddle p = (Paddle) o;
		if (getY() + getHeight() >= p.getY() && getY() + getHeight() < p.getY() + p.getHeight()){
			return true;
		}
		return false;
	}
	
   //add a toString() method
	
	public String toString(){
		String output = getX() + " " + getY() + " " + getWidth() + " " + getHeight() + " " + getColor() + "\t" + getXSpeed() + " " + getYSpeed();
		return output;
	}
	
	
}