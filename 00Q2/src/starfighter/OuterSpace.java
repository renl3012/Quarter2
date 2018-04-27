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
import java.io.File;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import java.awt.Image;

import pong.Paddle;

public class OuterSpace extends Canvas implements KeyListener, Runnable
{
	private Ship ship;
	//private Alien alienOne;
	//private Alien alienTwo;
	private Ammo ammo;
	private boolean fired;
	//private boolean destroyed;
	private int score;
	private PowerUp p;
	private Image boostedShip;
	private Image regShip;
	private AlienAmmo currentAlienAmmo;
	private boolean alienShoot;
	private boolean vulnerable;
	private int whoseTurn;
	
	private Aliens send;
	private Alien[][] transfer;

	private ArrayList<Alien> aliens;
	private ArrayList<AlienAmmo> shots;

	private boolean[] keys;
	private BufferedImage back;

	public OuterSpace()
	{
		setBackground(Color.black);

		keys = new boolean[5];

		//instantiate other stuff
		ship = new Ship(300, 480, 2);
		//alienOne = new Alien(200, 100, 1);
		//alienTwo = new Alien(300, 100, 1);
		aliens = new ArrayList<Alien>();
		send = new Aliens();
		transfer = new Alien[3][2];
		transfer = send.getAliens();
		p = new PowerUp((int)(1+Math.random()*700), (int)(1+Math.random()*500));
		currentAlienAmmo = new AlienAmmo();
		shots = new ArrayList<AlienAmmo>();
		alienShoot = false;
		whoseTurn = 0;
		vulnerable = true;
		
		try
		{
			boostedShip = ImageIO.read(new File(System.getProperty("user.dir") + "\\src\\starfighter\\shipWithShield.jpg"));
		}
		catch(Exception e)
		{
			//feel free to do something here
			System.out.println("RIP. Something got messed up.");
		}
		
		try
		{
			regShip = ImageIO.read(new File(System.getProperty("user.dir") + "\\src\\starfighter\\ship.jpg"));
		}
		catch(Exception e)
		{
			//feel free to do something here
			System.out.println("RIP. Something got messed up.");
		}
		
		
		
		for(int e = 0; e < 3; e++){
			for(int f = 0; f < 2; f++){
				aliens.add(transfer[e][f]);
			}
		}
		
		for(int d = 0; d < 6; d++){
			shots.add(new AlienAmmo());
		}
		
		ammo = new Ammo(ship.getX() + 35, ship.getY() + 5, 0);
		fired = false;
		//destroyed = false;
		
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
		
		p.draw(graphToBack);
		ship.draw(graphToBack);
		
		for(int e = 0; e < 6; e++){
			shots.set(e, new AlienAmmo((aliens.get(e)).getX() + 35, (aliens.get(e)).getY() + 80));
			//shots.get(e).draw(graphToBack);
			

		}
		
		if(alienShoot == true){
			currentAlienAmmo.move("DOWN");
			currentAlienAmmo.draw(graphToBack);
			
		} else if (alienShoot == false){
			whoseTurn = (int)(Math.random()*5);
			currentAlienAmmo = shots.get(whoseTurn);
			currentAlienAmmo.setSpeed(1);
			//currentAlienAmmo.draw(graphToBack);
			currentAlienAmmo.move("DOWN");
			currentAlienAmmo.draw(graphToBack);
			alienShoot = true;
		}
		
		if(currentAlienAmmo.getY() >= 550){
			currentAlienAmmo.setPos(-800, 800);
			alienShoot = false;
		}
				
		graphToBack.setColor(Color.WHITE);
		graphToBack.drawString("Score: " + score, 700, 550);
		
		for(Alien a: aliens){
			a.draw(graphToBack);
		}
		
		/*if(destroyed == false){
			alienOne.draw(graphToBack);
			alienTwo.draw(graphToBack);
			
		}*/
			
		//ammo.move("SPACE");
		if(!(ammo.getSpeed() == 0)){
			ammo.draw(graphToBack);
		}
		
		
		/*alienOne.move("LEFT");
		if(alienOne.getX() < 0 || alienOne.getX() > 710){
			alienOne.setSpeed(-alienOne.getSpeed());
		}
		
		alienTwo.move("LEFT");	
		if(alienTwo.getX() < 0 || alienTwo.getX() > 710){
			alienTwo.setSpeed(-alienTwo.getSpeed());
		}*/
		
		for(Alien a: aliens){
			a.move("LEFT");
			if(a.getX() < 0 || a.getX() > 710){
				a.setSpeed(-a.getSpeed());
			}
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
		
		/*if(ammo.getY() == alienOne.getY()){
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
		}*/
		
		for(Alien a: aliens){
			if(ammo.getY() <= a.getY()+80 && ammo.getY() >= a.getY()){
				if(ammo.getX() >= a.getX() && ammo.getX() <= a.getX() + 80){
					ammo.setPos(-500,900);
					ammo.setSpeed(0);
					a.setPos(-500, 100);
					a.setSpeed(0);
					a.invisible(graphToBack);
					//aliens.remove(a);
					//ammo.invisible(graphToBack);
					score++;
					graphToBack.setColor(Color.BLACK);
					graphToBack.drawString("Score: " + score, 700, 550);
					
				}
			}
		}
		
		if(ship.getX()+80 >= p.getX() && ship.getX() + 80 <= p.getX()+75 || ship.getX() >= p.getX() && ship.getX() <= p.getX() + 80){
			if(ship.getY()+80 >= p.getY() && ship.getY()+80 <= p.getY()+80 || ship.getY() >= p.getY() && ship.getY() <= p.getY()+80){
				p.setPos(-800,800);
				ship.setImage(boostedShip);
				vulnerable = false;
				graphToBack.setColor(Color.BLACK);
				graphToBack.drawString("Score: " + score, 700, 550);
			}
		}
		
		if(currentAlienAmmo.getX()+10 >= ship.getX() && currentAlienAmmo.getX()+10 <= ship.getX()+80 || currentAlienAmmo.getX() >= ship.getX() && currentAlienAmmo.getX() <= ship.getX() + 80){
			if(currentAlienAmmo.getY()+10 >= ship.getY() && currentAlienAmmo.getY()+10 <= ship.getY()+80 || currentAlienAmmo.getY() >= ship.getY() && currentAlienAmmo.getY() <= ship.getY()+80){
				if(vulnerable == false){
					currentAlienAmmo.setPos(-800,800);
					currentAlienAmmo.setSpeed(0);
					ship.setImage(regShip);
					vulnerable = true;
				}else{
					currentAlienAmmo.setPos(-800,800);
					currentAlienAmmo.setSpeed(0);
					score -= 1;
					graphToBack.setColor(Color.BLACK);
					graphToBack.drawString("Score: " + score, 700, 550);
				}
			}
		}
		
		if(score == 6){
			graphToBack.setColor(Color.WHITE);
			graphToBack.drawString("YOU WIN!", 400, 550);
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

