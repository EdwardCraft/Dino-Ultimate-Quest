package Entities;
import FrameWork.GameObject;
import FrameWork.ObjectId;
import java.util.LinkedList;

import Classes.Game;
import Classes.Texture;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Color;

public class Block extends GameObject {

	private int blockType;
	Texture texture;
	
	public Block(float x, float y, int blockType, ObjectId id){
		super(x, y, id);
		this.blockType = blockType;
		texture = Game.getTexture();
	}

	public void update(LinkedList<GameObject> object){

	}
	
	public void render(Graphics g){
		if(blockType == 0){
			g.drawImage(texture.block[0],(int)x,(int)y,null);
		}else if(blockType == 1){
			g.drawImage(texture.block[1],(int)x,(int)y,null);
		}
	}

	public Rectangle getBounds(){
		return new Rectangle((int)x, (int)y, 32, 32);
	}


	public void select() {
		// TODO Auto-generated method stub
		
	}

}