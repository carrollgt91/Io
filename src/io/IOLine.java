package io;

import java.lang.Math;

/*
 * Simple line animation class. Will be used in the composition of many other more complex animations,
 * so it needs to be pretty robust and clean.
 * 
 * xi, yi - coordinates of the first point. For algorithms that extend in a direction,
 * you can think of these as 
 * 
 */

public class IOLine extends Animation implements AnimationInterface {
	float xi, yi, xf, yf;
	float delta;
	float xlim, ylim;
	private float cx;
	private float cy;
	private float dx;
	private float dy;
	Io parent;

	IOLine(float xi, float yi, float xf, float yf, float d, int duration) {
		this.duration = duration;
		this.xi = xi;
		this.yi = yi;
		this.xf = xf;
		this.yf = yf;
		this.dx = xf - xi;
		this.dy = yf - yi;
		this.cx = (float) (this.xi + (d * this.dx));
		this.cy = (float) (this.yi + (d * this.dy));
		this.dx = xf - xi;
		this.dy = yf - yi;
		this.delta = d;
		this.parent = AnimationManager.getInstance().getSharedParent();
		this.xlim = 2*Math.abs(delta*this.dx);
	    this.ylim = 2*Math.abs(delta*this.dy);

	}

	public void animationMethod() {

		parent.line(this.xi, this.yi, this.cx, this.cy);
		this.update();

	}

	public void drawMethod() {
		parent.line(this.xi, this.yi, this.xf, this.xf);
		System.out.println("draw");
	}

	public void update() {
		//System.out.println("update");
		this.cx = this.cx + (delta * this.dx);
		this.cy = this.cy + (delta * this.dy);

		if ((Math.abs(xf - cx) < xlim && xf - cx != 0)
				|| (Math.abs(yf - cy) < ylim) && yf - cy != 0) {
			this.cx = this.xi + (delta * this.dx);
			this.cy = this.yi + (delta * this.dy);
			System.out.println("restart cx: " + this.cx + "cy:" + this.cy);
			if(this.superList == null)
				parent.rect(0,0, this.parent.getWidth(),this.parent.getHeight());

		}

	}

}
