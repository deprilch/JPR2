package jpr2.main.desktop;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import jpr2.main.Main;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new Main(), config);

		config.width = Gdx.graphics.getWidth();
		config.height = Gdx.graphics.getHeight();

		/*config.width = 1024;
		config.height = 800;*/

		config.fullscreen = true;
		config.title = "Quiz2";

	}
}
