package FrameWork;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import Entities.Manager;
import Entities.Player;
import Utils.Constants;

public class Hud {
	private Player player;
	private BufferedImage hud;
	private int health;
	public Hud(){

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
		health = 0;
		
	}


	public void update(){
		
	}
	
	public void render(Graphics g) {
		
		g.setColor(new Color(249,99, 127));
        g.fillRect(90,39,health,40);     
		g.drawImage(hud, 0, 10,null);
	}
	
	public void setHelth(int health){
		this.health = health;
	}
	
	
}
