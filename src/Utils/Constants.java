package Utils;

public class Constants {
	
	//overall game
	public static final int GAME_WINDOW_WIDTH = 1000;
	public static final int GAME_WINDOW_HEIGHT = 600;
	public static final String GAME_NAME = "POAGAME";
	public static final int GAME_WORLD_OFFSET = 300;


	//Player
	public static final int PLAYER_RECTANGLE_WIDTH = 100;
	public static final int PLAYER_RECTANGLE_HEIGHT = 100;
	public static final int PLAYER_HEALTH = 262;
	public static int health = 262;
	public static final float PLAYER_GRAVITY_ACCELERATION = 0.5f;
	public static final float PLAYER_MOVEMENT_SPEDD = 10;
	public static final float PLAYER_JUMP_HIGHT = 10;
	public static final float PLAYER_MAX_SPEED = 10;
	public static final String PLAYER_IDLE_SPRITES = "/Player/SriteSheetTirunt.png";
	public static final String PLAYER_RUNNING_SPRITES  = "/Player/Running.png";
	

	// Thread 
	public static final double AMOUNT_OF_TICKS = 60.0f;
	public static final double NANO_SECONDS = 1000000000 / AMOUNT_OF_TICKS;

	//Render
	public static final int BUFFER_STRATEGY = 3;
	
	//Audio
	public static final String GAME_LEVEL_1_AUDIO = "/Music/prueba.mp3";
	
	//level's
	public static Boolean PAUSE = false;
	public static int LEVELS = 1;
	public static final int NUMBER_GAME_STATES = 2;
	public static final int MENU_STATE = 0;
	public static final int LEVELS_STATE = 1;
	public static final String GAME_MENU_BACKGROUND = "/World/Menu.png";
	public static final String GAME_LEVEL_1_SKY = "/World/Level-1-Sky.png";
	public static final String BLOCK_1  = "/World/tileset.png";
	public static final String GAME_LEVEL_1_IMAGE = "/World/level-1.png";
	public static final String GAME_MENU_SCREEN = "/World/MenuScreen.png";
	public static final String GAME_LEVEL_1_TREES = "/World/lvl1.png";
	public static final String GAME_HUD = "/HUD/hud-prototype.png";
}


