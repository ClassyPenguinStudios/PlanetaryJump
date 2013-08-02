package com.classypenguinstudios.roadrunner.Model;

import com.badlogic.gdx.math.Vector2;

public class Train extends MoveableArticle {
	public int bodyLength;
	public Train(Vector2 postion, float width, float height, float speed, int bodyLength) {
		super(postion, width, height, speed);
		this.bodyLength = bodyLength;
	}

	public void advance(float delta) {
	}
	
	
}
