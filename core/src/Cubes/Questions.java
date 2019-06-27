package Cubes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import jpr2.main.Main;
import jpr2.main.screenFather;

import java.util.Timer;
import java.util.TimerTask;

public class Questions extends screenFather {

    int nubmerHeight = 100;
    int nubmerWidth = 100;
    int questionWidth = 1000;
    int QuestionHeight = 100;

    TextButton one = new TextButton("1", Main.redStyle);
    TextButton two = new TextButton("2", Main.redStyle);
    TextButton three = new TextButton("3", Main.redStyle);
    TextButton four = new TextButton("4", Main.redStyle);
    TextButton five = new TextButton("5", Main.redStyle);

    TextButton firstQuestion = new TextButton("Here goes some question", Main.greyStyle);
    TextButton secondQuestion = new TextButton("Here goes some question", Main.greyStyle);
    TextButton thirdQuestion = new TextButton("Here goes some question", Main.greyStyle);
    TextButton fourthQuestion = new TextButton("Here goes some question", Main.greyStyle);
    TextButton fifthQuestion = new TextButton("Here goes some question", Main.greyStyle);

    TextButton firstValue = new TextButton("1", Main.redStyle);
    TextButton secondValue = new TextButton("1", Main.redStyle);
    TextButton thirdValue = new TextButton("2", Main.redStyle);
    TextButton fouthValue = new TextButton("2", Main.redStyle);
    TextButton fifthValue = new TextButton("3", Main.redStyle);

    Timer timerLeft;
    TimerTask timerTask;
    public int timeConst = 31;

    TextButton timer = new TextButton("", Main.menuButton);


    public Questions(){

        table.add(firstValue).padRight(10).padBottom(10).width(nubmerWidth).height(nubmerHeight);
        table.add(one).padRight(10).padBottom(10).width(nubmerWidth).height(nubmerHeight);
        table.add(firstQuestion).padRight(10).padBottom(10).width(questionWidth).height(QuestionHeight);
        table.row();
        table.add(secondValue).padRight(10).padBottom(10).width(nubmerWidth).height(nubmerHeight);
        table.add(two).padRight(10).padBottom(10).width(nubmerWidth).height(nubmerHeight);
        table.add(secondQuestion).padRight(10).padBottom(10).width(questionWidth).height(QuestionHeight);
        table.row();
        table.add(thirdValue).padRight(10).padBottom(10).width(nubmerWidth).height(nubmerHeight);
        table.add(three).padRight(10).padBottom(10).width(nubmerWidth).height(nubmerHeight);
        table.add(thirdQuestion).padRight(10).padBottom(10).width(questionWidth).height(QuestionHeight);
        table.row();
        table.add(fouthValue).padRight(10).padBottom(10).width(nubmerWidth).height(nubmerHeight);
        table.add(four).padRight(10).padBottom(10).width(nubmerWidth).height(nubmerHeight);
        table.add(fourthQuestion).padRight(10).padBottom(10).width(questionWidth).height(QuestionHeight);
        table.row();
        table.add(fifthValue).padRight(10).padBottom(10).width(nubmerWidth).height(nubmerHeight);
        table.add(five).padRight(10).padBottom(10).width(nubmerWidth).height(nubmerHeight);
        table.add(fifthQuestion).padRight(10).padBottom(10).width(questionWidth).height(QuestionHeight);
        table.row();
        table.add(timer).height(timerSize).width(timerSize).padTop(50).colspan(3);

        timer.setVisible(false);

        firstQuestion.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeListener.ChangeEvent event, Actor actor) {
                firstQuestion.setStyle(Main.redStyle);
                firstQuestion.setText("Changed!");
                timer.setVisible(true);
            }
        });

        timerLeft = new Timer();

        timer.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                timerTask.cancel();
                Main.game.setScreen(new CubeAnswer());
            }
        });

        timerTask = new TimerTask() {
            @Override
            public void run() {
                timeConst--;
            }
        };

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
            Main.game.setScreen(new CubeAnswer());
        }
    }

    @Override
    public void show() {
        timerLeft.schedule(timerTask, 0, 1000);
        Gdx.input.setInputProcessor(stage);
    }
}
