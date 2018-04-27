package starfighter;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;

public class AlienAmmo extends MovingThing
{
	private int speed;

	public AlienAmmo()
	{
		this(0,0,0);
	}

	public AlienAmmo(int x, int y)
	{
		//add code
		this(x,y,0);
	}

	public AlienAmmo(int x, int y, int s)
	{
		//add code
		super(x,y);
		speed = s;
	}

	public void setSpeed(int s)
	{
	   //add code
		speed = s;
	}

	public int getSpeed()
	{
	   return speed;
	}

	
	public void invisible(Graphics window){
		window.setColor(Color.BLACK);
		window.fillRect(getX(), getY(), 10, 10);
	}
	public void draw( Graphics window )
	{
		//add code to draw the ammo
		window.setColor(Color.RED);
		window.fillRect(getX(), getY(), 10, 10);
	}
}