package jpr2.main;

import Konkurses.Quiz.Quiz;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

public class MainMenu extends ScreenAdapter {

    private Stage mainMenuStage;

    public int btnWidth = 600;
    public int btnHeight = 80;

    private Table menuTable;
    private TextButton quiz, next, dice, fans, guess, exit, calculateResults, about;

    public TextButton quizQuest;
    public TextButton[] nextQuest = new TextButton[2];
    public TextButton[] diceQuest = new TextButton[2];
    public TextButton[] fansQuest = new TextButton[2];
    public TextButton[] guessQuest = new TextButton[2];
    public TextButton[] results = new TextButton[2];

    public MainMenu(final Main main){

        menuTable = new Table();

        mainMenuStage = new Stage();
        mainMenuStage.addActor(menuTable);
        menuTable.setFillParent(true); //Table is adopting to the stage

        for(int i = 0; i < 2; i++){
            nextQuest[i] = new TextButton("Hi!", main.redStyle);
            diceQuest[i] = new TextButton("", main.redStyle);
            guessQuest[i] = new TextButton("", main.redStyle);
            fansQuest[i] = new TextButton("", main.redStyle);
            results[i] = new TextButton("", main.redStyle);
        }

        quizQuest = new TextButton("Quiz", main.menuButton);

        quiz = new TextButton("Ребус", Main.menuButton);
        next = new TextButton("Далi-Далi", Main.menuButton);
        dice = new TextButton("Ребус", main.menuButton);
        fans = new TextButton("Ребус", main.menuButton);
        guess = new TextButton("Ребус", main.menuButton);
        calculateResults = new TextButton("Ребус", main.menuButton);
        exit = new TextButton("Ребус", main.menuButton);
        about = new TextButton("Ребус", main.menuButton);


        menuTable.add(quiz).padBottom(10).padRight(10).size(btnWidth,btnHeight);
        menuTable.add(nextQuest[0]).padBottom(10).padRight(10).size(100,btnHeight);
        menuTable.add(nextQuest[1]).padBottom(10).padRight(10).size(100, btnHeight);
        menuTable.row().padRight(10);

        menuTable.add(next).padBottom(10).padRight(10).size(btnWidth,btnHeight);
        menuTable.add(nextQuest[0]).padBottom(10).padRight(10).size(100,btnHeight);
        menuTable.add(nextQuest[1]).padBottom(10).padRight(10).size(100, btnHeight);
        menuTable.row().padRight(10);


//        menuTable.add(quiz.padRight(10)).size(btnWidth,btnHeight);
//        menuTable.add(new TextButton("1", main.redStyle)).padBottom(10).padRight(10).size(100,btnHeight);
//        menuTable.add(new TextButton("2", main.redStyle)).padBottom(10).padRight(10).size(100, btnHeight);
//        menuTable.row().padRight(10);
//
//        menuTable.add(next).padRight(10).size(btnWidth,btnHeight);
//        menuTable.add(new TextButton("1", main.redStyle)).padBottom(10).padRight(10).size(100,btnHeight);
//        menuTable.add(new TextButton("2", main.redStyle)).padBottom(10).padRight(10).size(100, btnHeight);
//        menuTable.row().padRight(10);


        quiz.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                main.game.setScreen(new Quiz());
            }
        });

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1,1,1, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        mainMenuStage.draw();
        mainMenuStage.act();

        if(Gdx.input.isKeyJustPressed(Input.Keys.Q)){
            Gdx.app.exit();
        }

    }

    @Override
    public void dispose() {

    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(mainMenuStage); //Установка слушания ввода на menuStage, когда активен этот экран
    }

    @Override
    public void resize(int width, int height) {
        mainMenuStage.getViewport().update(width, height); //updates viewport to current window size
    }

}
