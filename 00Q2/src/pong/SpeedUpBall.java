package pong;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

class SpeedUpBall extends Ball
{

   //instance variables

   public SpeedUpBall()
   {
	   super();

   }

   public SpeedUpBall(int x, int y)
   {
	   super(x, y);

   }


   public SpeedUpBall(int x, int y, int xSpd, int ySpd)
   {
	   super(x, y, xSpd, ySpd);

   }

   public SpeedUpBall(int x, int y, int wid, int ht, int xSpd, int ySpd)
   {
	   super(x, y, wid, ht, xSpd, ySpd);

   }


   public SpeedUpBall(int x, int y, int wid, int ht, Color col, int xSpd, int ySpd)
   {
	   super(x, y, wid, ht, col, xSpd, ySpd);



   }

   public void setXSpeed( int xSpd )
   {
	   if(getXSpeed() > 0){
		   setXSpeed(getXSpeed() + 1);
	   }

	   else if (getXSpeed() < 0){
		   setXSpeed(getXSpeed() - 1);
	   }


   }

   public void setYSpeed( int ySpd )
   {
	   if(getYSpeed() > 0){
		   setYSpeed(getYSpeed() + 1);
	   }

	   else if (getYSpeed() < 0){
		   setYSpeed(getYSpeed() - 1);
	   }



   }
}

