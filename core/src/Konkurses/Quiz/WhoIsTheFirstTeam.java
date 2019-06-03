package Konkurses.Quiz;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import jpr2.main.Main;
import jpr2.main.screenFather;

public class WhoIsTheFirstTeam extends screenFather {

    TextButton title = new TextButton("Enter team names", Main.redStyle);
    TextField firstTeamNameField = new TextField("", Main.redTextFieldStyle);
    TextField secondTeamNameField = new TextField("", Main.redTextFieldStyle);
    TextButton apply = new TextButton("Apply", Main.menuButton);

    public static String firstTeamName;
    public static String secondTeamName;

    public WhoIsTheFirstTeam(){

        table.add(title).center().fill().width(1200).height(100).padBottom(20);
        table.row();
        table.add(firstTeamNameField).center().fill().width(400).height(100).padBottom(20);
        table.row();
        table.add(secondTeamNameField).center().fill().width(400).height(100).padBottom(20);
        table.row();
        table.add(apply).width(400).height(100);

        apply.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                firstTeamName = firstTeamNameField.getText();
                secondTeamName = secondTeamNameField.getText();
                Main.game.setScreen(Main.mainMenu);
            }
        });

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1,1,1, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.draw();
        stage.act();

        if(Gdx.input.isKeyJustPressed(Input.Keys.Q)){
            Gdx.app.exit();
        }

    }

    @Override
    public void dispose() {

    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage); //Установка слушания ввода на menuStage, когда активен этот экран
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height); //updates viewport to current window size
    }

}
