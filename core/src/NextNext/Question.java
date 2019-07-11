package NextNext;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import jpr2.main.Main;

import java.util.Timer;
import java.util.TimerTask;

import static NextNext.Next.redCurrent;

public class Question extends jpr2.main.screenFather {

    public static TextButton[] questButtons;
    public static boolean[] green = new boolean[43];
    public static boolean[] wrong = new boolean[43];
    public static boolean[] skiped = new boolean[43];
    public static int buttonIds;
    static public Button.ButtonStyle styles = Main.yellowStyle;
    TextButton timer = new TextButton("", Main.menuButton);
    TextButton next = new TextButton("Далі", Main.menuButton);

    Timer timerLeft;
    TimerTask timerTask;
    public int timeConst = 241;
    public static int timeLeft = 0;

    static boolean freshStart = true;

    public static TextButton.TextButtonStyle NextbtnStyle = Main.menuButton;

    //public static Image image = main.nextImagePool[0];

    public boolean soundDone = false;

    public Question(){
        timerLeft = new Timer();
        if(freshStart){
        timeLeft = timeConst;
        freshStart = false;
        }

        questButtons = new TextButton[21];
        for(int i = 0; i < 21; i++){
            questButtons[i] = new TextButton(Integer.toString(i + 1), Main.purpleStyle);
            if(Next.currentQuestion < 22){
                if(green[i+1]){
                    questButtons[i].setStyle(Main.greenStyle);
                }
                if(wrong[i+1]) {
                    questButtons[i].setStyle(Main.redStyle);
                }
                if(skiped[i+1]) {
                    questButtons[i].setStyle(Main.purpleStyle);
                }
            }
            if(Next.currentQuestion > 22){
                if(green[i+1 + 21]){
                    questButtons[i].setStyle(Main.greenStyle);
                }
                if(wrong[i+1 + 21]) {
                    questButtons[i].setStyle(Main.redStyle);
                }
                if(skiped[i+1 + 21]) {
                    questButtons[i].setStyle(Main.purpleStyle);
                }
            }
        }

        timer.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                timerTask.cancel();
                Main.game.setScreen(new Answer());
            }
        });

        next.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                timerTask.cancel();
                if(Next.currentQuestion == 42){
                    Main.game.setScreen(Main.mainMenu);
                    Question.freshStart = true;
                    return;
                }
                Question.changeColor(Next.currentQuestion, Main.purpleStyle);
                Question.skiped[Next.currentQuestion] = true;
                Next.currentAnswer++;
                Next.currentQuestion++;
                if(Next.currentQuestion == 22){
                    Next.currentAnswer = 22;
                    redCurrent = false;
                    freshStart = true;
                    Main.game.setScreen(new Next());
                    Question.NextbtnStyle = Main.blueStyle;
                    Next.start.setStyle(Main.purpleStyle);
                    return;
                }
                Main.game.setScreen(new Question());
            }
        });

        //question
        table.add(new TextButton(Main.nextQuestions[Next.currentQuestion], Main.purpleStyle)).colspan(21).expandY().center();
        table.row();

        //table.add(image).colspan(4);
        //table.row();

        table.add(next).size(timerSize,timerSize).center().colspan(21).padBottom(10);
        table.row();

        //timer
        table.add(timer).size(timerSize,timerSize).center().colspan(21).padBottom(10);
        table.row();

        //numbers
        for (int s = 0; s < 21; s++){
            table.add(questButtons[s]).padBottom(10).padRight(10).padTop(5).size(standartSize,standartSize);
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
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.draw();  //only draws
        stage.act();   //only acts

        setBackground(Main.purpleBackground);

        timer.setText(Integer.toString(timeLeft));

        questButtons[buttonIds].setStyle(Main.yellowStyle);

        if(Gdx.input.isKeyJustPressed(Input.Keys.Q)){
            Gdx.app.exit();
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.M)){
            Main.game.setScreen(Main.mainMenu);
        }
        if(timeLeft <= 0){
            timerTask.cancel();
            Answer.changeTeam(Next.redCurrent);
        }
    }


    public static void changeColor(int buttonId, Button.ButtonStyle style){
        if(buttonId >= 21){
            buttonIds = buttonId - 21;
        }
        else {
            buttonIds = buttonId;
        }
        questButtons[buttonIds].setStyle(style);
        styles = style;
    }

    //try to use show for colors change
    @Override
    public void show() {
        timerLeft.schedule(timerTask, 0, 1000);
        soundDone = false;
        Gdx.input.setInputProcessor(stage);
    }
}
