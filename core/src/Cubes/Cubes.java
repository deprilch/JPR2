package Cubes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import jpr2.main.Main;
import jpr2.main.screenFather;

public class Cubes extends screenFather {

    public static int redScore = 0;
    public static int blueScore = 0;

    int width = 200;
    int height = 200;

    TextButton one = new TextButton("", Main.oneBlack);
    TextButton two = new TextButton("", Main.twoBlack);
    TextButton three = new TextButton("", Main.threeBlack);
    TextButton four = new TextButton("", Main.fourBlack);
    TextButton five = new TextButton("", Main.fiveBlack);
    TextButton six = new TextButton("", Main.sixBlack);

    public Cubes(){

        table.add(one).padRight(10).padBottom(10).width(width).height(height);
        table.add(two).padRight(10).padBottom(10).width(width).height(height);
        table.add(three).padRight(10).padBottom(10).width(width).height(height);
        table.row();
        table.add(four).padRight(10).padBottom(10).width(width).height(height);
        table.add(five).padRight(10).padBottom(10).width(width).height(height);
        table.add(six).padRight(10).padBottom(10).width(width).height(height);

        one.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                Main.game.setScreen(new CubesQuestions(1));
            }
        });
        two.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                Main.game.setScreen(new CubesQuestions(2));
            }
        });
        three.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                Main.game.setScreen(new CubesQuestions(3));
            }
        });
        four.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                Main.game.setScreen(new CubesQuestions(4));
            }
        });
        five.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                Main.game.setScreen(new CubesQuestions(5));
            }
        });
        six.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                Main.game.setScreen(new CubesQuestions(6));
            }
        });

        disableBtns();
    }

    public void disableBtns(){
        if(!Main.displayDices[0]){
            one.setDisabled(true);
            one.setStyle(Main.greyStyle);
        }
        if(!Main.displayDices[1]){
            two.setDisabled(true);
            two.setStyle(Main.greyStyle);
        }
        if(!Main.displayDices[2]){
            three.setDisabled(true);
            three.setStyle(Main.greyStyle);
        }
        if(!Main.displayDices[3]){
            four.setDisabled(true);
            four.setStyle(Main.greyStyle);
        }
        if(!Main.displayDices[4]){
            five.setDisabled(true);
            five.setStyle(Main.greyStyle);
        }
        if(!Main.displayDices[5]){
            six.setDisabled(true);
            six.setStyle(Main.greyStyle);
        }
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 0);
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
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
    }
}
