package Konkurses.Quiz;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import jpr2.main.Main;

import java.util.Timer;
import java.util.TimerTask;

public class Quiz extends jpr2.main.screenFather {

    Timer timerLeft = new Timer();
    TimerTask timerTask;
    public int timeConst = 31;
    public int timeLeft = timeConst;

    TextButton timer;
    TextButton question;

    public Quiz(){

        question = new TextButton("texttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttext", Main.redStyle);
        timer = new TextButton("text", Main.menuButton);

        table.add(question).colspan(10).expandY().center().fill();
        table.getCell(question).maxWidth(1000);
        table.getCell(question).maxHeight(100);
        table.row();

        //timer
        table.add(timer).center().colspan(10).padBottom(10).size(timerSize,timerSize);
        table.row();


        timer.addListener(new ChangeListener() {
            @Override
            public void changed (ChangeListener.ChangeEvent event, Actor actor) {

                Main.game.setScreen(new WhoIsTheFirstTeam());
            }
        });

        timerTask = new TimerTask() {
            @Override
            public void run() {
                timeLeft--;
            }
        };
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.draw();  //only draws
        stage.act();   //only acts

        timer.setText(Integer.toString(timeLeft));

        if(Gdx.input.isKeyJustPressed(Input.Keys.Q)){
            Gdx.app.exit();
        }

    }
    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
        timeLeft = timeConst;
        timerLeft.schedule(timerTask, 0, 1000);
    }

}
