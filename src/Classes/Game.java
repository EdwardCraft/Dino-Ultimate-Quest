package Classes;
import java.awt.Canvas;

import Utils.BufferedImageLoader;
import Utils.Constants;
import Utils.Enums.ScreenState;
import Utils.Texture;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import Audio.GameAudio;
import java.awt.Graphics;
import java.awt.Color;
import Entities.Manager;
import FrameWork.ObjectId;
import FrameWork.PlayerCam;
import Screens.Hud;
import Screens.Menu;
import Screens.Pause;
import Entities.Player;
import FrameWork.KeyInput;

import java.awt.Graphics2D;



public class Game extends Canvas implements Runnable{

	private boolean running;
	private static Thread thread;

	private BufferStrategy bufferStrategy;
	private Graphics graphics;
	private Graphics2D graphics2D;
	private Manager manager;
	private PlayerCam playerCamera;
	private Hud hud;
	private GameAudio gameAudio;
	private BufferedImageLoader imageLoader;
	static Texture texture;
	private Pause pause;
	private Menu menu;
	private int hudActive;
	private ScreenState state;
	
	public Game(){
		
		running = false;
		gameAudio = new GameAudio(Constants.GAME_LEVEL_1_AUDIO);
		imageLoader = new BufferedImageLoader();
		pause = new Pause();
		state = ScreenState.Menu;
		//gameAudio.play();
	}


	private void init(){
		
		texture = new Texture();
		playerCamera = new PlayerCam(0,0);
		manager = new Manager(playerCamera);
		menu = new Menu(this);
		this.addKeyListener(new KeyInput(manager, menu, this));
		hud = new Hud(manager);
		hudActive = 0;
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
			frames = 0;
			updates = 0;
			}
		}

	}


	//Everything  that updates;
	private void update(){
		
		if(state == ScreenState.Pause){
			return;
		}
		
		if(state == ScreenState.Game){
			manager.update();	
			for(int i = 0; i < manager.gameObjects.size(); i++){
				if(manager.gameObjects.get(i).getObjectId() == ObjectId.Player){
					playerCamera.update(manager.gameObjects.get(i));
				}
			}	
		}
		
		if(state == ScreenState.Menu){
			menu.update();
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


	    graphics.setColor(new Color(0,0,0));
	    graphics.fillRect(0, 0, getWidth(), getHeight());
	    
	   if(state == ScreenState.Game || state == ScreenState.Pause){
		   
	    	graphics.drawImage(texture.SkyBackground[0], 0, 0, 
	    			Constants.GAME_WINDOW_WIDTH + 10, 
	    			Constants.GAME_WINDOW_HEIGHT + 10, null);
	    	
	    	
		   // if(playerCamera.getPositionX() < 0){
			    graphics2D.translate( playerCamera.getPositionX(),playerCamera.getPositionY());
			//}
			   
			    manager.render(graphics);
		
			graphics2D.translate( -playerCamera.getPositionX(), -playerCamera.getPositionY());			
		    	
				hud.render(graphics);
			
			   		
	    }
	   
	   if(state == ScreenState.Menu){
		   menu.render(graphics);
	   }
	   
	   	
	    if(state == ScreenState.Pause){
				 graphics.setColor(new Color(0f,0f,0f,.7f));
				 graphics.fillRect(0, 0, getWidth() + Constants.GAME_WORLD_OFFSET , getHeight());
				 pause.render(graphics);
				
			 }
	    
		dispose();
		bufferStrategy.show();
		

	}


	private void dispose(){

		graphics.dispose();

	}
	
	public static Texture getTexture(){
		return texture;
	}

	
	public ScreenState getScreenState(){
		return state;
	}
	
	public void setScreenState(ScreenState state){
		this.state = state;
	}
	
	
	
	
}