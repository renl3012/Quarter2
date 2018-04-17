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
import java.util.Arrays;
import java.util.ArrayList;

public class Breakout extends Canvas implements KeyListener, Runnable
{
	private Ball ball;
	private Paddle paddle;
	private boolean[] keys;
	private BufferedImage back;
	private int score;
	private Block[][] bricks;

	public Breakout()
	{
		//set up all variables related to the game
		
		System.out.println("Lucy Ren");
		System.out.println("Period 4");
		System.out.println("4/4/18");
		System.out.println("Computer #F106-01");
		
		score = 0;
		ball = new Ball(400, 200, 10, 10, 1, -1);
		paddle = new Paddle(10, 300);
		
		bricks = new Block[5][4];
		for(int i = 0; i <= 4; i++){
			for (int h = 0; h <= 3; h++){
				bricks[i][h] = new Block (680+h*30, i*100, 20, 80);
			}
		}

		keys = new boolean[2];

    
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
			graphToBack.setColor(Color.RED);
			graphToBack.drawString("Score: " + score, 500, 530);

			
			for(int i = 0; i <= 4; i++){
				for (int h = 0; h <= 3; h++){
					(bricks[i][h]).draw(graphToBack, Color.BLACK);
				}
			}
			ball.moveAndDraw(graphToBack);
			paddle.draw(graphToBack);

			//see if ball hits left wall
			if(ball.getX()<= 10)
			{
				ball.setXSpeed(0);
				ball.setYSpeed(0);
				ball.draw(graphToBack,Color.WHITE);
				
				if(ball.getX() <= paddle.getX()){
					graphToBack.setColor(Color.WHITE);
					graphToBack.drawString("Score: " + score, 500, 530);
					score = 0;
				}
				
				ball = new Ball(400, 200, 10, 10, 1, -1);
				
				graphToBack.setColor(Color.RED);
				graphToBack.drawString("Score: " + score, 500, 530);
			}
			
			if(ball.getX() >= 790){
				ball.setXSpeed(-ball.getXSpeed());
			}

			//see if the ball hits the top or bottom wall 
			if(!(ball.getY()>=10 && ball.getY() <= 470))
			{
				ball.setYSpeed(-ball.getYSpeed());
				
			}


			//see if the ball hits the bricks
			
			for(int i = 0; i <= 4; i++){
				for (int h = 0; h <= 3; h++){
					if((ball.getX() >= bricks[i][h].getX() - ball.getWidth() - Math.abs(ball.getXSpeed()))
							&&
							(ball.getY() >= bricks[i][h].getY() &&
							ball.getY() <= bricks[i][h].getY() + bricks[i][h].getHeight() ||
							ball.getY() + ball.getHeight() >= bricks[i][h].getY() &&
							ball.getY() + ball.getHeight() < bricks[i][h].getY() + bricks[i][h].getHeight())){
						if(ball.getX() >= bricks[i][h].getX() - Math.abs(ball.getXSpeed())){
							ball.setYSpeed(-ball.getYSpeed());
							//bricks[i][h].draw(graphToBack, Color.WHITE);
							bricks[i][h].setWidth(0);
							bricks[i][h].setHeight(0);
							bricks[i][h].draw(graphToBack, Color.WHITE);
							graphToBack.setColor(Color.WHITE);
							graphToBack.drawString("Score: " + score, 500, 530);
							score += 1;
						}else{
							ball.setXSpeed(-ball.getXSpeed());
							bricks[i][h].draw(graphToBack, Color.WHITE);
							bricks[i][h].setWidth(0);
							bricks[i][h].setHeight(0);
							//bricks[i][h].draw(graphToBack, Color.WHITE);
							graphToBack.setColor(Color.WHITE);
							graphToBack.drawString("Score: " + score, 500, 530);
							score += 1;
						}
					}
					
				}
			}
			
			
			//see if the ball hits the left paddle
			
			if (ball.didCollideRight(paddle) && (ball.didCollideTop(paddle) || ball.didCollideBottom(paddle))){
				if(ball.getX() <= paddle.getX() + paddle.getWidth() - Math.abs(ball.getXSpeed())){
					ball.setYSpeed(-ball.getYSpeed());
				}else{
					ball.setXSpeed(-ball.getXSpeed());
				}
			}
			
			
			//see if the paddles need to be moved

			if(keys[0] == true)
			{
				//move left paddle up and draw it on the window
				if(paddle.getY() >= 10){
					paddle.moveUpAndDraw(graphToBack);
				}
				
			}
			if(keys[1] == true)
			{
				//move left paddle down and draw it on the window
				if(paddle.getY() <= 500){
					paddle.moveDownAndDraw(graphToBack);
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
			}
		}

		public void keyReleased(KeyEvent e)
		{
			switch(toUpperCase(e.getKeyChar()))
			{
				case 'W' : keys[0]=false; break;
				case 'Z' : keys[1]=false; break;
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