package io;
import processing.core.PApplet;
/*
 * Simple line animation class. Will be used in the composition of many other more complex animations,
 * so it needs to be pretty robust and clean.
 * 
 * xi, yi - coordinates of the first point. For algorithms that extend in a direction,
 * you can think of these as 
 * 
 */

public class IOLine extends Animation implements AnimationInterface {
	public float xi, yi, xf, yf;
	double delta;
	private float cx;
	private float cy;
	private float dx;
	private float dy;
	PApplet parent;
	
	IOLine(float xi, float yi, float xf, float yf, double d, PApplet p){
		this.xi = xi;
		this.yi = yi;
		this.xf = xf;
		this.yf = yf;
		this.dx = xf - xi;
	    this.dy = yf - yi;
	    this.cx = (float) (this.xi + (d*this.dx));
	    this.cy = (float) (this.yi + (d*this.dy));
		this.delta = d;
		this.parent = p;
		
	}
	public void animationMethod(int type) {
		
		parent.line(this.xi, this.yi, this.cx, this.cy);
	    this.update(type);
	    
		
	}

	public void drawMethod() {
		System.out.println("drawMethod in IOLine");
	}
	
	public void update(int type)
	{
		
	}

}
