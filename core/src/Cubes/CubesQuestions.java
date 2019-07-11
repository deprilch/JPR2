package Cubes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import jpr2.main.Main;
import jpr2.main.screenFather;
import sun.awt.image.GifImageDecoder;

import java.util.Timer;
import java.util.TimerTask;

public class CubesQuestions extends screenFather {
    int nubmerHeight = 100;
    int nubmerWidth = 100;
    int questionWidth = 1000;
    int QuestionHeight = 100;

    TextButton one = new TextButton("1", Main.redStyle);
    TextButton two = new TextButton("2", Main.redStyle);
    TextButton three = new TextButton("3", Main.redStyle);
    TextButton four = new TextButton("4", Main.redStyle);
    TextButton five = new TextButton("5", Main.redStyle);

    TextButton firstQuestion = new TextButton("Натиснить щоб відкрити питання", Main.redStyle);
    TextButton secondQuestion = new TextButton("Натиснить щоб відкрити питання", Main.redStyle);
    TextButton thirdQuestion = new TextButton("Натиснить щоб відкрити питання", Main.redStyle);
    TextButton fourthQuestion = new TextButton("Натиснить щоб відкрити питання", Main.redStyle);
    TextButton fifthQuestion = new TextButton("Натиснить щоб відкрити питання", Main.redStyle);

    TextButton firstValue = new TextButton("1", Main.redStyle);
    TextButton secondValue = new TextButton("1", Main.redStyle);
    TextButton thirdValue = new TextButton("2", Main.redStyle);
    TextButton fouthValue = new TextButton("2", Main.redStyle);
    TextButton fifthValue = new TextButton("3", Main.redStyle);

    Timer timerLeft;
    TimerTask timerTask;
    public int timeConst = 11;

    TextButton timer = new TextButton("", Main.menuButton);

    public String[] questions;

    int block;
    public static int questionCounter = 0;

