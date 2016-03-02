package Entities;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Color;
import java.util.LinkedList;

import FrameWork.GameObject;
import FrameWork.ObjectId;


public class Flag extends GameObject{

	public Flag(float x, float y, ObjectId id){
		super(x,y,id);
		System.out.println("hola");
	}

	public void update(LinkedList<GameObject> object) {
		
	}

	public void render(Graphics g){
		g.setColor(Color.yellow);
		g.fillRect((int)x,(int)y,32,32);
	}

	public Rectangle getBounds(){
		return new Rectangle((int)x,(int)y,32,32);
	}


	public void select() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Rectangle getBoundsTop() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Rectangle getBoundsRight() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Rectangle getBoundsLeft() {
		// TODO Auto-generated method stub
		return null;
	}


}