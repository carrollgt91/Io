package io;
import processing.core.PApplet;

@SuppressWarnings("serial")
public class Io extends PApplet {
	
	public static int WIDTH = 600;
	public static int HEIGHT = 600;
	private static final int FRAMERATE = 60;
	public IOLine line;
	public Animation animation;
	public AnimationList testAnimList;
	public AnimationManager animManager;
	
	
	

	public void setup() {
		size(WIDTH, HEIGHT);
		background(255);
		fill(0);
		stroke(255);
		loop();
		animManager = AnimationManager.getInstance();// HACKALERT: the order of these calls is important currently. might want to fix that.
		AnimationManager.setSharedParent(this);
		
		animManager.sharedParent.testSingleton();
		/*
		line = new IOLine(200, 200, 400, 400, .01, this);
		line.startAnimation();
		*/
		
		animation = new Animation(1000, this);
		animation.startAnimation();
		System.out.println("setup");
	}

	public void draw() {
		fill(255);
		stroke(0);
		strokeWeight(4);
		rect(20, 20, WIDTH-20, HEIGHT-20);
		
		
	}
	
	public int getFramerate()
	{
		return FRAMERATE;
	}
	
	public void testSingleton()
	{
		System.out.println("testing the singleton's query of io");
	}
}
