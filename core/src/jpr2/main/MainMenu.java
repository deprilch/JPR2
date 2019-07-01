package jpr2.main;

import Cubes.Cubes;
import Konkurses.Quiz.Quiz;
import Konkurses.Quiz.WhoIsTheFirstTeam;
import NextNext.Next;
import NextNext.Question;
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
    public TextButton[] quizNames = new TextButton[2];
    public TextButton[] nextQuest = new TextButton[2];
    public TextButton[] diceQuest = new TextButton[2];
    public TextButton[] fansQuest = new TextButton[2];
    public TextButton[] guessQuest = new TextButton[2];
    public TextButton[] results = new TextButton[2];

    public MainMenu(){
        menuTable = new Table();

        mainMenuStage = new Stage();
        mainMenuStage.addActor(menuTable);
        menuTable.setFillParent(true); //Table is adopting to the stage

        for(int i = 0; i < 2; i++){
            quizNames[i] = new TextButton("", Main.redStyle);
            nextQuest[i] = new TextButton("Hi!", Main.redStyle);
            diceQuest[i] = new TextButton("", Main.redStyle);
            guessQuest[i] = new TextButton("", Main.redStyle);
            fansQuest[i] = new TextButton("", Main.redStyle);
            results[i] = new TextButton("", Main.redStyle);
        }

        quizQuest = new TextButton("Quiz", Main.menuButton);

        quiz = new TextButton("Ребус", Main.menuButton);
        next = new TextButton("Далi-Далi", Main.menuButton);
        dice = new TextButton("Ти - менi, я - тобi", Main.menuButton);
        fans = new TextButton("Ребус", Main.menuButton);
        guess = new TextButton("Ребус", Main.menuButton);
        calculateResults = new TextButton("Ребус", Main.menuButton);
        exit = new TextButton("Ребус", Main.menuButton);
        about = new TextButton("Ребус", Main.menuButton);


        menuTable.add(quiz).padBottom(10).padRight(10).size(btnWidth,btnHeight);
        menuTable.add(quizNames[0]).padBottom(10).padRight(10).size(300,btnHeight);
        menuTable.add(quizNames[1]).padBottom(10).padRight(10).size(300, btnHeight);
        menuTable.row().padRight(10);
        menuTable.add(next).padBottom(10).padRight(10).size(btnWidth,btnHeight);
        menuTable.add(nextQuest[0]).padBottom(10).padRight(10).size(300,btnHeight);
        menuTable.add(nextQuest[1]).padBottom(10).padRight(10).size(300, btnHeight);
        menuTable.row().padRight(10);
        menuTable.add(dice).padBottom(10).padRight(10).size(btnWidth,btnHeight);
        menuTable.add(diceQuest[0]).padBottom(10).padRight(10).size(300,btnHeight);
        menuTable.add(diceQuest[1]).padBottom(10).padRight(10).size(300, btnHeight);
        menuTable.row().padRight(10);

        quiz.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                Main.game.setScreen(new Quiz());
            }
        });
        next.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                nextQuestClearData();
                Main.game.setScreen(new Next());
            }
        });
        dice.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                Main.game.setScreen(new Cubes());
            }
        });

    }

    public void nextQuestClearData(){
        Next.redScore = 0;
        Next.blueScore = 0;
        Next.currentQuestion = 1;
        Next.currentAnswer = 1;
        Next.redCurrent = true;
        Question.buttonIds = 0;
        for(int i = 0; i < 42; i++){
            Question.green[i] = false;
            Question.wrong[i] = false;
        }
        Next.start.setStyle(Main.redStyle);
        Question.NextbtnStyle = Main.redStyle;
    }

    public void setBackground(){
        menuTable.setBackground(Main.purpleBackground);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1,1,1, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        setBackground();

        mainMenuStage.draw();
        mainMenuStage.act();

        quizNames[0].setText(WhoIsTheFirstTeam.firstTeamName);
        quizNames[1].setText(WhoIsTheFirstTeam.secondTeamName);

        nextQuest[0].setText(Integer.toString(Next.redScore));
        nextQuest[1].setText(Integer.toString(Next.blueScore));

        diceQuest[0].setText(Integer.toString(Cubes.redScore));
        diceQuest[1].setText(Integer.toString(Cubes.blueScore));

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
