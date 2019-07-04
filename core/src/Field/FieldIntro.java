package Field;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import jpr2.main.Main;
import jpr2.main.screenFather;

public class FieldIntro extends screenFather {

    TextButton desc = new TextButton("Натиснить ENTER щоб розпочати", Main.purpleStyle);

    public FieldIntro(){

        table.add(desc);

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.draw();  //only draws
        stage.act();   //only acts

        setBackground(Main.purpleBackground);

        if(Gdx.input.isKeyJustPressed(Input.Keys.ENTER)){
            Main.game.setScreen(new Field());
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
        Gdx.input.setInputProcessor(stage);
    }

}
