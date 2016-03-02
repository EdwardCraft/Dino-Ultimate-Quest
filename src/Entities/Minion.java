package Entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.LinkedList;

import Classes.Game;
import Classes.Texture;
import FrameWork.Animation;
import FrameWork.GameObject;
import FrameWork.ObjectId;
import Utils.Constants;
import Utils.Enums.Facing;
import Utils.Enums.JumpState;

public class Minion extends GameObject {
	
	private Texture texture;
	private Animation monster;
	private Manager manager;
	private GameObject gameObject;

	private static final int left = 5;
	private float width   = 70, height = 70;
	private float gravity = 0.5f;
	private final float MAX_SPEED = 10;

	private static final int c=5;
	

	public Minion(float x, float y, Manager manager, ObjectId id) {
		super(x, y, id);
		this.manager = manager;
		
		texture = Game.getTexture();
		monster = new Animation(Constants.ENEMY_ANIMATION_DURATION, 
				texture.enemy[0], texture.enemy[1],
				texture.enemy[2], texture.enemy[3],
				texture.enemy[4], texture.enemy[5],
				texture.enemy[6], texture.enemy[7],
				texture.enemy[8], texture.enemy[9]);
		
		facing = Facing.RIGHT;


	}


	public void update(LinkedList<GameObject> object) {
		
		y += velocity_Y;
		
		if(facing == Facing.RIGHT){
			x -= Constants.ENEMY_MOVEMENT_SPEED;
			
		}
	    if(facing == Facing.LEFT){
			x += Constants.ENEMY_MOVEMENT_SPEED;
		
		}
		
			

		if((falling || jumping)){
			velocity_Y += Constants.PLAYER_GRAVITY_ACCELERATION;
		}
		
		
		monster.runAnimation();
		Collision(object);
	}
	
	private void Collision(LinkedList<GameObject> object){
		for(int i = 0; i <manager.gameObjects.size(); i++)
		{
			GameObject tempObject = manager.gameObjects.get(i);
			/*if(tempObject.getObjectId() == ObjectId.Player)
			{
				if(getBoundsLeft().intersects(tempObject.getBounds()))
				{
					manager.mapReset();
				}
				if(getBoundsRight().intersects(tempObject.getBounds()))
				{
					manager.mapReset();
				}
				if(getBoundsTop().intersects(tempObject.getBounds()))
				{
					manager.mapReset();
					
				}
				if(getBounds().intersects(tempObject.getBounds()))
				{
					manager.mapReset();
				}				
			}*/
			 if(tempObject.getObjectId() == ObjectId.Block)
			{

				if(getBounds().intersects(tempObject.getBounds()))
				{

					y = tempObject.getY() - Constants.ENEMY_RECTANGLE_HEIGHT;
					velocity_Y = 0;
					falling = false;
					jumping = false;
					System.out.println("boton");
				}else falling = true;

				if(getBoundsTop().intersects(tempObject.getBounds()))
				{
					y = tempObject.getY()+32;
					velocity_Y =0;
				
				}

				if(getBoundsLeft().intersects(tempObject.getBounds()))
				{
					x = tempObject.getX() + 35;
					facing = Facing.RIGHT;
					System.out.println("left");
				}

				if(getBoundsRight().intersects(tempObject.getBounds()))
				{
					x =tempObject.getX() - Constants.ENEMY_RECTANGLE_WIDTH;
					facing = Facing.LEFT;
					System.out.println("right");
				}

			}
		}

		
	}

	public void render(Graphics g) {
		
		Graphics2D g2d = (Graphics2D) g; 
		g.setColor(Color.red);
		g2d.draw(getBounds());
		g2d.draw(getBoundsRight());
		g2d.draw(getBoundsLeft());
		g2d.draw(getBoundsTop());
		
		if(facing == Facing.RIGHT){
			monster.drawAnimation(g, (int)x, 
					(int)y , Constants.ENEMY_RECTANGLE_WIDTH, Constants.ENEMY_RECTANGLE_HEIGHT );
		}else{
			monster.drawAnimation(g, (int)x + Constants.ENEMY_RECTANGLE_WIDTH , 
					(int)y , - Constants.ENEMY_RECTANGLE_WIDTH , Constants.ENEMY_RECTANGLE_HEIGHT );
		}
				
	}
	
	
	
	public Rectangle getBounds(){
		
		return  new Rectangle(
				(int)((int)x+(Constants.ENEMY_RECTANGLE_WIDTH / 4)),
				(int)((int)y+(Constants.ENEMY_RECTANGLE_HEIGHT/2)),
				(int)Constants.ENEMY_RECTANGLE_WIDTH/2,
				(int)Constants.ENEMY_RECTANGLE_HEIGHT/2);
	}
	

	public Rectangle getBoundsTop(){

		return new Rectangle(
				(int)((int)x+(Constants.ENEMY_RECTANGLE_WIDTH / 4)),
				(int)y,
				(int)Constants.ENEMY_RECTANGLE_WIDTH/2,
				(int)Constants.ENEMY_RECTANGLE_HEIGHT/2);
	}
	public Rectangle getBoundsRight(){

		return new Rectangle(
				(int)((int)x+Constants.ENEMY_RECTANGLE_WIDTH - 6),
				(int)y + 10,
				(int)5,
				(int)Constants.ENEMY_RECTANGLE_HEIGHT - 20);
	}
	public Rectangle getBoundsLeft(){

		return new Rectangle(
				(int)x,
				(int)y + 10,
				(int)5,
				(int)Constants.ENEMY_RECTANGLE_HEIGHT - 20);
	}
	
	
	public void select() {
		
		
	}

}
