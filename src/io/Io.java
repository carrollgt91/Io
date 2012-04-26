package io;

import processing.core.PApplet;

@SuppressWarnings("serial")
public class Io extends PApplet {

	public static final int WIDTH = 600;
	public static final int HEIGHT = 600;
	private static final int FRAMERATE = 60;
	//public IOLine line;
	public Animation animation;
	public AnimationList testAnimList;
	public AnimationManager animManager;

	public void setup() {
		size(WIDTH, HEIGHT);
		background(255);
		fill(0);
		stroke(255);
		loop();
		animManager = AnimationManager.getInstance();// HACKALERT: the order of
														// these calls is
														// important currently.
														// might want to fix
														// that.
		AnimationManager.setSharedParent(this);

		
		testAnimList = new AnimationList();

		for (int i = 0; i < 10; i++) {
			IOLine line = new IOLine((i*24345)%301, (i*24345)%238, WIDTH/2, HEIGHT/2, (float) .1, 1000);
			line.testTag=i;
			testAnimList.add(line);
		}
		testAnimList.startAnimation();
		 
		// animation = new Animation(1000);
		// animation.startAnimation();
		// testAnimList.add(animation);

		// }
	}

	public void draw() {
		fill(255);
		stroke(0);
		strokeWeight(4);
		// rect(20, 20, WIDTH - 20, HEIGHT - 20);

	}

	public int getFramerate() {
		return FRAMERATE;
	}

	public int getWidth() {
		return WIDTH;
	}

	public int getHeight() {
		return HEIGHT;
	}

	public void testSingleton() {
		System.out.println("testing the singleton's query of io");
	}
}
