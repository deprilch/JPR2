package FansWordBlocks;

import Konkurses.Quiz.WhoIsTheFirstTeam;
import NextNext.Answer;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import jpr2.main.Main;
import jpr2.main.MainMenu;
import jpr2.main.screenFather;

import java.util.Timer;
import java.util.TimerTask;

public class FansWordBlocks extends screenFather {

    TextButton[] firstTeamBtns = new TextButton[7];
    TextButton[] secondTeamBtns = new TextButton[7];

    String[] firstWords, secondWords = new String[7];

    public static int currentBlock = 1;

    private int correctAnswerFirst;
    private int correctAnswerSecond;

    private int btnHeight = 100;
    private int btnWidth = 400;

    public static int redScore = 0;
    public static int blueScore = 0;

    TextButton teamName1 = new TextButton(WhoIsTheFirstTeam.firstTeamName, Main.redStyle);
    TextButton teamName2 = new TextButton(WhoIsTheFirstTeam.secondTeamName, Main.redStyle);

    TextButton timer = new TextButton("", Main.menuButton);

    Timer timerLeft;
    TimerTask timerTask;
    private int timeLeft = 11;

    public FansWordBlocks(){

        timerLeft = new Timer();

        switch (currentBlock){
            case 1:
                firstWords = Main.firstTeamB1;
                secondWords = Main.secondTeamB1;
                break;
            case 2:
                firstWords = Main.firstTeamB2;
                secondWords = Main.secondTeamB2;
                break;
            case 3:
                firstWords = Main.firstTeamB3;
                secondWords = Main.secondTeamB3;
                break;
        }

        correctAnswerFirst = Integer.parseInt(firstWords[1]) + 1;
        correctAnswerSecond = Integer.parseInt(secondWords[1]) + 1;

        table.add(teamName1).size(btnWidth, btnHeight).padRight(20).padBottom(20);
        table.add(teamName2).size(btnWidth, btnHeight).padBottom(20);
        table.row();

        for (int i = 2; i < 7; i++) {
            firstTeamBtns[i] = new TextButton(firstWords[i], Main.purpleStyle);
            secondTeamBtns[i] = new TextButton(secondWords[i], Main.purpleStyle);
            final int num = i;
            firstTeamBtns[i].addListener(new ChangeListener() {
                @Override
                public void changed(ChangeEvent event, Actor actor) {
                    firstTeamBtns[num].setStyle(Main.redStyle);
                    for (int i = 2; i < 7; i++) {
                        firstTeamBtns[i].setDisabled(true);
                    }
                }
            });
            secondTeamBtns[i].addListener(new ChangeListener() {
                @Override
                public void changed(ChangeEvent event, Actor actor) {
                    secondTeamBtns[num].setStyle(Main.redStyle);
                    for (int i = 2; i < 7; i++) {
                        secondTeamBtns[i].setDisabled(true);
                    }
                }
            });
            table.add(firstTeamBtns[i]).size(btnWidth, btnHeight).padRight(20);
            table.add(secondTeamBtns[i]).size(btnWidth, btnHeight);
            table.row();
        }
        table.add(timer).colspan(2).size(timerSize, timerSize);
        firstTeamBtns[correctAnswerFirst].addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                firstTeamBtns[correctAnswerFirst].setStyle(Main.greenStyle);
                for (int i = 2; i < 7; i++) {
                    firstTeamBtns[i].setDisabled(true);
                }
                redScore++;
            }
        });
        secondTeamBtns[correctAnswerSecond].addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                secondTeamBtns[correctAnswerSecond].setStyle(Main.greenStyle);
                for (int i = 2; i < 7; i++) {
                    secondTeamBtns[i].setDisabled(true);
                }
                blueScore++;
            }
        });

        timerTask = new TimerTask() {
            @Override
            public void run() {
                timeLeft--;
            }
        };

        timer.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                nextBlock();
            }
        });
    }

    public void nextBlock(){
        timerTask.cancel();
        currentBlock++;
        if(currentBlock < 4){
            Main.game.setScreen(new FansWordBlocks());
        }
        else {
            Main.game.setScreen(Main.mainMenu);
        }
    }
    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.draw();  //only draws
        stage.act();   //only acts

        timer.setText(Integer.toString(timeLeft));

        if(Gdx.input.isKeyJustPressed(Input.Keys.M)) {
            Main.game.setScreen(Main.mainMenu);
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.Q)) {
            Gdx.app.exit();
        }

        if(timeLeft <= 0){
            nextBlock();
        }

        setBackground(Main.purpleBackground);
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
        timerLeft.schedule(timerTask, 0, 1000);
        Gdx.input.setInputProcessor(stage);
    }

}
