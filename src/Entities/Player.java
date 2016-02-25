package Entities;
import FrameWork.Animation;
import FrameWork.GameObject;
import FrameWork.ObjectId;
import java.util.LinkedList;

import Classes.Game;
import Classes.Texture;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.time.temporal.JulianFields;

import Utils.Constants;
import java.awt.Color;

import Utils.Enums.Facing;
import Utils.Enums.JumpState;
import Utils.PlayerCam;

import java.awt.Graphics2D;
import FrameWork.GameObject;
import FrameWork.ObjectId;



public class Player extends GameObject{



	Graphics2D g2d;
	Manager manager;
	GameObject gameObject;
	private PlayerCam camera;
	Texture texture;
	
	private Animation playerIdle;
	private Animation palyerjump;
	private Animation palyerFall;
	private Animation playerRun;
	private int health;
	
	public Player(float x, float y, Manager manager,PlayerCam camera,ObjectId id){
		super(x, y, id);
		this.manager = manager;
		this.camera = camera;
		texture = Game.getTexture();
		
		playerIdle   = new Animation(3, texture.player[0], texture.player[1], 
				texture.player[2], texture.player[3], 
				texture.player[4], texture.player[5],
				texture.player[6], texture.player[7]
				);
		
		palyerjump   = new Animation(3, texture.player[8]);
		
		palyerFall   = new Animation(10, texture.player[9]);
		
		playerRun   = new Animation(1,
				texture.runnigS[0],texture.runnigS[1],
				texture.runnigS[2],texture.runnigS[3],texture.runnigS[4],
				texture.runnigS[5],texture.runnigS[6],texture.runnigS[7],
				texture.runnigS[8],texture.runnigS[9],texture.runnigS[10],
				texture.runnigS[11],texture.runnigS[12],texture.runnigS[13],
				texture.runnigS[14],texture.runnigS[15],texture.runnigS[16],
				texture.runnigS[17],texture.runnigS[18],texture.runnigS[19],
				texture.runnigS[20]
				);

		facing = Facing.LEFT;
		jumpState = JumpState.FALLING;
		health = 100;
	}



	public void update(LinkedList<GameObject> object){

		x += velocity_X;
		y += velocity_Y;
		
		if(x <= 0 ){
			x = 0;
		}
		
		if(falling || jumping){
			velocity_Y += Constants.PLAYER_GRAVITY_ACCELERATION;
			//velocity_X += Constants.PLAYER_GRAVITY_ACCELERATION;
		}
		
		if(velocity_X < 0){
			facing = Facing.RIGHT;
		}else if(velocity_X > 0){
			facing = Facing.LEFT;
		}
		
		Collision(object);
		playerIdle.runAnimation();
		palyerjump.runAnimation();
		palyerFall.runAnimation();
		playerRun.runAnimation();
		
	}

	public void render(Graphics g){

		g.setColor(Color.blue);
		
		if(jumping){
			if(facing == Facing.RIGHT)
				palyerFall.drawAnimation(g,(int)x + Constants.PLAYER_RECTANGLE_WIDTH,
						(int)y, - Constants.PLAYER_RECTANGLE_WIDTH,Constants.PLAYER_RECTANGLE_HEIGHT);
			else
				palyerFall.drawAnimation(g,(int)x,(int)y,Constants.PLAYER_RECTANGLE_WIDTH,Constants.PLAYER_RECTANGLE_HEIGHT);
		}else{
			if(velocity_X !=0){
			if(facing == Facing.RIGHT)
				playerRun.drawAnimation(g,(int)x + Constants.PLAYER_RECTANGLE_WIDTH,
						(int)y, - Constants.PLAYER_RECTANGLE_WIDTH, Constants.PLAYER_RECTANGLE_HEIGHT);
			else 
				playerRun.drawAnimation(g,(int)x,(int)y, Constants.PLAYER_RECTANGLE_WIDTH, Constants.PLAYER_RECTANGLE_HEIGHT);
		}else{
			if(facing == Facing.RIGHT)
				playerIdle.drawAnimation(g,(int)x + Constants.PLAYER_RECTANGLE_WIDTH,
						(int)y, - Constants.PLAYER_RECTANGLE_WIDTH, Constants.PLAYER_RECTANGLE_HEIGHT);
			else
				playerIdle.drawAnimation(g,(int)x,(int)y, Constants.PLAYER_RECTANGLE_WIDTH, Constants.PLAYER_RECTANGLE_HEIGHT);
		}

		}		

	}

	private void Collision(LinkedList<GameObject> object){

		for(int i = 0; i < manager.gameObjects.size(); i++){
			gameObject = manager.gameObjects.get(i);
			if(gameObject.getObjectId() == ObjectId.Block){
				//top collision
				if(getBoundsTop().intersects(gameObject.getBounds()))
				{
					y = gameObject.getY()+32;
					velocity_Y =0;
				}
				//button half
				if(getBounds().intersects(gameObject.getBounds()))
				{
					y = gameObject.getY()-Constants.PLAYER_RECTANGLE_HEIGHT;
					velocity_Y = 0;
					falling = false;
					jumping = false;
				//code lines for jumping	
				}else{
					falling =true;
				}
				//code for Right
				if(getBoundsRight().intersects(gameObject.getBounds()))
				{
					x = gameObject.getX() - Constants.PLAYER_RECTANGLE_WIDTH;
				}
				//code for left
				if(getBoundsLeft().intersects(gameObject.getBounds()))
				{
					x = gameObject.getX() + 35;
				}
			}
		}

	}



	public Rectangle getBounds(){

		return new Rectangle(
			(int)((int)x + (Constants.PLAYER_RECTANGLE_WIDTH / 4)),
			(int)((int)y + (Constants.PLAYER_RECTANGLE_HEIGHT / 2)),
			(int)Constants.PLAYER_RECTANGLE_WIDTH / 2,
			(int)Constants.PLAYER_RECTANGLE_HEIGHT / 2
			);
	}

	public Rectangle getBoundsTop(){

		return new Rectangle(
			(int)((int)x + (Constants.PLAYER_RECTANGLE_WIDTH / 4)),
			(int)y,
			(int)Constants.PLAYER_RECTANGLE_WIDTH / 2,
			(int)Constants.PLAYER_RECTANGLE_HEIGHT / 2
			);
	}

	public Rectangle getBoundsRight(){

		return new Rectangle(
			(int)((int)x + (Constants.PLAYER_RECTANGLE_WIDTH - 5)),
			(int)y + 5,
			(int)5.0,
			(int)Constants.PLAYER_RECTANGLE_HEIGHT - 10
			);
	}

	public Rectangle getBoundsLeft(){

		return new Rectangle(
			(int)x,
			(int)y + 5,
			(int)5.0,
			(int)Constants.PLAYER_RECTANGLE_HEIGHT - 10
			);
	}




	public void select() {
		// TODO Auto-generated method stub
		
	}

	public int getHealth(){
		return health;
	}


} 