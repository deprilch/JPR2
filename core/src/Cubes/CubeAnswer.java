package Cubes;

import NextNext.Next;
import NextNext.Question;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import jpr2.main.Main;
import jpr2.main.screenFather;

public class CubeAnswer extends screenFather {

    TextButton correct = new TextButton("Вірно!", Main.greenStyle);
    TextButton incorrect = new TextButton("Невірно!", Main.redStyle);

    public CubeAnswer(){

        table.add(new TextButton("Here will be answer", Main.purpleStyle)).colspan(2).center().padBottom(10);
        table.row();
        table.add(correct).padRight(10).size(360, 150);
        table.add(incorrect).size(360, 150);

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
        if(Gdx.input.isKeyJustPressed(Input.Keys.M)){
            Main.game.setScreen(Main.mainMenu);
        }
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
    }
}
