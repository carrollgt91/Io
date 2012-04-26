package io;
import java.util.Timer;
import java.util.TimerTask;

import processing.core.PApplet;


public class Animation extends TimerTask {
    Timer manager;//What to name? Exactly how do we want to integrate this in the class hierarchy? Should we have each AnimationList
    //have some sort of delegate that would handle all of the timing using a master timer? Then we could handle the synchronization
    // of timers on a case by case basis. Version .... later idea
    
    AnimationList superList;
    AnimationList subList;
    
    long duration;
    
    int testTag;
    
    boolean isAnimating;
    boolean isDrawing;
    
    Io parent;
    
    
    private long framerate;
    
    private StopAnimationTask stopTask;
    
    Animation() // WARNING:if you use this constructor, you must specify the parent manually after the fact until the singlton exists
    {
    	this.duration = 0;
    	this.manager = new Timer();
    	superList = new AnimationList();
    	subList = new AnimationList();
    	isAnimating = false;
    	//this.parent = defaultParent; implement singleton functionality on the sketch so you can just grab it anywhere, much simpler
    	//framerate = this.parent.getFramerate();
    	this.stopTask = new StopAnimationTask(this);
    }
    
    
    Animation(long duration, Io parent)
    {
    	this.duration = duration;
    	this.manager = new Timer();
    	//superList = new AnimationList();
    	//subList = new AnimationList();
    	isAnimating = false;
    	this.parent = parent;
    	framerate = this.parent.getFramerate();
    	this.stopTask = new StopAnimationTask(this);
    }

    void startAnimation()
    {
    	isAnimating = true;
    	manager.schedule(this, 0, framerate);
    	manager.schedule(stopTask, duration);
    }

	public void animationMethod() {
	System.out.println("animationMethod in Animation");		
	}
	
	public void drawMethod() {
		//System.out.println("drawMethod in Animation");
	}

	@Override
	public void run() {
		this.animationMethod();
		//System.out.println("running");
		
	}

	public void stopAnimation() {
		this.isAnimating = false;
		this.isDrawing = true;
		this.cancel();
		
	}
    
 
}