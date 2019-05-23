package jpr2.main;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public class screenFather extends ScreenAdapter {

    public  static Stage stage;
    public Table table;

    public int timerSize = 150;

    Main main;

    public screenFather(){

        main = new Main();

        stage = new Stage(Main.viewport);
        table = new Table();

        stage.addActor(table);
        table.setFillParent(true);
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage); //Установка слушания ввода на menuStage, когда активен этот экран
    }

    @Override
    public void dispose() {
        main.font.dispose();
    }

    public void resize(int width, int height) {
        Main.viewport.update(width, height);
    }
}
