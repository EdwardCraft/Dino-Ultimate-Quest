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
	
	private BufferedImage hud;
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
		
	}


	public void update(){
		
	}
	
	public void render(Graphics g) {
		
		g.setColor(new Color(1f,0f,0f,.7f));
        g.fillRect(90,39,Constants.health,40);     
		g.drawImage(hud, 0, 10,null);
	}
		
	
}
