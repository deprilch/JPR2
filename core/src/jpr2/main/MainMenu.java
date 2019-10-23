package jpr2.main;

import BlackBox.BlackBox;
import BlackBox.BlackBoxQuestion;
import Cubes.Cubes;
import FansWord.FansWord;
import FansWordBlocks.FansWordBlocks;
import Field.Field;
import Field.FieldIntro;
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
    private TextButton quiz, next, dice, fansWord, fansWordBlock, field, blackbox, exit, calculateResults, about;

    public TextButton quizQuest;
    public TextButton[] quizNames = new TextButton[2];
    public TextButton[] nextQuest = new TextButton[2];
    public TextButton[] diceQuest = new TextButton[2];
    public TextButton[] fansWordQuest = new TextButton[2];
    public TextButton[] fansWordBlocks = new TextButton[2];
    public TextButton[] fieldQuest = new TextButton[2];
    public TextButton[] blackboxQuest = new TextButton[2];
    public TextButton[] results = new TextButton[2];

    int red, blue;

    public MainMenu(){
        menuTable = new Table();

        mainMenuStage = new Stage();
        mainMenuStage.addActor(menuTable);
        menuTable.setFillParent(true); //Table is adopting to the stage

        for(int i = 0; i < 2; i++){
            quizNames[i] = new TextButton("", Main.redStyle);
            nextQuest[i] = new TextButton("Hi!", Main.redStyle);
            diceQuest[i] = new TextButton("", Main.redStyle);
            fieldQuest[i] = new TextButton("", Main.redStyle);
            blackboxQuest[i] = new TextButton("", Main.redStyle);
            fansWordQuest[i] = new TextButton("", Main.redStyle);
            results[i] = new TextButton("", Main.redStyle);
            fansWordBlocks[i] = new TextButton("", Main.redStyle);
        }

        quizQuest = new TextButton("Quiz", Main.menuButton);

        quiz = new TextButton("Ребус", Main.menuButton);
        next = new TextButton("Далi-Далi", Main.menuButton);
        dice = new TextButton("Ти - менi, я - тобi", Main.menuButton);
        fansWord = new TextButton("Склади слово", Main.menuButton);
        fansWordBlock = new TextButton("Знайди зайве", Main.menuButton);
        field = new TextButton("Зорянi перегони", Main.menuButton);
        blackbox = new TextButton("Впiзнай мене", Main.menuButton);
        calculateResults = new TextButton("Результати", Main.menuButton);
        exit = new TextButton("Вийти", Main.menuButton);
        about = new TextButton("Ребус", Main.menuButton);


        menuTable.add(quiz).padBottom(10).padRight(10).size(btnWidth, btnHeight);
        menuTable.add(quizNames[0]).padBottom(10).padRight(10).size(300, btnHeight);
        menuTable.add(quizNames[1]).padBottom(10).padRight(10).size(300, btnHeight);
        menuTable.row().padRight(10);
        menuTable.add(next).padBottom(10).padRight(10).size(btnWidth,btnHeight);
        menuTable.add(nextQuest[0]).padBottom(10).padRight(10).size(300, btnHeight);
        menuTable.add(nextQuest[1]).padBottom(10).padRight(10).size(300, btnHeight);
        menuTable.row().padRight(10);
        menuTable.add(dice).padBottom(10).padRight(10).size(btnWidth,btnHeight);
        menuTable.add(diceQuest[0]).padBottom(10).padRight(10).size(300, btnHeight);
        menuTable.add(diceQuest[1]).padBottom(10).padRight(10).size(300, btnHeight);
        menuTable.row().padRight(10);
        menuTable.add(fansWord).padBottom(10).padRight(10).size(btnWidth, btnHeight);
        menuTable.add(fansWordQuest[0]).padBottom(10).padRight(10).size(300, btnHeight);
        menuTable.add(fansWordQuest[1]).padBottom(10).padRight(10).size(300, btnHeight);
        menuTable.row();
        menuTable.add(fansWordBlock).padBottom(10).padRight(10).size(btnWidth, btnHeight);
        menuTable.add(fansWordBlocks[0]).padBottom(10).padRight(10).size(300, btnHeight);
        menuTable.add(fansWordBlocks[1]).padBottom(10).padRight(10).size(300, btnHeight);
        menuTable.row();
        menuTable.add(field).padBottom(10).padRight(10).size(btnWidth,btnHeight);
        menuTable.add(fieldQuest[0]).padBottom(10).padRight(10).size(300, btnHeight);
        menuTable.add(fieldQuest[1]).padBottom(10).padRight(10).size(300, btnHeight);
        menuTable.row();
        menuTable.add(blackbox).padBottom(10).padRight(10).size(btnWidth, btnHeight);
        menuTable.add(blackboxQuest[0]).padBottom(10).padRight(10).size(300, btnHeight);
        menuTable.add(blackboxQuest[1]).padBottom(10).padRight(10).size(300, btnHeight);
        menuTable.row();
        menuTable.add(calculateResults).padBottom(10).padRight(10).size(btnWidth, btnHeight);
        menuTable.add(results[0]).padBottom(10).padRight(10).size(300, btnHeight);
        menuTable.add(results[1]).padBottom(10).padRight(10).size(300, btnHeight);
        menuTable.row();
        menuTable.add(exit).colspan(3).size(btnWidth, btnHeight).center();

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
        field.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                Field.freshStart = true;
                Main.game.setScreen(new FieldIntro());
            }
        });
        blackbox.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                blackBoxClearData();
                Main.game.setScreen(new BlackBox());
            }
        });
        fansWord.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                Main.game.setScreen(new FansWord());
            }
        });
        fansWordBlock.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                FansWordBlocks.currentBlock = 1;
                FansWordBlocks.redScore = 0;
                FansWordBlocks.blueScore = 0;
                Main.game.setScreen(new FansWordBlocks());
            }
        });
        exit.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                Gdx.app.exit();
            }
        });

        calculateResults.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                red = 0;
                blue = 0;

                red+= Integer.parseInt(nextQuest[0].getText().toString());
                red+= Integer.parseInt(blackboxQuest[0].getText().toString());
                red+= Integer.parseInt(fieldQuest[0].getText().toString());
                red+= Integer.parseInt(fansWordQuest[0].getText().toString());
                red+= Integer.parseInt(diceQuest[0].getText().toString());
                red+= Integer.parseInt(fansWordBlocks[0].getText().toString());

                blue+= Integer.parseInt(nextQuest[1].getText().toString());
                blue+= Integer.parseInt(blackboxQuest[1].getText().toString());
                blue+= Integer.parseInt(fieldQuest[1].getText().toString());
                blue+= Integer.parseInt(fansWordQuest[1].getText().toString());
                blue+= Integer.parseInt(diceQuest[1].getText().toString());
                blue+= Integer.parseInt(fansWordBlocks[1].getText().toString());
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

        fieldQuest[0].setText(Integer.toString(Field.redScore));
        fieldQuest[1].setText(Integer.toString(Field.blueScore));

        fansWordQuest[0].setText(Integer.toString(FansWord.redScore));
        fansWordQuest[1].setText(Integer.toString(FansWord.blueScore));

        fansWordBlocks[0].setText(Integer.toString(FansWordBlocks.redScore));
        fansWordBlocks[1].setText(Integer.toString(FansWordBlocks.blueScore));

        blackboxQuest[0].setText(Integer.toString(BlackBox.redScore));
        blackboxQuest[1].setText(Integer.toString(BlackBox.blueScore));

        results[0].setText(Integer.toString(red));
        results[1].setText(Integer.toString(blue));

        if(Gdx.input.isKeyJustPressed(Input.Keys.Q)){
            Gdx.app.exit();
        }
    }

    public void blackBoxClearData(){
        for(int i = 0; i < 10; i++){
            BlackBoxQuestion.redScore[i] = 0;
            BlackBoxQuestion.blueScore[i] = 0;
        }
        BlackBox.currentQuestion = 1;
        BlackBox.currentAnswer = 1;
        BlackBox.redScore = 0;
        BlackBox.blueScore = 0;
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
