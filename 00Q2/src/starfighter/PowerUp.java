package starfighter;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;

public class PowerUp
{
	private Image image;
	private int xPos;
	private int yPos;

	public PowerUp()
	{
		xPos = 0;
		yPos = 0;
		try
		{
			image = ImageIO.read(new File(System.getProperty("user.dir") + "\\src\\starfighter\\powerup.jpg"));
		}
		catch(Exception e)
		{
			//feel free to do something here
			System.out.println("RIP. Something got messed up.");
		}
	}

	public PowerUp(int x, int y)
	{
		xPos = x;
		yPos = y;
		try
		{
			image = ImageIO.read(new File(System.getProperty("user.dir") + "\\src\\starfighter\\powerup.jpg"));
		}
		catch(Exception e)
		{
			//feel free to do something here
			System.out.println("RIP. Something got messed up.");
		}
	}
	
	public int getX(){
		return xPos;
	}
	
	public int getY(){
		return yPos;
	}

	public void setPos(int x, int y){
		xPos = x;
		yPos = y;
	}
	
	public void draw( Graphics window )
	{
		window.drawImage(image,xPos, yPos,75,95,null);
		
	}
}

