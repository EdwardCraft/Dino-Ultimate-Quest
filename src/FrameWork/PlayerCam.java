package FrameWork;
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
		if(player.jumping == true){
			position_Y = (-player.getY() + (Constants.GAME_WINDOW_HEIGHT - (Constants.PLAYER_RECTANGLE_HEIGHT + 30)));
		}else{
			position_Y = (int)(-player.getY() + (Constants.GAME_WINDOW_HEIGHT - (Constants.PLAYER_RECTANGLE_HEIGHT + 30)));
		}
		
		
	}
	

	public float getPositionX(){ return position_X; }
	public void setPositionX(float position_X){ this.position_X = position_X; }
	public float getPositionY(){ return position_Y; }
	public void setPositionY(float position_Y){ this.position_Y = position_Y;  }
	
	
	
}
