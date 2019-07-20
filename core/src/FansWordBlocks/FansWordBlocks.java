package FansWordBlocks;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import jpr2.main.Main;
import jpr2.main.screenFather;

public class FansWordBlocks extends screenFather {

    TextButton[] firstTeamBtns = new TextButton[7];
    TextButton[] secondTeamBtns = new TextButton[7];

    String[] firstWords, secondWords = new String[7];

    public static int currentBlock = 1;

    private int correctAnswerFirst;
    private int correctAnswerSecond;

    private int btnHeight = 100;
    private int btnWidth = 400;

    public static int redScore = 0;
    public static int blueScore = 0;

    public FansWordBlocks(){

        switch (currentBlock){
            case 1:
                firstWords = Main.firstTeamB1;
                secondWords = Main.secondTeamB1;
                break;
            case 2:
                firstWords = Main.firstTeamB2;
                secondWords = Main.secondTeamB2;
                break;
            case 3:
                firstWords = Main.firstTeamB3;
                secondWords = Main.secondTeamB3;
                break;
        }

        correctAnswerFirst = Integer.parseInt(firstWords[1]);
        correctAnswerSecond = Integer.parseInt(secondWords[1]);

        for (int i = 2; i < 7; i++) {
            firstTeamBtns[i] = new TextButton(firstWords[i], Main.redStyle);
            secondTeamBtns[i] = new TextButton(secondWords[i], Main.redStyle);
            final int num = i;
            firstTeamBtns[i].addListener(new ChangeListener() {
                @Override
                public void changed(ChangeEvent event, Actor actor) {
                    firstTeamBtns[num].setStyle(Main.redStyle);
                }
            });
            secondTeamBtns[i].addListener(new ChangeListener() {
                @Override
                public void changed(ChangeEvent event, Actor actor) {
                    secondTeamBtns[num].setStyle(Main.redStyle);
                }
            });
            table.add(firstTeamBtns[i]).size(btnWidth, btnHeight).padRight(20);
            table.add(secondTeamBtns[i]).size(btnWidth, btnHeight);
            table.row();
        }
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.draw();  //only draws
        stage.act();   //only acts

        if(Gdx.input.isKeyJustPressed(Input.Keys.M)) {
            Main.game.setScreen(Main.mainMenu);
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.Q)) {
            Gdx.app.exit();
        }

        setBackground(Main.purpleBackground);
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
    }

}
