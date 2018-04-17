package pong;

import java.awt.Color;
import java.awt.Graphics;

public class Block implements Locatable
{
	private int xPos;
	private int yPos;
	private int width;
	private int height;

	private Color color;

	public Block()
	{
		xPos = 100;
		yPos = 150;
		width = 10;
		height = 10;
		color = new Color(0, 0, 0);

	}

	//add other Block constructors - x , y , width, height, color
	public Block(int x, int y){
		xPos = x;
		yPos = y;
		color =  new Color(0, 0, 0);
	}

	public Block(int x, int y, int w, int h){
		xPos = x;
		yPos = y;
		width = w;
		height = h;
		color =  new Color(0, 0, 0);
	}
	
	public Block(int x, int y, int w, int h, Color c){
		xPos = x;
		yPos = y;
		width = w;
		height = h;
		color = c;
	}

	
   //add the other set methods
   public void setX(int x){
	   xPos = x;
   }

   public void setY(int y){
	   yPos = y;
   }
   
   public void setPos(int x, int y){
	   xPos = x;
	   yPos = y;
   }
   
   public void setWidth(int w){
	   width = w;
   }
   
   public void setHeight(int h){
	   height = h;
   }
   
   public void setColor(Color col)
   {

	   color = col;
   }

   public void draw(Graphics window)
   {
   	//uncomment after you write the set and get methods
      window.setColor(color);
      window.fillRect(getX(), getY(), getWidth(), getHeight());
   }

   public void draw(Graphics window, Color col)
   {
	   window.setColor(col);
	   window.fillRect(getX(), getY(), getWidth(), getHeight());
	   

   }
   
	public boolean equals(Object obj)
	{
		if (this == obj)
		{
			return true;
		}

		return false;
	}   

   //add the other get methods
	public int getX(){
		return xPos;
	}
	
	public int getY(){
		return yPos;
	}
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}
	
	public String getColor(){
		return color.toString();
	}

   //add a toString() method  - x , y , width, height, color
	public String toString(){
		String output = getX() + " " + getY() + " " + getWidth() + " " + getHeight() + " " + getColor();
		return output;
	}
}