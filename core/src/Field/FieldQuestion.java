package Field;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import jpr2.main.Main;
import jpr2.main.screenFather;

import java.util.Timer;
import java.util.TimerTask;

public class FieldQuestion extends screenFather {

    TextButton question = new TextButton("", Main.purpleStyle);

    Timer timerLeft;
    TimerTask timerTask;
    public int timeConst = 31;

    TextButton timer = new TextButton("", Main.menuButton);

    int number;
    TextButton.TextButtonStyle color;

    public FieldQuestion(final int number, final TextButton.TextButtonStyle color){

        this.number = number;
        this.color = color;

        question.setText(Main.fieldQuestions[number]);
        table.add(question);
        table.row();
        table.add(timer).size(timerSize, timerSize);

        timer.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                Main.game.setScreen(new FieldAnswer(number, color));
            }
        });

        timerLeft = new Timer();

        timerTask = new TimerTask() {
            @Override
            public void run() {
                timeConst--;
            }
        };
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.draw();  //only draws
        stage.act();   //only acts

        setBackground(Main.purpleBackground);

        if(timeConst <= 0){
            Main.game.setScreen(new FieldAnswer(number, color));
        }

        timer.setText(Integer.toString(timeConst));

        if(Gdx.input.isKeyJustPressed(Input.Keys.Q)){
            Gdx.app.exit();
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.M)) {
            Main.game.setScreen(Main.mainMenu);
        }
    }

    @Override
    public void show() {
        timerLeft.schedule(timerTask, 0,1000);
        Gdx.input.setInputProcessor(stage);
    }

}
