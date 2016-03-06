package FrameWork;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import Entities.Blast;
import Utils.Constants;


public class PlayerCam {
	
	private float position_X;
	private float position_Y;

	public PlayerCam(float position_X, float position_Y){
		this.position_X = position_X;
		this.position_Y = position_Y;
	}


	public void update(GameObject player){
		/*float smothCameraX = -player.getX() + Constants.GAME_WINDOW_WIDTH / 6;
		float smothCameraY = (float) (-player.getY() + (float)Constants.GAME_WINDOW_HEIGHT/ 1.25);
		position_X += (int)((smothCameraX - position_X) * (0.1));
		position_Y += (int)((smothCameraY - position_Y) * (0.1));*/
		
		position_X = -player.getX() + Constants.GAME_WINDOW_WIDTH / 3;
		position_Y = (int)(-player.getY() + (Constants.GAME_WINDOW_HEIGHT - (Constants.PLAYER_RECTANGLE_HEIGHT + 30)));

		
	
		
		
	}
	
	public void reder(Graphics g){
		Graphics2D g2d = (Graphics2D) g; 
		g.setColor(Color.white);
		g2d.draw(getBounds());
		
	}
	
	public Rectangle getBounds(){
		
		return  new Rectangle(
				-(int)position_X - Constants.BLAST_RECTANGLE_WIDTH + 20,
				-(int)position_Y+5,
				(int)Constants.GAME_WINDOW_WIDTH + Constants.BLAST_RECTANGLE_WIDTH * 2,
				(int)Constants.GAME_WINDOW_HEIGHT);
	}
	
	
	public float getPositionX(){ return position_X; }
	public void setPositionX(float position_X){ this.position_X = position_X; }
	public float getPositionY(){ return position_Y; }
	public void setPositionY(float position_Y){ this.position_Y = position_Y;  }
	
	
	
}
