package io;

import java.util.ArrayList;

public class AnimationList extends Animation implements AnimationInterface {
	
	ArrayList<Animation>list;
	AnimationList()
	{
		super();
		list = new ArrayList<Animation>();
	}

	AnimationList(long duration, Io parent) {
		super(duration, parent);
		list = new ArrayList<Animation>();
		
	}

    void startAnimation()
    {
    	super.startAnimation();
    }

	public void animationMethod() {
	System.out.println("animationMethod in Animation");		
	}
	
	public void drawMethod() {
		System.out.println("drawMethod in Animation");
	}

	@Override
	public void run() {
		this.animationMethod();
		System.out.println("running");
		
	}

	public void stopAnimation() {
		this.isAnimating = false;
		this.isDrawing = true;
		this.cancel();
		
	}
    
}
