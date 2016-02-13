package Entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import FrameWork.GameObject;
import FrameWork.ObjectId;

public class Reset extends GameObject{
	
	
	public Reset(float x, float y, ObjectId id){
		super(x,y,id);
	}

	
	public void update(LinkedList<GameObject> object){}

	
	
	public void render(Graphics g){

		g.setColor(new Color(161,134,190));
		g.fillRect((int)x,(int)y,32,32);
	}	

	
	public Rectangle getBounds(){
		return new  Rectangle((int)x,(int)y,32,32);
	}



	public void select() {
		// TODO Auto-generated method stub
		
	}	
	
	

}
