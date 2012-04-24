package io;
/*
 * Simple line animation class. Will be used in the composition of many other more complex animations,
 * so it needs to be pretty robust and clean.
 * 
 * xi, yi - coordinates of the first point. For algorithms that extend in a direction,
 * you can think of these as 
 * 
 */

public class IOLine extends Animation implements AnimationInterface {
	public float xi, yi, xf, yf, delta;
	private float cx;
	private float cy;
	private float dx;
	private float dy;
	
	IOLine(float xi, float yi, float xf, float yf, float delta){
		this.xi = xi;
		this.yi = yi;
		this.xf = xf;
		this.yf = yf;
		this.dx = xf - xi;
	    this.dy = yf - yi;
	    this.cx = this.xi + (delta*this.dx);
	    this.cy = this.yi + (delta*this.dy);
		
		
		this.delta = delta;
		
	}
	public void animationMethod() {
	
		
		
	}

	public void drawMethod() {
		System.out.println("drawMethod in IOLine");
	}

}
