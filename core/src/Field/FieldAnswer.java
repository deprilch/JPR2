package Field;

import Konkurses.Quiz.WhoIsTheFirstTeam;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import jpr2.main.Main;
import jpr2.main.screenFather;

public class FieldAnswer extends screenFather {

    TextButton redRight = new TextButton(WhoIsTheFirstTeam.firstTeamName, Main.greenStyle);
    TextButton blueRight = new TextButton(WhoIsTheFirstTeam.secondTeamName, Main.redStyle);
    TextButton nobodyRight = new TextButton("Ніхто!", Main.greyStyle);

    boolean redQuestion = false;
    boolean yellowQuestion = false;
    boolean blueQuestion = false;

    public FieldAnswer(int number, TextButton.TextButtonStyle color){

        determineQuestionType(number);

        Field.makeGrey.add(number);

        table.add(new TextButton("Відповідь: " + Main.fieldAnswers[number], Main.purpleStyle)).colspan(2).center().padBottom(10);
        table.row();
        table.add(new TextButton("Хто дав правильну відповідь?", Main.purpleStyle)).colspan(2).center().padBottom(10);
        table.row();
        table.add(redRight).padRight(10).size(360, 150);
        table.add(blueRight).size(360, 150);
        table.row();
        table.add(nobodyRight).size(360, 150).colspan(2).padTop(20);

        redRight.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                if(redQuestion){
                    Field.redScore += 2;
                }
                if(blueQuestion){
                    Field.redScore += 3;
                }
                if(yellowQuestion){
                    Field.redScore += 1;
                }
                if(Field.makeGrey.size() == 24){
                    Main.game.setScreen(Main.mainMenu);
                }
                else {
                    Main.game.setScreen(new Field());
                }
            }
        });
        blueRight.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                if(redQuestion){
                    Field.blueScore += 3;
                }
                if(blueQuestion){
                    Field.blueScore += 2;
                }
                if(yellowQuestion){
                    Field.blueScore += 1;
                }
                if(Field.makeGrey.size() == 24){
                    Main.game.setScreen(Main.mainMenu);
                }
                else {
                    Main.game.setScreen(new Field());
                }
            }
        });
        nobodyRight.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                if(Field.makeGrey.size() == 24){
                    Main.game.setScreen(Main.mainMenu);
                }
                else {
                    Main.game.setScreen(new Field());
                }
            }
        });

    }

    public void determineQuestionType(int i){
        if(i == 1 || i == 3 || i == 5 || i == 11 || i == 13 || i == 15 || i == 18 || i == 20){
            redQuestion = true;
        }
        if(i == 2 || i == 7 || i == 9 || i == 12 || i == 14 || i == 16 || i == 21 || i == 23){
            yellowQuestion = true;
        }
        if(i == 4 || i == 6 || i == 8 || i == 10 || i == 17 || i == 19 || i == 22 || i == 24){
            blueQuestion = true;
        }
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
