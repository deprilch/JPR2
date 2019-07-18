package FansWord;

import Konkurses.Quiz.WhoIsTheFirstTeam;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import jpr2.main.Main;
import jpr2.main.screenFather;

import java.util.ArrayList;

public class FansWord extends screenFather {

    private int letterWidth = 50;
    private int fieldWidth = 300;
    private int fieldHeight = 100;

    TextButton firstTeam = new TextButton(WhoIsTheFirstTeam.firstTeamName, Main.redStyle);
    TextButton secondTeam = new TextButton(WhoIsTheFirstTeam.secondTeamName, Main.greenStyle);

    TextButton submit = new TextButton("Готово", Main.wrongStyle);

    ArrayList<TextButton> redLetters = new ArrayList<TextButton>();
    ArrayList<TextButton> blueLetters = new ArrayList<TextButton>();
    ArrayList<TextField> redFields = new ArrayList<TextField>();
    ArrayList<TextField> blueFields = new ArrayList<TextField>();
    private char[] word = {'С', 'К', 'Л', 'Е', 'Р', 'А'};
    public static int redScore = 0;
    public static int blueScore = 0;

    public FansWord()
    {
        table.add(firstTeam).padRight(10).padBottom(10).size(letterWidth + fieldWidth, fieldHeight).colspan(2);
        table.add(secondTeam).padBottom(10).size(letterWidth + fieldWidth, fieldHeight).colspan(2);
        table.row();

        for (int i = 0; i < 6; i++) {
            redLetters.add(new TextButton(String.valueOf(word[i]), Main.redStyle));
            blueLetters.add(new TextButton(String.valueOf(word[i]), Main.greenStyle));
            redFields.add(new TextField("", Main.redTextFieldStyle));
            blueFields.add(new TextField("", Main.greenTextFieldStyle));

            table.add(redLetters.get(i)).size(letterWidth, fieldHeight).padBottom(10);
            table.add(redFields.get(i)).size(fieldWidth, fieldHeight).padBottom(10).padRight(10);

            table.add(blueLetters.get(i)).size(letterWidth, fieldHeight).padBottom(10);
            table.add(blueFields.get(i)).size(fieldWidth, fieldHeight).padBottom(10);

            table.row();
        }
        table.add(submit).colspan(4).center().size(200, 100);

        submit.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                Main.game.setScreen(Main.mainMenu);
            }
        });
    }

    public void calculateScore(){

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
