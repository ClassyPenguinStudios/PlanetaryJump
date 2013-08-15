package com.classypenguinstudios.roadrunner.Model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

public class Train extends MoveableArticle {
	public int bodyLength;
	private Car[] body;
	boolean gravity;
	public Train(Vector2 postion, float width, float height, float speed, int bodyLength) {
		super(postion, width, height, speed);
		this.gravity = false;
		this.bodyLength = bodyLength;
		body = new Car[this.bodyLength];
		float carHeight = (Gdx.graphics.getHeight()/9);
		float carWidth = (Gdx.graphics.getWidth()/16);
		for (int i=0; i<this.bodyLength; i++){
			Vector2 carPosition = new Vector2(this.position.x+(carWidth)*(i+1),this.position.y+(carHeight)*(i+1));
			body[i] = new Car(carPosition, carWidth, carHeight, this.speed);
		}
				
		
	}
	
	public void advance(float delta) {
	}

	@Override
	public void update() {
		this.position.add(0, this.velocity.x*gdx.)
	}
	
	public float getRotation(){
		return this.rotation;
	}
	
	
}
