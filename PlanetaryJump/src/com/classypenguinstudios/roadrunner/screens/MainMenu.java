package com.classypenguinstudios.roadrunner.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.classypenguinstudios.roadrunner.MyGdxGame;

public class MainMenu implements Screen {
	MyGdxGame game;
	Stage stage;
	BitmapFont whiteFont;
	BitmapFont blackFont;
	TextureAtlas atlas;
	Skin skin;
	SpriteBatch batch;
	TextButton playGame;

	public MainMenu(MyGdxGame myGdxGame) {
		this.game = myGdxGame;
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

		stage.act(delta);

		batch.begin();
		stage.draw();
		batch.end();

	}

	@Override
	public void resize(int width, int height) {
		if (stage == null) {
			stage = new Stage(Gdx.graphics.getWidth(),
					Gdx.graphics.getHeight(), false);
		}
		stage.clear();
		Gdx.input.setInputProcessor(stage);
		TextButtonStyle buttonStyle = new TextButtonStyle();
		buttonStyle.up = skin.getDrawable("unpressed");
		buttonStyle.down = skin.getDrawable("pressed");
		buttonStyle.font = whiteFont;

		playGame = new TextButton("", buttonStyle);
		playGame.setWidth(Gdx.graphics.getWidth() / 3);
		playGame.setHeight(Gdx.graphics.getHeight() / 6);
		playGame.setX(Gdx.graphics.getWidth() / 4 - playGame.getWidth() / 2);
		playGame.setY(Gdx.graphics.getHeight() / 4 - playGame.getHeight() / 2
				+ Gdx.graphics.getHeight() / 2);

		stage.addActor(playGame);

		playGame.addListener(new InputListener() {
			public boolean touchDown(InputEvent event, float x, float y,
					int pointer, int button) {
				Gdx.app.log("RoadRunner", "touch started at (" + x + ", " + y
						+ ")");
				return true;
			}

			public void touchUp(InputEvent event, float x, float y,
					int pointer, int button) {
				Gdx.app.log("RoadRunner", "touch done at (" + x + ", " + y + ")");
			}
		});
	}

	@Override
	public void show() {
		batch = new SpriteBatch();
		atlas = new TextureAtlas("data/playgame.pack");
		skin = new Skin();
		skin.addRegions(atlas);
		whiteFont = new BitmapFont(
				Gdx.files.internal("data/game_font_white.fnt"), false);
		blackFont = new BitmapFont(
				Gdx.files.internal("data/game_font_black.fnt"), false);

	}

	@Override
	public void hide() {
		dispose();

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		batch.dispose();
		skin.dispose();
		atlas.dispose();
		whiteFont.dispose();
		blackFont.dispose();
		stage.dispose();

	}

}
