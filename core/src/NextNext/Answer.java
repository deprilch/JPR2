package NextNext;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import jpr2.main.Main;

import java.util.Random;

import static NextNext.Next.redCurrent;

public class Answer extends jpr2.main.screenFather {

    TextButton correct = new TextButton("Вірно!", Question.NextbtnStyle);
    TextButton incorrect = new TextButton("Невірно!", Question.NextbtnStyle);

    Answer(){

        correct.addListener(new ChangeListener() {
            @Override
            public void changed (ChangeListener.ChangeEvent event, Actor actor) {
                if(redCurrent){
                    Next.redScore++;
                }
                else {
                    Next.blueScore++;
                }
                if(Next.currentQuestion == 42){
                    Main.game.setScreen(Main.mainMenu);
                    return;
                }
                Question.changeColor(Next.currentQuestion, Main.greenStyle);
                Question.green[Next.currentQuestion] = true;
                Next.currentAnswer++;
                Next.currentQuestion++;
                if(Next.currentQuestion == 22){
                    Main.game.setScreen(new Next());
                    redCurrent = false;
                    Question.NextbtnStyle = Main.blueStyle;
                    Next.start.setStyle(Main.blueStyle);
                    setNewPic();
                    return;
                }
                setNewPic();
                Main.game.setScreen(new Pause());
            }
        });

        incorrect.addListener(new ChangeListener() {
            @Override
            public void changed (ChangeListener.ChangeEvent event, Actor actor) {
                if(Next.currentQuestion == 42){
                    Main.game.setScreen(Main.mainMenu);
                    return;
                }
                Question.changeColor(Next.currentQuestion, Main.redStyle);
                Question.wrong[Next.currentQuestion] = true;
                Next.currentAnswer++;
                Next.currentQuestion++;
                if(Next.currentQuestion == 22){
                    Main.game.setScreen(new Next());
                    redCurrent = false;
                    Question.NextbtnStyle = Main.blueStyle;
                    Next.start.setStyle(Main.blueStyle);
                    setNewPic();
                    return;
                }
                setNewPic();
                Main.game.setScreen(new Pause());
                System.out.println(Next.currentQuestion);
            }
        });

        table.add(new TextButton(Main.nextAnswers[Next.currentAnswer], Question.NextbtnStyle)).colspan(2).center().padBottom(10);
        table.row();
        table.add(correct).padRight(10).size(360, 150);
        table.add(incorrect).size(360, 150);
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
//        if(redCurrent){
//            table.setBackground(Main.redBackground);
//            correct.setStyle(Main.styleBig);
//            incorrect.setStyle(Main.styleBig);
//        }
//        else {
//            table.setBackground(Main.blueBackground);
//            correct.setStyle(Main.blueStyleBig);
//            incorrect.setStyle(Main.blueStyleBig);
//        }
    }

    public void setNewPic(){
        Random rand = new Random();
        int n = rand.nextInt(5) + 1;
        //Question.image = Main.nextImagePool[n-1];
    }

}
