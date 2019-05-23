package jpr2.main;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;

public class Loader {
    Image image;
    public BitmapFont setFont(BitmapFont font, float size) {
        final String font_chars = "’«»^*єЄіІїЇабвгдежзийклмнопрстуфхцчшщъыьэюяabcdefghijklmnopqrstuvwxyzАБВГДЕЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789][_!$%#@|\\/?-+=()*&.;:,{}\"´`'<>";
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("BloggerSans.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.characters = font_chars;
        //font is 1/30 of any screen resolution
        parameter.size = 20;    //(int)(size * Gdx.graphics.getHeight());
        //filters remove pixelation of font
        parameter.genMipMaps = true;
        parameter.minFilter = Texture.TextureFilter.MipMapLinearNearest;
        parameter.magFilter = Texture.TextureFilter.Linear;
        parameter.color = Color.WHITE;
        font = generator.generateFont(parameter); // font size шт pixels
        //scale of font .setScale(worldHeight / window height)
        font.getData().setScale(1000f / Gdx.graphics.getHeight());
        //font.setUseIntegerPositions(false);
        generator.dispose();
        return font;
    }

    public String[] loadText(String path){
        FileHandle file = Gdx.files.internal(path);
        String text = file.readString("UTF-8"); //setting charset required for correct font display in builds
        String[] questNext;
        questNext = text.split("#");

        for (int i = 0; i < questNext.length; i++){
            String temp;
            temp = questNext[i];
            temp = temp.trim();
            temp = temp.replaceAll("\\\\n", "\n");
            questNext[i] = temp;
        }

        return questNext;
    }

    public Skin setSkin(String atlasPath){
        Skin skin = new Skin();
        TextureAtlas atlas = new TextureAtlas(atlasPath);
        skin.addRegions(atlas);
        return skin;
    }

    public void setButtonStyle(TextButton.TextButtonStyle style, Colors color, BitmapFont font, Skin skin){

        switch (color){
            case menu:
                style.font = font;
                style.up = skin.getDrawable("redStyle");
                style.over = skin.getDrawable("greenStyle");
                return;
            case green:
                style.font = font;
                style.up = skin.getDrawable("greenStyle");
                style.over = skin.getDrawable("greenStyle");
                return;
            case red:
                style.font = font;
                style.up = skin.getDrawable("redStyle");
                style.over = skin.getDrawable("redStyle");

                return;
        }

    }
    public Drawable createBackground(Drawable drawable, Skin skin, String path){
        drawable = skin.getDrawable(path);
        return drawable;
    }

    public Image fillImage(String path){
        Texture texture = new Texture(path);
        image = new Image(texture);
        return image;
    }
}
