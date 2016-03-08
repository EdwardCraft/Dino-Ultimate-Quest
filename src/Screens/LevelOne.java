package Screens;

import java.awt.Graphics;

import Classes.Game;
import Utils.Texture;

public class LevelOne {

	private Texture texture;
	
	
	public LevelOne(){
		this.texture = Game.getTexture();
	}
	
	
	
	public void update(){
		
		
		
	}
	
	
	
	
	public void render(Graphics g){
		
		for(int i = 0; i < texture.Backgrounds[1].getWidth() * 10; i +=texture.Backgrounds[1].getWidth())
			g.drawImage(texture.Backgrounds[1], i, 50,null); 
		
	}

	
	
}
