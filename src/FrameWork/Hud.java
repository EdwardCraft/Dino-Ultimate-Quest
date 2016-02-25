package FrameWork;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import Entities.Player;
import Utils.Constants;

public class Hud {
	private Player player;
	private BufferedImage hud;
	
	public Hud(){
		//this.player = player;
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



	public void render(Graphics g) {
		
		g.drawImage(hud, 0, 10,null);
		
	}
	
	
	
}
