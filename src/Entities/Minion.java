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
	private Facing facingMonster;
	private static final int left = 5;
	private float width   = 70, height = 70;
	private float gravity = 0.5f;
	private final float MAX_SPEED = 10;

	private static final int c=5;
	

	public Minion(float x, float y, Manager manager, ObjectId id) {
		super(x, y, id);
		this.manager = manager;
		
		texture = Game.getTexture();
		monster = new Animation(3, 
				texture.enemy[0], texture.enemy[1],
				texture.enemy[2], texture.enemy[3],
				texture.enemy[4], texture.enemy[5],
				texture.enemy[6], texture.enemy[7],
				texture.enemy[8], texture.enemy[9]);
		
		facingMonster = Facing.LEFT;


	}


	public void update(LinkedList<GameObject> object) {
		x -= left;
		x += velocity_X;
		y += velocity_Y;

		if(falling || jumping)
		{
			velocity_Y += gravity;
			if(velocity_Y > MAX_SPEED)
				velocity_Y = MAX_SPEED;			
		}

		/*if(facingMonster == Facing.RIGHT){
			x -= Constants.ENEMY_MOVEMENT_SPEED;
			System.out.println("right" + x);
		}
	    if(facingMonster == Facing.LEFT){
			x += Constants.ENEMY_MOVEMENT_SPEED;
			System.out.println("left " + x);
		}
		*/
			

		/*if((falling || jumping)){
			velocity_Y += Constants.PLAYER_GRAVITY_ACCELERATION;
		}*/
		
		
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

					y = tempObject.getY()-height;
					velocity_Y = 0;
					falling = false;
					jumping = false;
					//velocity_Y -= 5;
					System.out.println("boton");
				}else falling =true;

				if(getBoundsTop().intersects(tempObject.getBounds()))
				{
					y = tempObject.getY()+32;
					velocity_Y =0;
				
				}

				if(getBoundsLeft().intersects(tempObject.getBounds()))
				{
					x = tempObject.getX() + 35;
					velocity_X+=10;
					facingMonster = Facing.RIGHT;
					System.out.println("left");
				}

				if(getBoundsRight().intersects(tempObject.getBounds()))
				{
					x =tempObject.getX() - width;
					velocity_X-=10;
					facingMonster = Facing.LEFT;
					System.out.println("right");
				}

			}
		}

		
	}

	public void render(Graphics g) {
		
		/*Graphics2D g2d = (Graphics2D) g; 
		g.setColor(Color.red);
		g2d.draw(getBounds());
		g2d.draw(getBoundsRight());
		g2d.draw(getBoundsLeft());
		g2d.draw(getBoundsTop());*/
		
		if(facingMonster == Facing.RIGHT){
			monster.drawAnimation(g, (int)x, 
					(int)y , Constants.ENEMY_RECTANGLE_WIDTH, Constants.ENEMY_RECTANGLE_HEIGHT );
		}else{
			monster.drawAnimation(g, (int)x + Constants.ENEMY_RECTANGLE_WIDTH , 
					(int)y , - Constants.ENEMY_RECTANGLE_WIDTH , Constants.ENEMY_RECTANGLE_HEIGHT );
		}
		
		/*g.setColor(new Color(105,224,130));
		//g.fillRect((int)x,(int)y,32,32);

		g.fillRect((int)x,(int)y,(int)70,(int)70);

		Graphics2D g2d = (Graphics2D) g;

		g.setColor(Color.red);
		g2d.draw(getBounds());
		g2d.draw(getBoundsRight());
		g2d.draw(getBoundsLeft());
		g2d.draw(getBoundsTop());*/
		
		
	}
	
	
	
	public Rectangle getBounds(){
		return  new Rectangle((int)((int)x+(Constants.ENEMY_RECTANGLE_WIDTH/2)-((Constants.ENEMY_RECTANGLE_WIDTH/2)/2)),
				(int)((int)y+(Constants.ENEMY_RECTANGLE_HEIGHT/2)),
				(int)Constants.ENEMY_RECTANGLE_WIDTH/2,(int)Constants.ENEMY_RECTANGLE_HEIGHT/2);
	}
	

	public Rectangle getBoundsTop(){

		return new Rectangle((int)((int)x+(Constants.ENEMY_RECTANGLE_WIDTH/2)-((Constants.ENEMY_RECTANGLE_WIDTH/2)/2)),
				(int)y,(int)Constants.ENEMY_RECTANGLE_WIDTH/2,(int)Constants.ENEMY_RECTANGLE_HEIGHT/2);
	}
	public Rectangle getBoundsRight(){

		return new Rectangle((int)((int)x+Constants.ENEMY_RECTANGLE_WIDTH-5),(int)y+5,
				(int)5,(int)Constants.ENEMY_RECTANGLE_HEIGHT-10);
	}
	public Rectangle getBoundsLeft(){

		return new Rectangle((int)x,(int)y+5,
				(int)5,(int)Constants.ENEMY_RECTANGLE_HEIGHT-10);
	}
	@Override
	public void select() {
		
		
	}

}
