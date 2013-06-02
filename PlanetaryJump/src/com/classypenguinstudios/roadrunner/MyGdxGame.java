package com.classypenguinstudios.roadrunner;

import com.badlogic.gdx.Game;
import com.classypenguinstudios.roadrunner.screens.SplashScreen;

public class MyGdxGame extends Game {
	public static final String version = "0.0.0.1 pre-Alpha";
	public static final String log = "Planetary Jumper";

	@Override
	public void create() {
		setScreen(new SplashScreen(this));
	}

	@Override
	public void dispose() {
		super.dispose();
	}

	@Override
	public void render() {
		super.render();
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
	}

	@Override
	public void pause() {
		super.pause();
	}

	@Override
	public void resume() {
		super.resume();
	}
}
