package Classes;
import java.awt.Canvas;

import Utils.BufferedImageLoader;
import Utils.Constants;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.concurrent.locks.AbstractQueuedLongSynchronizer.ConditionObject;

import Audio.GameAudio;

import java.awt.Graphics;
import java.awt.Color;
import Entities.Manager; 
import FrameWork.ObjectId;
import Entities.Player;
import FrameWork.KeyInput;
import Utils.PlayerCam;
import java.awt.Graphics2D;


public class Game extends Canvas implements Runnable{

	private boolean running;
	public static Thread thread;

	BufferStrategy bufferStrategy;
	Graphics graphics;
	Graphics2D graphics2D;
	Manager manager;
	PlayerCam playerCamera;
	
	GameAudio gameAudio;
	BufferedImageLoader imageLoader;
	static Texture texture;
	

	public Game(){

		running = false;
		gameAudio = new GameAudio(Constants.GAME_LEVEL_1_AUDIO);
		imageLoader = new BufferedImageLoader();

		//gameAudio.play();
	}


	private void init(){
		
		texture = new Texture();
		playerCamera = new PlayerCam(0,0);
		manager = new Manager(playerCamera);
		this.addKeyListener(new KeyInput(manager));

	}



	public synchronized void start(){

		if(running){
			return;	
		}

		running = true;
		thread = new Thread(this);
		thread.start(); 


	}

	// The Thread
	public void run(){

		System.out.println("Thread has begun");
		init();
		this.requestFocus();

		long lastTime = System.nanoTime();
		double delta = 0;
		long timer = System.currentTimeMillis();
		int updates = 0;
		int frames = 0;

		while(running){
		long now = System.nanoTime();
		delta += (now - lastTime) / Constants.NANO_SECONDS;
		lastTime = now;
		while(delta >= 1){
			update();
			updates++;
			delta--;
		}

		render();
		frames++;
			
		if(System.currentTimeMillis() - timer > 1000){
			timer += 1000;
			//System.out.println("FPS: " + updates);
			frames = 0;
			updates = 0;
			}
		}

	}


	//Everything  that updates;
	private void update(){
		manager.update();

		for(int i = 0; i < manager.gameObjects.size(); i++){
			if(manager.gameObjects.get(i).getObjectId() == ObjectId.Player){
				playerCamera.update(manager.gameObjects.get(i));
			}
		}	
		

	}


	// Everything that renders  
	private void render(){

        bufferStrategy = this.getBufferStrategy();
		if(bufferStrategy == null){
			this.createBufferStrategy(Constants.BUFFER_STRATEGY);
			return;
		}

	    graphics = bufferStrategy.getDrawGraphics();
	    graphics2D = (Graphics2D) graphics;


	    graphics.setColor(new Color(90,194,250));
	    graphics.fillRect(0, 0, getWidth(), getHeight());
	    //graphics.drawImage(texture.SkyBackground[Game.LEVEL], 0, 0,Constants.GAME_WINDOW_WIDTH + 10,Constants.GAME_WINDOW_HEIGHT + 10,null)
	    if(Constants.LEVELS == 1){
	    	graphics.drawImage(texture.SkyBackground[0], 0, 0, 
	    			Constants.GAME_WINDOW_WIDTH + 10, 
	    			Constants.GAME_WINDOW_HEIGHT + 10, null);
	    }
	    
	    if(playerCamera.getPositionX() < 0){
	    	 graphics2D.translate( playerCamera.getPositionX(),  playerCamera.getPositionY());
	    }
	   
	    manager.render(graphics);


	    graphics2D.translate( -playerCamera.getPositionX(),  -playerCamera.getPositionY());
		dispose();
		bufferStrategy.show();

	}


	private void dispose(){

		graphics.dispose();

	}
	
	public static Texture getTexture(){
		return texture;
	}


}