package Entities;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import Classes.Game;
import Classes.Texture;
import FrameWork.Animation;
import FrameWork.GameObject;
import FrameWork.ObjectId;
import Utils.Constants;
import Utils.Enums.Facing;


public class Blast extends GameObject{
	
	private Texture texture;
	private Animation blast;

	public Blast(float x, float y, ObjectId id, Facing facing) {
		super(x, y, id);

		this.facing = facing;
		texture = Game.getTexture();
		
		blast = new Animation(1, texture.fire[0],
				texture.fire[1], texture.fire[2]);
		
	}

	@Override
	public void update(LinkedList<GameObject> object) {
		
		if(facing == Facing.LEFT){
			x += Constants.FIRE_BALL_VELOCITY;
		}else if(facing == Facing.RIGHT){
			x -= Constants.FIRE_BALL_VELOCITY;
		}
		
		blast.runAnimation();
	}

	@Override
	public void render(Graphics g) {
		if(facing == Facing.RIGHT){
			blast.drawAnimation(g, (int)x + Constants.PLAYER_RECTANGLE_WIDTH / 2, 
					(int)y + 10, - Constants.PLAYER_RECTANGLE_WIDTH, Constants.PLAYER_RECTANGLE_HEIGHT);
		}else{
			blast.drawAnimation(g, (int)x + Constants.PLAYER_RECTANGLE_WIDTH / 2, 
					(int)y + 10, Constants.PLAYER_RECTANGLE_WIDTH, Constants.PLAYER_RECTANGLE_HEIGHT);
		}
		
		
	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void select() {
		// TODO Auto-generated method stub
		
	}

}
