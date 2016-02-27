package FrameWork;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import Classes.Game;
import Entities.Manager;
import Entities.Pause;
import FrameWork.GameObject;
import FrameWork.ObjectId;
import Utils.Constants;
import Utils.Enums.JumpState;

public class KeyInput extends KeyAdapter{
	
	Manager manager;
	GameObject gameObject;
	JumpState jumpState;
	public KeyInput(Manager manager){
		this.manager = manager;
	}


	@SuppressWarnings("deprecation")
	public void keyPressed(KeyEvent e){
		int  key  = e.getKeyCode();
		
		for(int i = 0; i < manager.gameObjects.size(); i++){
			gameObject = manager.gameObjects.get(i);
			if(gameObject.getObjectId() == ObjectId.Player){
				if(Constants.PAUSE == false){
					if(key == KeyEvent.VK_RIGHT) gameObject.setVelocityX(Constants.PLAYER_MOVEMENT_SPEDD);
					if(key == KeyEvent.VK_LEFT) gameObject.setVelocityX(-Constants.PLAYER_MOVEMENT_SPEDD);
					if(key == KeyEvent.VK_SPACE && !gameObject.isJumping()){					
						gameObject.setJumping(true);
						gameObject.setVelocityY(-Constants.PLAYER_JUMP_HIGHT);
					}
				}
				
				if(key == KeyEvent.VK_ENTER){
					if(Constants.PAUSE == false){
						Constants.PAUSE = true;
					}else{
						Constants.PAUSE = false;
					}
					
				}

		}
	}
		
	   for(int i = 0; i < manager.gameObjects.size(); i++){
		   gameObject = manager.gameObjects.get(i);
			   if(gameObject.getObjectId() == ObjectId.Menu){
				   if(key == KeyEvent.VK_ENTER) gameObject.select();
				   if(key == KeyEvent.VK_UP) {
					   gameObject.currentChoice --;
					   if(gameObject.currentChoice == -1){
						   gameObject.currentChoice = gameObject.options.length - 1;
					   }
				   }
				   if(key == KeyEvent.VK_DOWN) {
					   gameObject.currentChoice ++;
					   if(gameObject.currentChoice == gameObject.options.length) {
						   gameObject.currentChoice = 0;
						}
				   }
			   }
		   
	   }
	   
	   if(key == KeyEvent.VK_ESCAPE){
		   System.exit(1);
	   }
	}

	public void keyReleased(KeyEvent e){
		int  key  = e.getKeyCode();
		
		for(int i = 0; i < manager.gameObjects.size(); i++){
			gameObject = manager.gameObjects.get(i);
			if(gameObject.getObjectId() == ObjectId.Player){
				if(key == KeyEvent.VK_RIGHT) gameObject.setVelocityX(0);
				if(key == KeyEvent.VK_LEFT) gameObject.setVelocityX(0);
				if(key == KeyEvent.VK_W) gameObject.setVelocityY(0);
				
			}
		}


	}

	
	
}
