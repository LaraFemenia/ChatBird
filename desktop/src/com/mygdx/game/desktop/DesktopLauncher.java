package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.ChatBird;

public class DesktopLauncher {
	public static void main (String[] arg) {

		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

		config.width = ChatBird.WIDTH;
		config.height = ChatBird.HEIGTH;
		config.title = ChatBird.TITLE;

		new LwjglApplication(new ChatBird(), config);
	}
}
