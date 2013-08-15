package com.classypenguinstudios.roadrunner.Model;

import com.badlogic.gdx.math.Vector2;

public abstract class MoveableArticle extends Article {
 protected Vector2 velocity = new Vector2(0,0);
 protected float speed;
 
 public MoveableArticle(Vector2 postion, float width, float height, float speed){
	 super(postion, width, height);
	 this.speed = speed;
 }

/**
 * @return the velocity
 */
public Vector2 getVelocity() {
	return this.velocity;
}

/**
 * @param velocity the velocity to set
 */
public void setVelocity(Vector2 velocity) {
	this.velocity = velocity;
}

public abstract void update();

///**
// * @return the speed
// */
//public float getSpeed() {
//	return speed;
//}
//
///**
// * @param speed the speed to set
// */
//public void setSpeed(float speed) {
//	this.speed = speed;
//}
 
}
