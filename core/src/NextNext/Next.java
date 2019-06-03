package NextNext;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import jpr2.main.Main;

public class Next extends jpr2.main.screenFather {

    public static TextButton start = new TextButton("Натисніть ENTER щоб розпочати", Main.redStyle);
    public static int currentQuestion = 1;
    public static int currentAnswer = 1;
    public static int blueScore = 0;
    public static int redScore = 0;
    public static boolean redCurrent = true;

    public Next(){

        TextButton[] redButtons = new TextButton[21];
        TextButton[] blueButtons = new TextButton[21];
        for(int i = 0; i < 21; i++){
            redButtons[i] = new TextButton(Integer.toString(i + 1), Main.redStyle);
            blueButtons[i] = new TextButton(Integer.toString(i + 1), Main.blueStyle);
        }

        for (int s = 0; s < 21; s++){
            table.add(redButtons[s]).padBottom(10).padRight(10).padTop(5).size(standartSize,standartSize);
        }
        table.row();
        for (int j = 0; j < 21; j++){
            table.add(blueButtons[j]).padBottom(10).padRight(10).padTop(5).size(standartSize,standartSize);
        }
        table.row();
        table.add(start).center().colspan(21);

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
            Main.game.setScreen(new Question());
        }
    }

    public void setBackground(){
        if(redCurrent){
            //table.setBackground(Main.redBackground);
        }
        else {
            //table.setBackground(main.blueBackground);
        }
    }
}
