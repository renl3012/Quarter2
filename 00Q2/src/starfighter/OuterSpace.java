package starfighter;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import pong.Paddle;

public class OuterSpace extends Canvas implements KeyListener, Runnable
{
	private Ship ship;
	private Alien alienOne;
	private Alien alienTwo;
	private Ammo ammo;
	private boolean fired;
	private boolean destroyed;
	private int score;

	/* uncomment once you are ready for this part
	 *
	private ArrayList<Alien> aliens;
	private ArrayList<Ammo> shots;
	*/

	private boolean[] keys;
	private BufferedImage back;

	public OuterSpace()
	{
		setBackground(Color.black);

		keys = new boolean[5];

		//instantiate other stuff
		ship = new Ship(300, 480, 1);
		alienOne = new Alien(200, 100, 1);
		alienTwo = new Alien(300, 100, 1);
		ammo = new Ammo(ship.getX() + 35, ship.getY() + 5, 1);
		fired = false;
		destroyed = false;
		
		this.addKeyListener(this);
		new Thread(this).start();

		setVisible(true);
	}

   public void update(Graphics window)
   {
	   paint(window);
   }

	public void paint( Graphics window )
	{
		//set up the double buffering to make the game animation nice and smooth
		Graphics2D twoDGraph = (Graphics2D)window;

		//take a snapshot of the current screen and same it as an image
		//that is the exact same width and height as the current screen
		if(back==null)
		   back = (BufferedImage)(createImage(getWidth(),getHeight()));

		//create a graphics reference to the background image
		//we will draw all changes on the background image
		Graphics graphToBack = back.createGraphics();

		graphToBack.setColor(Color.BLUE);
		graphToBack.drawString("StarFighter ", 25, 50);
		graphToBack.setColor(Color.BLACK);
		graphToBack.fillRect(0,0,800,600);
		
		
		ship.draw(graphToBack);
		graphToBack.setColor(Color.WHITE);
		graphToBack.drawString("Score: " + score, 700, 550);
		
		if(destroyed == false){
			alienOne.draw(graphToBack);
		}
		alienTwo.draw(graphToBack);
		
		ammo.move("SPACE");
		if(!(ammo.getSpeed() == 0)){
			ammo.draw(graphToBack);
		}
		
		alienOne.move("LEFT");
		if(alienOne.getX() < 0 || alienOne.getX() > 710){
			alienOne.setSpeed(-alienOne.getSpeed());
		}
		
		alienTwo.move("LEFT");	
		if(alienTwo.getX() < 0 || alienTwo.getX() > 710){
			alienTwo.setSpeed(-alienTwo.getSpeed());
		}
		
		//add code to move stuff
		if(keys[0] == true)
		{
			if(ship.getX() >= -10){
				ship.move("LEFT");
			}
			
		}
		
		if(keys[1] == true)
		{
			if(ship.getX() <= 720){
				ship.move("RIGHT");
			}
		}
		
		if(keys[2] == true)
		{
			if(ship.getY() > 0){
				ship.move("UP");
			}
			
		}
		
		if(keys[3] == true)
		{
			if(ship.getY() < 490){
				ship.move("DOWN");
			}
		}
		
		if(keys[4] == true)
		{
			ammo = new Ammo(ship.getX() + 35, ship.getY() + 5, 1);
			ammo.draw(graphToBack);
			fired = true;
			ammo.move("UP");
		}		

		if(fired){
			ammo.move("UP");
		}
		
		if(!(ammo.getY() >= 0)){
			fired = false;
			ammo.invisible(graphToBack);
		}
		
		if(ammo.getY() == alienOne.getY()){
			if(ammo.getX() >= alienOne.getX() && ammo.getX() <= alienOne.getX() + 80){
				alienOne.setSpeed(0);
				ammo.move("DOWN");
				ammo.setSpeed(0);
				ammo.invisible(graphToBack);
				alienOne.invisible(graphToBack);
				destroyed = true;
				score++;
				graphToBack.setColor(Color.BLACK);
				graphToBack.drawString("Score: " + score, 700, 550);
				alienOne.setPos(-100, 100);
			}
		}
		
		twoDGraph.drawImage(back, null, 0, 0);
	}


	public void keyPressed(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			keys[0] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			keys[1] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP)
		{
			keys[2] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			keys[3] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			keys[4] = true;
		}
		repaint();
	}

	public void keyReleased(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			keys[0] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			keys[1] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP)
		{
			keys[2] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			keys[3] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			keys[4] = false;
		}
		repaint();
	}

	public void keyTyped(KeyEvent e)
	{
		
	}

   public void run()
   {
   	try
   	{
   		while(true)
   		{
   		   Thread.currentThread().sleep(5);
            repaint();
         }
      }catch(Exception e)
      {
      }
  	}
}

