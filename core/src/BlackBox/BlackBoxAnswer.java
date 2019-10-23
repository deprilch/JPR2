package BlackBox;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import jpr2.main.Main;
import jpr2.main.screenFather;

public class BlackBoxAnswer extends screenFather {

    TextButton redTeamRight = new TextButton("Червона команда має рацію!", Main.redStyle);
    TextButton blueTeamRight = new TextButton("Синя команда має рацію!", Main.blueStyle);
    TextButton nobodyRight = new TextButton("Відповідь невірна!", Main.greyStyle);

    BlackBoxAnswer(){

        redTeamRight.addListener(new ChangeListener() {
            @Override
            public void changed (ChangeListener.ChangeEvent event, Actor actor) {
                //BlackBoxQuestion.redScore[BlackBox.currentQuestion-1] = 4;

                if(BlackBoxQuestion.green){
                    BlackBox.redScore+=4;
                    BlackBoxQuestion.redScore[BlackBox.currentQuestion-1] = 4;
                }
                if(BlackBoxQuestion.yellow){
                    BlackBox.redScore+=3;
                    BlackBoxQuestion.redScore[BlackBox.currentQuestion-1] = 3;
                }
                if(BlackBoxQuestion.red){
                    BlackBox.redScore++;
                    BlackBoxQuestion.redScore[BlackBox.currentQuestion-1] = 1;
                }

                if(BlackBox.currentQuestion == 10){
                    Main.game.setScreen(Main.mainMenu);
                    return;
                }

                BlackBox.currentAnswer++;
                BlackBox.currentQuestion++;
                Main.game.setScreen(new BlackBoxQuestion());
            }
        });

        blueTeamRight.addListener(new ChangeListener() {
            @Override
            public void changed (ChangeListener.ChangeEvent event, Actor actor) {
                if(BlackBoxQuestion.green){
                    BlackBox.blueScore+=4;
                    BlackBoxQuestion.blueScore[BlackBox.currentQuestion-1] = 4;
                }
                if(BlackBoxQuestion.yellow){
                    BlackBox.blueScore+=3;
                    BlackBoxQuestion.blueScore[BlackBox.currentQuestion-1] = 3;
                }
                if(BlackBoxQuestion.red){
                    BlackBox.blueScore++;
                    BlackBoxQuestion.blueScore[BlackBox.currentQuestion-1] = 1;
                }

                if(BlackBox.currentQuestion == 10){
                    Main.game.setScreen(Main.mainMenu);
                    return;
                }

                BlackBox.currentAnswer++;
                BlackBox.currentQuestion++;
                Main.game.setScreen(new BlackBoxQuestion());
            }
        });

        nobodyRight.addListener(new ChangeListener() {
            @Override
            public void changed (ChangeListener.ChangeEvent event, Actor actor) {
                if(BlackBox.currentQuestion == 10){
                    Main.game.setScreen(Main.mainMenu);
                    return;
                }

                BlackBox.currentAnswer++;
                BlackBox.currentQuestion++;
                Main.game.setScreen(new BlackBoxQuestion());
            }
        });

        table.add(new TextButton(Main.blackBoxAnswers[BlackBox.currentAnswer], Main.purpleStyle)).colspan(2).center().padBottom(20);
        table.row();
        table.add(redTeamRight).size(1300, 150).padBottom(20);
        table.row();
        table.add(blueTeamRight).size(1300, 150).padBottom(20);
        table.row();
        table.add(nobodyRight).size(1300, 150);
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
    }

    public void setBackground(){
        table.setBackground(Main.purpleBackground);
    }

}
