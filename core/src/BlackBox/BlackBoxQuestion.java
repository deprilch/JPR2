package BlackBox;

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

public class BlackBoxQuestion extends screenFather {

    TextButton[] questButtons;
    Timer timerLeft = new Timer();
    TimerTask timerTask;
    public int timeConst = 91;
    public int timeLeft = timeConst;
    TextButton timer = new TextButton("", Main.menuButton);
    TextButton question = new TextButton("", Main.greenStyle);

    public static TextButton[] redTeam = new TextButton[10];
    public static TextButton[] blueTeam = new TextButton[10];

    public static int[] redScore = new int[10];
    public static int[] blueScore = new int[10];

    public static boolean green = true;
    public static boolean yellow = false;
    public static boolean red = false;

    BlackBoxQuestion(){
        green = true;
        yellow = false;
        red = false;
        for(int i = 0; i < 10; i++){
            redTeam[i] = new TextButton("", Main.redStyle);
            blueTeam[i] = new TextButton("", Main.blueStyle);
        }

        questButtons = new TextButton[10];
        for(int i = 0; i < 10; i++){
            questButtons[i] = new TextButton(Integer.toString(i + 1), Main.blueStyle);
        }

        timer.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                Main.game.setScreen(new BlackBoxAnswer());
                /*if(timeLeft == 7){
                    green = false;
                    yellow = true;
                }
                if(timeLeft == 4){
                    yellow = false;
                    red = true;
                }*/
            }
        });

        //question
        table.add(question).colspan(10).expandY().center().fill();
        table.getCell(question).maxWidth(800);
        table.getCell(question).maxHeight(400);
        question.setSize(800, 400);
        question.setText(Main.blackBoxQuestions[BlackBox.currentQuestion]);
        table.row();

        //timer
        table.add(timer).center().colspan(10).padBottom(50).size(100,100);
        table.row();

        //numbers
        for (int s = 0; s < 10; s++){
            table.add(redTeam[s]).size(standartSize,standartSize).padRight(10).padBottom(10);
        }
        table.row();
        for (int s = 0; s < 10; s++){
            table.add(blueTeam[s]).size(standartSize,standartSize).padRight(10).padBottom(10);
        }
        timerTask = new TimerTask() {
            @Override
            public void run() {
                timeLeft--;
            }
        };
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.draw();  //only draws
        stage.act();   //only acts

        setBackground();

        timer.setText(Integer.toString(timeLeft));

        for(int i = 0; i < 10; i++){
            if(redTeam[i] !=null){
                redTeam[i].setText(Integer.toString(redScore[i]));
            }
            if(blueTeam[i] !=null){
                blueTeam[i].setText(Integer.toString(blueScore[i]));
            }
        }

        if(Gdx.input.isKeyJustPressed(Input.Keys.Q)){
            Gdx.app.exit();
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.M)){
            Main.game.setScreen(Main.mainMenu);
        }
        if(timeLeft <= 50 & timeLeft > 20){
            green = false;
            yellow = true;
            table.setBackground(Main.orangeBackground);
            question.setStyle(Main.yellowStyle);
            question.setText(Main.blackBoxQuestions[BlackBox.currentQuestion] + "\n"+ "\n" + Main.blackBoxFirstHints[BlackBox.currentQuestion]);
        }
        if(timeLeft <= 20){
            yellow = false;
            red = true;
            table.setBackground(Main.redBackground);
            question.setStyle(Main.redStyle);
            question.setText(Main.blackBoxQuestions[BlackBox.currentQuestion] + "\n"+ "\n" + Main.blackBoxFirstHints[BlackBox.currentQuestion] + "\n"+ "\n" + Main.blackBoxSecondHints[BlackBox.currentQuestion]);
        }
        if(timeLeft == 0){
            timerLeft.cancel();
        }
    }

    public void setBackground(){
        table.setBackground(Main.greenBackground);
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
        timeLeft = timeConst;
        timerLeft.schedule(timerTask, 0, 1000);
    }

}
