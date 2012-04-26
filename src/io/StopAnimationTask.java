package io;

import java.util.TimerTask;

public class StopAnimationTask extends TimerTask {
	Animation animation;
	StopAnimationTask(Animation animation)
	{
		this.animation = animation;
	}

	@Override
	public void run() {
		this.animation.stopAnimation();
	}
	


}
