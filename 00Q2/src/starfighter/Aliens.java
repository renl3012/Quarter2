package starfighter;

import java.lang.Math;

public class Aliens{
	private Alien[][] crew = new Alien[3][2];
	private int whichWay = 0;
	
	public Aliens(){
		for(int row = 0; row < 3; row++){
			for(int col = 0; col < 2; col++){
				crew[row][col] = new Alien(row * 80, col * 80, (int)(Math.random()*3 + 1));
			}
		}
	}
	
	public void scramble(){
		for(int e = 0; e < 3; e++){
			for(int f = 0; f < 2; f++){
				whichWay = (int)(2 * Math.random() + 1);
				if(whichWay == 1){
					crew[e][f].move("LEFT");
				}else{
					crew[e][f].move("RIGHT");
				}
				
				if(crew[e][f].getX() < 0 || crew[e][f].getX() > 710){
					crew[e][f].setSpeed(-crew[e][f].getSpeed());
				}
				
				if(crew[e][f].getX() < 0 || crew[e][f].getX() > 710){
					crew[e][f].setSpeed(-crew[e][f].getSpeed());
				}
			}
		}
	}
	
	public Alien[][] getAliens(){
		return crew;
	}
}
