package com.classypenguinstudios.roadrunner.screens;

import aurelienribon.tweenengine.BaseTween;
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenCallback;
import aurelienribon.tweenengine.TweenEquations;
import aurelienribon.tweenengine.TweenManager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.classypenguinStudios.roadrunner.TweenAccessors.SpriteTween;
import com.classypenguinstudios.roadrunner.MyGdxGame;

public class SplashScreen implements Screen{
	Texture splashTexture;
	Sprite splashSprite;
	SpriteBatch splashBatch;
	MyGdxGame game;
	TweenManager manager;
	
	public SplashScreen(MyGdxGame myGdxGame) {
		this.game = myGdxGame;
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0,0, 0, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		manager.update(delta);
//		Gdx.app.log(MyGdxGame.log, "RENDERING");
		
		splashBatch.begin();
		splashSprite.draw(splashBatch);
		splashBatch.end();
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		splashTexture = new Texture("data/splash.png");
		splashTexture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		
		splashSprite = new Sprite(splashTexture);
		splashSprite.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
//		splashSprite.setOrigin(splashSprite.getWidth()/2, splashSprite.getHeight()/2);
		splashSprite.setX(Gdx.graphics.getWidth()/2 - (splashSprite.getWidth()/2));
		splashSprite.setY(Gdx.graphics.getHeight()/2 - (splashSprite.getHeight()/2));
		splashSprite.setColor(1, 1, 1, 0);
		
		splashBatch = new SpriteBatch();
		
		Tween.registerAccessor(Sprite.class, new SpriteTween());
		
		manager = new TweenManager();
		
		TweenCallback fadeCB = new TweenCallback() {
			
			@Override
			public void onEvent(int type, BaseTween<?> source) {
				tweenCompleted();
				
			}
		};
		
		Tween.to(splashSprite, SpriteTween.alpha, 2.5f).target(1).ease(TweenEquations.easeInSine).repeatYoyo(1, 0).setCallback(fadeCB).setCallbackTriggers(TweenCallback.COMPLETE).start(manager);
		
	}

	private void tweenCompleted(){
		Gdx.app.log(MyGdxGame.log,"complete");
		game.setScreen(new MainMenu(game));
	}
	
	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
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
		
	}

}
