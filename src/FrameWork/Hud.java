package FrameWork;

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
		
		g.drawImage(hud, 0, 10,null);
		
	}
	
	
	
}
