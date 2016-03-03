package Screens;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import Entities.Manager;
import Entities.Player;
import FrameWork.GameObject;
import FrameWork.ObjectId;
import Utils.Constants;

public class Hud {
	
	private BufferedImage hud;
	private Manager manager;
	
	public Hud(Manager manager){
		
		this.manager = manager;
		
		try {
			hud = ImageIO.read(
				getClass().getResourceAsStream(
					Constants.GAME_HUD
				)
			);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}


	public void update(){
		
	}
	
	public void render(Graphics g) {
		
		g.setColor(new Color(1f,0f,0f,.7f));
		
		for(int i = 0; i < manager.gameObjects.size(); i++ ){
			GameObject gameObject = manager.gameObjects.get(i);
			if(gameObject.getObjectId() == ObjectId.Player){
				 g.fillRect(90,39,gameObject.getHealth(),40);     
			}
		}   
		
		g.drawImage(hud, 0, 10,null);
		
	}
		
	
}
