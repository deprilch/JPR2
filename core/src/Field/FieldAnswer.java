package Field;

import Konkurses.Quiz.WhoIsTheFirstTeam;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import jpr2.main.Main;
import jpr2.main.screenFather;

public class FieldAnswer extends screenFather {

    TextButton redRight = new TextButton(WhoIsTheFirstTeam.firstTeamName, Main.greenStyle);
    TextButton blueRight = new TextButton(WhoIsTheFirstTeam.secondTeamName, Main.redStyle);
    TextButton nobodyRight = new TextButton("Nobody!", Main.greyStyle);


    public FieldAnswer(){

        table.add(new TextButton("Відповідь: some shit", Main.purpleStyle)).colspan(2).center().padBottom(10);
        table.row();
        table.add(new TextButton("Хто дав правильну відповідь?", Main.purpleStyle)).colspan(2).center().padBottom(10);
        table.row();
        table.add(redRight).padRight(10).size(360, 150);
        table.add(blueRight).size(360, 150);
        table.row();
        table.add(nobodyRight).size(360, 150).colspan(2).padTop(20);

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
