package FrameWork;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import Entities.Manager;
import java.awt.event.KeyListener;
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


	public void keyPressed(KeyEvent e){
		int  key  = e.getKeyCode();
		
		for(int i = 0; i < manager.gameObjects.size(); i++){
			gameObject = manager.gameObjects.get(i);
			if(gameObject.getObjectId() == ObjectId.Player){
				if(key == KeyEvent.VK_D) gameObject.setVelocityX(Constants.PLAYER_MOVEMENT_SPEDD);
				if(key == KeyEvent.VK_A) gameObject.setVelocityX(-Constants.PLAYER_MOVEMENT_SPEDD);
				if(key == KeyEvent.VK_S) gameObject.setVelocityY(Constants.PLAYER_MOVEMENT_SPEDD);
				if(key == KeyEvent.VK_SPACE && !gameObject.isJumping()){
					
					gameObject.setJumping(true);
					gameObject.setVelocityY(-Constants.PLAYER_JUMP_HIGHT);
			}
		}
	}
		
	   for(int i = 0; i < manager.gameObjects.size(); i++){
		   gameObject = manager.gameObjects.get(i);
			   if(gameObject.getObjectId() == ObjectId.Menu){
				   if(key == KeyEvent.VK_ENTER) gameObject.select();
				   if(key == KeyEvent.VK_W) {
					   gameObject.currentChoice --;
					   if(gameObject.currentChoice == -1){
						   gameObject.currentChoice = gameObject.options.length - 1;
					   }
				   }
				   if(key == KeyEvent.VK_S) {
					   gameObject.currentChoice ++;
					   if(gameObject.currentChoice == gameObject.options.length) {
						   gameObject.currentChoice = 0;
						}
				   }
			   }
		   
	   }

	}

	public void keyReleased(KeyEvent e){
		int  key  = e.getKeyCode();
		
		for(int i = 0; i < manager.gameObjects.size(); i++){
			gameObject = manager.gameObjects.get(i);
			if(gameObject.getObjectId() == ObjectId.Player){
				if(key == KeyEvent.VK_D) gameObject.setVelocityX(0);
				if(key == KeyEvent.VK_A) gameObject.setVelocityX(0);
				if(key == KeyEvent.VK_W) gameObject.setVelocityY(0);
				if(key == KeyEvent.VK_S) gameObject.setVelocityY(0);
				
			}
		}


	}

	
	
}
