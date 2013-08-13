package com.classypenguinstudios.roadrunner.screens;

import com.badlogic.gdx.Screen;
import com.classypenguinstudios.roadrunner.MyGdxGame;
import com.classypenguinstudios.roadrunner.view.World;
import com.classypenguinstudios.roadrunner.view.WorldRenderer;

public class GameScreen implements Screen{
	MyGdxGame game;
	World world;
	WorldRenderer renderer;
	
	public GameScreen(MyGdxGame game){
	this.game = game;
	world = new World(game);
	renderer = new WorldRenderer(world);
	}
	@Override
	public void render(float delta) {
		world.update();
		renderer.render();
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		
	}

}
