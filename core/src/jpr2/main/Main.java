package jpr2.main;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.utils.viewport.FitViewport;

import java.util.Arrays;

public class Main extends Game {

	public static Game game;
	Loader loader;
	Camera camera;
	public static FitViewport viewport;
	public static MainMenu mainMenu;

	Skin menuSkin;
	public BitmapFont font, bigFont;
	TextureAtlas menuAtlas;

	Skin skinPack;
	Skin blackDices;

	public static boolean[] displayDices = new boolean[6];
	public static boolean[] displayFirst = new boolean[5];
	public static boolean[] displaySecond = new boolean[5];
	public static boolean[] displayThird = new boolean[5];
	public static boolean[] displayFourth = new boolean[5];
	public static boolean[] displayFifth = new boolean[5];
	public static boolean[] displaySix = new boolean[5];

	public static TextButton.TextButtonStyle menuButton = new TextButton.TextButtonStyle();
	public static TextButton.TextButtonStyle greenStyle = new TextButton.TextButtonStyle();
	public static TextButton.TextButtonStyle redStyle = new TextButton.TextButtonStyle();
	public static TextButton.TextButtonStyle yellowStyle = new TextButton.TextButtonStyle();
	public static TextButton.TextButtonStyle purpleStyle = new TextButton.TextButtonStyle();
	public static TextButton.TextButtonStyle blueStyle = new TextButton.TextButtonStyle();
	public static TextButton.TextButtonStyle wrongStyle = new TextButton.TextButtonStyle();
	public static TextButton.TextButtonStyle greyStyle = new TextButton.TextButtonStyle();

	public static TextButton.TextButtonStyle oneBlack = new TextButton.TextButtonStyle();
	public static TextButton.TextButtonStyle twoBlack = new TextButton.TextButtonStyle();
	public static TextButton.TextButtonStyle threeBlack = new TextButton.TextButtonStyle();
	public static TextButton.TextButtonStyle fourBlack = new TextButton.TextButtonStyle();
	public static TextButton.TextButtonStyle fiveBlack = new TextButton.TextButtonStyle();
	public static TextButton.TextButtonStyle sixBlack = new TextButton.TextButtonStyle();

	public static Drawable redBackground, blueBackground, greenBackground, yellowBackground, orangeBackground, purpleBackground;

	public static String[] nextQuestions, nextAnswers;
	public static String[] cubeQuestions1, cubeQuestions2, cubeQuestions3, cubeQuestions4, cubeQuestions5, cubeQuestions6;
	public static String[] cubeAnswers1, cubeAnswers2, cubeAnswers3, cubeAnswers4, cubeAnswers5, cubeAnswers6;
	public static String[] fieldQuestions, fieldAnswers;

	//FansWordBlocks data
	public static String[] firstTeamB1, firstTeamB2, firstTeamB3, secondTeamB1, secondTeamB2, secondTeamB3;

	public static TextField.TextFieldStyle redTextFieldStyle = new TextField.TextFieldStyle();
	public static TextField.TextFieldStyle greenTextFieldStyle = new TextField.TextFieldStyle();

	@Override
	public void create () {

		Arrays.fill(displayFirst, true);
		Arrays.fill(displaySecond, true);
		Arrays.fill(displayThird, true);
		Arrays.fill(displayFourth, true);
		Arrays.fill(displayFifth, true);
		Arrays.fill(displaySix, true);
		Arrays.fill(displayDices, true);

		camera = new OrthographicCamera();
		viewport = new FitViewport(1600f, 1000f, camera);

		game = this;
		loader = new Loader();

		font = loader.setFont(font, 1/14f);
		skinPack = loader.setSkin("Styles/styles.atlas");
		blackDices = loader.setSkin("Styles/blackDices.atlas");

		loader.setButtonStyle(menuButton, Colors.menu, font, skinPack);
		loader.setButtonStyle(greenStyle, Colors.green, font, skinPack);
		loader.setButtonStyle(redStyle, Colors.red, font, skinPack);
		loader.setButtonStyle(yellowStyle, Colors.yellow, font, skinPack);
		loader.setButtonStyle(purpleStyle, Colors.purple, font, skinPack);
		loader.setButtonStyle(blueStyle, Colors.blue, font, skinPack);
		loader.setButtonStyle(wrongStyle, Colors.wrong, font, skinPack);
		loader.setButtonStyle(greyStyle, Colors.grey, font, skinPack);
		loader.setFieldStyle(redTextFieldStyle, Colors.red, font, skinPack);
		loader.setFieldStyle(greenTextFieldStyle, Colors.green, font, skinPack);

		loader.setButtonStyle(oneBlack, Colors.oneBlack, font, blackDices);
		loader.setButtonStyle(twoBlack, Colors.twoBlack, font, blackDices);
		loader.setButtonStyle(threeBlack, Colors.threeBlack, font, blackDices);
		loader.setButtonStyle(fourBlack, Colors.fourBlack, font, blackDices);
		loader.setButtonStyle(fiveBlack, Colors.fiveBlack, font, blackDices);
		loader.setButtonStyle(sixBlack, Colors.sixBlack, font, blackDices);

		redBackground = loader.createBackground(redBackground, skinPack, "redStyle");
		blueBackground = loader.createBackground(blueBackground, skinPack, "blueStyle");
		greenBackground = loader.createBackground(greenBackground, skinPack, "greenStyle");
		yellowBackground = loader.createBackground(yellowBackground, skinPack, "yellowStyle");
		orangeBackground = loader.createBackground(orangeBackground, skinPack, "orangeStyle");
		purpleBackground = loader.createBackground(purpleBackground, skinPack, "purpleStyle");

		nextQuestions = loader.loadText("NextNext/nextQuestions.txt");
		nextAnswers = loader.loadText("NextNext/nextAnswers.txt");

		cubeQuestions1 = loader.loadText("Cubes/cubesQuestions1.txt");
		cubeQuestions2 = loader.loadText("Cubes/cubesQuestions2.txt");
		cubeQuestions3 = loader.loadText("Cubes/cubesQuestions3.txt");
		cubeQuestions4 = loader.loadText("Cubes/cubesQuestions4.txt");
		cubeQuestions5 = loader.loadText("Cubes/cubesQuestions5.txt");
		cubeQuestions6 = loader.loadText("Cubes/cubesQuestions6.txt");

		cubeAnswers1 = loader.loadText("Cubes/cubesAnswers1.txt");
		cubeAnswers2 = loader.loadText("Cubes/cubesAnswers2.txt");
		cubeAnswers3 = loader.loadText("Cubes/cubesAnswers3.txt");
		cubeAnswers4 = loader.loadText("Cubes/cubesAnswers4.txt");
		cubeAnswers5 = loader.loadText("Cubes/cubesAnswers5.txt");
		cubeAnswers6 = loader.loadText("Cubes/cubesAnswers6.txt");

		fieldQuestions = loader.loadText("Field/fieldQuestions.txt");
		fieldAnswers = loader.loadText("Field/fieldAnswers.txt");

		firstTeamB1 = loader.loadText("FansWordBlocks/firstTeam/firstBlock.txt");
		firstTeamB2 = loader.loadText("FansWordBlocks/firstTeam/secondBlock.txt");
		firstTeamB3 = loader.loadText("FansWordBlocks/firstTeam/thirdBlock.txt");

		secondTeamB1 = loader.loadText("FansWordBlocks/secondTeam/firstBlock.txt");
		secondTeamB2 = loader.loadText("FansWordBlocks/secondTeam/secondBlock.txt");
		secondTeamB3 = loader.loadText("FansWordBlocks/secondTeam/thirdBlock.txt");


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
