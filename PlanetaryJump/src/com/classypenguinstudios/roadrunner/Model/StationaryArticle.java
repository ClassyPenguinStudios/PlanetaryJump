package com.classypenguinstudios.roadrunner.Model;

import com.badlogic.gdx.math.Vector2;

public abstract class StationaryArticle extends Article {
	StationaryArticle(Vector2 position, float width, float height) {
		super(position, width, height);
	}
}
