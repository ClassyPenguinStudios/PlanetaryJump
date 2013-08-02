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
	TextButton credits;
	TextButton store;
	TextButton achievements;
	int xWidth;
	int yHeight;

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
			stage = new Stage(xWidth,
					yHeight, false);
		}
		stage.clear();
		Gdx.input.setInputProcessor(stage);
		TextButtonStyle buttonStyleOne = new TextButtonStyle();
		buttonStyleOne.up = skin.getDrawable("button-lo1-up");
		buttonStyleOne.down = skin.getDrawable("button-lo1-down");
		buttonStyleOne.font = whiteFont;
		
		TextButtonStyle buttonStyleTwo = new TextButtonStyle();
		buttonStyleTwo.up = skin.getDrawable("button-lo2-up");
		buttonStyleTwo.down = skin.getDrawable("button-lo2-down");
		buttonStyleTwo.font = whiteFont;

		playGame = new TextButton("START!", buttonStyleOne);
		playGame.setWidth(xWidth / 3);
		playGame.setHeight((float)(playGame.getWidth()/2.5));
		playGame.setX(xWidth / 4 - playGame.getWidth() / 2);
		playGame.setY(yHeight / 4 - playGame.getHeight() / 2
				+ yHeight / 6);
		
		credits = new TextButton("CREDITS", buttonStyleTwo);
		credits.setWidth(xWidth / 3);
		credits.setHeight((float) (credits.getWidth()/2.5));
		credits.setX(xWidth / 4 - credits.getWidth() / 2);
		credits.setY(yHeight / 6 - credits.getHeight() / 2);
		
		store = new TextButton("STORE", buttonStyleOne);
		store.setWidth(xWidth / 3);
		store.setHeight((float) (store.getWidth()/2.5));
		store.setX(xWidth - (xWidth / 4 - store.getWidth() / 2) - store.getWidth());
		store.setY(yHeight / 4 - playGame.getHeight() / 2
				+ yHeight / 6);
		
		achievements = new TextButton("AWARDS", buttonStyleTwo);
		achievements.setWidth(xWidth / 3);
		achievements.setHeight((float)(achievements.getWidth()/2.5));
		achievements.setX(xWidth - (xWidth / 4 - store.getWidth() / 2) - achievements.getWidth());
		achievements.setY(yHeight / 6 - achievements.getHeight() / 2);
		
		stage.addActor(playGame);
		stage.addActor(credits);
		stage.addActor(store);
		stage.addActor(achievements);

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
				game.setScreen(new Game(game));
			}
		});
	}

	@Override
	public void show() {
		xWidth = Gdx.graphics.getWidth();
		yHeight = Gdx.graphics.getHeight();
		batch = new SpriteBatch();
		atlas = new TextureAtlas("data/drawable.pack");
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
