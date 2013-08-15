package com.classypenguinstudios.roadrunner.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.classypenguinstudios.roadrunner.MyGdxGame;
import com.classypenguinstudios.roadrunner.Model.Train;

public class World {
	MyGdxGame game;
	Train train;

	public World(MyGdxGame game) {
		this.game = game;
		train = new Train(new Vector2(Gdx.graphics.getWidth()/5,Gdx.graphics.getWidth()/3), 1, 1, 5f, 5);
		Gdx.input.setInputProcessor(new InputHandler(this));
	}

	public Train getTrain() {
		return this.train;
	}

	public void update() {
		train.update();
	}
	
	public void dispose(){
		
	}

}
