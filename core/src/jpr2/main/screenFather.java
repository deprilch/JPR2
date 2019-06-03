package jpr2.main;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public class screenFather extends ScreenAdapter {

    public static Stage stage;
    public Table table;

    public int standartSize = 60;
    public int bigSize = 150;
    public int timerSize = 150;

    public screenFather(){
        stage = new Stage(Main.viewport);
        table = new Table();

        stage.addActor(table);
        table.setFillParent(true);
        table.setDebug(true);
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage); //Установка слушания ввода на menuStage, когда активен этот экран
    }

    @Override
    public void dispose() {
    }
}
