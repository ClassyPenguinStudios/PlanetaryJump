package com.classypenguinstudios.roadrunner.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.classypenguinstudios.roadrunner.Model.Train;

public class WorldRenderer {
	World world;
	SpriteBatch batch;
	Train train;
	OrthographicCamera cam;
	Texture trainTexture;
	float width, height;

	public WorldRenderer(World world) {
		this.world = world;
		train = world.getTrain();

		width = Gdx.graphics.getWidth();
		height = Gdx.graphics.getHeight();

		trainTexture = new Texture("data/train.png");
		trainTexture.setFilter(TextureFilter.Linear, TextureFilter.Linear);

		cam = new OrthographicCamera();
		cam.setToOrtho(true, width, height);
		cam.update();

		batch = new SpriteBatch();
		batch.setProjectionMatrix(cam.combined);

	}

	public void render() {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

		batch.begin();
		batch.draw(trainTexture, train.getPosition().x, train.getPosition().y,
				width / 10, height / 10);
		batch.end();
	}

	public void dispose() {
		batch.dispose();
		trainTexture.dispose();
	}
}
