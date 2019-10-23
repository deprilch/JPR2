package BlackBox;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import jpr2.main.Main;
import jpr2.main.screenFather;


public class BlackBox extends screenFather {

    public static int currentQuestion = 1;
    public static int currentAnswer = 1;
    public static int blueScore = 0;
    public static int redScore = 0;

    TextButton red = new TextButton("1 бал", Main.redStyle);
    TextButton green = new TextButton("4 бали", Main.greenStyle);
    TextButton orange = new TextButton("3 бали", Main.yellowStyle);
    TextButton question = new TextButton("Натисніть ENTER щоб розпочати", Main.purpleStyle);

    public BlackBox(){

        table.add(green).size(600, 200).padBottom(20);
        table.row();
        table.add(orange).size(600, 200).padBottom(20);
        table.row();
        table.add(red).size(600, 200).padBottom(20);
        table.row();
        table.add(question).size(600, 200);

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.draw();  //only draws
        stage.act();   //only acts

        setBackground();

        if(Gdx.input.isKeyJustPressed(Input.Keys.Q)){
            Gdx.app.exit();
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.M)){
            Main.game.setScreen(Main.mainMenu);
        }

        if(Gdx.input.isKeyJustPressed(Input.Keys.ENTER)){
            Main.game.setScreen(new BlackBoxQuestion());
        }
    }

    public void setBackground(){
        table.setBackground(Main.purpleBackground);
    }

}
