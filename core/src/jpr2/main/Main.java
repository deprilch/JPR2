package jpr2.main;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class Main extends Game {

	public static Game game;
	Loader loader;
	Camera camera;
	public static FitViewport viewport;
	public static MainMenu mainMenu;

	Skin menuSkin;
	BitmapFont font, bigFont;
	TextureAtlas menuAtlas;

	Skin skinPack;

	public static TextButton.TextButtonStyle menuButton = new TextButton.TextButtonStyle();
	public static TextButton.TextButtonStyle greenStyle = new TextButton.TextButtonStyle();
	public static TextButton.TextButtonStyle redStyle = new TextButton.TextButtonStyle();
	public static TextButton.TextButtonStyle yellowStyle = new TextButton.TextButtonStyle();
	public static TextButton.TextButtonStyle purpleStyle = new TextButton.TextButtonStyle();
	public static TextButton.TextButtonStyle blueStyle = new TextButton.TextButtonStyle();


	public static String[] nextQuestions, nextAnswers;



	public static TextField.TextFieldStyle redTextFieldStyle = new TextField.TextFieldStyle();


	@Override
	public void create () {
		camera = new OrthographicCamera();
		viewport = new FitViewport(1600f, 1000f, camera);

		game = this;
		loader = new Loader();

		//menuSkin = loader.setSkin("menuPack.atlas");

		font = loader.setFont(font, 1/12f);
		skinPack = loader.setSkin("Styles/styles.atlas");

		loader.setButtonStyle(menuButton, Colors.menu, font, skinPack);
		loader.setButtonStyle(greenStyle, Colors.green, font, skinPack);
		loader.setButtonStyle(redStyle, Colors.red, font, skinPack);
		loader.setButtonStyle(yellowStyle, Colors.yellow, font, skinPack);
		loader.setButtonStyle(purpleStyle, Colors.purple, font, skinPack);
		loader.setButtonStyle(blueStyle, Colors.blue, font, skinPack);
		loader.setButtonStyle(redTextFieldStyle, Colors.red, font, skinPack);

		nextQuestions = loader.loadText("NextNext/nextQuestions.txt");
		nextAnswers = loader.loadText("NextNext/nextAnswers.txt");

		camera = new OrthographicCamera();
		viewport = new FitViewport(1600f, 1000f, camera);
		//camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

		mainMenu = new MainMenu();
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
