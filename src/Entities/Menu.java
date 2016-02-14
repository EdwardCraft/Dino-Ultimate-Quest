package Entities;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import Classes.Game;
import Classes.Texture;
import FrameWork.GameObject;
import FrameWork.ObjectId;
import Utils.Constants;


public class Menu extends GameObject{
	
	Texture texture;
	Manager manager;

	private Font font; 
		
	
	public Menu(float x, float y,Manager manager, ObjectId id) {
		super(x, y, id);
		this.manager = manager;
		texture = Game.getTexture();
		
		try{
			font = new Font("Arial", Font.PLAIN, 30);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
	}


	public void update(LinkedList<GameObject> object) {

		
	}


	public void render(Graphics g) {
		g.drawImage(texture.menuBackground[0], 0, 0, Constants.GAME_WINDOW_WIDTH + 10, Constants.GAME_WINDOW_HEIGHT + 10, null);
		
		g.setFont(font);
		for(int i = 0; i < options.length; i++) {
			if(i == currentChoice) {
				g.setColor(Color.BLACK);
			}
			else {
				g.setColor(Color.RED);
			}
			g.drawString(options[i], 500, 300 + i * 40);
		}
		
	}
	
	
	public void select(){
		if(currentChoice == 0){
			manager.setState(Constants.LEVELS);
		}else if(currentChoice == 1){
			
		}else if(currentChoice == 2){
			System.exit(0);
		}
		
	}
		
	

	public Rectangle getBounds() {

		return null;
	}




	
	
	
}
