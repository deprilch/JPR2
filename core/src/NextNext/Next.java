package NextNext;

import Konkurses.Quiz.WhoIsTheFirstTeam;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import jpr2.main.Main;

public class Next extends jpr2.main.screenFather {

    public static TextButton start = new TextButton("", Main.purpleStyle);
    public static int currentQuestion = 1;
    public static int currentAnswer = 1;
    public static int blueScore = 0;
    public static int redScore = 0;
    public static boolean redCurrent = true;

    public Next(){

        if(redCurrent) {
            start.setStyle(Main.purpleStyle);
            start.setText("Починає команда " + WhoIsTheFirstTeam.firstTeamName);
        }
        else{
            start.setStyle(Main.purpleStyle);
            start.setText("Команда " + WhoIsTheFirstTeam.firstTeamName + " набрала " + redScore + " балів\n" +
                    "Команда " + WhoIsTheFirstTeam.secondTeamName + " - тепер граєте ви!");
        }

        table.add(start);

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
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
        if(Gdx.input.isKeyJustPressed(Input.Keys.ENTER)){
            Main.game.setScreen(new Question());
        }
    }
}