    public CubesQuestions(int questionBlock){
        block = questionBlock;
        bindContent(questionBlock);

        table.add(one).padRight(10).padBottom(10).width(nubmerWidth).height(nubmerHeight);
        table.add(firstQuestion).padRight(10).padBottom(10).width(questionWidth).height(QuestionHeight);
        table.add(firstValue).padRight(10).padBottom(10).width(nubmerWidth).height(nubmerHeight);
        table.row();
        table.add(two).padRight(10).padBottom(10).width(nubmerWidth).height(nubmerHeight);
        table.add(secondQuestion).padRight(10).padBottom(10).width(questionWidth).height(QuestionHeight);
        table.add(secondValue).padRight(10).padBottom(10).width(nubmerWidth).height(nubmerHeight);
        table.row();
        table.add(three).padRight(10).padBottom(10).width(nubmerWidth).height(nubmerHeight);
        table.add(thirdQuestion).padRight(10).padBottom(10).width(questionWidth).height(QuestionHeight);
        table.add(thirdValue).padRight(10).padBottom(10).width(nubmerWidth).height(nubmerHeight);
        table.row();
        table.add(four).padRight(10).padBottom(10).width(nubmerWidth).height(nubmerHeight);
        table.add(fourthQuestion).padRight(10).padBottom(10).width(questionWidth).height(QuestionHeight);
        table.add(fouthValue).padRight(10).padBottom(10).width(nubmerWidth).height(nubmerHeight);
        table.row();
        table.add(five).padRight(10).padBottom(10).width(nubmerWidth).height(nubmerHeight);
        table.add(fifthQuestion).padRight(10).padBottom(10).width(questionWidth).height(QuestionHeight);
        table.add(fifthValue).padRight(10).padBottom(10).width(nubmerWidth).height(nubmerHeight);
        table.row();
        table.add(timer).height(timerSize).width(timerSize).padTop(50).colspan(3);

        setBtnLight();

        timer.setVisible(false);

        firstQuestion.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeListener.ChangeEvent event, Actor actor) {
                firstQuestion.setStyle(Main.greenStyle);
                firstQuestion.setText(questions[1]);
                CubeAnswer.addToScore = 1;
                CubeAnswer.answerNum = 1;
                timer.setVisible(true);
                timerLeft.schedule(timerTask, 0, 1000);
                disableBtns(0);

                firstQuestion.setDisabled(true);
                secondQuestion.setDisabled(true);
                thirdQuestion.setDisabled(true);
                fourthQuestion.setDisabled(true);
                fifthQuestion.setDisabled(true);
            }
        });
        secondQuestion.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeListener.ChangeEvent event, Actor actor) {
                secondQuestion.setStyle(Main.greenStyle);
                secondQuestion.setText(questions[2]);
                CubeAnswer.addToScore = 1;
                CubeAnswer.answerNum = 2;
                timer.setVisible(true);
                timerLeft.schedule(timerTask, 0, 1000);
                disableBtns(1);

                firstQuestion.setDisabled(true);
                secondQuestion.setDisabled(true);
                thirdQuestion.setDisabled(true);
                fourthQuestion.setDisabled(true);
                fifthQuestion.setDisabled(true);
            }
        });
        thirdQuestion.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeListener.ChangeEvent event, Actor actor) {
                thirdQuestion.setStyle(Main.greenStyle);
                thirdQuestion.setText(questions[3]);
                CubeAnswer.addToScore = 2;
                CubeAnswer.answerNum = 3;
                timer.setVisible(true);
                timerLeft.schedule(timerTask, 0, 1000);
                disableBtns(2);

                firstQuestion.setDisabled(true);
                secondQuestion.setDisabled(true);
                thirdQuestion.setDisabled(true);
                fourthQuestion.setDisabled(true);
                fifthQuestion.setDisabled(true);
            }
        });
        fourthQuestion.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeListener.ChangeEvent event, Actor actor) {
                fourthQuestion.setStyle(Main.greenStyle);
                fourthQuestion.setText(questions[4]);
                CubeAnswer.addToScore = 2;
                CubeAnswer.answerNum = 4;
                timer.setVisible(true);
                timerLeft.schedule(timerTask, 0, 1000);
                disableBtns(3);

                firstQuestion.setDisabled(true);
                secondQuestion.setDisabled(true);
                thirdQuestion.setDisabled(true);
                fourthQuestion.setDisabled(true);
                fifthQuestion.setDisabled(true);
            }
        });
        fifthQuestion.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeListener.ChangeEvent event, Actor actor) {
                fifthQuestion.setStyle(Main.greenStyle);
                fifthQuestion.setText(questions[5]);
                CubeAnswer.addToScore = 3;
                CubeAnswer.answerNum = 5;
                timer.setVisible(true);
                timerLeft.schedule(timerTask, 0, 1000);
                disableBtns(4);

                firstQuestion.setDisabled(true);
                secondQuestion.setDisabled(true);
                thirdQuestion.setDisabled(true);
                fourthQuestion.setDisabled(true);
                fifthQuestion.setDisabled(true);
            }
        });

        timerLeft = new Timer();

        timer.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                timerTask.cancel();
                Main.game.setScreen(new CubeAnswer(block));
            }
        });

        timerTask = new TimerTask() {
            @Override
            public void run() {
                timeConst--;
            }
        };

    }

    public void bindContent(int block){
        switch (block){
            case 1:
                questions = Main.cubeQuestions1;
                CubeAnswer.answers = Main.cubeAnswers1;
                return;
            case 2:
                questions = Main.cubeQuestions2;
                CubeAnswer.answers = Main.cubeAnswers2;
                return;
            case 3:
                questions = Main.cubeQuestions3;
                CubeAnswer.answers = Main.cubeAnswers3;
                return;
            case 4:
                questions = Main.cubeQuestions4;
                CubeAnswer.answers = Main.cubeAnswers4;
                return;
            case 5:
                questions = Main.cubeQuestions5;
                CubeAnswer.answers = Main.cubeAnswers5;
                return;
            case 6:
                questions = Main.cubeQuestions6;
                CubeAnswer.answers = Main.cubeAnswers6;
        }
    }

    public void disableBtns(int questionNum){
        switch (block){
            case 1:
                Main.displayFirst[questionNum] = false;
                return;
            case 2:
                Main.displaySecond[questionNum] = false;
                return;
            case 3:
                Main.displayThird[questionNum] = false;
                return;
            case 4:
                Main.displayFourth[questionNum] = false;
                return;
            case 5:
                Main.displayFifth[questionNum] = false;
                return;
            case 6:
                Main.displaySix[questionNum] = false;

        }
    }

    public void setBtnLight(){
        switch (block){
            case 1:
                if(!Main.displayFirst[0]){
                    firstQuestion.setDisabled(true);
                    firstQuestion.setStyle(Main.greyStyle);
                    setPlaceHolder(firstQuestion);
                }
                if(!Main.displayFirst[1]){
                    secondQuestion.setDisabled(true);
                    secondQuestion.setStyle(Main.greyStyle);
                    setPlaceHolder(secondQuestion);
                }
                if(!Main.displayFirst[2]){
                    thirdQuestion.setDisabled(true);
                    thirdQuestion.setStyle(Main.greyStyle);
                    setPlaceHolder(thirdQuestion);
                }
                if(!Main.displayFirst[3]){
                    fourthQuestion.setDisabled(true);
                    fourthQuestion.setStyle(Main.greyStyle);
                    setPlaceHolder(fourthQuestion);
                }
                if(!Main.displayFirst[4]){
                    fifthQuestion.setDisabled(true);
                    fifthQuestion.setStyle(Main.greyStyle);
                    setPlaceHolder(fifthQuestion);
                }
                return;
            case 2:
                if(!Main.displaySecond[0]){
                    firstQuestion.setDisabled(true);
                    firstQuestion.setStyle(Main.greyStyle);
                    setPlaceHolder(firstQuestion);
                }
                if(!Main.displaySecond[1]){
                    secondQuestion.setDisabled(true);
                    secondQuestion.setStyle(Main.greyStyle);
                    setPlaceHolder(secondQuestion);
                }
                if(!Main.displaySecond[2]){
                    thirdQuestion.setDisabled(true);
                    thirdQuestion.setStyle(Main.greyStyle);
                    setPlaceHolder(thirdQuestion);
                }
                if(!Main.displaySecond[3]){
                    fourthQuestion.setDisabled(true);
                    fourthQuestion.setStyle(Main.greyStyle);
                    setPlaceHolder(fourthQuestion);
                }
                if(!Main.displaySecond[4]){
                    fifthQuestion.setDisabled(true);
                    fifthQuestion.setStyle(Main.greyStyle);
                    setPlaceHolder(fifthQuestion);
                }
                return;
            case 3:
                if(!Main.displayThird[0]){
                    firstQuestion.setDisabled(true);
                    firstQuestion.setStyle(Main.greyStyle);
                    setPlaceHolder(firstQuestion);
                }
                if(!Main.displayThird[1]){
                    secondQuestion.setDisabled(true);
                    secondQuestion.setStyle(Main.greyStyle);
                    setPlaceHolder(secondQuestion);
                }
                if(!Main.displayThird[2]){
                    thirdQuestion.setDisabled(true);
                    thirdQuestion.setStyle(Main.greyStyle);
                    setPlaceHolder(thirdQuestion);
                }
                if(!Main.displayThird[3]){
                    fourthQuestion.setDisabled(true);
                    fourthQuestion.setStyle(Main.greyStyle);
                    setPlaceHolder(fourthQuestion);
                }
                if(!Main.displayThird[4]){
                    fifthQuestion.setDisabled(true);
                    fifthQuestion.setStyle(Main.greyStyle);
                    setPlaceHolder(fifthQuestion);
                }
                return;
            case 4:
                if(!Main.displayFourth[0]){
                    firstQuestion.setDisabled(true);
                    firstQuestion.setStyle(Main.greyStyle);
                    setPlaceHolder(firstQuestion);
                }
                if(!Main.displayFourth[1]){
                    secondQuestion.setDisabled(true);
                    secondQuestion.setStyle(Main.greyStyle);
                    setPlaceHolder(secondQuestion);
                }
                if(!Main.displayFourth[2]){
                    thirdQuestion.setDisabled(true);
                    thirdQuestion.setStyle(Main.greyStyle);
                    setPlaceHolder(thirdQuestion);
                }
                if(!Main.displayFourth[3]){
                    fourthQuestion.setDisabled(true);
                    fourthQuestion.setStyle(Main.greyStyle);
                    setPlaceHolder(fourthQuestion);
                }
                if(!Main.displayFourth[4]){
                    fifthQuestion.setDisabled(true);
                    fifthQuestion.setStyle(Main.greyStyle);
                    setPlaceHolder(fifthQuestion);
                }
                return;
            case 5:
                if(!Main.displayFifth[0]){
                    firstQuestion.setDisabled(true);
                    firstQuestion.setStyle(Main.greyStyle);
                    setPlaceHolder(firstQuestion);
                }
                if(!Main.displayFifth[1]){
                    secondQuestion.setDisabled(true);
                    secondQuestion.setStyle(Main.greyStyle);
                    setPlaceHolder(secondQuestion);
                }
                if(!Main.displayFifth[2]){
                    thirdQuestion.setDisabled(true);
                    thirdQuestion.setStyle(Main.greyStyle);
                    setPlaceHolder(thirdQuestion);
                }
                if(!Main.displayFifth[3]){
                    fourthQuestion.setDisabled(true);
                    fourthQuestion.setStyle(Main.greyStyle);
                    setPlaceHolder(fourthQuestion);
                }
                if(!Main.displayFifth[4]){
                    fifthQuestion.setDisabled(true);
                    fifthQuestion.setStyle(Main.greyStyle);
                    setPlaceHolder(fifthQuestion);
                }
            case 6:
                if(!Main.displaySix[0]){
                    firstQuestion.setDisabled(true);
                    firstQuestion.setStyle(Main.greyStyle);
                    setPlaceHolder(firstQuestion);
                }
                if(!Main.displaySix[1]){
                    secondQuestion.setDisabled(true);
                    secondQuestion.setStyle(Main.greyStyle);
                    setPlaceHolder(secondQuestion);
                }
                if(!Main.displaySix[2]){
                    thirdQuestion.setDisabled(true);
                    thirdQuestion.setStyle(Main.greyStyle);
                    setPlaceHolder(thirdQuestion);
                }
                if(!Main.displaySix[3]){
                    fourthQuestion.setDisabled(true);
                    fourthQuestion.setStyle(Main.greyStyle);
                    setPlaceHolder(fourthQuestion);
                }
                if(!Main.displaySix[4]){
                    fifthQuestion.setDisabled(true);
                    fifthQuestion.setStyle(Main.greyStyle);
                    setPlaceHolder(fifthQuestion);
                }


        }
    }

    public void setPlaceHolder(TextButton textButton){
        textButton.setText("Питання зіграно");
    }


    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.draw();  //only draws
        stage.act();   //only acts

        setBackground(Main.purpleBackground);

        if(Gdx.input.isKeyJustPressed(Input.Keys.Q)){
            Gdx.app.exit();
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.M)) {
            Main.game.setScreen(Main.mainMenu);
        }

        timer.setText(Integer.toString(timeConst));

        if(timeConst <= 0){
            timerTask.cancel();
            Main.game.setScreen(new CubeAnswer(block));
        }
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
    }
}
