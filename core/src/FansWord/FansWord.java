package FansWord;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import jpr2.main.Main;
import jpr2.main.screenFather;

public class FansWord extends screenFather {

    int fieldWidth = 300;
    int fieldHeight = 100;

    TextButton redLetterOne = new TextButton("С", Main.redStyle);
    TextButton redLetterTwo = new TextButton("К", Main.redStyle);
    TextButton redLetterThree = new TextButton("Л", Main.redStyle);
    TextButton redLetterFour = new TextButton("Е", Main.redStyle);
    TextButton redLetterFive = new TextButton("Р", Main.redStyle);
    TextButton redLetterSix = new TextButton("А", Main.redStyle);

    TextField redFieldOne = new TextField("", Main.redTextFieldStyle);
    TextField redFieldTwo = new TextField("", Main.redTextFieldStyle);
    TextField redFieldThree = new TextField("", Main.redTextFieldStyle);
    TextField redFieldFour = new TextField("", Main.redTextFieldStyle);
    TextField redFieldFive = new TextField("", Main.redTextFieldStyle);
    TextField redFieldSix = new TextField("", Main.redTextFieldStyle);

    TextButton blueLetterOne = new TextButton("С", Main.greenStyle);
    TextButton blueLetterTwo = new TextButton("К", Main.greenStyle);
    TextButton blueLetterThree = new TextButton("Л", Main.greenStyle);
    TextButton blueLetterFour = new TextButton("Е", Main.greenStyle);
    TextButton blueLetterFive = new TextButton("Р", Main.greenStyle);
    TextButton blueLetterSix = new TextButton("А", Main.greenStyle);

    TextField blueFieldOne = new TextField("", Main.greenTextFieldStyle);
    TextField blueFieldTwo = new TextField("", Main.greenTextFieldStyle);
    TextField blueFieldThree = new TextField("", Main.greenTextFieldStyle);
    TextField blueFieldFour = new TextField("", Main.greenTextFieldStyle);
    TextField blueFieldFive = new TextField("", Main.greenTextFieldStyle);
    TextField blueFieldSix = new TextField("", Main.greenTextFieldStyle);

    public FansWord()
    {

        table.add(redLetterOne).size(fieldHeight, fieldHeight).padBottom(10);
        table.add(redFieldOne).size(fieldWidth, fieldHeight).padBottom(10);

        table.add(blueLetterOne).size(fieldHeight, fieldHeight).padBottom(10);
        table.add(blueFieldOne).size(fieldWidth, fieldHeight).padBottom(10);

        table.row();

        table.add(redLetterTwo).size(fieldHeight, fieldHeight).padBottom(10);
        table.add(redFieldTwo).size(fieldWidth, fieldHeight).padBottom(10);

        table.add(blueLetterTwo).size(fieldHeight, fieldHeight).padBottom(10);
        table.add(blueFieldTwo).size(fieldWidth, fieldHeight).padBottom(10);

        table.row();

        table.add(redLetterThree).size(fieldHeight, fieldHeight).padBottom(10);
        table.add(redFieldThree).size(fieldWidth, fieldHeight).padBottom(10);

        table.add(blueLetterThree).size(fieldHeight, fieldHeight).padBottom(10);
        table.add(blueFieldThree).size(fieldWidth, fieldHeight).padBottom(10);

        table.row();

        table.add(redLetterFour).size(fieldHeight, fieldHeight).padBottom(10);
        table.add(redFieldFour).size(fieldWidth, fieldHeight).padBottom(10);

        table.add(blueLetterFour).size(fieldHeight, fieldHeight).padBottom(10);
        table.add(blueFieldFour).size(fieldWidth, fieldHeight).padBottom(10);

        table.row();

        table.add(redLetterFive).size(fieldHeight, fieldHeight).padBottom(10);
        table.add(redFieldFive).size(fieldWidth, fieldHeight).padBottom(10);

        table.add(blueLetterFive).size(fieldHeight, fieldHeight).padBottom(10);
        table.add(blueFieldFive).size(fieldWidth, fieldHeight).padBottom(10);

        table.row();

        table.add(redLetterSix).size(fieldHeight, fieldHeight).padBottom(10);
        table.add(redFieldSix).size(fieldWidth, fieldHeight).padBottom(10);

        table.add(blueLetterSix).size(fieldHeight, fieldHeight).padBottom(10);
        table.add(blueFieldSix).size(fieldWidth, fieldHeight).padBottom(10);

        table.row();

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
