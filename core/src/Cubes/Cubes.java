package Cubes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import jpr2.main.Main;
import jpr2.main.screenFather;

import java.util.Arrays;

public class Cubes extends screenFather {

    public static int redScore = 0;
    public static int blueScore = 0;

    int width = 200;
    int height = 100;

    TextButton one = new TextButton("one", Main.menuButton);
    TextButton two = new TextButton("two", Main.menuButton);
    TextButton three = new TextButton("three", Main.menuButton);
    TextButton four = new TextButton("four", Main.menuButton);
    TextButton five = new TextButton("five", Main.menuButton);
    TextButton six = new TextButton("six", Main.menuButton);

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
