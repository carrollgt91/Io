package io;
import processing.core.PApplet;

public class Io extends PApplet {
	
	public static int WIDTH = 600;
	public static int HEIGHT = 600;
	public IOLine line;
	

	public void setup() {
		size(WIDTH, HEIGHT);
		background(255);
		fill(0);
		stroke(255);
		line = new IOLine(200, 200, 400, 400, .01, this);
		line.startAnimation();
		System.out.println("setup");
	}

	public void draw() {
		fill(255);
		stroke(0);
		strokeWeight(4);
		rect(20, 20, WIDTH-20, HEIGHT-20);
		line.animate();
	}
}
