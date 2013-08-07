package com.classypenguinstudios.roadrunner.Model;

import com.badlogic.gdx.math.Vector2;

public class Car extends MoveableArticle{

	public Car(Vector2 postion, float width, float height, float speed) {
		super(postion, width, height, speed);
		// TODO Auto-generated constructor stub
	}
	
	public void changeX(float x){
		this.position.x=x;
	}

}
