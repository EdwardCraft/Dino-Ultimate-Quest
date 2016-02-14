package Classes;

import java.awt.image.BufferedImage;
import java.util.concurrent.locks.AbstractQueuedLongSynchronizer.ConditionObject;

import Utils.BufferedImageLoader;
import Utils.Constants;

public class Texture{

	SpriteSheet blockSprite,playerSpriteIdle,palyerMovingSprite,levelSprite, MenuSprite;
	BufferedImageLoader imageloader;
	
	private BufferedImage blockSheet   = null;
	private BufferedImage playerIdleSheet  = null;
	private BufferedImage palyerRunnigSheet  = null;
	private BufferedImage levelSheet = null;
	private BufferedImage MenuSheet = null; 
	public  BufferedImage Level1Game = null;
	
	public BufferedImage[] block   =  new BufferedImage[3];
	public BufferedImage[] player  =  new BufferedImage[17];
	public BufferedImage[] runnigS =  new BufferedImage[22];
	public BufferedImage[] levels = new BufferedImage[3];
	public BufferedImage[] levelBarckground = new BufferedImage[3];
	public BufferedImage[] SkyBackground = new BufferedImage[3];
	public BufferedImage[] Menu = new BufferedImage[3];
	public BufferedImage[] menuBackground = new BufferedImage[1];
	
	public Texture(){

		imageloader = new BufferedImageLoader();
		
		try{
			
			blockSheet  = imageloader.loadImage(Constants.BLOCK_1);
			playerIdleSheet = imageloader.loadImage(Constants.PLAYER_IDLE_SPRITES);
			palyerRunnigSheet = imageloader.loadImage(Constants.PLAYER_RUNNING_SPRITES);

			SkyBackground[0] = imageloader.loadImage(Constants.GAME_LEVEL_1_SKY);
			MenuSheet = imageloader.loadImage(Constants.GAME_MENU_SCREEN);
			menuBackground[0] = imageloader.loadImage(Constants.GAME_MENU_BACKGROUND);
			Level1Game = imageloader.loadImage(Constants.GAME_LEVEL_1_IMAGE);
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		levelSprite = new SpriteSheet(levelSheet);
		blockSprite = new SpriteSheet(blockSheet);
		playerSpriteIdle = new SpriteSheet(playerIdleSheet);
		palyerMovingSprite = new SpriteSheet(palyerRunnigSheet);
		MenuSprite = new SpriteSheet(MenuSheet);
		getTextures();

	}
	
	
	private void getTextures(){	
		
		Menu[0] =  MenuSprite.grabImage(1, 1, 1, 1);
			
		block[0]   = blockSprite.grabImage(1,2,32,32);//dirt block
		block[1]   = blockSprite.grabImage(2,2,32,32);// grass


		player[0]  = playerSpriteIdle.grabImage(1,1,100,100);// idle frame for player
		player[1]  = playerSpriteIdle.grabImage(2,1,100,100);// idle frame for player
		player[2]  = playerSpriteIdle.grabImage(3,1,100,100);// idle frame for player
		player[3]  = playerSpriteIdle.grabImage(4,1,100,100);// idle frame for player
		player[4]  = playerSpriteIdle.grabImage(5,1,100,100);// idle frame for player
		player[5]  = playerSpriteIdle.grabImage(6,1,100,100);// idle frame for player
		player[6]  = playerSpriteIdle.grabImage(7,1,100,100);// idle frame for player
		player[7]  = playerSpriteIdle.grabImage(8,1,100,100);// idle frame for player

		player[8]  = playerSpriteIdle.grabImage(1,2,100,100);// jump
		player[9]  = playerSpriteIdle.grabImage(2,2,100,100);// fall

		runnigS[0] = palyerMovingSprite.grabImage(1,1,105,100);//runnihg
		runnigS[1] = palyerMovingSprite.grabImage(2,1,106,100);//runnihg
		runnigS[2] = palyerMovingSprite.grabImage(3,1,106,100);//runnihg
		runnigS[3] = palyerMovingSprite.grabImage(4,1,106,100);//runnihg
		runnigS[4] = palyerMovingSprite.grabImage(5,1,106,100);//runnihg
		runnigS[5] = palyerMovingSprite.grabImage(6,1,106,100);//runnihg
		runnigS[6] = palyerMovingSprite.grabImage(7,1,106,100);//runnihg

		runnigS[7] = palyerMovingSprite.grabImage(1,2,105,100);//runnihg
		runnigS[8] = palyerMovingSprite.grabImage(2,2,106,100);//runnihg
		runnigS[9] = palyerMovingSprite.grabImage(3,2,106,100);//runnihg
		runnigS[10] = palyerMovingSprite.grabImage(4,2,106,100);//runnihg
		runnigS[11] = palyerMovingSprite.grabImage(5,2,106,100);//runnihg
		runnigS[12] = palyerMovingSprite.grabImage(6,2,106,100);//runnihg
		runnigS[13] = palyerMovingSprite.grabImage(7,2,106,100);//runnihg

		runnigS[14] = palyerMovingSprite.grabImage(1,3,105,100);//runnihg
		runnigS[15] = palyerMovingSprite.grabImage(2,3,106,100);//runnihg
		runnigS[16] = palyerMovingSprite.grabImage(3,3,106,100);//runnihg
		runnigS[17] = palyerMovingSprite.grabImage(4,3,106,100);//runnihg
		runnigS[18] = palyerMovingSprite.grabImage(5,3,106,100);//runnihg
		runnigS[19] = palyerMovingSprite.grabImage(6,3,106,100);//runnihg
		runnigS[20] = palyerMovingSprite.grabImage(7,3,106,100);//runnihg




	}
	
	public BufferedImage[] getLevelBarckground() {
		return levelBarckground;
	}



	public void setLevelBarckground(BufferedImage[] levelBarckground) {
		this.levelBarckground = levelBarckground;
	}
	

}