package starfighter;

import java.lang.Math;

public class Aliens{
	private Alien[][] crew = new Alien[3][2];
	private int whichWay = 0;
	
	public Aliens(){
		for(int row = 0; row < 3; row++){
			for(int col = 0; col < 2; col++){
				crew[row][col] = new Alien(row * 80, col * 100, (int)(Math.random()*2 + 1));
			}
		}
	}
	
	public Alien[][] getAliens(){
		return crew;
	}
}
