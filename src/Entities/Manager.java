package Entities;
import java.util.LinkedList;

import FrameWork.GameObject;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import Classes.Game;
import Classes.Texture;
import FrameWork.ObjectId;
import Utils.BufferedImageLoader;
import Utils.Constants;
import Utils.PlayerCam;


public class Manager{

	public LinkedList<GameObject> gameObjects;
	private GameObject tempObject;
	private PlayerCam camera;
	BufferedImageLoader imageLoader;
	Texture texture;
	private int currentState;
	private Player player;
	private LevelOne lvlOne;
	
	public Manager(PlayerCam camera){

		texture = Game.getTexture();
		this.camera = camera;
		gameObjects = new LinkedList<GameObject>();
		imageLoader = new BufferedImageLoader();
		currentState = Constants.MENU_STATE;
		loadScreen(currentState);
		
	}
	
	public void loadScreen(int state){
		if(state == Constants.MENU_STATE){
			clearLevel();
			loadingImages(texture.Menu[0]);
		}
		else if(state == Constants.LEVELS_STATE){

			switchLevel();
		}
	}
	

	public void switchLevel(){
		clearLevel();
		
		camera.setPositionX(0);	
		camera.setPositionY(0);
		
		switch(Constants.LEVELS)
		{
			case 1:			
				loadingImages(texture.Level1Game);
			break;
			case 2:
				loadingImages(texture.levels[Constants.LEVELS]);
			break;
			case 3:
				loadingImages(texture.levels[Constants.LEVELS]);
			break;
			case 4:
			break;

		}
		
				
	}
	
	
	public void setState(int state){
		clearLevel();
		currentState = state;
		loadScreen(state);
	}
	
	
	private void clearLevel(){
		gameObjects.clear();
	}
	
	
	public void mapReset(){
		clearLevel();
		camera.setPositionX(0);
		loadingImages(texture.levels[0]);
		Constants.LEVELS = 1;
	}
	
	
	public void update(){

		for(int i = 0; i < gameObjects.size(); i ++ ){
			tempObject = gameObjects.get(i);
			tempObject.update(gameObjects);
			if(tempObject.getObjectId() == ObjectId.Blast){
				if(tempObject.getX() < 0){
					removeObject(tempObject);					
				}
				if(tempObject.getX() > (Constants.GAME_WINDOW_WIDTH * 10)){
					removeObject(tempObject);
				}
				
			}
		}
		
	}
	
	

	
	public void render(Graphics g){	
	
			for(int i = 0; i < gameObjects.size(); i ++ ){
				tempObject = gameObjects.get(i);
				tempObject.render(g);
			}
			
	}


	
	public void addObject(GameObject object){
		this.gameObjects.add(object);
	}

	
	public void removeObject(GameObject object){
		this.gameObjects.remove(object);
	}
	

	
	public  void loadingImages(BufferedImage image){
		int width = image.getWidth();
		int height = image.getHeight();
		
		//where looping through every single pixel on the image
		for(int i = 0;i < height; i++)
		{		
			for(int j = 0;j < width; j++)
			{
				int pixel = image.getRGB(i,j);
				int red   = (pixel >> 16) & 0xff;
				int green = (pixel >> 8)  &  0xff;
				int blue  = (pixel) & 0xff;
				
				if(red == 255 && green == 0 && blue == 0) addObject(new Menu(i * 32, j * 32,this, ObjectId.Menu));
				if(red == 255 && green == 255 && blue == 0) addObject(new Flag(i * 32, j * 32,ObjectId.Flag));
				if(red == 255 && green == 255 && blue == 255) addObject(new Block(i * 32, j * 32,0,ObjectId.Block));
				if(red == 129 && green == 243 && blue == 158) addObject(new Block(i * 32, j * 32,1,ObjectId.Block));
				if(red == 161 && green == 134 && blue == 190) addObject(new Reset(i * 32, j * 32,ObjectId.Reset));
				if(red == 0 && green == 0 && blue == 255) addObject(new Player(i * 32, j * 32,this,camera,ObjectId.Player));
				if(red == 0 && green == 250 && blue == 0) addObject(new Minion(i * 32, j * 32,this,ObjectId.Enemy));
				
			}		
		}

	}
	public Player getPlayer(){
		return player;
	}
	public LevelOne getlevel(){
		return lvlOne;
	}
	
	public int getCurrentState(){
		return currentState;
	}

}