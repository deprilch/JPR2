package Field;

import Cubes.CubeAnswer;
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

public class Field extends screenFather {

    TextButton[] coloredBtnArray = new TextButton[25];
    TextButton[] btnArray;

    Timer timerLeft;
    TimerTask timerTask;
    public int timeConst = 3;

    TextButton timer = new TextButton("", Main.menuButton);

    int btnSize = 150;

    public Field(){

        for(int i = 1; i < 25; i++){
            if(i == 1 || i == 3 || i == 5 || i == 11 || i == 13 || i == 15 || i == 18 || i == 20){
                coloredBtnArray[i] = new TextButton(Integer.toString(i), Main.redStyle);
            }
            if(i == 4 || i == 6 || i == 8 || i == 10 || i == 17 || i == 19 || i == 22 || i == 24){
                coloredBtnArray[i] = new TextButton(Integer.toString(i), Main.blueStyle);
            }
            if(i == 2 || i == 7 || i == 9 || i == 12 || i == 14 || i == 16 || i == 21 || i == 23){
                coloredBtnArray[i] = new TextButton(Integer.toString(i), Main.yellowStyle);
            }
            table.add(coloredBtnArray[i]).width(btnSize).height(btnSize).padRight(10).padBottom(10);
            if(i == 6 || i == 12 || i == 18){
                table.row();
            }
            coloredBtnArray[i].setDisabled(true);
            coloredBtnArray[i].addListener(new ChangeListener() {
                @Override
                public void changed(ChangeEvent event, Actor actor) {
                    Main.game.setScreen(new FieldQuestion());
                }
            });
        }

        btnArray = coloredBtnArray;

        table.row();
        table.add(timer).width(btnSize).height(btnSize).colspan(6).center();

        timer.setDisabled(true);

        timerLeft = new Timer();

        timerTask = new TimerTask() {
            @Override
            public void run() {
                timeConst--;
            }
        };
    }

    public void hideColors(){
        for (int i = 1; i < coloredBtnArray.length; i++) {
            coloredBtnArray[i].setStyle(Main.greenStyle);
            coloredBtnArray[i].setDisabled(false);
        }
        timerLeft.cancel();
        table.removeActor(timer);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.draw();  //only draws
        stage.act();   //only acts

        setBackground(Main.purpleBackground);

        timer.setText(Integer.toString(timeConst));

        if(timeConst <= 0){
            hideColors();
        }

        if(Gdx.input.isKeyJustPressed(Input.Keys.Q)){
            Gdx.app.exit();
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.M)) {
            Main.game.setScreen(Main.mainMenu);
        }
    }

    @Override
    public void show() {
        timerLeft.schedule(timerTask, 0,1000);
        Gdx.input.setInputProcessor(stage);
    }

}
