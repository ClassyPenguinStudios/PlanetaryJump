package com.classypenguinstudios.roadrunner.Model;

import com.badlogic.gdx.math.Vector2;

public class BackgroundArticle extends MoveableArticle {
	int backgroundDistance;

	public BackgroundArticle(Vector2 postion, float width, float height,
			float speed, int backgroundDistance) {
		super(postion, width, height, speed);
		this.backgroundDistance = backgroundDistance;
		// TODO Auto-generated constructor stub
	}
	
}
