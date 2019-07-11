package Cubes;

import Konkurses.Quiz.WhoIsTheFirstTeam;
import NextNext.Next;
import NextNext.Question;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import jpr2.main.Main;
import jpr2.main.MainMenu;
import jpr2.main.screenFather;

import static Cubes.CubesQuestions.questionCounter;

public class CubeAnswer extends screenFather {

    TextButton redRight = new TextButton(WhoIsTheFirstTeam.firstTeamName, Main.greenStyle);
    TextButton blueRight = new TextButton(WhoIsTheFirstTeam.secondTeamName, Main.redStyle);
    TextButton nobodyRight = new TextButton("Ніхто", Main.greyStyle);

    public static int addToScore = 0;

    public static String[] answers;

    public static int answerNum;

    public CubeAnswer(final int block){

        questionCounter += 1;

        table.add(new TextButton("Відповідь: " + answers[answerNum], Main.purpleStyle)).colspan(2).center().padBottom(10);
        table.row();
        table.add(new TextButton("Хто дав правильну відповідь?", Main.purpleStyle)).colspan(2).center().padBottom(10);
        table.row();
        table.add(redRight).padRight(10).size(360, 150);
        table.add(blueRight).size(360, 150);
        table.row();
        table.add(nobodyRight).size(360, 150).colspan(2).padTop(20);

        redRight.addListener(new ChangeListener() {
                    @Override
                    public void changed(ChangeListener.ChangeEvent event, Actor actor) {
                        Cubes.redScore += addToScore;
                        if(questionCounter == 5){
                            Main.displayDices[block - 1] = false;
                            Main.game.setScreen(new Cubes());
                            questionCounter = 0;
                        }
                        else {
                            Main.game.setScreen(new CubesQuestions(block));
                        }
            }
        });
        blueRight.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeListener.ChangeEvent event, Actor actor) {
                Cubes.blueScore += addToScore;
                if(questionCounter == 5){
                    Main.displayDices[block - 1] = false;
                    Main.game.setScreen(new Cubes());
                    questionCounter = 0;
                }
                else {
                    Main.game.setScreen(new CubesQuestions(block));
                }
            }
        });
        nobodyRight.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeListener.ChangeEvent event, Actor actor) {
                if(questionCounter == 5){
                    Main.displayDices[block - 1] = false;
                    Main.game.setScreen(new Cubes());
                    questionCounter = 0;
                }
                else {
                    Main.game.setScreen(new CubesQuestions(block));
                }
            }
        });

    }


    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
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
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
    }
}
