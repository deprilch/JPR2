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

public class Question extends jpr2.main.screenFather {

    public static TextButton[] questButtons;
    public static boolean[] green = new boolean[43];
    public static boolean[] wrong = new boolean[43];
    public static int buttonIds;
    static public Button.ButtonStyle styles = Main.yellowStyle;
    TextButton timer = new TextButton("", Main.menuButton);

    Timer timerLeft;
    TimerTask timerTask;
    public static int timeConst = 241;
    //public int timeLeft = timeConst;

    public static TextButton.TextButtonStyle NextbtnStyle = Main.menuButton;

    //public static Image image = main.nextImagePool[0];

    public boolean soundDone = false;

    public Question(){
        timerLeft = new Timer();

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
            }
            if(Next.currentQuestion > 22){
                if(green[i+1 + 21]){
                    questButtons[i].setStyle(Main.greenStyle);
                }
                if(wrong[i+1 + 21]) {
                    questButtons[i].setStyle(Main.redStyle);
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

        //question
        table.add(new TextButton(Main.nextQuestions[Next.currentQuestion], NextbtnStyle)).colspan(21).expandY().center();
        table.row();

        //table.add(image).colspan(4);
        //table.row();

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
                timeConst--;
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

        timer.setText(Integer.toString(timeConst));

        questButtons[buttonIds].setStyle(Main.yellowStyle);

        if(Gdx.input.isKeyJustPressed(Input.Keys.Q)){
            Gdx.app.exit();
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.M)){
            Main.game.setScreen(Main.mainMenu);
        }
        if(timeConst == 0){
            timerTask.cancel();
            Main.game.setScreen(new Answer());
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

    public void setBackground(){
//        if(redCurrent){
//            table.setBackground(Main.redBackground);
//        }
//        else {
//            table.setBackground(Main.blueBackground);
//        }
    }

    //try to use show for colors change
    @Override
    public void show() {
        //timeLeft = timeConst;
        timerLeft.schedule(timerTask, 0, 1000);
        soundDone = false;
        Gdx.input.setInputProcessor(stage);
    }
}
