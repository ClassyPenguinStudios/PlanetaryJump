package com.classypenguinstudios.roadrunner.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.classypenguinstudios.roadrunner.Model.Train;

public class WorldRenderer {
	World world;
	SpriteBatch batch;
	Train train;
	OrthographicCamera cam;
	Texture trainTexture;
	float width, height;
	
	public WorldRenderer(World world){
		this.world = world;
		
		width = Gdx.graphics.getWidth();
		height =Gdx.graphics.getHeight();
		
		train = world.getTrain();
		trainTexture = new Texture("data/train.png");
		
		cam = new OrthographicCamera();
		cam.setToOrtho(false, width, height);
		cam.update();
		
		batch = new SpriteBatch();
		batch.setProjectionMatrix(cam.projection);
		
	}
	
	public void render(){
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

		batch.begin();
		batch.draw(trainTexture, train.getPosition().x, train.getPosition().y, width/16, height/6, 0, 0, trainTexture.getWidth(), trainTexture.getHeight(), false, false);
		batch.end();
	}
	
	public void dispose(){
		batch.dispose();
		trainTexture.dispose();
	}
}
