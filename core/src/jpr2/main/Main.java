package jpr2.main;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class Main extends Game {

	Game game;
	Loader loader;
	Camera camera;
	public static FitViewport viewport;
	MainMenu mainMenu;

	Skin menuSkin;
	BitmapFont font, bigFont;
	TextureAtlas menuAtlas;

	Skin skinPack;

	public static TextButton.TextButtonStyle menuButton = new TextButton.TextButtonStyle();
	public static TextButton.TextButtonStyle greenStyle = new TextButton.TextButtonStyle();
	public static TextButton.TextButtonStyle redStyle = new TextButton.TextButtonStyle();


	@Override
	public void create () {
		camera = new OrthographicCamera();
		viewport = new FitViewport(1600f, 1000f, camera);

		game = this;
		loader = new Loader();

		//menuSkin = loader.setSkin("menuPack.atlas");

		font = loader.setFont(font, 1/20f);
		skinPack = loader.setSkin("buttonsStyles.atlas");

		loader.setButtonStyle(menuButton, Colors.menu, font, skinPack);
		loader.setButtonStyle(greenStyle, Colors.green, font, skinPack);
		loader.setButtonStyle(redStyle, Colors.red, font, skinPack);

		camera = new OrthographicCamera();
		viewport = new FitViewport(1600f, 1000f, camera);
		//camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

		mainMenu = new MainMenu(this);
		game.setScreen(mainMenu);

	}
	
	@Override
	public void dispose () {

	}

	public TextButton.TextButtonStyle getRedStyle() {
		System.out.println(font);
		return redStyle;
	}
}
