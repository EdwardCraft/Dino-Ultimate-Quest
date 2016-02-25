package Entities;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import Classes.Game;
import Classes.Texture;
import FrameWork.GameObject;
import FrameWork.Hud;
import FrameWork.ObjectId;


public class LevelOne extends GameObject{
	private Texture texture;
	public LevelOne(float x, float y, ObjectId id) {
		super(x, y, id);
		texture = Game.getTexture();
	}


	public void update(LinkedList<GameObject> object) {
		// TODO Auto-generated method stub
		
	}


	public void render(Graphics g) {
		for(int i = 0; i < texture.SkyBackground[1].getWidth() * 4 ; i += texture.SkyBackground[1].getWidth()){
			g.drawImage(texture.SkyBackground[1], i, 0, null);
		}		
	}


	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return null;
	}


	public void select() {
		// TODO Auto-generated method stub
		
	}
	


}
