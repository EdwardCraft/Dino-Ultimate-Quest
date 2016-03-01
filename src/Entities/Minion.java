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

public class Minion extends GameObject {
	
	private Texture texture;
	private Animation monster;
	
	public Minion(float x, float y, ObjectId id) {
		
		super(x, y, id);
		texture = Game.getTexture();
		monster = new Animation(1, 
				texture.enemy[0], texture.enemy[1],
				texture.enemy[2], texture.enemy[3],
				texture.enemy[4], texture.enemy[5],
				texture.enemy[6], texture.enemy[7],
				texture.enemy[8], texture.enemy[9]);
		facing = Facing.LEFT;
	}

	@Override
	public void update(LinkedList<GameObject> object) {
		x = 0;
		y = 0;
		monster.runAnimation();
		
	}

	@Override
	public void render(Graphics g) {
		
		if(facing == Facing.RIGHT){
			monster.drawAnimation(g, (int)x + Constants.ENEMY_RECTANGLE_WIDTH , 
					(int)y, - Constants.ENEMY_RECTANGLE_WIDTH, Constants.ENEMY_RECTANGLE_HEIGHT);
		}else{
			monster.drawAnimation(g, (int)x + Constants.ENEMY_RECTANGLE_WIDTH, 
					(int)y, Constants.ENEMY_RECTANGLE_WIDTH, Constants.ENEMY_RECTANGLE_HEIGHT);
		}
		
	}

	@Override
	public Rectangle getBounds() {
		
		return null;
	}

	@Override
	public void select() {
		
		
	}

}
