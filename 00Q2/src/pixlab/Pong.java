package pong;

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
import java.lang.Math;

public class Pong extends Canvas implements KeyListener, Runnable
{
	//private Ball ball;
	private BlinkyBall ball;
	private Paddle leftPaddle;
	private Paddle rightPaddle;
	private boolean[] keys;
	private BufferedImage back;
	private int Lplayer;
	private int Rplayer;

	public Pong()
	{
		//set up all variables related to the game
		Lplayer = 0;
		Rplayer = 0;
		ball = new BlinkyBall(200, 200, 10, 10);
		leftPaddle = new Paddle(10, 300);
		rightPaddle = new Paddle(550, 300);


		keys = new boolean[4];

    
    	setBackground(Color.WHITE);
		setVisible(true);
		
		new Thread(this).start();
		addKeyListener(this);		//starts the key thread to log key strokes
	}
	
   public void update(Graphics window){
	   paint(window);
   }

   public void paint(Graphics window)
   {
		
		//set up the double buffering to make the game animation nice and smooth
		Graphics2D twoDGraph = (Graphics2D)window;

		//take a snap shop of the current screen and same it as an image
		//that is the exact same width and height as the current screen
		if(back==null)
		   back = (BufferedImage)(createImage(getWidth(),getHeight()));

		//create a graphics reference to the back ground image
		//we will draw all changes on the background image
		Graphics graphToBack = back.createGraphics();


		ball.moveAndDraw(graphToBack);
		leftPaddle.draw(graphToBack);
		rightPaddle.draw(graphToBack);

		//see if ball hits left wall or right wall
		if(!(ball.getX()>=10 && ball.getX()<=780))
		{
			ball.setXSpeed(0);
			ball.setYSpeed(0);
			ball.draw(graphToBack,Color.WHITE);
			if(ball.getX() <= leftPaddle.getX()){
				graphToBack.setColor(Color.WHITE);
				graphToBack.drawString("Left Player Score: " + Lplayer + "  Right Player Score: " + Rplayer, 500, 500);
				Rplayer += 1;
			}
			else if(ball.getX() >= rightPaddle.getX()){
				graphToBack.setColor(Color.WHITE);
				graphToBack.drawString("Left Player Score: " + Lplayer + "  Right Player Score: " + Rplayer, 500, 500);
				Lplayer += 1;
			}
			
			ball = new BlinkyBall(200, 200, 10, 10);
			
			graphToBack.setColor(Color.RED);
			graphToBack.drawString("Left Player Score: " + Lplayer + "  Right Player Score: " + Rplayer, 500, 500);
		}


		//see if the ball hits the top or bottom wall 
		if(!(ball.getY()>=10 && ball.getY()<= 500))
		{
			ball.setYSpeed(-ball.getYSpeed());
			
		}


		//see if the ball hits the left paddle
		
		if((ball.getX() <= leftPaddle.getX() +leftPaddle.getWidth() + Math.abs(ball.getXSpeed()))
		&&
		(ball.getY() >= leftPaddle.getY() &&
		ball.getY() <= leftPaddle.getY() + leftPaddle.getHeight() ||
		ball.getY() + ball.getHeight() >= leftPaddle.getY() &&
		ball.getY() + ball.getHeight() < leftPaddle.getY() + leftPaddle.getHeight())){
			if(ball.getX() <= leftPaddle.getX() + leftPaddle.getWidth() - Math.abs(ball.getXSpeed())){
				ball.setYSpeed(-ball.getYSpeed());
			}else{
				ball.setXSpeed(-ball.getXSpeed());
			}
		}
		
		/*if(ball.didCollideLeft(leftPaddle) || ball.didCollideRight(leftPaddle) || ball.didCollideTop(leftPaddle) || ball.didCollideBottom(leftPaddle)){
			if(ball.getX() <= leftPaddle.getX() + leftPaddle.getWidth() - Math.abs(ball.getXSpeed())){
				ball.setYSpeed(-ball.getYSpeed());
			}else{
				ball.setXSpeed(-ball.getXSpeed());
			}
			
		}*/
		
		//see if the ball hits the right paddle
		
		/*if((ball.getX() + ball.getWidth() >= rightPaddle.getX() - Math.abs(ball.getXSpeed()))
				&&
				(ball.getY() >= rightPaddle.getY() &&
				ball.getY() <= rightPaddle.getY() + rightPaddle.getHeight() ||
				ball.getY() + ball.getHeight() >= rightPaddle.getY() &&
				ball.getY() + ball.getHeight() < rightPaddle.getY() + rightPaddle.getHeight())){
			if(ball.getX() + ball.getWidth() <= rightPaddle.getX() + rightPaddle.getWidth() - Math.abs(ball.getXSpeed())){
				ball.setYSpeed(-ball.getYSpeed());
			}else{
				ball.setXSpeed(-ball.getXSpeed());
			}
		}*/
		
		if(ball.didCollideLeft(leftPaddle) || ball.didCollideRight(leftPaddle) || ball.didCollideLeft(rightPaddle) || ball.didCollideLeft(rightPaddle)){
			ball.setXSpeed(-ball.getXSpeed());
		}

		if(ball.didCollideTop(leftPaddle) || ball.didCollideBottom(leftPaddle) || ball.didCollideTop(rightPaddle) || ball.didCollideBottom(rightPaddle)){
			ball.setXSpeed(-ball.getYSpeed());
		}
		//see if the paddles need to be moved

		if(keys[0] == true)
		{
			//move left paddle up and draw it on the window
			if(leftPaddle.getY() >= 10){
				leftPaddle.moveUpAndDraw(graphToBack);
			}
			
		}
		if(keys[1] == true)
		{
			//move left paddle down and draw it on the window
			if(leftPaddle.getY() <= 500){
				leftPaddle.moveDownAndDraw(graphToBack);
			}

		}
		if(keys[2] == true)
		{
			if(rightPaddle.getY() >= 10){
				rightPaddle.moveUpAndDraw(graphToBack);
			}
		}
		if(keys[3] == true)
		{
			if(rightPaddle.getY() <= 500){
				rightPaddle.moveDownAndDraw(graphToBack);
			}
		}
		
		twoDGraph.drawImage(back, null, 0, 0);
	}

	public void keyPressed(KeyEvent e)
	{
		switch(toUpperCase(e.getKeyChar()))
		{
			case 'W' : keys[0]=true; break;
			case 'Z' : keys[1]=true; break;
			case 'I' : keys[2]=true; break;
			case 'M' : keys[3]=true; break;
		}
	}

	public void keyReleased(KeyEvent e)
	{
		switch(toUpperCase(e.getKeyChar()))
		{
			case 'W' : keys[0]=false; break;
			case 'Z' : keys[1]=false; break;
			case 'I' : keys[2]=false; break;
			case 'M' : keys[3]=false; break;
		}
	}

	public void keyTyped(KeyEvent e){}
	
   public void run()
   {
   	try
   	{
   		while(true)
   		{
   		   Thread.currentThread().sleep(8);
            repaint();
         }
      }catch(Exception e)
      {
      }
  	}	
}

